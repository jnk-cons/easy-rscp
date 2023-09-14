package de.jnkconsulting.e3dc.easyrscp.service.creator.db


import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.DBTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import de.jnkconsulting.e3dc.easyrscp.service.creator.FrameCreator
import java.time.Duration
import java.time.LocalDate
import java.time.ZoneId

/**
 * [de.jnkconsulting.e3dc.easyrscp.api.frame.Frame] generator to request the day summary of a specific day
 *
 * @since 2.0
 */
class ReadDailySummaryCreator: FrameCreator<LocalDate> {

    override fun invoke(day: LocalDate) =
        FrameBuilder()
            .addData(
                DataBuilder().tag(DBTag.REQ_HISTORY_DATA_DAY).container(
                    DataBuilder().tag(DBTag.REQ_HISTORY_TIME_START).timestamp(day.atStartOfDay(ZoneId.of("Z")).toInstant()).build(),
                    DataBuilder().tag(DBTag.REQ_HISTORY_TIME_INTERVAL).timestamp(Duration.ofHours(24)).build(),
                    DataBuilder().tag(DBTag.REQ_HISTORY_TIME_SPAN).timestamp(Duration.ofHours(24)).build()
                )
                    .build()
            )
            .build()
}
