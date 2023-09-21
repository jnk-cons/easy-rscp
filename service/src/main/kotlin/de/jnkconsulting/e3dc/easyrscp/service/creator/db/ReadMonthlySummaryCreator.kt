package de.jnkconsulting.e3dc.easyrscp.service.creator.db


import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.DBTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import de.jnkconsulting.e3dc.easyrscp.service.creator.FrameCreator
import java.time.Duration
import java.time.YearMonth
import java.time.ZoneId

/**
 * [de.jnkconsulting.e3dc.easyrscp.api.frame.Frame] generator to request the month summary of a specific month
 *
 * @since 2.0
 */
class ReadMonthlySummaryCreator: FrameCreator<YearMonth> {

    override fun invoke(month: YearMonth) =
        FrameBuilder()
            .addData(
                DataBuilder().tag(DBTag.REQ_HISTORY_DATA_MONTH).container(
                    DataBuilder().tag(DBTag.REQ_HISTORY_TIME_START).timestamp(month.atDay(1).atStartOfDay(ZoneId.of("Z")).toInstant()).build(),
                    DataBuilder().tag(DBTag.REQ_HISTORY_TIME_INTERVAL).timestamp(Duration.ofDays(month.lengthOfMonth().toLong())).build(),
                    DataBuilder().tag(DBTag.REQ_HISTORY_TIME_SPAN).timestamp(Duration.ofDays(month.lengthOfMonth().toLong())).build()
                )
                .build()
            )
            .build()
}
