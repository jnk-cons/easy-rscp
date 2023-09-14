package de.jnkconsulting.e3dc.easyrscp.api.bytes

import de.jnkconsulting.e3dc.easyrscp.api.frame.*
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.*
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.util.zip.CRC32


/**
 * Helper object that defines the fixed sizes of individual fields in the RSCP protocol.
 */
val SIZES = FieldSizes(
    frameHeaderMagicBytes = 2,
    frameHeaderControlBytes = 2,
    frameHeaderDataLength = 2,
    timestampEpochSeconds = 8,
    timestampEpochNanos = 4,
    checksum = 4,
    dataTagSize = 4,
    dataTypeSize = 1,
    dataValueLengthSize = 2
)

/**
 * Helper object that defines the fixed positions of the individual fields in a FrameHeader.
 */
val POSITIONS = FieldPositions(
    frameHeaderMagicBytes = 0,
    frameHeaderControlBytes = SIZES.frameHeaderMagicBytes,
    frameHeaderDataLength = SIZES.frameHeaderMagicBytes + SIZES.frameHeaderControlBytes + SIZES.timestampEpochSeconds + SIZES.timestampEpochNanos,
    frameHeaderTimestampEpochSeconds = SIZES.frameHeaderMagicBytes + SIZES.frameHeaderControlBytes,
    frameHeaderTimestampEpochNanos = SIZES.frameHeaderMagicBytes + SIZES.frameHeaderControlBytes + SIZES.timestampEpochSeconds,
    dataTag = 0,
    dataType = SIZES.dataTagSize,
    dataValueLength = SIZES.dataTagSize + SIZES.dataTypeSize
)

/**
 * Helper object that defines some fixed values from the RSCP protocol
 */
val FIXED_VALUES = FixedValues(
    magicBytes = "E3DC".fromHexString(),
    controlBytesWithChecksum = "1100".fromHexString().reversedArray(),
    controlBytesWithoutChecksum = "1000".fromHexString().reversedArray(),
)

/**
 * Map containing all known tags. The key is the respective hex code as string in lowercase with leading prefix 0x
 */
val tagsByHexString = mutableMapOf<String, Tag>()
    .apply { putAll(BatTag.values().associateBy { it.hex.lowercase() }) }
    .apply { putAll(DBTag.values().associateBy { it.hex.lowercase() }) }
    .apply { putAll(DCDCTag.values().associateBy { it.hex.lowercase() }) }
    .apply { putAll(EMSTag.values().associateBy { it.hex.lowercase() }) }
    .apply { putAll(EPTag.values().associateBy { it.hex.lowercase() }) }
    .apply { putAll(FMSTag.values().associateBy { it.hex.lowercase() }) }
    .apply { putAll(HATag.values().associateBy { it.hex.lowercase() }) }
    .apply { putAll(InfoTag.values().associateBy { it.hex.lowercase() }) }
    .apply { putAll(PMTag.values().associateBy { it.hex.lowercase() }) }
    .apply { putAll(PVITag.values().associateBy { it.hex.lowercase() }) }
    .apply { putAll(RSCPTag.values().associateBy { it.hex.lowercase() }) }
    .apply { putAll(SRVTag.values().associateBy { it.hex.lowercase() }) }
    .apply { putAll(SYSTag.values().associateBy { it.hex.lowercase() }) }
    .apply { putAll(UMTag.values().associateBy { it.hex.lowercase() }) }
    .apply { putAll(WBTag.values().associateBy { it.hex.lowercase() }) }
    .toMap()

/**
 * Creates a byte array from the string assuming that the string is in valid hex format.
 *
 * The call works for strings with and without prefix 0x. There is no validation if the string is a valid hex string.
 *
 * @return ByteArray representation of the hex string
 *
 * @since 2.0
 */
fun String.fromHexString() =
    this
        .removePrefix("0x")
        .let {
            ByteArray(it.length / 2) { index ->
                it.substring(index * 2, index * 2 + 2).toInt(16).toByte()
            }
        }

/**
 * Creates a string from the [ByteArray] in hex format, without prefix
 *
 * @return Hex String representation of the [ByteArray]
 *
 * @since 2.0
 */
fun ByteArray.toHexString() =
    joinToString("") { String.format("%02x", it) }


/**
 * Calculates the CRC32 checksum of the ByteArray.
 *
 * @return Checksum of the ByteArray

 * @see [CRC32]
 *
 * @since 2.0
 */
fun ByteArray.crc32() =
    CRC32()
        .also { it.update(this) }
        .value

/**
 * Calculates the CRC32 checksum assuming that the byte buffer is an E3DC RSCP frame.
 * This means that the checksum is formed over all bytes of the buffer, minus the last 4. See [SIZES].
 *
 * @return ByteBuffer with filled checksum.
 */
fun ByteBuffer.fillCRC32forFrame(): ByteBuffer =
    putInt(
        array()
            .let { it.sliceArray(IntRange(0, it.size - 1 - SIZES.checksum)) }
            .crc32()
            .toInt()
    )


/**
 * Creates an empty [ByteBuffer] with the specified size [size] in bytes.
 *
 * The ByteOrder, as required by E3DC, is [ByteOrder.LITTLE_ENDIAN].
 *
 * @param size Size of the [ByteBuffer] in byte
 * @return Empty [ByteBuffer] object, with the requested size, in [ByteOrder.LITTLE_ENDIAN] order.
 *
 * @since 2.0
 */
fun emptyByteBuffer(size: Int): ByteBuffer =
    ByteBuffer
        .allocate(size)
        .order(ByteOrder.LITTLE_ENDIAN)


/**
 * Returns the [Tag] for the given [byteArray].
 *
 * If the tag is not known, an instance of [UnknownTag] is returned.
 *
 * @return [Tag] object to the given [byteArray].
 *
 * @since 2.0
 */
fun tagFromByteArray(byteArray: ByteArray): Tag =
    "0x${byteArray.toHexString()}"
        .let {
            when(tagsByHexString.containsKey(it)) {
                true -> tagsByHexString[it]!!
                else -> UnknownTag(it)
            }
        }

/**
 * Helper class to define different field sizes in the RSCP protocol. All sizes are specified in byte
 *
 * @param frameHeaderControlBytes Size of the control area in a FrameHeader in bytes
 * @param frameHeaderMagicBytes Size of the MagicBytes area in a FrameHeader in bytes
 * @param frameHeaderDataLength Size of the length specification field in a frame header in bytes
 * @param timestampEpochSeconds Size in bytes, of the seconds part in a value field of type [DataType.TIMESTAMP].
 * @param timestampEpochNanos Size in bytes, of the nanosecond portion in a value field of type [DataType.TIMESTAMP].
 * @param checksum Size of the CRC checksum section in a frame in bytes
 * @param dataTagSize Size of the tag section in a data area of a frame in bytes
 * @param dataTypeSize Size of the type section in a data area of a frame in bytes
 * @param dataValueLengthSize Size of the length section in a data area of a frame in bytes
 *
 * @since 2.0
 */
data class FieldSizes(
    val frameHeaderMagicBytes: Int,
    val frameHeaderControlBytes: Int,
    val frameHeaderDataLength: Int,
    val timestampEpochSeconds: Int,
    val timestampEpochNanos: Int,
    val checksum: Int,
    val dataTagSize: Int,
    val dataTypeSize: Int,
    val dataValueLengthSize: Int
) {
    /**
     * Size of a whole frame header in bytes
     *
     * @since 2.0
     */
    val completeHeaderSize =
        frameHeaderMagicBytes +
            frameHeaderControlBytes +
            timestampEpochSeconds +
            timestampEpochNanos +
            frameHeaderDataLength
}

/**
 * Helper class to hold fixed field positions in a RSCP frame. All data in byte
 *
 * @param frameHeaderControlBytes Position of the control area in a FrameHeader in bytes
 * @param frameHeaderMagicBytes Position of the MagicBytes area in a FrameHeader in bytes
 * @param frameHeaderDataLength Position of the length specification field in a frame header in bytes
 * @param frameHeaderTimestampEpochSeconds Position in bytes, of the seconds part in a FrameHeader in bytes
 * @param frameHeaderTimestampEpochNanos Position in bytes, of the nanos part in a FrameHeader in bytes
 * @param dataTag Position in bytes, of the tag section in a single datasection of a frame
 * @param dataType Position in bytes, of the type section in a single datasection of a frame
 * @param dataValueLength Position in bytes, of the length section in a single datasection of a frame
 *
 * @since 2.0
 */
data class FieldPositions(
    val frameHeaderMagicBytes: Int,
    val frameHeaderControlBytes: Int,
    val frameHeaderDataLength: Int,
    val frameHeaderTimestampEpochSeconds: Int,
    val frameHeaderTimestampEpochNanos: Int,
    val dataTag: Int,
    val dataType: Int,
    val dataValueLength: Int,
) {

    /**
     * Position of the data section in bytes within a frame
     */
    val frameDataSection = SIZES.completeHeaderSize

    /**
     * Position of the data section within a single data block of a frame
     */
    val dataValueSection = SIZES.dataTagSize + SIZES.dataTypeSize + SIZES.dataValueLengthSize
}

/**
 * @param magicBytes The magic bytes section of the RSCP Header
 * @param controlBytesWithChecksum String in hex format that is used for the ControlByte section in an RSCP frame when CRC checksums are active.
 * @param controlBytesWithoutChecksum String in hex format used for the ControlByte section in an RSCP frame when CRC checksums are NOT active.
 */
data class FixedValues(
    val magicBytes: ByteArray,
    val controlBytesWithChecksum: ByteArray,
    val controlBytesWithoutChecksum: ByteArray
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as FixedValues

        if (!magicBytes.contentEquals(other.magicBytes)) return false
        if (!controlBytesWithChecksum.contentEquals(other.controlBytesWithChecksum)) return false
        if (!controlBytesWithoutChecksum.contentEquals(other.controlBytesWithoutChecksum)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = magicBytes.contentHashCode()
        result = 31 * result + controlBytesWithChecksum.contentHashCode()
        result = 31 * result + controlBytesWithoutChecksum.contentHashCode()
        return result
    }
}

