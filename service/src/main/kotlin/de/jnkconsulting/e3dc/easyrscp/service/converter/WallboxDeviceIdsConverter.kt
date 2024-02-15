package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag

/**
 * Converter to build a list of Ids from a [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag.CONNECTED_DEVICES] Container
 *
 * @since 2.3
 */
class WallboxDeviceIdsConverter: FrameConverter<List<Int>> {

    override fun invoke(frame: Frame): List<Int> =
        frame.containerByTag(WBTag.CONNECTED_DEVICES).mapNotNull { it.valueAsInt() }

}
