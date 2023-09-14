package de.jnkconsulting.e3dc.easyrscp.service.creator.db


import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.DBTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import de.jnkconsulting.e3dc.easyrscp.service.creator.FrameCreator
import java.time.*

/**
 * [de.jnkconsulting.e3dc.easyrscp.api.frame.Frame] generator to request the year summary of a specific year
 *
 * @since 2.0
 */
class ReadYearlySummaryCreator: FrameCreator<Year> {

    override fun invoke(year: Year) =
        FrameBuilder()
            .addData(
                DataBuilder().tag(DBTag.REQ_HISTORY_DATA_YEAR).container(
                    DataBuilder().tag(DBTag.REQ_HISTORY_TIME_START).timestamp(year.atMonthDay(MonthDay.of(Month.JANUARY, 1)).atStartOfDay(ZoneId.of("Z")).toInstant()).build(),
                    DataBuilder().tag(DBTag.REQ_HISTORY_TIME_INTERVAL).timestamp(Duration.ofDays(year.length().toLong())).build(),
                    DataBuilder().tag(DBTag.REQ_HISTORY_TIME_SPAN).timestamp(Duration.ofDays(year.length().toLong())).build()
                )
                    .build()
            )
            .build()
}
