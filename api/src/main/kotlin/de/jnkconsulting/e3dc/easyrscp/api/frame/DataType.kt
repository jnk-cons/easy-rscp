package de.jnkconsulting.e3dc.easyrscp.api.frame

/**
 * Possible data types that can be used in [Data] objects.
 *
 * @param code Code in the data block that identifies the data type
 *
 * @since 2.0
 */
enum class DataType(val code: Byte) {
    NONE(0x00.toByte()),
    BOOL(0x01.toByte()),
    CHAR8(0x02.toByte()),
    UCHAR8(0x03.toByte()),
    INT16(0x04.toByte()),
    UINT16(0x05.toByte()),
    INT32(0x06.toByte()),
    UINT32(0x07.toByte()),
    INT64(0x08.toByte()),
    UINT64(0x09.toByte()),
    FLOAT32(0x0A.toByte()),
    DOUBLE64(0x0B.toByte()),
    BITFIELD(0x0C.toByte()),
    STRING(0x0D.toByte()),
    CONTAINER(0x0E.toByte()),
    TIMESTAMP(0x0F.toByte()),
    BYTEARRAY(0x10.toByte()),
    ERROR(0xFF.toByte()),

    /**
     * Not an official E3DC DataType. Used to represent Unknown types
     */
    UNKNOWN(0xFE.toByte());

    /**
     * Checks if the type is a valid [Byte] type.
     *
     * @return true if [code] is [CHAR8] or [UCHAR8], false otherwise
     *
     * @since 2.0
     */
    fun isByteType() =
        code == CHAR8.code || code == UCHAR8.code

    /**
     * Checks if the type is a valid [Short] type.
     *
     * @return true if [code] is [INT16], [UINT16] or [isByteType] is true. false otherwise
     *
     * @since 2.0
     */
    fun isShortType() =
        isByteType() || code == INT16.code || code == UINT16.code

    /**
     * Checks if the type is a valid [Int] type.
     *
     * @return true if [code] is [INT32], [UINT32] or [isShortType] is true. false otherwise
     *
     * @since 2.0
     */
    fun isIntType() =
        isShortType() || code == INT32.code || code == UINT32.code

    /**
     * Checks if the type is a valid [Long] type.
     *
     * @return true if [code] is [INT64], [UINT64] or [isIntType] is true. false otherwise
     *
     * @since 2.0
     */
    fun isLongType() =
        isIntType() || code == INT64.code || code == UINT64.code


    companion object {

        /**
         * Returns the [DataType] object for the given code.
         *
         * If the code is not known, [UNKNOWN] is supplied.
         *
         * @return [DataType] object to the given code
         *
         * @since 2.0
         */
        fun byCode(code: Byte) =
            DataType.values()
                .find { it.code == code }
                ?: UNKNOWN

    }
}
