package de.jnkconsulting.e3dc.easyrscp.service.creator

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.InfoTag
import de.jnkconsulting.e3dc.easyrscp.service.testutils.assertHasDataWithType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RequestSystemInfosCreatorTest {
    private val toTest = RequestSystemInfosCreator()

    @Test
    fun `test frame creation`() {
        val result = toTest(null)

        assertEquals(4, result.data.size)

        result.assertHasDataWithType(
            tag = InfoTag.REQ_MAC_ADDRESS,
            expectedType = DataType.NONE
        )

        result.assertHasDataWithType(
            tag = InfoTag.REQ_PRODUCTION_DATE,
            expectedType = DataType.NONE
        )

        result.assertHasDataWithType(
            tag = InfoTag.REQ_SERIAL_NUMBER,
            expectedType = DataType.NONE
        )

        result.assertHasDataWithType(
            tag = InfoTag.REQ_SW_RELEASE,
            expectedType = DataType.NONE
        )
    }
}
