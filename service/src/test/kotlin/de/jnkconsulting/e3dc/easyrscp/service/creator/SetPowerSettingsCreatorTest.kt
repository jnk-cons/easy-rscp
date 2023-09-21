package de.jnkconsulting.e3dc.easyrscp.service.creator

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ChargingLimits
import de.jnkconsulting.e3dc.easyrscp.service.converter.StringFrameConverter
import de.jnkconsulting.e3dc.easyrscp.service.testutils.assertHasDataWithType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class SetPowerSettingsCreatorTest {

    private val toTest = SetPowerSettingsCreator()

    @Test
    fun `test frame creation`() {
        val input = ChargingLimits(
            maxCurrentChargingPower = 1000,
            maxCurrentDischargingPower = 500,
            dischargeStartPower = 25,
            chargingLimitationsEnabled = true,
        )

        val result = toTest(input)

        println(StringFrameConverter().invoke(result))

        assertEquals(1, result.data.size)

        result.assertHasDataWithType(
            tag = EMSTag.REQ_SET_POWER_SETTINGS,
            expectedType = DataType.CONTAINER
        )

        result.assertHasDataWithType(
            tag = EMSTag.MAX_CHARGE_POWER,
            expectedType = DataType.UINT32,
            expectedValue = "1000",
            path = arrayOf(EMSTag.REQ_SET_POWER_SETTINGS)
        )

        result.assertHasDataWithType(
            tag = EMSTag.MAX_DISCHARGE_POWER,
            expectedType = DataType.UINT32,
            expectedValue = "500",
            path = arrayOf(EMSTag.REQ_SET_POWER_SETTINGS)
        )

        result.assertHasDataWithType(
            tag = EMSTag.DISCHARGE_START_POWER,
            expectedType = DataType.UINT32,
            expectedValue = "25",
            path = arrayOf(EMSTag.REQ_SET_POWER_SETTINGS)
        )

        result.assertHasDataWithType(
            tag = EMSTag.POWER_LIMITS_USED,
            expectedType = DataType.BOOL,
            expectedValue = "true",
            path = arrayOf(EMSTag.REQ_SET_POWER_SETTINGS)
        )
    }
}
