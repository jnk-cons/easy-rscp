package de.jnkconsulting.e3dc.easyrscp.api.service.model

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Month

class ProductionDateTest {

    @Test
    fun `test parsing middle of year`() {
        val toTest = ProductionDate("KW27 2022")

        assertEquals(27, toTest.calendarWeek)
        assertEquals(2022, toTest.year)
        val localDate = toTest.asLocalDate()
        assertEquals(4, localDate.dayOfMonth)
        assertEquals(Month.JULY, localDate.month)
        assertEquals(2022, localDate.year)
    }

    @Test
    fun `test parsing start of year`() {
        val toTest = ProductionDate("KW1 2022")
        assertEquals(1, toTest.calendarWeek)
        assertEquals(2022, toTest.year)
        val localDate = toTest.asLocalDate()
        assertEquals(3, localDate.dayOfMonth)
        assertEquals(Month.JANUARY, localDate.month)
        assertEquals(2022, localDate.year)
    }

    @Test
    fun `test parsing of unexpected string format`() {
        val toTest = ProductionDate("wrong format")
        assertEquals(-1, toTest.calendarWeek)
        assertEquals(-1, toTest.year)
        val localDate = toTest.asLocalDate()
        assertEquals(LocalDate.MIN, localDate)
    }

}
