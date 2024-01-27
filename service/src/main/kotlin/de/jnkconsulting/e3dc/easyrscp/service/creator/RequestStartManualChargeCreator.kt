package de.jnkconsulting.e3dc.easyrscp.service.creator


import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder

/**
 * [de.jnkconsulting.e3dc.easyrscp.api.frame.Frame] generator to request the the start of a manual charge
 *
 * @since 2.2
 */
class RequestStartManualChargeCreator: FrameCreator<Int> {

    override fun invoke(amount: Int): Frame =
        FrameBuilder()
            .addData(
                DataBuilder().tag(EMSTag.REQ_START_MANUAL_CHARGE).uint32(amount).build()
            )
            .build()
}
