package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.InfoTag
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ProductionDate
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.Instant

class SystemInfoConverterTest {
    val toTest = SystemInfoConverter()

    private val timestamp = Instant.now()

    @Test
    fun `test conversion`() {
        val frame = FrameBuilder()
            .timestamp(timestamp)
            .addData(
                DataBuilder().tag(InfoTag.SERIAL_NUMBER).string("12345").build(),
                DataBuilder().tag(InfoTag.SW_RELEASE).string("6789").build(),
                DataBuilder().tag(InfoTag.PRODUCTION_DATE).string("KW22 2022").build()
            )
            .build()

        val result = toTest.invoke(frame)

        assertEquals("12345", result.serialNumber)
        assertEquals("6789", result.softwareVersion)
        assertEquals(ProductionDate("KW22 2022"), result.productionDate)
    }
}
