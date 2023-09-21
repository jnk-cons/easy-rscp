package de.jnkconsulting.e3dc.easyrscp.service.converter.db

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.DBTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.*

class MonthlySummaryConverterTest {
    val toTest = MonthlySummaryConverter()

    private val month = YearMonth.of(2023,Month.JULY)

    @Test
    fun `test conversion`() {
        val requestFrame = FrameBuilder()
            .addData(
                DataBuilder().tag(DBTag.REQ_HISTORY_DATA_MONTH).container(
                    DataBuilder().tag(DBTag.REQ_HISTORY_TIME_START).timestamp(month.atDay(1).atStartOfDay(ZoneId.of("Z")).toInstant()).build(),
                    DataBuilder().tag(DBTag.REQ_HISTORY_TIME_INTERVAL).timestamp(Duration.ofDays(month.lengthOfMonth().toLong())).build(),
                    DataBuilder().tag(DBTag.REQ_HISTORY_TIME_SPAN).timestamp(Duration.ofDays(month.lengthOfMonth().toLong())).build()
                )
                    .build()
            )
            .build()
        val responseFrame = FrameBuilder()
            .addData(
                DataBuilder().tag(DBTag.HISTORY_DATA_MONTH).container(
                    DataBuilder().tag(DBTag.SUM_CONTAINER).container(
                        DataBuilder().tag(DBTag.BAT_POWER_IN).float32(1000.0f).build(),
                        DataBuilder().tag(DBTag.BAT_POWER_OUT).float32(2000.0f).build(),
                        DataBuilder().tag(DBTag.GRID_POWER_IN).float32(3000.0f).build(),
                        DataBuilder().tag(DBTag.GRID_POWER_OUT).float32(4000.0f).build(),
                        DataBuilder().tag(DBTag.DC_POWER).float32(5000.0f).build(),
                        DataBuilder().tag(DBTag.CONSUMPTION).float32(6000.0f).build(),
                        DataBuilder().tag(DBTag.AUTARKY).float32(85.3f).build(),
                        DataBuilder().tag(DBTag.CONSUMED_PRODUCTION).float32(75.3f).build(),
                    ).build(),
                    DataBuilder().tag(DBTag.VALUE_CONTAINER).container(
                        DataBuilder().tag(DBTag.BAT_POWER_IN).float32(100.0f).build(),
                        DataBuilder().tag(DBTag.BAT_POWER_OUT).float32(200.0f).build(),
                        DataBuilder().tag(DBTag.GRID_POWER_IN).float32(300.0f).build(),
                        DataBuilder().tag(DBTag.GRID_POWER_OUT).float32(400.0f).build(),
                        DataBuilder().tag(DBTag.DC_POWER).float32(500.0f).build(),
                        DataBuilder().tag(DBTag.CONSUMPTION).float32(600.0f).build(),
                        DataBuilder().tag(DBTag.AUTARKY).float32(15.3f).build(),
                        DataBuilder().tag(DBTag.CONSUMED_PRODUCTION).float32(25.3f).build(),
                    ).build()
                ).build()
            )
            .build()

        val result = toTest.invoke(requestFrame, responseFrame)

        assertEquals(1000.0f, result.batteryIn)
        assertEquals(2000.0f, result.batteryOut)
        assertEquals(3000.0f, result.gridIn)
        assertEquals(4000.0f, result.gridOut)
        assertEquals(5000.0f, result.pvDelivery)
        assertEquals(6000.0f, result.houseConsumption)

        assertTrue(result.selfSufficiency >= 0.8529f && result.selfSufficiency <= 0.854f )
        assertTrue(result.selfConsumption >= 0.7529f && result.selfConsumption <= 0.754f )
    }
}
