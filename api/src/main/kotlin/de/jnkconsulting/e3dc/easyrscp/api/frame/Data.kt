package de.jnkconsulting.e3dc.easyrscp.api.frame

import de.jnkconsulting.e3dc.easyrscp.api.bytes.*
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ResultCode
import java.time.Duration
import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter

/**
 * Data object that can be used within a [Frame].
 *
 * A data object always consists of 3 parts:
 * A [Tag] that identifies the meaning,
 * a [DataType] that describes the format of the [value] array
 * and the data itself.
 *
 * @param tag [Tag] for logical assignment of the data block. See [Tag].
 * @param type [DataType] of this data block
 * @param value The actual value
 *
 * @since 2.0
 * @since 2.1 new function:
 * - [valueAsErrorCode]
 */
data class Data(
    val tag: ByteArray,
    val type: Byte,
    val value: ByteArray
) {

    /**
     * Further constructor to create an instance with the corresponding objects and not to go the low-level way via the byte structures.
     *
     * @param tag [Tag] for logical assignment of the data block. See [Tag].
     * @param type [DataType] of this data block
     * @param value The actual value
     *
     * @since 2.0
     */
    constructor(tag: Tag, type: DataType, value: ByteArray) : this(tag.hex.fromHexString(), type.code, value)

    /**
     * Returns the tag object to the [tag] [ByteArray]
     *
     * @return [Tag] Object
     *
     * @since 2.0
     */
    fun tagObject() =
        tagFromByteArray(tag)

    /**
     * Returns the [DataType] object to the [type] [ByteArray].
     *
     * @return [DataType] Object
     *
     * @since 2.0
     */
    fun typeObject() =
        DataType.byCode(type)

    /**
     * If [typeObject] is of type [DataType.CONTAINER], the data block is processed using the [parser] object and the result is returned.
     *
     * In all other cases an empty list is returned.
     *
     * @param parser Parser to process the data block
     * @return Result of the parsing
     *
     * @since 2.0
     */
    fun valueAsContainer(parser: DataParser) =
        when(type == DataType.CONTAINER.code) {
            true -> parser.parseRSCPData(value)
            else -> listOf()
        }

    /**
     * If [typeObject] is a valid byte type (see [DataType.isByteType]), the data block is interpreted as [Byte] and returned.
     *
     * In all other cases, null is returned.
     *
     * @return Data block as [Byte] or zero if the data type does not fit
     *
     * @since 2.0
     */
    fun valueAsByte() =
        when(typeObject().isByteType()) {
            true -> valueAsBuffer(Byte.SIZE_BYTES).get()
            else -> null
        }

    /**
     * If [typeObject] is a valid short type (see [DataType.isShortType]), the data block is interpreted as [Short] and returned.
     *
     * In all other cases, null is returned.
     *
     * @return Data block as [Short] or zero if the data type does not fit
     *
     * @since 2.0
     */
    fun valueAsShort() =
        when(typeObject().isShortType()) {
            true -> valueAsBuffer(Short.SIZE_BYTES).getShort()
            else -> null
        }

    /**
     * If [typeObject] is a valid int type (see [DataType.isIntType]), the data block is interpreted as [Int] and returned.
     *
     * In all other cases, null is returned.
     *
     * @return Data block as [Int] or zero if the data type does not fit
     *
     * @since 2.0
     */
    fun valueAsInt() =
        when(typeObject().isIntType()) {
            true -> valueAsBuffer(Int.SIZE_BYTES).getInt()
            else -> null
        }

    /**
     * If [typeObject] is a valid long type (see [DataType.isLongType]), the data block is interpreted as [Long] and returned.
     *
     * In all other cases, null is returned.
     *
     * @return Data block as [Long] or zero if the data type does not fit
     *
     * @since 2.0
     */
    fun valueAsLong() =
        when(typeObject().isLongType()) {
            true -> valueAsBuffer(Long.SIZE_BYTES).getLong()
            else -> null
        }

    /**
     * If [typeObject] is of type [DataType.FLOAT32], the data block is interpreted as [Float] and returned.
     *
     * In all other cases, null is returned.
     *
     * @return Data block as [Float] or zero if the data type does not fit
     *
     * @since 2.0
     */
    fun valueAsFloat() =
        when(type == DataType.FLOAT32.code) {
            true -> valueAsBuffer(Float.SIZE_BYTES).getFloat()
            else -> null
        }

    /**
     * If [typeObject] is of type [DataType.DOUBLE64], the data block is interpreted as [Double] and returned.
     *
     * In all other cases, null is returned.
     *
     * @return Data block as [Double] or zero if the data type does not fit
     *
     * @since 2.0
     */
    fun valueAsDouble() =
        when(type == DataType.DOUBLE64.code) {
            true -> valueAsBuffer(Double.SIZE_BYTES).getDouble()
            else -> null
        }

    /**
     * If [typeObject] is of type [DataType.BOOL], the data block is interpreted as [Boolean] and returned.
     *
     * In all other cases, null is returned.
     *
     * @return Data block as [Boolean] or zero if the data type does not fit
     *
     * @since 2.0
     */
    fun valueAsBoolean() =
        when(type == DataType.BOOL.code && value.size == 1) {
            true -> value[0] == 1.toByte()
            else -> null
        }

    /**
     * Regardless of the [typeObject] result, the data block is converted to a [String].
     *
     * Depending on the data type, the conversion is performed according to different rules:
     * - [DataType.NONE] -> The fixed string "`[`NONE`]`" is returned
     * - [DataType.BOOL] -> The result of [String.format] with the parameter `%b` is returned
     * - All integer types -> The result of [String.format] with the parameter `%d` is returned
     * - All floating point types -> The result of [String.format] with the parameter `%.2f` is returned
     * - [DataType.BITFIELD] -> The result of [String.format] with the parameter `%b` is returned
     * - [DataType.STRING] -> The data block is interpreted as a string with the character set [Charsets.UTF_8] and returned
     * - [DataType.CONTAINER] -> The fixed string "`[`CONTAINER`]`" is returned
     * - [DataType.TIMESTAMP] -> The data block is interpreted as [Instant] and converted with the time zone information [ZoneOffset.UTC] into a string with the format [DateTimeFormatter.ISO_LOCAL_DATE_TIME] and returned
     * - Everything else -> All other types (also unknown), return the value as hex string
     *
     * @return Data block as string interpretation, depending on type (See [typeObject].
     *
     * @since 2.0
     */
    fun valueAsString(): String =
        when(type) {
            DataType.NONE.code -> "[NONE]"
            DataType.BOOL.code -> String.format("%b", valueAsBoolean())
            DataType.CHAR8.code -> String.format("%d", valueAsByte())
            DataType.UCHAR8.code -> String.format("%d", valueAsByte())
            DataType.INT16.code -> String.format("%d", valueAsShort())
            DataType.UINT16.code -> String.format("%d", valueAsShort())
            DataType.INT32.code -> String.format("%d", valueAsInt())
            DataType.UINT32.code -> String.format("%d", valueAsInt())
            DataType.INT64.code -> String.format("%d", valueAsLong())
            DataType.UINT64.code -> String.format("%d", valueAsLong())
            DataType.FLOAT32.code -> String.format("%.2f", valueAsFloat())
            DataType.DOUBLE64.code -> String.format("%.2f", valueAsDouble())
            DataType.BITFIELD.code -> String.format("%d", valueAsByte())
            DataType.STRING.code -> String(value, Charsets.UTF_8)
            DataType.CONTAINER.code -> "[CONTAINER]"
            DataType.TIMESTAMP.code -> valueAsInstant().let { DateTimeFormatter.ISO_LOCAL_DATE_TIME.withZone(ZoneId.from(ZoneOffset.UTC)).format(it) }
            else -> value.toHexString()
        }

    /**
     * If [typeObject] is of type [DataType.TIMESTAMP], the data block is interpreted as E3DC timestamp and converted to an [Instant] object and returned.
     *
     * In all other cases, null is returned.
     *
     * @return Data block as [Instant] or zero if the data type does not fit
     *
     * @since 2.0
     */
    fun valueAsInstant() =
        when(type == DataType.TIMESTAMP.code) {
            true -> valueAsBuffer(SIZES.timestampEpochSeconds + SIZES.timestampEpochNanos)
                .let {
                    Instant.ofEpochSecond(it.getLong(), it.getInt().toLong())
                }
            else -> null
        }

    /**
     * If [typeObject] is of type [DataType.TIMESTAMP], the data block is interpreted as E3DC timestamp and converted to an [Duration] object and returned.
     *
     * In all other cases, null is returned.
     *
     * @return Data block as [Duration] or zero if the data type does not fit
     *
     * @since 2.0
     */
    fun valueAsDuration() =
        valueAsInstant()
            ?.let { Duration.ofSeconds(it.epochSecond, it.nano.toLong()) }


    /**
     * Returns the complete [ByteArray] of this data block as it was sent to or received from the E3DC home power plant.
     *
     * - Byte 0-3: are for the [Tag]
     * - Byte 4: specifies the [DataType]
     * - Byte 5-6: Specifies the data length of the [value] field
     * - ALL following bytes contain the actual value ([value])
     *
     * @return [ByteArray] in RSCP format
     *
     * @since 2.0
     */
    fun asByteArray(): ByteArray =
        tag.reversedArray() +
                typeAsArray().reversedArray() +
                emptyByteBuffer(Short.SIZE_BYTES)
                    .putShort(value.size.toShort())
                    .array() +
                value

    /**
     * Reads the Int value of the data block and converts it into a [ResultCode].
     *
     * @return [ResultCode] value
     *
     * @since 2.0
     */
    fun valueAsResultCode() =
        if (typeObject() == DataType.ERROR) ResultCode.UNKNOWN else ResultCode.byRscpCode(valueAsInt()?:ResultCode.UNKNOWN.rscpCode)

    /**
     * Reads the Int value of the data block and converts it into a [ErrorCode].
     *
     * @return [ErrorCode] Value
     *
     * @since 2.1
     */
    fun valueAsErrorCode() =
        if (typeObject() == DataType.ERROR) ResultCode.UNKNOWN else ErrorCode.byRscpCode(valueAsInt() ?: ErrorCode.UNKNOWN.rscpCode.toInt())

    /**
     * Checks if the response type is of type error.
     *
     * If a request fails, for whatever reason, you get the normal tag back as a response, but the type is [DataType.ERROR].
     *
     * @return true if it is an error response, otherwise false
     *
     * @since 2.0
     *
     */
    fun isErrorResponse() = typeObject() == DataType.ERROR


    private fun valueAsBuffer(size: Int) =
        emptyByteBuffer(size)
            .put(value)
            .rewind()

    private fun typeAsArray() =
        ByteArray(1)
            .apply { set(0, type) }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Data

        if (!tag.contentEquals(other.tag)) return false
        if (!value.contentEquals(other.value)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = tag.contentHashCode()
        result = 31 * result + value.contentHashCode()
        return result
    }

    override fun toString(): String {
        return "Data(tag=${tagObject()} - ${tag.contentToString()}, type=${typeObject()} - $type, value=${value.size} bytes)"
    }


}
