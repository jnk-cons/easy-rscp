package de.jnkconsulting.e3dc.easyrscp.service.creator

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag
import de.jnkconsulting.e3dc.easyrscp.service.testutils.assertHasDataWithType
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RequestWallboxIdsCreatorTest {

    private val toTest = RequestWallboxIdsCreator()

    @Test
    fun `test frame creation`() {
        val result = toTest(null)

        assertEquals(1, result.data.size)

        result.assertHasDataWithType(
            tag = WBTag.REQ_CONNECTED_DEVICES,
            expectedType = DataType.NONE
        )
    }

}
