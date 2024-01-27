package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.Instant

class StartManualChargeResponseConverterTest {
    val toTest = StartManualChargeResponseConverter()

    private val timestamp = Instant.now()

    @Test
    fun `test conversion`() {
        val frame = FrameBuilder()
            .timestamp(timestamp)
            .addData(
                DataBuilder().tag(EMSTag.START_MANUAL_CHARGE).bool(true).build()
            )
            .build()

        val result = toTest.invoke(frame)
        assertTrue(result)
    }
}
