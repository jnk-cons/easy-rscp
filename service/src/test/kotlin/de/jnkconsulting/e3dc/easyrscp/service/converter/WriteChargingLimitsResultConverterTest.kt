package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ResultCode
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.Instant

class WriteChargingLimitsResultConverterTest {
    val toTest = WriteChargingLimitsResultConverter()

    private val timestamp = Instant.now()

    @Test
    fun `test conversion`() {
        val frame = FrameBuilder()
            .timestamp(timestamp)
            .addData(
                DataBuilder().tag(EMSTag.SET_POWER_SETTINGS).container(
                    DataBuilder().tag(EMSTag.RES_MAX_CHARGE_POWER).int32(ResultCode.SUCCESS.rscpCode).build(),
                    DataBuilder().tag(EMSTag.RES_MAX_DISCHARGE_POWER).int32(ResultCode.UNHANDLED.rscpCode).build(),
                    DataBuilder().tag(EMSTag.DISCHARGE_START_POWER).int32(ResultCode.ACCESS_DENIED.rscpCode).build(),
                    DataBuilder().tag(EMSTag.RES_POWER_LIMITS_USED).int32(ResultCode.FORMAT_ERROR.rscpCode).build(),
                )
                .build()
            )
            .build()

        val result = toTest.invoke(frame)

        assertEquals(ResultCode.SUCCESS, result.maxCurrentChargingPower)
        assertEquals(ResultCode.UNHANDLED, result.maxCurrentDischargingPower)
        assertEquals(ResultCode.ACCESS_DENIED, result.dischargeStartPower)
        assertEquals(ResultCode.FORMAT_ERROR, result.chargingLimitationsEnabled)
    }
}
