package de.jnkconsulting.e3dc.easyrscp.service.creator

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EPTag
import de.jnkconsulting.e3dc.easyrscp.api.service.model.BatteryUnit
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder

/**
 * [de.jnkconsulting.e3dc.easyrscp.api.frame.Frame] generator to configure the emergency power reserve
 *
 * @since 2.2
 */
class SetEmergencyPowerReserveCreator: FrameCreator<PowerReserveInput> {

    override fun invoke(param: PowerReserveInput) =
        FrameBuilder()
            .addData(
                DataBuilder().tag(EPTag.REQ_SET_EP_RESERVE).container(
                    DataBuilder().tag(EPTag.PARAM_INDEX).uint32(0).build(),
                    if (param.unit == BatteryUnit.PERCENTAGE) DataBuilder().tag(EPTag.PARAM_EP_RESERVE).float32(param.value * 100f).build()
                    else DataBuilder().tag(EPTag.PARAM_EP_RESERVE_ENERGY).float32(param.value).build()
                ).build()
            ).build()
}


data class PowerReserveInput(
    val value: Float,
    val unit: BatteryUnit
) {
    init {
        if (value < 0.0) {
            throw IllegalArgumentException("The value must not be less than 0")
        }
        else if (unit == BatteryUnit.PERCENTAGE && value > 1.0f) {
            throw IllegalArgumentException("The percentage must be between 0.0 and 1.0")
        }
    }
}
