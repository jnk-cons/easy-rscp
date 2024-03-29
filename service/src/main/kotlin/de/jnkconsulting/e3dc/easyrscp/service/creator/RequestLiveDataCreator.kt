package de.jnkconsulting.e3dc.easyrscp.service.creator


import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder

/**
 * [de.jnkconsulting.e3dc.easyrscp.api.frame.Frame] generator to request the current power state of the home power plant
 *
 * @since 2.0
 *
 * @since 2.3
 * - [EMSTag.REQ_POWER_WB_ALL] and [EMSTag.REQ_POWER_WB_SOLAR] are queried
 */
class RequestLiveDataCreator: FrameCreator<Nothing?> {

    override fun invoke(param: Nothing?): Frame =
        FrameBuilder()
            .addData(
                DataBuilder().tag(EMSTag.REQ_POWER_PV).build(),
                DataBuilder().tag(EMSTag.REQ_POWER_BAT).build(),
                DataBuilder().tag(EMSTag.REQ_POWER_GRID).build(),
                DataBuilder().tag(EMSTag.REQ_POWER_HOME).build(),
                DataBuilder().tag(EMSTag.REQ_BAT_SOC).build(),
                DataBuilder().tag(EMSTag.REQ_POWER_WB_ALL).build(),
                DataBuilder().tag(EMSTag.REQ_POWER_WB_SOLAR).build(),
            )
            .build()
}
