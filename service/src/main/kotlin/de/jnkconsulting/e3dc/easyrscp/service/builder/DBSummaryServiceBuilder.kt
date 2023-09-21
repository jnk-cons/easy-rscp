package de.jnkconsulting.e3dc.easyrscp.service.builder

import de.jnkconsulting.e3dc.easyrscp.api.service.DBSummaryService
import de.jnkconsulting.e3dc.easyrscp.api.service.model.HistoryData
import de.jnkconsulting.e3dc.easyrscp.connection.ConnectionBuilder
import de.jnkconsulting.e3dc.easyrscp.service.DefaultDBSummaryService
import de.jnkconsulting.e3dc.easyrscp.service.converter.RequestResponseFrameConvert
import de.jnkconsulting.e3dc.easyrscp.service.converter.db.DailySummaryConverter
import de.jnkconsulting.e3dc.easyrscp.service.converter.db.MonthlySummaryConverter
import de.jnkconsulting.e3dc.easyrscp.service.converter.db.YearlySummaryConverter
import de.jnkconsulting.e3dc.easyrscp.service.creator.FrameCreator
import de.jnkconsulting.e3dc.easyrscp.service.creator.db.ReadDailySummaryCreator
import de.jnkconsulting.e3dc.easyrscp.service.creator.db.ReadMonthlySummaryCreator
import de.jnkconsulting.e3dc.easyrscp.service.creator.db.ReadYearlySummaryCreator
import java.time.LocalDate
import java.time.Year
import java.time.YearMonth

/**
 * [ServiceBuilder] implementation that creates instances of the [DBSummaryService] type.
 *
 * The Builder offers optional extension points in frame conversion and frame generation:
 * - [withDailySummaryFrameConverter]
 * - [withMonthlySummaryFrameConverter]
 * - [withYearlySummaryFrameConverter]
 * - [withRequestDailySummaryFrameCreator]
 * - [withRequestMonthlySummaryFrameCreator]
 * - [withRequestYearlySummaryFrameCreator]
 *
 * @since 2.0
 */
class DBSummaryServiceBuilder: DefaultServiceBuilder<DBSummaryService>() {

    private var convertFrameToDailySummary: RequestResponseFrameConvert<HistoryData>? = null
    private var convertFrameToMonthlySummary: RequestResponseFrameConvert<HistoryData>? = null
    private var convertFrameToYearlySummary: RequestResponseFrameConvert<HistoryData>? = null
    private var createRequestDailySummaryFrame: FrameCreator<LocalDate>? = null
    private var createRequestMonthlySummaryFrame: FrameCreator<YearMonth>? = null
    private var createRequestYearlySummaryFrame: FrameCreator<Year>? = null

    /**
     * Function is only overwritten to increase usability in java. Without that, the Java compiler would generate an error, because here a
     * [DefaultServiceBuilder] instance is supplied and no [DBSummaryServiceBuilder] instance ...
     */
    override fun withConnectionBuilder(connectionBuilder: ConnectionBuilder): DBSummaryServiceBuilder {
        return super.withConnectionBuilder(connectionBuilder) as DBSummaryServiceBuilder
    }

    /**
     * Sets the converter to create a [HistoryData] object from a response frame. Optional specification.
     * By default an instance of the type [DailySummaryConverter] is used.
     *
     * @param converter Converter to use
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withDailySummaryFrameConverter(converter: RequestResponseFrameConvert<HistoryData>) =
        converter
            .let {
                convertFrameToDailySummary = it
                this
            }

    /**
     * Sets the converter to create a [HistoryData] object from a response frame. Optional setting.
     * By default an instance of the type [MonthlySummaryConverter] is used.
     *
     * @param converter Converter to use
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withMonthlySummaryFrameConverter(converter: RequestResponseFrameConvert<HistoryData>) =
        converter
            .let {
                convertFrameToMonthlySummary = it
                this
            }

    /**
     * Sets the converter to create a [HistoryData] object from a response frame. Optional setting.
     * By default an instance of the type [YearlySummaryConverter] is used.
     *
     * @param converter Converter to use
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withYearlySummaryFrameConverter(converter: RequestResponseFrameConvert<HistoryData>) =
        converter
            .let {
                convertFrameToYearlySummary = it
                this
            }

    /**
     * Sets the creator of request frames to load daily summaries from the house power plant database. Optional setting.
     * By default, an instance of the type [ReadDailySummaryCreator] is used.
     *
     * @param creator Creator to use
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withRequestDailySummaryFrameCreator(creator: FrameCreator<LocalDate>?) =
        creator
            .let {
                createRequestDailySummaryFrame = it
                this
            }

    /**
     * Sets the creator of request frames to load monthly summaries from the house power plant database. Optional setting.
     * By default, an instance of the type [ReadMonthlySummaryCreator] is used.
     *
     * @param creator Creator to use
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withRequestMonthlySummaryFrameCreator(creator: FrameCreator<YearMonth>?) =
        creator
            .let {
                createRequestMonthlySummaryFrame = it
                this
            }

    /**
     * Sets the creator of request frames to load yearly summaries from the house power plant database. Optional setting.
     * By default, an instance of the type [ReadYearlySummaryCreator] is used.
     *
     * @param creator Creator to use
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withRequestYearlySummaryFrameCreator(creator: FrameCreator<Year>?) =
        creator
            .let {
                createRequestYearlySummaryFrame = it
                this
            }

    private fun buildDailySummaryFrameConverter() =
        convertFrameToDailySummary ?: DailySummaryConverter()

    private fun buildMonthlySummaryFrameConverter() =
        convertFrameToMonthlySummary ?: MonthlySummaryConverter()

    private fun buildYearlySummaryFrameConverter() =
        convertFrameToYearlySummary ?: YearlySummaryConverter()

    private fun buildRequestDailySummaryFrameCreator() =
        createRequestDailySummaryFrame ?: ReadDailySummaryCreator()

    private fun buildRequestMonthlySummaryFrameCreator() =
        createRequestMonthlySummaryFrame ?: ReadMonthlySummaryCreator()

    private fun buildRequestYearlySummaryFrameCreator() =
        createRequestYearlySummaryFrame ?: ReadYearlySummaryCreator()

    override fun buildService() =
        DefaultDBSummaryService(
            connectionPool = getConnectionBuilder().buildConnectionPool(),
            convertFrameToDailySummary = buildDailySummaryFrameConverter(),
            convertFrameToMonthlySummary = buildMonthlySummaryFrameConverter(),
            convertFrameToYearlySummary = buildYearlySummaryFrameConverter(),
            createRequestDailySummaryFrame = buildRequestDailySummaryFrameCreator(),
            createRequestMonthlySummaryFrame = buildRequestMonthlySummaryFrameCreator(),
            createRequestYearlySummaryFrame = buildRequestYearlySummaryFrameCreator(),
        )
}
