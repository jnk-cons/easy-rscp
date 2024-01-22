package de.jnkconsulting.e3dc.easyrscp.service.creator

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.BatTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder

class BatteryInfoRequestCreator : FrameCreator<Int>{

    override fun invoke(batIndex: Int) =
        FrameBuilder()
            .addData(
                DataBuilder().tag(BatTag.REQ_DATA).container(
                    DataBuilder().tag(BatTag.INDEX).uint16(batIndex.toShort()).build(),
                    DataBuilder().tag(BatTag.REQ_DEVICE_NAME).build(),
                    DataBuilder().tag(BatTag.REQ_CHARGE_HIGH_TEMP).build(),
                    DataBuilder().tag(BatTag.REQ_CHARGE_LOW_TEMP).build(),
                    DataBuilder().tag(BatTag.REQ_DESIGN_VOLTAGE).build(),
                    DataBuilder().tag(BatTag.REQ_DESIGN_CAPACITY).build(),
                    DataBuilder().tag(BatTag.REQ_SPECIFICATION).build(),
                    DataBuilder().tag(BatTag.REQ_MAX_CHARGE_CURRENT).build(),
                    DataBuilder().tag(BatTag.REQ_MAX_DISCHARGE_CURRENT).build(),
                    DataBuilder().tag(BatTag.REQ_DCB_COUNT).build(),
                    DataBuilder().tag(BatTag.REQ_TRAINING_MODE).build(),
                    DataBuilder().tag(BatTag.REQ_DEVICE_STATE).build(),
                    DataBuilder().tag(BatTag.REQ_ASOC).build(),
                    DataBuilder().tag(BatTag.REQ_RSOC_REAL).build(),
                    DataBuilder().tag(BatTag.REQ_MODULE_VOLTAGE).build(),
                ).build()
            )
            .build()
}
