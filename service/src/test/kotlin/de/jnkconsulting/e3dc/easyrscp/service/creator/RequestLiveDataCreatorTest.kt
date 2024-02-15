package de.jnkconsulting.e3dc.easyrscp.service.creator

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.service.testutils.assertHasDataWithType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RequestLiveDataCreatorTest {

    private val toTest = RequestLiveDataCreator()

    @Test
    fun `test frame creation`() {
        val result = toTest(null)

        assertEquals(7, result.data.size)

        result.assertHasDataWithType(
            tag = EMSTag.REQ_POWER_PV,
            expectedType = DataType.NONE
        )

        result.assertHasDataWithType(
            tag = EMSTag.REQ_POWER_BAT,
            expectedType = DataType.NONE
        )

        result.assertHasDataWithType(
            tag = EMSTag.REQ_POWER_GRID,
            expectedType = DataType.NONE
        )

        result.assertHasDataWithType(
            tag = EMSTag.REQ_POWER_HOME,
            expectedType = DataType.NONE
        )

        result.assertHasDataWithType(
            tag = EMSTag.REQ_BAT_SOC,
            expectedType = DataType.NONE
        )

        result.assertHasDataWithType(
            tag = EMSTag.REQ_POWER_WB_SOLAR,
            expectedType = DataType.NONE
        )

        result.assertHasDataWithType(
            tag = EMSTag.REQ_POWER_WB_SOLAR,
            expectedType = DataType.NONE
        )
    }

}
