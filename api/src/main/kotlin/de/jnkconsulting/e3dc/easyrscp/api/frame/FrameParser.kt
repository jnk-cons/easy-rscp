package de.jnkconsulting.e3dc.easyrscp.api.frame

/**
 * Defines a parser to create a RSCP [frame] from binary data.
 *
 * @since 2.0
 */
interface FrameParser {

    /**
     * Parses binary data and creates an RSCP [frame] from the given data.
     *
     * Currently no(!) validation is performed. If the byte array does not contain a valid RSCP format, it is therefore a matter of luck what comes out as result
     *
     * @param data Binary data to be parsed in RSCP Data Format
     *
     * @return [Frame] object
     *
     * @since 2.0
     */
    fun parseRSCPFrame(frame: ByteArray): Frame
}
