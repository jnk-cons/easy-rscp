package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.api.service.model.WriteChargingLimitsResult

/**
 * Converter to build a [WriteChargingLimitsResult] object from a frame
 *
 * @since 2.0
 */
class WriteChargingLimitsResultConverter: FrameConverter<WriteChargingLimitsResult> {

    override fun invoke(frame: Frame): WriteChargingLimitsResult =
        WriteChargingLimitsResult(
            maxCurrentChargingPower = frame.resultCodeByTag(EMSTag.RES_MAX_CHARGE_POWER, EMSTag.SET_POWER_SETTINGS),
            maxCurrentDischargingPower = frame.resultCodeByTag(EMSTag.RES_MAX_DISCHARGE_POWER, EMSTag.SET_POWER_SETTINGS),
            dischargeStartPower = frame.resultCodeByTag(EMSTag.DISCHARGE_START_POWER, EMSTag.SET_POWER_SETTINGS),
            chargingLimitationsEnabled = frame.resultCodeByTag(EMSTag.RES_POWER_LIMITS_USED, EMSTag.SET_POWER_SETTINGS),
        )
}
