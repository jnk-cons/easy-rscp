package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WallboxDeviceIdsConverterTest {
    val toTest = WallboxDeviceIdsConverter()

    @Test
    fun `test conversion`() {
        val frame = FrameBuilder()
            .addData(
                DataBuilder().tag(WBTag.CONNECTED_DEVICES).container(
                    DataBuilder().tag(WBTag.INDEX).uchar8(0).build(),
                    DataBuilder().tag(WBTag.INDEX).uchar8(1).build()
                ).build()
            )
            .build()

        val result = toTest.invoke(frame)

        assertEquals(2, result.size)
        assertEquals(0, result[0])
        assertEquals(1, result[1])
    }
}
