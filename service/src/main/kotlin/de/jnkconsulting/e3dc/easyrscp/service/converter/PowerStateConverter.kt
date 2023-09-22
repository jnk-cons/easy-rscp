package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.api.service.model.PowerState

/**
 * Converter to build a [PowerState] object from a frame
 *
 * @since 2.0
 */
class PowerStateConverter: FrameConverter<PowerState> {

    override fun invoke(frame: Frame) =
        PowerState(
            timestamp = frame.timestamp,
            pvDelivery = frame.intByTag(EMSTag.POWER_PV),
            gridDelivery = frame.intByTag(EMSTag.POWER_GRID),
            batteryDelivery = frame.intByTag(EMSTag.POWER_BAT) * -1,
            houseConsumption = frame.intByTag(EMSTag.POWER_HOME),
            batteryChargingLevel = frame.byteByTag(EMSTag.BAT_SOC).toFloat() / 100.0f,
        )
}