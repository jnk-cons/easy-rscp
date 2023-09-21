package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.EMSSysSpecName
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.Instant

class ChargingConfigurationConverterTest {
    val toTest = ChargingConfigurationConverter()

    private val timestamp = Instant.now()

    @Test
    fun `test conversion`() {
        val frame = FrameBuilder()
            .timestamp(timestamp)
            .addData(
                DataBuilder().tag(EMSTag.GET_POWER_SETTINGS).container(
                    DataBuilder().tag(EMSTag.MAX_CHARGE_POWER).int32(7000).build(),
                    DataBuilder().tag(EMSTag.MAX_DISCHARGE_POWER).int32(6000).build(),
                    DataBuilder().tag(EMSTag.DISCHARGE_START_POWER).int32(65).build(),
                    DataBuilder().tag(EMSTag.POWER_LIMITS_USED).bool(true).build(),
                ).build(),
                DataBuilder().tag(EMSTag.GET_SYS_SPECS).container(
                    DataBuilder().tag(EMSTag.SYS_SPEC).container(
                        DataBuilder().tag(EMSTag.SYS_SPEC_INDEX).int32(0).build(),
                        DataBuilder().tag(EMSTag.SYS_SPEC_NAME).string(EMSSysSpecName.MAX_CHARGE_POWER.rscpName).build(),
                        DataBuilder().tag(EMSTag.SYS_SPEC_VALUE_INT).int32(10000).build(),
                    ).build(),
                    DataBuilder().tag(EMSTag.SYS_SPEC).container(
                        DataBuilder().tag(EMSTag.SYS_SPEC_INDEX).int32(1).build(),
                        DataBuilder().tag(EMSTag.SYS_SPEC_NAME).string(EMSSysSpecName.MAX_BATTERY_CHARGE_POWER.rscpName).build(),
                        DataBuilder().tag(EMSTag.SYS_SPEC_VALUE_INT).int32(11000).build(),
                    ).build(),
                    DataBuilder().tag(EMSTag.SYS_SPEC).container(
                        DataBuilder().tag(EMSTag.SYS_SPEC_INDEX).int32(2).build(),
                        DataBuilder().tag(EMSTag.SYS_SPEC_NAME).string(EMSSysSpecName.MAX_DISCHARGE_POWER.rscpName).build(),
                        DataBuilder().tag(EMSTag.SYS_SPEC_VALUE_INT).int32(12000).build(),
                    ).build(),
                    DataBuilder().tag(EMSTag.SYS_SPEC).container(
                        DataBuilder().tag(EMSTag.SYS_SPEC_INDEX).int32(3).build(),
                        DataBuilder().tag(EMSTag.SYS_SPEC_NAME).string(EMSSysSpecName.MAX_BATTERY_DISCHARGE_POWER.rscpName).build(),
                        DataBuilder().tag(EMSTag.SYS_SPEC_VALUE_INT).int32(13000).build(),
                    ).build(),
                    DataBuilder().tag(EMSTag.SYS_SPEC).container(
                        DataBuilder().tag(EMSTag.SYS_SPEC_INDEX).int32(4).build(),
                        DataBuilder().tag(EMSTag.SYS_SPEC_NAME).string(EMSSysSpecName.MIN_START_CHARGE_POWER.rscpName).build(),
                        DataBuilder().tag(EMSTag.SYS_SPEC_VALUE_INT).int32(10).build(),
                    ).build(),
                    DataBuilder().tag(EMSTag.SYS_SPEC).container(
                        DataBuilder().tag(EMSTag.SYS_SPEC_INDEX).int32(5).build(),
                        DataBuilder().tag(EMSTag.SYS_SPEC_NAME).string(EMSSysSpecName.MIN_START_DISCHARGE_POWER.rscpName).build(),
                        DataBuilder().tag(EMSTag.SYS_SPEC_VALUE_INT).int32(20).build(),
                    ).build(),
                    DataBuilder().tag(EMSTag.SYS_SPEC).container(
                        DataBuilder().tag(EMSTag.SYS_SPEC_INDEX).int32(6).build(),
                        DataBuilder().tag(EMSTag.SYS_SPEC_NAME).string(EMSSysSpecName.START_CHARGE_DEFAULT.rscpName).build(),
                        DataBuilder().tag(EMSTag.SYS_SPEC_VALUE_INT).int32(30).build(),
                    ).build()
                ).build(),
            )
            .build()

        val result = toTest.invoke(frame)

        assertEquals(7000, result.currentLimitations.maxCurrentChargingPower)
        assertEquals(6000, result.currentLimitations.maxCurrentDischargingPower)
        assertEquals(65, result.currentLimitations.dischargeStartPower)
        assertTrue(result.currentLimitations.chargingLimitationsEnabled)

        assertEquals(10000, result.maxPossibleChargingPower)
        assertEquals(10, result.minPossibleChargingPower)
        assertEquals(12000, result.maxPossibleDischargingPower)
        assertEquals(20, result.minPossibleDischargingPower)
        assertEquals(30, result.defaultStartChargingThreshold)
    }
}
