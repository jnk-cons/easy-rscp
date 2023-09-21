package de.jnkconsulting.e3dc.easyrscp.service.creator.db

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.DBTag
import de.jnkconsulting.e3dc.easyrscp.service.converter.StringFrameConverter
import de.jnkconsulting.e3dc.easyrscp.service.testutils.assertHasDataWithType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.Month
import java.time.YearMonth

class ReadMonthlySummaryCreatorTest {

    private val toTest = ReadMonthlySummaryCreator()

    @Test
    fun `test frame creation`() {
        val input = YearMonth.of(2023, Month.JULY)

        val result = toTest(input)

        assertEquals(1, result.data.size)

        result.assertHasDataWithType(
            tag = DBTag.REQ_HISTORY_DATA_MONTH,
            expectedType = DataType.CONTAINER
        )

        result.assertHasDataWithType(
            tag = DBTag.REQ_HISTORY_TIME_START,
            expectedType = DataType.TIMESTAMP,
            expectedValue = "2023-07-01T00:00:00",
            path = arrayOf(DBTag.REQ_HISTORY_DATA_MONTH)
        )

        result.assertHasDataWithType(
            tag = DBTag.REQ_HISTORY_TIME_INTERVAL,
            expectedType = DataType.TIMESTAMP,
            expectedValue = "1970-02-01T00:00:00", // Duration 1 month -> Starts at 1970-01-01
            path = arrayOf(DBTag.REQ_HISTORY_DATA_MONTH)
        )

        result.assertHasDataWithType(
            tag = DBTag.REQ_HISTORY_TIME_SPAN,
            expectedType = DataType.TIMESTAMP,
            expectedValue = "1970-02-01T00:00:00", // Duration 1 month -> Starts at 1970-01-01
            path = arrayOf(DBTag.REQ_HISTORY_DATA_MONTH)
        )
    }
}
