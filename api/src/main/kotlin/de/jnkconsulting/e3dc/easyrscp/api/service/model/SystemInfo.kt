package de.jnkconsulting.e3dc.easyrscp.api.service.model

import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.IsoFields

/**
 * Contains the basic system information of a home power plant
 *
 * @param serialNumber Serial number of the home power plant
 * @param softwareVersion Currently installed firmware
 * @param productionDate Date of manufacture of the home power plant
 *
 * @since 2.0
 */
data class SystemInfo(
    val serialNumber: String,
    val softwareVersion: String,
    val productionDate: ProductionDate
)

/**
 * Contains the production date of the home power plant.
 *
 * Expected is the string read from a [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.InfoTag.PRODUCTION_DATE] data block.
 * This should be in the format "KWXY YYYY". Where XY stands for the calendar week and YYYY for the four-digit year.
 * 
 * If the string cannot be interpreted because the format differs, the properties [calendarWeek] and [year] are set to -1. [asLocalDate] then returns [LocalDate.MIN].
 * 
 * @param rscpValue Value from a [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.InfoTag.PRODUCTION_DATE] data block. Format "KWXY YYYY"
 * 
 * @since 2.0
 */
data class ProductionDate(
    val rscpValue: String
) {
    /**
     * Calendar week. If the calendar week could not be extracted from [rscpValue], the value here is always -1
     *
     * @since 2.0
     */
    val calendarWeek: Int

    /**
     * Four-digit year. If the year could not be extracted from [rscpValue], the value here is always -1
     *
     * @since 2.0
     */
    val year: Int

    init {
        val regex = """KW(\d+) (\d+)""".toRegex()
        val matchResult = regex.find(rscpValue)

        if (matchResult != null) {
            val (cw, year) = matchResult.destructured
            calendarWeek = cw.toInt()
            this.year = year.toInt()
        } else {
            calendarWeek = -1;
            year = -1;
        }
    }

    /**
     * Converts [calendarWeek] and [year] into a [LocalDate] object. The first day of the calendar week is used as day.
     *
     * If [calendarWeek] or [year] could not be extracted from the [rscpValue], [LocalDate.MIN] is supplied.
     *
     * @return [calendarWeek] and [year] as [LocalDate] with the first day of the week as [LocalDate.getDayOfMonth]. [LocalDate.MIN] is returned if the [rscpValue] could not be interpreted.
     *
     * @since 2.0
     */
    fun asLocalDate(): LocalDate =
        when (calendarWeek == -1) {
            true -> LocalDate.MIN
            false -> LocalDate
                .of(year, 1, 1)
                .with(IsoFields.WEEK_OF_WEEK_BASED_YEAR, calendarWeek.toLong())
                .with(IsoFields.WEEK_BASED_YEAR, 2022)
                .with(DayOfWeek.MONDAY)
        }

    override fun toString(): String {
        return "ProductionDate(rscpValue='$rscpValue', calendarWeek=$calendarWeek, year=$year, localDate=${asLocalDate()})"
    }


}
