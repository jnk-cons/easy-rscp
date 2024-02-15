package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WallboxDeviceInfosConverterTest {
    val toTest = WallboxDeviceInfosConverter()

    @Test
    fun `test conversion`() {
        val frame = FrameBuilder()
            .addData(
                DataBuilder().tag(WBTag.DATA).container(
                    DataBuilder().tag(WBTag.INDEX).uchar8(0).build(),
                    DataBuilder().tag(WBTag.DEVICE_NAME).string("WB 1").build()
                ).build(),
                DataBuilder().tag(WBTag.DATA).container(
                    DataBuilder().tag(WBTag.INDEX).uchar8(5).build(),
                    DataBuilder().tag(WBTag.DEVICE_NAME).string("WB 5").build()
                ).build(),
                DataBuilder().tag(WBTag.DATA).container(
                    DataBuilder().tag(WBTag.INDEX).uchar8(7).build(),
                    DataBuilder().tag(WBTag.DEVICE_NAME).string("WB 7").build()
                ).build()
            )
            .build()

        val result = toTest.invoke(frame)

        assertEquals(3, result.size)
        assertEquals(0, result[0].id)
        assertEquals("WB 1", result[0].name)

        assertEquals(5, result[1].id)
        assertEquals("WB 5", result[1].name)

        assertEquals(7, result[2].id)
        assertEquals("WB 7", result[2].name)
    }
}
