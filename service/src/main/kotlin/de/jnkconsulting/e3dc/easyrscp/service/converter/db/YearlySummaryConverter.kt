package de.jnkconsulting.e3dc.easyrscp.service.converter.db

import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.DBTag
import de.jnkconsulting.e3dc.easyrscp.api.service.model.HistoryData
import de.jnkconsulting.e3dc.easyrscp.service.converter.RequestResponseFrameConvert

/**
 * Converter to build a [HistoryData] object from a frame.
 *
 * The [HistoryData] instance contains a year summary
 *
 * @since 2.0
 */
class YearlySummaryConverter: RequestResponseFrameConvert<HistoryData> {

    override fun invoke(request: Frame, response: Frame) =
        HistoryData(
            start = request.instantByTag(DBTag.REQ_HISTORY_TIME_START, DBTag.REQ_HISTORY_DATA_YEAR),
            duration = request.durationByTag(DBTag.REQ_HISTORY_TIME_SPAN, DBTag.REQ_HISTORY_DATA_YEAR),
            batteryIn = response.floatByTag(DBTag.BAT_POWER_IN, DBTag.HISTORY_DATA_YEAR, DBTag.SUM_CONTAINER),
            batteryOut = response.floatByTag(DBTag.BAT_POWER_OUT, DBTag.HISTORY_DATA_YEAR, DBTag.SUM_CONTAINER),
            gridIn = response.floatByTag(DBTag.GRID_POWER_IN, DBTag.HISTORY_DATA_YEAR, DBTag.SUM_CONTAINER),
            gridOut = response.floatByTag(DBTag.GRID_POWER_OUT, DBTag.HISTORY_DATA_YEAR, DBTag.SUM_CONTAINER),
            pvDelivery = response.floatByTag(DBTag.DC_POWER, DBTag.HISTORY_DATA_YEAR, DBTag.SUM_CONTAINER),
            houseConsumption = response.floatByTag(DBTag.CONSUMPTION, DBTag.HISTORY_DATA_YEAR, DBTag.SUM_CONTAINER),
            selfSufficiency = response.floatByTag(DBTag.AUTARKY, DBTag.HISTORY_DATA_YEAR, DBTag.SUM_CONTAINER) / 100.0f,
            selfConsumption = response.floatByTag(DBTag.CONSUMED_PRODUCTION, DBTag.HISTORY_DATA_YEAR, DBTag.SUM_CONTAINER) / 100.0f
        )
}
