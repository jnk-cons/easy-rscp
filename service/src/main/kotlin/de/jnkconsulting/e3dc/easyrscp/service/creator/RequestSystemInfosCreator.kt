package de.jnkconsulting.e3dc.easyrscp.service.creator


import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.InfoTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder

/**
 * [de.jnkconsulting.e3dc.easyrscp.api.frame.Frame] generator to request the basic information's about the home power plant
 *
 * @since 2.0
 */
class RequestSystemInfosCreator: FrameCreator<Nothing?> {

    override fun invoke(limits: Nothing?) =
        FrameBuilder()
            .addData(
                DataBuilder().tag(InfoTag.REQ_MAC_ADDRESS).none().build(),
                DataBuilder().tag(InfoTag.REQ_PRODUCTION_DATE).none().build(),
                DataBuilder().tag(InfoTag.REQ_SERIAL_NUMBER).none().build(),
                DataBuilder().tag(InfoTag.REQ_SW_RELEASE).none().build()
            )
            .build()
}
