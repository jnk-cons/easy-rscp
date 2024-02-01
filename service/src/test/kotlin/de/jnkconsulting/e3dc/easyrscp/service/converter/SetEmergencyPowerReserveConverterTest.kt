package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EPTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.Instant

class SetEmergencyPowerReserveConverterTest {
    val toTest = EmergencyPowerStateConverter()

    private val timestamp = Instant.now()

    @Test
    fun `test conversion`() {
        val frame = FrameBuilder()
            .timestamp(timestamp)
            .addData(
                DataBuilder().tag(EPTag.EP_RESERVE).container(
                    DataBuilder().tag(EPTag.PARAM_EP_RESERVE_ENERGY).float32(2000.0f).build(),
                    DataBuilder().tag(EPTag.PARAM_EP_RESERVE).float32(25.3f).build(),
                ).build(),
                DataBuilder().tag(EPTag.IS_GRID_CONNECTED).bool(true).build(),
                DataBuilder().tag(EPTag.IS_READY_FOR_SWITCH).bool(true).build(),
                DataBuilder().tag(EPTag.IS_POSSIBLE).bool(true).build(),
                DataBuilder().tag(EPTag.IS_INVALID_STATE).bool(true).build(),
                DataBuilder().tag(EPTag.IS_ISLAND_GRID).bool(true).build(),
            )
            .build()

        val result = toTest.invoke(frame)

        assertTrue(result.emergencyPowerPossible)
        assertTrue(result.invalidState)
        assertTrue(result.island)
        assertTrue(result.readyForSwitch)
        assertTrue(result.connectedToGrid)

        assertEquals(result.reservePercentage, 0.253f, 0.0001f)
        assertEquals(result.reserveWh, 2000.0f, 0.0001f)
    }
}
