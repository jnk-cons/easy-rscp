package de.jnkconsulting.e3dc.easyrscp.service.creator

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EPTag
import de.jnkconsulting.e3dc.easyrscp.api.service.model.BatteryUnit
import de.jnkconsulting.e3dc.easyrscp.service.testutils.assertHasDataWithType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class SetEmergencyPowerReserveCreatorTest {
    private val toTest = SetEmergencyPowerReserveCreator()

    @Test
    fun `test frame creation with Watt hours`() {
        val result = toTest(PowerReserveInput(100f, BatteryUnit.WATT_HOURS))

        assertEquals(1, result.data.size)

        result.assertHasDataWithType(
            tag = EPTag.REQ_SET_EP_RESERVE,
            expectedType = DataType.CONTAINER
        )

        val indexResult = result.intByTag(EPTag.PARAM_INDEX, EPTag.REQ_SET_EP_RESERVE)
        val valueResult = result.floatByTag(EPTag.PARAM_EP_RESERVE_ENERGY, EPTag.REQ_SET_EP_RESERVE)

        assertEquals(0, indexResult)
        assertEquals(100f, valueResult, 0.01f)
    }

    @Test
    fun `test frame creation with percentage`() {
        val result = toTest(PowerReserveInput(0.5f, BatteryUnit.PERCENTAGE))

        assertEquals(1, result.data.size)

        result.assertHasDataWithType(
            tag = EPTag.REQ_SET_EP_RESERVE,
            expectedType = DataType.CONTAINER
        )

        val indexResult = result.intByTag(EPTag.PARAM_INDEX, EPTag.REQ_SET_EP_RESERVE)
        val valueResult = result.floatByTag(EPTag.PARAM_EP_RESERVE, EPTag.REQ_SET_EP_RESERVE)

        assertEquals(0, indexResult)
        assertEquals(50f, valueResult, 0.01f)
    }

    @Nested
    inner class PowerReserveInputTests {
        @Test
        fun `test validation value must be bigger or equal to 0`() {
            assertThrows<IllegalArgumentException> {
                PowerReserveInput(-5f, BatteryUnit.WATT_HOURS)
            }
            PowerReserveInput(0.0f, BatteryUnit.WATT_HOURS)
        }

        @Test
        fun `test validation value must between 0 and 1 if unit is percentage`() {
            PowerReserveInput(0.0f, BatteryUnit.PERCENTAGE)
            PowerReserveInput(1.0f, BatteryUnit.PERCENTAGE)
            assertThrows<IllegalArgumentException> {
                PowerReserveInput(1.1f, BatteryUnit.PERCENTAGE)
            }
        }
    }


}
