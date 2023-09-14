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
     * Operation successful
     *
     * @since 2.0
     */
    SUCCESS(0),

    /**
     * Unknown: Value ignored by home power plant???
     *
     * @since 2.0
     */
    UNHANDLED(1),

    /**
     * Missing permission to change the value
     *
     * @since 2.0
     */
    ACCESS_DENIED(2),

    /**
     * The request value is invalid
     *
     * @since 2.0
     */
    FORMAT_ERROR(3),

    /**
     * Unknown: Try again later??
     *
     * @since 2.0
     */
    AGAIN(4),

    /**
     * For all other codes
     *
     * @since 2.0
     */
    UNKNOWN(-1);

    companion object {
        fun byRscpCode(code: Int): ResultCode =
            values().find { it.rscpCode == code }?: UNKNOWN

    }
}
