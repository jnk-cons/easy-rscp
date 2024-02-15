package de.jnkconsulting.e3dc.easyrscp.frame

import de.jnkconsulting.e3dc.easyrscp.api.frame.Data
import de.jnkconsulting.e3dc.easyrscp.api.frame.DataParser
import de.jnkconsulting.e3dc.easyrscp.api.frame.WBExternalDataParser
import de.jnkconsulting.e3dc.easyrscp.api.frame.WBExternalEnergyData
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag
import java.nio.ByteBuffer
import java.nio.ByteOrder

/**
 * Default implementation for parsing the binary data in the different [WBTag.EXTERN_DATA] blocks.
 *
 * @param parser Der zu nutzende Parser um Werte aus den Binärdaten zu lesen. Im Default wird eine Instanz von [DefaultDataParser] verwendet
 *
 * @since 2.3
 */
class DefaultWBExternalDataParser(private val parser: DataParser = DefaultDataParser()) : WBExternalDataParser {

    override fun parseEnergyData(block: Data): WBExternalEnergyData {
        val containerTag = block.tagObject()
        if (ENERGY_DATA_SUPPORTED_TAGS.contains(containerTag)) {
            val rawBytes = block
                .valueAsContainer(parser)
                .find { it.tagObject() == WBTag.EXTERN_DATA }
                ?.value ?: throw IllegalArgumentException("Required block ${WBTag.EXTERN_DATA} does not exist")

            if (rawBytes.size < 6) {
                throw IllegalArgumentException("Length of the external data is to short. At least 6 bytes are needed. We found only ${rawBytes.size}")
            }

            val buffer = ByteBuffer
                .allocate(rawBytes.size)
                .order(ByteOrder.LITTLE_ENDIAN)
                .put(rawBytes)
                .rewind()

            val powerW = buffer.getShort()
            val totalEnergyWh = buffer.getInt(2)
            return WBExternalEnergyData(
                powerW = powerW,
                totalEnergyWh = totalEnergyWh
            )
        }
        else {
            throw IllegalArgumentException("Given datablock typ $containerTag is not supported. Only $ENERGY_DATA_SUPPORTED_TAGS are supported" )
        }
    }

    companion object {
        val ENERGY_DATA_SUPPORTED_TAGS = setOf(WBTag.EXTERN_DATA_SUN, WBTag.EXTERN_DATA_NET, WBTag.EXTERN_DATA_ALL)
    }
}
