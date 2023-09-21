package de.jnkconsulting.e3dc.easyrscp.service.creator.db

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.DBTag
import de.jnkconsulting.e3dc.easyrscp.service.converter.StringFrameConverter
import de.jnkconsulting.e3dc.easyrscp.service.testutils.assertHasDataWithType
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.Year

class ReadYearlySummaryCreatorTest {

    private val toTest = ReadYearlySummaryCreator()

    @Test
    fun `test frame creation`() {
        val input = Year.of(2023)

        val result = toTest(input)

        println(StringFrameConverter().invoke(result))

        assertEquals(1, result.data.size)

        result.assertHasDataWithType(
            tag = DBTag.REQ_HISTORY_DATA_YEAR,
            expectedType = DataType.CONTAINER
        )

        result.assertHasDataWithType(
            tag = DBTag.REQ_HISTORY_TIME_START,
            expectedType = DataType.TIMESTAMP,
            expectedValue = "2023-01-01T00:00:00",
            path = arrayOf(DBTag.REQ_HISTORY_DATA_YEAR)
        )

        result.assertHasDataWithType(
            tag = DBTag.REQ_HISTORY_TIME_INTERVAL,
            expectedType = DataType.TIMESTAMP,
            expectedValue = "1971-01-01T00:00:00", // Duration 1 year -> Starts at 1970-01-01
            path = arrayOf(DBTag.REQ_HISTORY_DATA_YEAR)
        )

        result.assertHasDataWithType(
            tag = DBTag.REQ_HISTORY_TIME_SPAN,
            expectedType = DataType.TIMESTAMP,
            expectedValue = "1971-01-01T00:00:00", // Duration 1 year -> Starts at 1970-01-01
            path = arrayOf(DBTag.REQ_HISTORY_DATA_YEAR)
        )
    }
}
