package de.jnkconsulting.e3dc.easyrscp.frame

import de.jnkconsulting.e3dc.easyrscp.api.bytes.*
import de.jnkconsulting.e3dc.easyrscp.api.frame.Data
import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Tag
import java.lang.IllegalStateException
import java.nio.charset.Charset
import java.time.Duration
import java.time.Instant

/**
 * Builder class to create instances of the [Data] type
 *
 * @sample de.jnkconsulting.e3dc.easyrscp.frame.samples.createBatDeviceNameExampleData
 *
 * @since 2.0
 */
class DataBuilder {

    private var tag: ByteArray? = null
    private var dataType: Byte? = null
    private var value: ByteArray? = null

    /**
     * Sets the [tag] to use, here directly as [ByteArray].
     *
     * @param bytes Data of the [Tag]
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun tag(bytes: ByteArray) =
        bytes
            .also { tag = it }
            .let { this }

    /**
     * Sets the [Tag] and [DataType] to use. See [Tag.type].
     *
     * @param tag The [Tag] to be used
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun tag(tag: Tag) =
        tag
            .let {
                dataType = it.type.code
                it.hex.fromHexString()
            }.let { tag(it) }

    /**
     * Sets the raw data without type safety.
     *
     * @param value Raw data
     * @param type Data type to be set. See [DataType.code].
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun raw(value: ByteArray, type: Byte) =
        value
            .also {
                this.value = it
                dataType = type
            }
            .let { this }

    /**
     * Sets the value as timestamp and the data type to [DataType.TIMESTAMP].
     *
     * @param timestamp Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun timestamp(timestamp: Instant) =
        emptyByteBuffer(SIZES.timestampEpochSeconds + SIZES.timestampEpochNanos)
            .putLong(timestamp.epochSecond)
            .putInt(timestamp.nano)
            .array()
            .let { raw(it, DataType.TIMESTAMP.code) }


    /**
     * Sets the value as timestamp and the data type to [DataType.TIMESTAMP].
     *
     * @param timestamp Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun timestamp(timestamp: Duration) =
        timestamp(Instant.ofEpochSecond(timestamp.seconds, timestamp.nano.toLong()))

    /**
     * Sets an empty [ByteArray] as value and the data type [DataType.NONE].
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun none() =
        raw(ByteArray(0), DataType.NONE.code)

    /**
     * Sets the value as [Boolean] and the data type to [DataType.BOOL].
     *
     * @param value Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun bool(value: Boolean) =
        ByteArray(1)
            .also { it[0] = (if (value) 1 else 0).toByte() }
            .let { raw(it, DataType.BOOL.code) }

    /**
     * Sets the value as [Byte] and the data type to [DataType.CHAR8].
     *
     * @param value Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun char8(value: Byte) =
        emptyByteBuffer(1)
            .put(value)
            .array()
            .let { raw(it, DataType.CHAR8.code) }

    /**
     * Sets the value as [Byte] and the data type to [DataType.UCHAR8].
     *
     * @param value Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun uchar8(value: Byte) =
        emptyByteBuffer(1)
            .put(value)
            .array()
            .let { raw(it, DataType.UCHAR8.code) }

    /**
     * Sets the value as [Short] and the data type to [DataType.INT16].
     *
     * @param value Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun int16(value: Short) =
       emptyByteBuffer(Short.SIZE_BYTES)
           .putShort(value)
           .array()
           .let { raw(it, DataType.INT16.code) }

    /**
     * Sets the value as [Short] and the data type to [DataType.UINT16].
     *
     * @param value Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun uint16(value: Short) =
        emptyByteBuffer(Short.SIZE_BYTES)
            .putShort(value)
            .array()
            .let { raw(it, DataType.UINT16.code) }

    /**
     * Sets the value as [Int] and the data type to [DataType.INT32].
     *
     * @param value Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun int32(value: Int) =
        emptyByteBuffer(Int.SIZE_BYTES)
            .putInt(value)
            .array()
            .let { raw(it, DataType.INT32.code) }

    /**
     * Sets the value as [Int] and the data type to [DataType.UINT32].
     *
     * @param value Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun uint32(value: Int) =
        emptyByteBuffer(Int.SIZE_BYTES)
            .putInt(value)
            .array()
            .let { raw(it, DataType.UINT32.code) }

    /**
     * Sets the value as [Long] and the data type to [DataType.INT64].
     *
     * @param value Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun int64(value: Long) =
        emptyByteBuffer(Long.SIZE_BYTES)
            .putLong(value)
            .array()
            .let { raw(it, DataType.INT64.code) }

    /**
     * Sets the value as [Long] and the data type to [DataType.UINT64].
     *
     * @param value Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun uint64(value: Long) =
        emptyByteBuffer(Long.SIZE_BYTES)
            .putLong(value)
            .array()
            .let { raw(it, DataType.UINT64.code) }

    /**
     * Sets the value as [Float] and the data type to [DataType.FLOAT32].
     *
     * @param value Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun float32(value: Float) =
        emptyByteBuffer(Float.SIZE_BYTES)
            .putFloat(value)
            .array()
            .let { raw(it, DataType.FLOAT32.code) }

    /**
     * Sets the value as [Double] and the data type to [DataType.DOUBLE64].
     *
     * @param value Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun double64(value: Double) =
        emptyByteBuffer(Double.SIZE_BYTES)
            .putDouble(value)
            .array()
            .let { raw(it, DataType.DOUBLE64.code) }

    /**
     * Sets the value as [Byte] and the data type to [DataType.BITFIELD].
     *
     * @param value Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun bitfield(value: Byte) =
        emptyByteBuffer(1)
            .put(value)
            .array()
            .let { raw(it, DataType.BITFIELD.code) }

    /**
     * Sets the value as [String] and the data type to [DataType.STRING].
     *
     * The UTF-8 character set is used to convert the string into a [ByteArray].
     *
     * @param value Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun string(value: String) =
        raw(value.toByteArray(Charset.forName("UTF-8")), DataType.STRING.code)

    /**
     * Sets the value to the [ByteArray] representation of the passed [Data] list. The data type is set to [DataType.CONTAINER]..
     *
     * @param value Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun container(value: List<Data>) =
        value
            .forEach { containerAdd(it) }
            .let { this }

    /**
     * Sets the value to the [ByteArray] representation of the passed [Data] arguments. The data type is set to [DataType.CONTAINER]..
     *
     * @param value Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun container(vararg value: Data) =
        value
            .forEach { containerAdd(it) }
            .let { this }

    private fun containerAdd(value: Data) {
        this.value = nullSafeValue() + value.asByteArray()
        dataType = DataType.CONTAINER.code
    }


    /**
     * Sets the value as [ByteArray] and the data type to [DataType.BYTEARRAY].
     *
     * @param value Value to be set
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun bytearray(value: ByteArray) =
        raw(value, DataType.BYTEARRAY.code)

    /**
     * Creates a [Data] objects based on the configured data.
     *
     * @return [Data] Object
     *
     * @throws IllegalStateException If the configured data is not complete
     *
     * @since 2.0
     */
    fun build() =
        tag
            .let { it?: throw IllegalStateException("tag is required") }
            .also { ensureValueIsSet() }
            .let { it to (value?: throw IllegalStateException("value is required")) }
            .let { it to (dataType?: throw IllegalStateException("dataType is required")) }
            .let { Data(it.first.first, it.second, it.first.second) }

    private fun ensureValueIsSet() {
        if (value == null) none()
    }

    private fun nullSafeValue() =
        value?: ByteArray(0)

}
