package de.jnkconsulting.e3dc.easyrscp.api.service.model

/**
 * Represents a percentage value, between 0.0 (0%) and 1.0 (100%)
 */
typealias Percentage = Float


/**
 * Status code supplied by the home power plant for certain write operations.
 *
 * @param rscpCode Code defined by E3DC
 *
 * @since 2.0
 */
enum class ResultCode(val rscpCode: Int) {
    /**
     * Operation successful; rscpCode = 0
     *
     * @since 2.0
     */
    SUCCESS(rscpCode = 0),

    /**
     * Unknown: Value ignored by home power plant???; rscpCode = 1
     *
     * @since 2.0
     */
    UNHANDLED(rscpCode = 1),

    /**
     * Missing permission to change the value; rscpCode = 2
     *
     * @since 2.0
     */
    ACCESS_DENIED(rscpCode = 2),

    /**
     * The request value is invalid; rscpCode = 3
     *
     * @since 2.0
     */
    FORMAT_ERROR(rscpCode = 3),

    /**
     * Unknown: Try again later??; rscpCode = 4
     *
     * @since 2.0
     */
    AGAIN(rscpCode = 4),

    /**
     * For all other codes; rscpCode = -1
     *
     * @since 2.0
     */
    UNKNOWN(rscpCode = -1);

    companion object {
        fun byRscpCode(code: Int): ResultCode =
            values().find { it.rscpCode == code }?: UNKNOWN

    }
}
