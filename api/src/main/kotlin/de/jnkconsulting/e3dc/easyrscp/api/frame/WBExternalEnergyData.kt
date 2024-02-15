package de.jnkconsulting.e3dc.easyrscp.api.frame

/**
 * Represents the actual amount of energy provided to a wallbox.
 *
 * The easiest way to create an instance is to use a [WBExternalDataParser] instance.
 *
 * Background: The live energy data of a wallbox is stored in binary code in the external data blocks.
 * This class and the parser are available to facilitate interpretation. Depending on the data block used,
 * the data either originates from the solar or grid source or corresponds to the total energy.
 *
 * The [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag.EXTERN_DATA_SUN] block is responsible for the solar part.
 * The [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag.EXTERN_DATA_NET] block is responsible for the grid part.
 * The [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag.EXTERN_DATA_ALL] block is responsible for the total energy range.
 *
 * @param powerW Current amount of energy in watts
 * @param totalEnergyWh Total energy in Wh
 *
 * @since 2.3
 */
data class WBExternalEnergyData(
    val powerW: Short,
    val totalEnergyWh: Int
)
