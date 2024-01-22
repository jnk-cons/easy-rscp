package de.jnkconsulting.e3dc.easyrscp.api.frame

import de.jnkconsulting.e3dc.easyrscp.api.bytes.FIXED_VALUES
import de.jnkconsulting.e3dc.easyrscp.api.bytes.SIZES
import de.jnkconsulting.e3dc.easyrscp.api.bytes.emptyByteBuffer
import de.jnkconsulting.e3dc.easyrscp.api.bytes.fillCRC32forFrame
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ResultCode
import java.time.Duration
import java.time.Instant

/**
 * RSCP data frame that can be sent to or received from an E3DC home power plant.
 *
 * A frame always consists of 3 logical parts:
 * Timestamp reflecting the creation time of the frame
 * Control area, contains the protocol version and a control information whether the checksum feature is used or not.
 * Data, the RSCP data itself.
 *
 * @param timestamp Creation time of the frame
 * @param controlBytes Control functions. Currently, the protocol version as well as a control bit whether checksum are used or not. See [FIXED_VALUES].
 * @param data The data itself. See [Data]
 * @param parser The parser to use for parsing container data
 *
 * @since 2.0
 * @since 2.1 new functions:
 * - [isDataBlockInError]
 * - [errorCodeByTag]
 */
data class Frame(
    val timestamp: Instant,
    val controlBytes: ByteArray,
    val data: List<Data>,
    val parser: DataParser,
) {

    /**
     * Provides the byte representation of the frame as it may be sent to or received from the home power plant.
     *
     * A frame is structured according to the following pattern:
     * - Byte 0 - 1: So-called magic bytes. Are fixed on the byte value of the hex string E3DC.
     * - Byte 2 - 3: Control area. The first byte is always 00 and is reserved for the future according to E3DC. The second byte contains the protocol version (currently always 1) and a 0 (without checksum) or 1 (with checksum).
     * - Byte 4 - 15: Contain the timestamp. 4 - 11 in seconds since 01.01.1970, and 12 - 15 the nanoseconds.
     * - Byte 16 - 17: Length in bytes for the following data block
     * - Bytes 18 - n: Data range
     * - Bytes n+1 - n + 4: CRC32 Checksum of the frame when bytes 0 - n are considered. This block is omitted if the checksum bit is set to 0 in the control area.
     *
     * @return [ByteArray] of the whole frame
     *
     * @since 2.0
     *
     */
    fun asByteArray(): ByteArray =
        dataAsBytes().let { data ->
            val result = emptyByteBuffer(frameSize())
                .put(FIXED_VALUES.magicBytes)
                .put(controlBytes)
                .putLong(timestamp.epochSecond)
                .putInt(timestamp.nano)
                .putShort(data.size.toShort())
                .put(data)

            if (isChecksumEnabled()) {
                result.fillCRC32forFrame()
            }

            result.array()
        }

    /**
     * Searches for a data block with the specified tag
     *
     * @param tag To be searched [Tag]
     * @param containerPath Path, if the block is to be searched nested in container blocks
     *
     * @return Data block or null if not found
     *
     * @since 2.0
     */
    fun dataByTag(tag: Tag, vararg containerPath: Tag) =
        find(tag, data, *containerPath)


    private fun find(tag: Tag, dataBlocks: List<Data>,  vararg containerPath: Tag): Data? {
        if (containerPath.isEmpty()) {
            return dataBlocks.find { d -> d.tagObject() == tag }
        }
        else {
            val currentContainerTag = containerPath[0]
            val container = dataBlocks.find { d -> d.tagObject() == currentContainerTag } ?: return null
            return find(tag, container.valueAsContainer(parser), *containerPath.sliceArray(IntRange(1, containerPath.size -1)))
        }
    }

    /**
     * Searches for a data block of type [tag] and returns the value as [Int].
     *
     * If the block is not found, or is not a valid [Int] type (see [DataType.isIntType], the value 0 is returned.
     *
     * @param tag The [Tag] to search for
     * @param containerPath Optional path through datablocks of type [DataType.CONTAINER].
     *
     * @return Value of the data block as [Int] or 0 if the data block does not exist or is not a valid [Int] type.
     *
     * @since 2.0
     */
    fun intByTag(tag: Tag, vararg containerPath: Tag) =
        find(tag, data, *containerPath)
            ?.valueAsInt() ?: 0

    /**
     * Searches for a data block of type [tag] and returns the value as [Short].
     *
     * If the block is not found, or is not a valid [Short] type (see [DataType.isShortType], the value 0 is returned.
     *
     * @param tag The [Tag] to search for
     * @param containerPath Optional path through datablocks of type [DataType.CONTAINER].
     *
     * @return Value of the data block as [Short] or 0 if the data block does not exist or is not a valid [Short] type.
     *
     * @since 2.0
     */
    fun shortByTag(tag: Tag, vararg containerPath: Tag) =
        find(tag, data, *containerPath)
            ?.valueAsShort() ?: 0

    /**
     * Searches for a data block of type [tag] and returns the value as [Byte].
     *
     * If the block is not found, or is not a valid [Byte] type (see [DataType.isByteType], the value 0 is returned.
     *
     * @param tag The [Tag] to search for
     * @param containerPath Optional path through datablocks of type [DataType.CONTAINER].
     *
     * @return Value of the data block as [Byte] or 0 if the data block does not exist or is not a valid [Byte] type.
     *
     * @since 2.0
     */
    fun byteByTag(tag: Tag, vararg containerPath: Tag) =
        find(tag, data, *containerPath)
            ?.valueAsByte() ?: 0

    /**
     * Searches for a data block of type [tag] and returns the value as [Long].
     *
     * If the block is not found, or is not a valid [Long] type (see [DataType.isLongType], the value 0 is returned.
     *
     * @param tag The [Tag] to search for
     * @param containerPath Optional path through datablocks of type [DataType.CONTAINER].
     *
     * @return Value of the data block as [Long] or 0 if the data block does not exist or is not a valid [Long] type.
     *
     * @since 2.0
     */
    fun longByTag(tag: Tag, vararg containerPath: Tag) =
        find(tag, data, *containerPath)
            ?.valueAsLong() ?: 0

    /**
     * Searches for a data block of type [tag] and returns the value as [Float].
     *
     * If the block is not found, or is not a valid [Float] type (see [DataType.FLOAT32]), the value 0.0f is returned.
     *
     * @param tag The [Tag] to search for
     * @param containerPath Optional path through datablocks of type [DataType.CONTAINER].
     *
     * @return Value of the data block as [Float] or 0.0f if the data block does not exist or is not a valid [Float] type.
     *
     * @since 2.0
     */
    fun floatByTag(tag: Tag, vararg containerPath: Tag) =
        find(tag, data, *containerPath)
            ?.valueAsFloat() ?: 0.0f

    /**
     * Searches for a data block of type [tag] and returns the value as [Double].
     *
     * If the block is not found, or is not a valid [Double] type (see [DataType.DOUBLE64]), the value 0.0 is returned.
     *
     * @param tag The [Tag] to search for
     * @param containerPath Optional path through datablocks of type [DataType.CONTAINER].
     *
     * @return Value of the data block as [Double] or 0.0 if the data block does not exist or is not a valid [Double] type.
     *
     * @since 2.0
     */
    fun doubleByTag(tag: Tag, vararg containerPath: Tag) =
        find(tag, data, *containerPath)
            ?.valueAsDouble() ?: 0.0

    /**
     * Searches for a data block of type [tag] and returns the value as [Boolean].
     *
     * If the block is not found, or is not a valid [Boolean] type (see [DataType.BOOL]), the value false is returned.
     *
     * @param tag The [Tag] to search for
     * @param containerPath Optional path through datablocks of type [DataType.CONTAINER].
     *
     * @return Value of the data block as [Boolean] or false if the data block does not exist or is not a valid [Boolean] type.
     *
     * @since 2.0
     */
    fun booleanByTag(tag: Tag, vararg containerPath: Tag) =
        find(tag, data, *containerPath)
            ?.valueAsBoolean() ?: false

    /**
     * Searches for a data block of type [tag] and returns the value as [DataType.CONTAINER].
     *
     * If the block is not found, or is not a valid [DataType.CONTAINER], an empty list is returned.
     *
     * @param tag The [Tag] to search for
     * @param containerPath Optional path through datablocks of type [DataType.CONTAINER].
     *
     * @return Value of the data block as [DataType.CONTAINER] or an empty list if the data block does not exist or is not a valid [DataType.CONTAINER] type.
     *
     * @since 2.0
     */
    fun containerByTag(tag: Tag, vararg containerPath: Tag): List<Data> =
        find(tag, data, *containerPath)
            ?.valueAsContainer(parser) ?: emptyList()

    /**
     * Searches for a data block of type [tag] and returns the value as [String].
     *
     * If the block is not found, the empty String is returned.
     *
     * @param tag The [Tag] to search for
     * @param containerPath Optional path through datablocks of type [DataType.CONTAINER].
     *
     * @return Value of the data block as [String] or the empty String if the data block does not exist.
     *
     * @since 2.0
     */
    fun stringByTag(tag: Tag, vararg containerPath: Tag) =
        find(tag, data, *containerPath)
            ?.valueAsString() ?: ""

    /**
     * Searches for a data block of type [tag] and returns the value as [Instant].
     *
     * If the block is not found, or is not a valid [Instant] type (see [DataType.TIMESTAMP]), [Instant.now] is returned
     *
     * @param tag The [Tag] to search for
     * @param containerPath Optional path through datablocks of type [DataType.CONTAINER].
     *
     * @return Value of the data block as [Instant] or [Instant.now] if the data block does not exist or is not of [DataType.TIMESTAMP] type.
     *
     * @since 2.0
     */
    fun instantByTag(tag: Tag, vararg containerPath: Tag) =
        find(tag, data, *containerPath)
            ?.valueAsInstant() ?: Instant.now()

    /**
     * Searches for a data block of type [tag] and returns the value as [Duration].
     *
     * If the block is not found, or is not a valid [Duration] type (see [DataType.TIMESTAMP]), [Instant.now] is returned
     *
     * @param tag The [Tag] to search for
     * @param containerPath Optional path through datablocks of type [DataType.CONTAINER].
     *
     * @return Value of the data block as [Duration] or [Instant.now] if the data block does not exist or is not a [DataType.TIMESTAMP] type.
     *
     * @since 2.0
     */
    fun durationByTag(tag: Tag, vararg containerPath: Tag): Duration =
        instantByTag(tag, *containerPath)
            .let { Duration.ofSeconds(it.epochSecond, it.nano.toLong()) }

    /**
     * Searches for a data block of type [tag] and returns the value as [ResultCode].
     *
     * If the block is not found [ResultCode.UNKNOWN] is returned.
     *
     * @param tag The [Tag] to search for
     * @param containerPath Optional path through datablocks of type [DataType.CONTAINER].
     *
     * @return Value of the data block as [ResultCode] or [ResultCode.UNKNOWN] if the data block does not exist.
     *
     * @since 2.0
     */
    fun resultCodeByTag(tag: Tag, vararg containerPath: Tag) =
        find(tag, data, *containerPath)
            ?.valueAsResultCode() ?: ResultCode.UNKNOWN

    /**
     * Checks whether the data block in the frame is of data type [DataType.ERROR].
     *
     * @param tag The [Tag] to search for
     * @param containerPath Optional path through datablocks of type [DataType.CONTAINER].
     *
     * @return true if the data block is of type [DataType.ERROR], otherwise false
     *
     * @since 2.1
     */
    fun isDataBlockInError(tag: Tag, vararg containerPath: Tag) =
        find(tag, data, *containerPath)
            ?.isErrorResponse() ?: false

    /**
     * Searches for a data block of type [tag] and returns the value as [ErrorCode].
     *
     * If the block is not found [ErrorCode.UNKNOWN] is returned.
     *
     * @param tag The [Tag] to search for
     * @param containerPath Optional path through datablocks of type [DataType.CONTAINER].
     *
     * @return Value of the data block as [ErrorCode] or [ErrorCode.UNKNOWN] if the data block does not exist.
     *
     * @since 2.1
     */
    fun errorCodeByTag(tag: Tag, vararg containerPath: Tag) =
        find(tag, data, *containerPath)
            ?.valueAsErrorCode() ?: ErrorCode.UNKNOWN

    /**
     * Query whether the frame calculates the checksum or not.
     *
     * @return true wenn ja, ansonsten false
     *
     * @since 2.0
     */
    fun isChecksumEnabled() =
        controlBytes[1].toInt() == 17

    private fun frameSize() =
        SIZES.completeHeaderSize + dataSize() + checksumSize()


    private fun dataAsBytes() =
        data
            .map { it.asByteArray() }
            .fold(byteArrayOf()) { acc, bytes -> acc + bytes }

    private fun dataSize() =
        data
            .sumOf { it.asByteArray().size }

    private fun checksumSize() =
        when (isChecksumEnabled()) {
            true -> SIZES.checksum
            else -> 0
        }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Frame

        if (timestamp != other.timestamp) return false
        if (!controlBytes.contentEquals(other.controlBytes)) return false
        if (data != other.data) return false

        return true
    }

    override fun hashCode(): Int {
        var result = timestamp.hashCode()
        result = 31 * result + controlBytes.contentHashCode()
        result = 31 * result + data.hashCode()
        return result
    }

    override fun toString(): String {
        return "Frame(timestamp=$timestamp, controlBytes=${controlBytes.contentToString()}, data=$data, parser=$parser)"
    }


}
