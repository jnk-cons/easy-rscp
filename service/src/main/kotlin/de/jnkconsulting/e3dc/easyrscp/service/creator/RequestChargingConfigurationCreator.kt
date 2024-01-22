package de.jnkconsulting.e3dc.easyrscp.service.creator


import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder

/**
 * [de.jnkconsulting.e3dc.easyrscp.api.frame.Frame] generator to request the active load configuration of the home power plant
 *
 * @since 2.0
 */
class RequestChargingConfigurationCreator: FrameCreator<Nothing?> {
    override fun invoke(param: Nothing?): Frame =
        FrameBuilder()
            .addData(
                DataBuilder().tag(EMSTag.REQ_GET_POWER_SETTINGS).build(),
                DataBuilder().tag(EMSTag.REQ_GET_SYS_SPECS).build()
            )
            .build()
}
