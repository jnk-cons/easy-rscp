package de.jnkconsulting.e3dc.easyrscp.frame.samples

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder

/**
 * Simple example to create a frame to query the current basic data from the E3DC home power plant
 */
fun createQueryCurrentPowerState() {
    val frame = FrameBuilder()
        .addData(DataBuilder().tag(EMSTag.REQ_POWER_PV).build())
        .addData(DataBuilder().tag(EMSTag.REQ_POWER_BAT).build())
        .addData(DataBuilder().tag(EMSTag.REQ_POWER_GRID).build())
        .addData(DataBuilder().tag(EMSTag.REQ_POWER_HOME).build())
        .build()

}
