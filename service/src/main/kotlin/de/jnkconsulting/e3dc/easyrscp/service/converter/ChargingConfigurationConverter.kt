package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.EMSSysSpecName
import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.SysSpecData
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ChargingConfiguration
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ChargingLimits
import java.lang.IllegalStateException
import kotlin.math.min

/**
 * Converter to build a [ChargingConfiguration] object from a frame
 *
 * @since 2.0
 */
class ChargingConfigurationConverter: FrameConverter<ChargingConfiguration> {

    override fun invoke(frame: Frame) =
        ChargingLimits(
            maxCurrentChargingPower = frame.intByTag(EMSTag.MAX_CHARGE_POWER, EMSTag.GET_POWER_SETTINGS),
            maxCurrentDischargingPower = frame.intByTag(EMSTag.MAX_DISCHARGE_POWER, EMSTag.GET_POWER_SETTINGS),
            dischargeStartPower = frame.intByTag(EMSTag.DISCHARGE_START_POWER, EMSTag.GET_POWER_SETTINGS),
            chargingLimitationsEnabled = frame.booleanByTag(EMSTag.POWER_LIMITS_USED, EMSTag.GET_POWER_SETTINGS),
        )
            .let { (frame.dataByTag(EMSTag.GET_SYS_SPECS) ?: throw IllegalStateException("Answer frame does not contain a ${EMSTag.GET_SYS_SPECS} block")) to it }
            .let { SysSpecData(it.first, frame.parser) to it.second }
            .let { (spec, limits) ->
                ChargingConfiguration(
                    maxPossibleChargingPower = nullSafeMin(
                        spec.intValue(EMSSysSpecName.MAX_CHARGE_POWER),
                        spec.intValue(EMSSysSpecName.MAX_BATTERY_CHARGE_POWER)
                    ),
                    maxPossibleDischargingPower = nullSafeMin(
                        spec.intValue(EMSSysSpecName.MAX_DISCHARGE_POWER),
                        spec.intValue(EMSSysSpecName.MAX_BATTERY_DISCHARGE_POWER)
                    ),
                    minPossibleChargingPower = spec.intValue(EMSSysSpecName.MIN_START_CHARGE_POWER) ?: 0,
                    minPossibleDischargingPower = spec.intValue(EMSSysSpecName.MIN_START_DISCHARGE_POWER) ?: 0,
                    defaultStartChargingThreshold = spec.intValue(EMSSysSpecName.START_CHARGE_DEFAULT) ?: 0,
                    currentLimitations = limits,
                )
            }


    companion object {
        private fun nullSafeMin(a : Int?, b: Int?) =
            if (a == null) b ?: 0
            else if (b == null) a
            else min(a, b)
    }
}
