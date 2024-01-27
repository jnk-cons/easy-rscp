package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.Instant

class ManualChargeStateConverterTest {
    val toTest = ManualChargeStateConverter()

    private val timestamp = Instant.now()

    @Test
    fun `test conversion`() {
        val frame = FrameBuilder()
            .timestamp(timestamp)
            .addData(
                DataBuilder().tag(EMSTag.GET_MANUAL_CHARGE).container(
                    DataBuilder().tag(EMSTag.MANUAL_CHARGE_ACTIVE).bool(true).build(),
                    DataBuilder().tag(EMSTag.MANUAL_CHARGE_LASTSTART).timestamp(timestamp).build(),
                    DataBuilder().tag(EMSTag.MANUAL_CHARGE_START_COUNTER).int64(100).build(),
                    DataBuilder().tag(EMSTag.MANUAL_CHARGE_ENERGY_COUNTER).double64(3000.0).build()
                ).build()
            )
            .build()

        val result = toTest.invoke(frame)

        assertEquals(timestamp, result.lastRun)
        assertEquals(3000.0, result.chargedEnergyWh)
        assertTrue(result.active)
    }
}
