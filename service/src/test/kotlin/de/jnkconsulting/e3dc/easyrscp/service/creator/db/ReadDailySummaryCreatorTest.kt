package de.jnkconsulting.e3dc.easyrscp.service.creator.db

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.DBTag
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ChargingLimits
import de.jnkconsulting.e3dc.easyrscp.service.converter.StringFrameConverter
import de.jnkconsulting.e3dc.easyrscp.service.creator.SetPowerSettingsCreator
import de.jnkconsulting.e3dc.easyrscp.service.testutils.assertHasDataWithType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate

class ReadDailySummaryCreatorTest {

    private val toTest = ReadDailySummaryCreator()

    @Test
    fun `test frame creation`() {
        val input = LocalDate.of(2023, 6, 25)

        val result = toTest(input)

        assertEquals(1, result.data.size)

        result.assertHasDataWithType(
            tag = DBTag.REQ_HISTORY_DATA_DAY,
            expectedType = DataType.CONTAINER
        )

        result.assertHasDataWithType(
            tag = DBTag.REQ_HISTORY_TIME_START,
            expectedType = DataType.TIMESTAMP,
            expectedValue = "2023-06-25T00:00:00",
            path = arrayOf(DBTag.REQ_HISTORY_DATA_DAY)
        )

        result.assertHasDataWithType(
            tag = DBTag.REQ_HISTORY_TIME_INTERVAL,
            expectedType = DataType.TIMESTAMP,
            expectedValue = "1970-01-02T00:00:00", // Duration 1 day -> Starts at 1970-01-01
            path = arrayOf(DBTag.REQ_HISTORY_DATA_DAY)
        )

        result.assertHasDataWithType(
            tag = DBTag.REQ_HISTORY_TIME_SPAN,
            expectedType = DataType.TIMESTAMP,
            expectedValue = "1970-01-02T00:00:00", // Duration 1 day -> Starts at 1970-01-01
            path = arrayOf(DBTag.REQ_HISTORY_DATA_DAY)
        )
    }
}
