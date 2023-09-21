package de.jnkconsulting.e3dc.easyrscp.service

import de.jnkconsulting.e3dc.easyrscp.api.connection.ConnectionPool
import de.jnkconsulting.e3dc.easyrscp.api.service.DBSummaryService
import de.jnkconsulting.e3dc.easyrscp.api.service.model.HistoryData
import de.jnkconsulting.e3dc.easyrscp.service.converter.RequestResponseFrameConvert
import de.jnkconsulting.e3dc.easyrscp.service.converter.db.DailySummaryConverter
import de.jnkconsulting.e3dc.easyrscp.service.converter.db.MonthlySummaryConverter
import de.jnkconsulting.e3dc.easyrscp.service.converter.db.YearlySummaryConverter
import de.jnkconsulting.e3dc.easyrscp.service.creator.FrameCreator
import de.jnkconsulting.e3dc.easyrscp.service.creator.db.ReadDailySummaryCreator
import de.jnkconsulting.e3dc.easyrscp.service.creator.db.ReadMonthlySummaryCreator
import de.jnkconsulting.e3dc.easyrscp.service.creator.db.ReadYearlySummaryCreator
import mu.KotlinLogging
import java.time.LocalDate
import java.time.Year
import java.time.YearMonth

/**
 * Service to retrieve the summary data of a time period (day, month, year, etc) from the home power plant database.S
 *
 * @param connectionPool Connection pool to be used
 * @param convertFrameToDailySummary Converter to create a [HistoryData] object from a frame for the daily summary. By default, an instance of [DailySummaryConverter] is used
 * @param convertFrameToMonthlySummary Converter to create a [HistoryData] object from a frame for the monthly summary. By default, an instance of [MonthlySummaryConverter] is used
 * @param convertFrameToYearlySummary Converter to create a [HistoryData] object from a frame for the yearlu summary. By default, an instance of [YearlySummaryConverter] is used
 * @param createRequestDailySummaryFrame Creator for frames to query the summary of a specific day. By default, an instance of [ReadDailySummaryCreator] is used
 * @param createRequestMonthlySummaryFrame Creator for frames to query the summary of a specific month. By default, an instance of [ReadMonthlySummaryCreator] is used
 * @param createRequestYearlySummaryFrame Creator for frames to query the summary of a specific year. By default, an instance of [ReadYearlySummaryCreator] is used
 *
 * @since 2.0
 */
class DefaultDBSummaryService(
    private val connectionPool: ConnectionPool,
    private val convertFrameToDailySummary: RequestResponseFrameConvert<HistoryData> = DailySummaryConverter(),
    private val convertFrameToMonthlySummary: RequestResponseFrameConvert<HistoryData> = MonthlySummaryConverter(),
    private val convertFrameToYearlySummary: RequestResponseFrameConvert<HistoryData> = YearlySummaryConverter(),
    private val createRequestDailySummaryFrame: FrameCreator<LocalDate> = ReadDailySummaryCreator(),
    private val createRequestMonthlySummaryFrame: FrameCreator<YearMonth> = ReadMonthlySummaryCreator(),
    private val createRequestYearlySummaryFrame: FrameCreator<Year> = ReadYearlySummaryCreator()
): DBSummaryService {

    private val logger = KotlinLogging.logger {  }

    override fun readDailySummary(day: LocalDate) =
        connectionPool.executeAndRelease {
            val request = createRequestDailySummaryFrame(day)
            logger.trace { "Requesting summary of day $day: $request" }
            val response = it.send(request)
            logger.trace { "Received summary of day $day: $response" }
            convertFrameToDailySummary(request, response)
        }

    override fun readMonthlySummary(yearMonth: YearMonth) =
        connectionPool.executeAndRelease {
            val request = createRequestMonthlySummaryFrame(yearMonth)
            logger.trace { "Requesting summary of month $yearMonth: $request" }
            val response = it.send(request)
            logger.trace { "Received summary of month $yearMonth: $response" }
            convertFrameToMonthlySummary(request, response)
        }

    override fun readYearlySummary(year: Year) =
        connectionPool.executeAndRelease {
            val request = createRequestYearlySummaryFrame(year)
            logger.trace { "Requesting summary of year $year: $request" }
            val response = it.send(request)
            logger.trace { "Received summary of year $year: $response" }
            convertFrameToYearlySummary(request, response)
        }

}
