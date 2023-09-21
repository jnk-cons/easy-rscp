package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.Instant

class PowerStateConverterTest {
    val toTest = PowerStateConverter()

    private val timestamp = Instant.now()

    @Test
    fun `test conversion`() {
        val frame = FrameBuilder()
            .timestamp(timestamp)
            .addData(
                DataBuilder().tag(EMSTag.POWER_PV).int32(2000).build(),
                DataBuilder().tag(EMSTag.POWER_GRID).int32(300).build(),
                DataBuilder().tag(EMSTag.POWER_BAT).int32(450).build(),
                DataBuilder().tag(EMSTag.POWER_HOME).int32(370).build(),
                DataBuilder().tag(EMSTag.BAT_SOC).uchar8(82).build()
            )
            .build()

        val result = toTest.invoke(frame)

        assertEquals(timestamp, result.timestamp)
        assertEquals(2000, result.pvDelivery)
        assertEquals(300, result.gridDelivery)
        assertEquals(-450, result.batteryDelivery)
        assertEquals(370, result.houseConsumption)
        assertEquals(0.82f, result.batteryChargingLevel)


    }
}
