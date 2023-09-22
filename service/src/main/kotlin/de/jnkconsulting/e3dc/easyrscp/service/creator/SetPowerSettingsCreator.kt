package de.jnkconsulting.e3dc.easyrscp.service.creator


import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ChargingLimits
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder

/**
 * [de.jnkconsulting.e3dc.easyrscp.api.frame.Frame] generator to configure the charging limits of the home power plant
 *
 * @since 2.0
 */
class SetPowerSettingsCreator: FrameCreator<ChargingLimits> {

    override fun invoke(limits: ChargingLimits): Frame =
        FrameBuilder()
            .addData(
                DataBuilder().tag(EMSTag.REQ_SET_POWER_SETTINGS).container(
                    DataBuilder().tag(EMSTag.MAX_CHARGE_POWER).uint32(limits.maxCurrentChargingPower).build(),
                    DataBuilder().tag(EMSTag.MAX_DISCHARGE_POWER).uint32(limits.maxCurrentDischargingPower).build(),
                    DataBuilder().tag(EMSTag.DISCHARGE_START_POWER).uint32(limits.dischargeStartPower).build(),
                    DataBuilder().tag(EMSTag.POWER_LIMITS_USED).bool(limits.chargingLimitationsEnabled).build(),
                ).build()
            )
            .build()
}
