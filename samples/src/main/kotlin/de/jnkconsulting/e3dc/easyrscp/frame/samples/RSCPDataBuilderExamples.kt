package de.jnkconsulting.e3dc.easyrscp.frame.samples

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.BatTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder

/**
 * Simple example to create a data block for the device name of the battery
 */
fun createBatDeviceNameExampleData() {
    val dataBlock = DataBuilder()
        .tag(BatTag.DEVICE_NAME)
        .string("Battery device name")
        .build()
}
