package de.jnkconsulting.e3dc.easyrscp.api.service

import de.jnkconsulting.e3dc.easyrscp.api.service.model.HistoryData
import java.time.LocalDate
import java.time.Year
import java.time.YearMonth

/**
 * Definition of the service to read summary data from the home power plant database
 *
 * @since 2.0
 */
interface DBSummaryService {

    /**
     * Reads the basic data for a concrete day
     *
     * @param day Day to be read
     *
     * @return Basic data of the specified day
     *
     * @since 2.0
     */
    fun readDailySummary(day: LocalDate): HistoryData

    /**
     * Reads the basic data for a concrete month
     *
     * @param yearMonth Month to be read
     *
     * @return Basic data of the specified month
     *
     * @since 2.0
     */
    fun readMonthlySummary(yearMonth: YearMonth): HistoryData

    /**
     * Reads the basic data for a concrete year
     *
     * @param year Year to be read
     *
     * @return Basic data of the specified year
     *
     * @since 2.0
     */
    fun readYearlySummary(year: Year): HistoryData
}
