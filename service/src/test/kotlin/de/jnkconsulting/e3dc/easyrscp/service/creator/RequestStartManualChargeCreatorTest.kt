package de.jnkconsulting.e3dc.easyrscp.service.creator

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.service.testutils.assertHasDataWithType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RequestStartManualChargeCreatorTest {

    private val toTest = RequestStartManualChargeCreator()

    @Test
    fun `test frame creation`() {
        val result = toTest(1000)

        assertEquals(1, result.data.size)

        result.assertHasDataWithType(
            tag = EMSTag.REQ_START_MANUAL_CHARGE,
            expectedType = DataType.UINT32
        )
        assertEquals(1000, result.intByTag(EMSTag.REQ_START_MANUAL_CHARGE))
    }

}
