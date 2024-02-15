package de.jnkconsulting.e3dc.easyrscp.service.creator


import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder

/**
 * [de.jnkconsulting.e3dc.easyrscp.api.frame.Frame] generator to request the connected wallboxes
 *
 * @since 2.3
 */
class RequestWallboxIdsCreator: FrameCreator<Nothing?> {

    override fun invoke(param: Nothing?): Frame =
        FrameBuilder()
            .addData(
                DataBuilder().tag(WBTag.REQ_CONNECTED_DEVICES).build(),
            )
            .build()
}
