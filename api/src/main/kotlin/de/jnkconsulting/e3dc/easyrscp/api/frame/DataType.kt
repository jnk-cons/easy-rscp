package de.jnkconsulting.e3dc.easyrscp.api.frame

/**
 * Possible data types that can be used in [Data] objects.
 *
 * @param code Code in the data block that identifies the data type
 *
 * @since 2.0
 */
enum class DataType(val code: Byte) {
    /**
     * Empty data block. Usually used for request frames; code = 0x00
     */
    NONE(code = 0x00.toByte()),
    /**
     * Boolean typ. 1 for true, 0 for false; code = 0x01
     */
    BOOL(code = 0x01.toByte()),

    /**
     * Contains a 1byte number; code = 0x02
     */
    CHAR8(code = 0x02.toByte()),
    /**
     * Contains a 1byte number (unsigned); code = 0x03
     */
    UCHAR8(code = 0x03.toByte()),
    /**
     * Contains a 2byte number; code = 0x04
     */
    INT16(code = 0x04.toByte()),
    /**
     * Contains a 2byte number; code = 0x05
     */
    UINT16(code = 0x05.toByte()),
    /**
     * Contains a 4byte number; code = 0x06
     */
    INT32(code = 0x06.toByte()),
    /**
     * Contains a 4byte number (unsigned); code = 0x07
     */
    UINT32(code = 0x07.toByte()),
    /**
     * Contains a 8byte number; code = 0x08
     */
    INT64(code = 0x08.toByte()),
    /**
     * Contains a 8byte number (unsigned); code = 0x09
     */
    UINT64(code = 0x09.toByte()),
    /**
     * Contains a 4byte floating point number; code = 0x0A
     */
    FLOAT32(code = 0x0A.toByte()),

    /**
     * Contains a 8byte floating point number; code = 0x0B
     */
    DOUBLE64(code = 0x0B.toByte()),

    /**
     * Unknown, 1byte long. It seems never to be used. According to the name it gives a bit pattern; code = 0x0C
     */
    BITFIELD(code = 0x0C.toByte()),

    /**
     * UTF-8 (I think ...) encoded text; code = 0x0D
     */
    STRING(code = 0x0D.toByte()),

    /**
     * A block that contains other blocks; code = 0x0E
     */
    CONTAINER(code = 0x0E.toByte()),

    /**
     * A timestamp since 01.01.1970 00:00h UTC in seconds and nanoseconds; code = 0x0F
     */
    TIMESTAMP(code = 0x0F.toByte()),

    /**
     * Binary data; code = 0x10
     */
    BYTEARRAY(code = 0x10.toByte()),

    /**
     * Transmits error codes; code = 0xFF
     */
    ERROR(code = 0xFF.toByte()),

    /**
     * Not an official E3DC DataType. Used to represent Unknown types; code = 0xFE
     */
    UNKNOWN(code = 0xFE.toByte());

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
            entries
                .find { it.code == code }
                ?: UNKNOWN

    }
}
