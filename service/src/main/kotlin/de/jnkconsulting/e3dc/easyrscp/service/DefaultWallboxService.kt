package de.jnkconsulting.e3dc.easyrscp.service

import de.jnkconsulting.e3dc.easyrscp.api.connection.ConnectionPool
import de.jnkconsulting.e3dc.easyrscp.api.service.WallboxService
import de.jnkconsulting.e3dc.easyrscp.api.service.model.WallboxInfo
import de.jnkconsulting.e3dc.easyrscp.api.service.model.WallboxPowerState
import de.jnkconsulting.e3dc.easyrscp.service.converter.*
import de.jnkconsulting.e3dc.easyrscp.service.creator.*
import mu.KotlinLogging

/**
 * Implementation to query the live data of the home power plant
 *
 * @param connectionPool Connection pool to be used
 * @param convertConnectedIdsConverter Converter to create a list of Wallbox IDs out of a connected devices response frame. By default, an instance of [WallboxDeviceIdsConverter] is used
 * @param convertWallboxInfosConverter Converter to create a list of Wallbox infos out of a frame. By default, an instance of [WallboxDeviceInfosConverter] is used
 * @param convertWallboxLiveDataConverter Converter to create a list of Wallbox live data infos out of a frame. By default, an instance of [WallboxPowerStateConverter] is used
 * @param createRequestConnectedWallboxes Creator for frames to query the connected Wallbox IDs. By default, an instance of [RequestWallboxIdsCreator] is used
 * @param createRequestWallboxInfos Creator for frames to query infos about the connected Wallboxes. By default, an instance of [RequestWallboxInfosCreator] is used
 * @param createRequestWallboxLiveData Creator for frames to query live power data from the given wallbozes. By default, an instance of [RequestWallboxLiveDataCreator] is used
 *
 * @since 2.3
 */
class DefaultWallboxService(
    private val connectionPool: ConnectionPool,
    private val convertConnectedIdsConverter: FrameConverter<List<Int>> = WallboxDeviceIdsConverter(),
    private val convertWallboxInfosConverter: FrameConverter<List<WallboxInfo>> = WallboxDeviceInfosConverter(),
    private val convertWallboxLiveDataConverter: FrameConverter<List<WallboxPowerState>> = WallboxPowerStateConverter(),
    private val createRequestConnectedWallboxes: FrameCreator<Nothing?> = RequestWallboxIdsCreator(),
    private val createRequestWallboxInfos: FrameCreator<List<Int>> = RequestWallboxInfosCreator(),
    private val createRequestWallboxLiveData: FrameCreator<List<Int>> = RequestWallboxLiveDataCreator()
) : WallboxService {

    private val logger = KotlinLogging.logger {}

    override fun readConnectedWallboxes() =
        connectionPool.executeAndRelease {
            val requestIds = createRequestConnectedWallboxes(null)
            logger.trace { "Requesting connected wallboxes: $requestIds" }
            val responseIds = it.send(requestIds)
            logger.trace { "Received connected wallboxes: $responseIds" }
            val ids = convertConnectedIdsConverter(responseIds)
            if (ids.isNotEmpty()) {
                val requestInfos = createRequestWallboxInfos(ids)
                logger.trace { "Requesting wallbox infos: $requestInfos" }
                val responseInfos = it.send(requestInfos)
                logger.trace { "Received wallbox infos: $responseInfos" }
                convertWallboxInfosConverter(responseInfos)
            }
            else {
                listOf()
            }
        }

    override fun readPowerState(vararg ids: Int) =
        connectionPool.executeAndRelease {
            if (ids.isEmpty()) {
                logger.error { "Parameter ids can not be empty" }
                throw IllegalArgumentException("Parameter ids can not be empty")
            }
            val request = createRequestWallboxLiveData(ids.asList())
            logger.trace { "Requesting livedata for wallboxes: $request" }
            val response = it.send(request)
            logger.trace { "Received livedata for wallboxes: $response" }
            convertWallboxLiveDataConverter(response)
        }
}
