package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataParser
import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.WBExternalDataParser
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag
import de.jnkconsulting.e3dc.easyrscp.api.service.model.PowerState
import de.jnkconsulting.e3dc.easyrscp.api.service.model.WallboxInfo
import de.jnkconsulting.e3dc.easyrscp.api.service.model.WallboxPowerState
import de.jnkconsulting.e3dc.easyrscp.frame.DefaultDataParser
import de.jnkconsulting.e3dc.easyrscp.frame.DefaultWBExternalDataParser
import mu.KotlinLogging

/**
 * Converter to build a list of [WallboxPowerState] objects from a [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag.DATA] Container.
 *
 * @param parser Parser for the Blockdata. In Default an instance of type [DefaultDataParser] is used
 * @param externalDataParser Parser for the binary data in the EXTERN_DATA blocks. In default an instance of type [DefaultWBExternalDataParser] is used
 *
 * @since 2.3
 */
class WallboxPowerStateConverter(
    private val parser: DataParser = DefaultDataParser(),
    private val externalDataParser: WBExternalDataParser = DefaultWBExternalDataParser(parser)
): FrameConverter<List<WallboxPowerState>> {

    private val logger = KotlinLogging.logger {}

    override fun invoke(frame: Frame): List<WallboxPowerState> =
        frame.data
            .filter { it.tagObject() == WBTag.DATA }
            .mapNotNull { data ->
                val childs = data.valueAsContainer(parser)
                val index = childs.find { it.tagObject() == WBTag.INDEX }?.valueAsInt()
                val sunRAW = childs.find { it.tagObject() == WBTag.EXTERN_DATA_SUN }
                val allRAW = childs.find { it.tagObject() == WBTag.EXTERN_DATA_ALL }
                if (index != null && sunRAW != null && allRAW != null) {
                    try {
                        val sun = externalDataParser.parseEnergyData(sunRAW)
                        val all = externalDataParser.parseEnergyData(allRAW)
                        WallboxPowerState(
                            id = index,
                            powerW = all.powerW.toInt(),
                            solarPowerW  = sun.powerW.toInt()
                        )
                    }catch (e: IllegalArgumentException){
                        logger.error(e) { "Error parsing the external data received from the HLW ${StringFrameConverter().invoke(frame)}" }
                        null
                    }

                }
                else {
                    null
                }
            }

}
