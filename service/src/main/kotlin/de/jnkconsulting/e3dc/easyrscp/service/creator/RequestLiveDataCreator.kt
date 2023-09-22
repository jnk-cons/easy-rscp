package de.jnkconsulting.e3dc.easyrscp.service.creator


import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder

/**
 * [de.jnkconsulting.e3dc.easyrscp.api.frame.Frame] generator to request the current power state of the home power plant
 *
 * @since 2.0
 */
class RequestLiveDataCreator: FrameCreator<Nothing?> {

    override fun invoke(param: Nothing?): Frame =
        FrameBuilder()
            .addData(
                DataBuilder().tag(EMSTag.REQ_POWER_PV).none().build(),
                DataBuilder().tag(EMSTag.REQ_POWER_BAT).none().build(),
                DataBuilder().tag(EMSTag.REQ_POWER_GRID).none().build(),
                DataBuilder().tag(EMSTag.REQ_POWER_HOME).none().build(),
                DataBuilder().tag(EMSTag.REQ_BAT_SOC).none().build(),
            )
            .build()
}
