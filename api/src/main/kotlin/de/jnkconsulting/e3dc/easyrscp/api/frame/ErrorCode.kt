package de.jnkconsulting.e3dc.easyrscp.api.frame

/**
 * Possible error codes that can be in data blocks of type [DataType.ERROR]
 *
 * @param rscpCode Code in the data block that identifies the error type
 *
 * @since 2.1
 */
enum class ErrorCode(val rscpCode: Byte) {
    /**
     * Empty data block. Usually used for request frames; code = 0x00
     */
    NOT_HANDLED(rscpCode = 0x00.toByte()),
    /**
     * Boolean typ. 1 for true, 0 for false; code = 0x01
     */
    ACCESS_DENIED(rscpCode = 0x01.toByte()),

    /**
     * Contains a 1byte number; code = 0x02
     */
    FORMAT(rscpCode = 0x02.toByte()),
    /**
     * Contains a 1byte number (unsigned); code = 0x03
     */
    AGAIN(rscpCode = 0x03.toByte()),

    UNKNOWN(rscpCode = 0xFF.toByte());


    companion object {

        /**
         * Returns the [ErrorCode] object for the given code.
         *
         * If the code is not known, [UNKNOWN] is supplied.
         *
         * @return [ErrorCode] object to the given code
         *
         * @since 2.1
         */
        fun byRscpCode(code: Int) =
            entries
                .find { it.rscpCode.toInt() == code }
                ?: UNKNOWN

    }
}
