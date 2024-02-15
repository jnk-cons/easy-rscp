package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataParser
import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag
import de.jnkconsulting.e3dc.easyrscp.api.service.model.PowerState
import de.jnkconsulting.e3dc.easyrscp.api.service.model.WallboxInfo
import de.jnkconsulting.e3dc.easyrscp.frame.DefaultDataParser

/**
 * Converter to build a list of Ids from a [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag.CONNECTED_DEVICES] Container
 *
 * @since 2.3
 */
class WallboxDeviceInfosConverter(val parser: DataParser = DefaultDataParser()): FrameConverter<List<WallboxInfo>> {

    override fun invoke(frame: Frame): List<WallboxInfo> =
        frame.data
            .filter { it.tagObject() == WBTag.DATA }
            .mapNotNull {
                val childs = it.valueAsContainer(parser)
                val index = childs.find { it.tagObject() == WBTag.INDEX }?.valueAsInt()
                val name = childs.find { it.tagObject() == WBTag.DEVICE_NAME }?.valueAsString()
                if (index != null && name != null) {
                    WallboxInfo(
                        id = index,
                        name = name
                    )
                }
                else {
                    null
                }
            }

}
