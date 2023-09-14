package de.jnkconsulting.e3dc.easyrscp.api.frame

/**
 * Defines a parser that creates [Data] objects from binary data.
 *
 * @since 2.0
 */
interface DataParser {
    /**
     * Parses the given [ByteArray] [data] and creates a list of [Data] objects from it.
     *
     * Currently no(!) validation is performed. If the byte array does not contain a valid RSCP format, it is therefore a matter of luck what comes out as result
     *
     * @param data Binary data to be parsed in RSCP Data Format
     *
     * @return List of [Data] objects
     *
     * @since 2.0
     */
    fun parseRSCPData(data: ByteArray): List<Data>
}
