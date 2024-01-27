package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ManualChargeState

/**
 * Converter to build a [ManualChargeState] object from a frame
 *
 * @since 2.2
 */
class ManualChargeStateConverter: FrameConverter<ManualChargeState> {

    override fun invoke(frame: Frame): ManualChargeState =
        ManualChargeState(
            active = frame.booleanByTag(EMSTag.MANUAL_CHARGE_ACTIVE, EMSTag.GET_MANUAL_CHARGE),
            chargedEnergyWh = frame.doubleByTag(EMSTag.MANUAL_CHARGE_ENERGY_COUNTER, EMSTag.GET_MANUAL_CHARGE),
            lastRun = frame.instantByTag(EMSTag.MANUAL_CHARGE_LASTSTART, EMSTag.GET_MANUAL_CHARGE),
        )
}
