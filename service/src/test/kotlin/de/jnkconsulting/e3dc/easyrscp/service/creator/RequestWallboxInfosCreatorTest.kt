package de.jnkconsulting.e3dc.easyrscp.service.creator

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag
import de.jnkconsulting.e3dc.easyrscp.frame.DefaultDataParser
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class RequestWallboxInfosCreatorTest {

    private val toTest = RequestWallboxInfosCreator()

    @Test
    fun `test frame creation`() {
        val result = toTest(listOf(3,1,5))

        val data = result.data
        assertEquals(3, result.data.size)
        data.forEachIndexed { index, data ->
            assertEquals(WBTag.REQ_DATA, data.tagObject())
            val content = data.valueAsContainer(DefaultDataParser())
            assertEquals(2, content.size)
            val indexBlock = content.find { it.tagObject() == WBTag.INDEX }
            assertNotNull(indexBlock)
            if (index == 0) {
                assertEquals(3, indexBlock?.valueAsInt())
            }
            else if (index == 1) {
                assertEquals(1, indexBlock?.valueAsInt())
            }
            else if (index == 2) {
                assertEquals(5, indexBlock?.valueAsInt())
            }
            assertNotNull(content.find { it.tagObject() == WBTag.REQ_DEVICE_NAME })
        }

    }

}
