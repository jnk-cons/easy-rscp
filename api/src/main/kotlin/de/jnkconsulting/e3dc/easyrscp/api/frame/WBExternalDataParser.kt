package de.jnkconsulting.e3dc.easyrscp.api.frame

/**
 * Defines a parser to parse the binary data of the response blocks which are prefixed with EXTERN_DATA_*.
 *
 * @since 2.3
 */
interface WBExternalDataParser {

    /**
     * Parses the data blocks of type [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag.EXTERN_DATA_SUN],
     * [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag.EXTERN_DATA_NET] and [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag.EXTERN_DATA_ALL].
     *
     * @param block Response block from the housekeeper. This must be of a supported type. See function description
     *
     * @return Parsing result
     * @throws IllegalArgumentException If the given data block is not of a supported type or the structure of the external data cannot be interpreted.
     *
     * @since 2.3
     */
    fun parseEnergyData(block: Data): WBExternalEnergyData
}
