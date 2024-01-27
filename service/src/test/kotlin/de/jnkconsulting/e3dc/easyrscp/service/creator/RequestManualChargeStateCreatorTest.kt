package de.jnkconsulting.e3dc.easyrscp.service.creator

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.service.testutils.assertHasDataWithType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RequestManualChargeStateCreatorTest {

    private val toTest = RequestManualChargeStateCreator()

    @Test
    fun `test frame creation`() {
        val result = toTest(null)

        assertEquals(1, result.data.size)

        result.assertHasDataWithType(
            tag = EMSTag.REQ_GET_MANUAL_CHARGE,
            expectedType = DataType.NONE
        )
    }

}
