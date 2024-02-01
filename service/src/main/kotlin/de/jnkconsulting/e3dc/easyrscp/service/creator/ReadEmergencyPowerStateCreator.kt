package de.jnkconsulting.e3dc.easyrscp.service.creator


import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EPTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder

/**
 * [de.jnkconsulting.e3dc.easyrscp.api.frame.Frame] generator to request the current emergency power state of the home power plant
 *
 * @since 2.2
 */
class ReadEmergencyPowerStateCreator: FrameCreator<Nothing?> {

    override fun invoke(param: Nothing?): Frame =
        FrameBuilder()
            .addData(
                DataBuilder().tag(EPTag.REQ_EP_RESERVE).build(),
                DataBuilder().tag(EPTag.REQ_IS_POSSIBLE).build(),
                DataBuilder().tag(EPTag.REQ_IS_GRID_CONNECTED).build(),
                DataBuilder().tag(EPTag.REQ_IS_ISLAND_GRID).build(),
                DataBuilder().tag(EPTag.REQ_IS_INVALID_STATE).build(),
                DataBuilder().tag(EPTag.REQ_IS_READY_FOR_SWITCH).build(),
            )
            .build()
}
