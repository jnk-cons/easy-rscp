package de.jnkconsulting.e3dc.easyrscp.service.creator

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EPTag
import de.jnkconsulting.e3dc.easyrscp.service.testutils.assertHasDataWithType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RequestEmergencyPowerStateCreatorTest {
    private val toTest = ReadEmergencyPowerStateCreator()

    @Test
    fun `test frame creation`() {
        val result = toTest(null)

        assertEquals(6, result.data.size)

        result.assertHasDataWithType(
            tag = EPTag.REQ_EP_RESERVE,
            expectedType = DataType.NONE
        )

        result.assertHasDataWithType(
            tag = EPTag.REQ_IS_POSSIBLE,
            expectedType = DataType.NONE
        )

        result.assertHasDataWithType(
            tag = EPTag.REQ_IS_GRID_CONNECTED,
            expectedType = DataType.NONE
        )

        result.assertHasDataWithType(
            tag = EPTag.REQ_IS_ISLAND_GRID,
            expectedType = DataType.NONE
        )

        result.assertHasDataWithType(
            tag = EPTag.REQ_IS_INVALID_STATE,
            expectedType = DataType.NONE
        )

        result.assertHasDataWithType(
            tag = EPTag.REQ_IS_READY_FOR_SWITCH,
            expectedType = DataType.NONE
        )
    }
}
