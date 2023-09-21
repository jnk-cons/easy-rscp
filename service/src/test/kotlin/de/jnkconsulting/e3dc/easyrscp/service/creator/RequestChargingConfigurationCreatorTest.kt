package de.jnkconsulting.e3dc.easyrscp.service.creator

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.service.testutils.assertHasDataWithType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RequestChargingConfigurationCreatorTest {

    private val toTest = RequestChargingConfigurationCreator()

    @Test
    fun `test frame creation`() {
        val result = toTest(null)

        assertEquals(2, result.data.size)
        result.assertHasDataWithType(
            tag = EMSTag.REQ_GET_POWER_SETTINGS,
            expectedType = DataType.NONE
        )

        result.assertHasDataWithType(
            tag = EMSTag.REQ_GET_SYS_SPECS,
            expectedType = DataType.NONE
        )
    }

}
