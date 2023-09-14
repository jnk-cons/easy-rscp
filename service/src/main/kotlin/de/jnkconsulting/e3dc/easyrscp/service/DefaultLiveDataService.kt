package de.jnkconsulting.e3dc.easyrscp.service

import de.jnkconsulting.e3dc.easyrscp.api.connection.ConnectionPool
import de.jnkconsulting.e3dc.easyrscp.api.service.LiveDataService
import de.jnkconsulting.e3dc.easyrscp.api.service.model.PowerState
import de.jnkconsulting.e3dc.easyrscp.service.converter.FrameConverter
import de.jnkconsulting.e3dc.easyrscp.service.creator.FrameCreator
import de.jnkconsulting.e3dc.easyrscp.service.converter.PowerStateConverter
import de.jnkconsulting.e3dc.easyrscp.service.creator.RequestLiveDataCreator
import mu.KotlinLogging

/**
 * Implementation to query the live data of the home power plant
 *
 * @param connectionPool Connection pool to be used
 * @param convertFrameToPowerState Converter to create a [PowerState] object from a frame. By default, an instance of [PowerStateConverter] is used
 * @param createRequestLiveDataFrame Creator for frames to query the current power state. By default, an instance of [RequestLiveDataCreator] is used
 *
 * @since 2.0
 */
class DefaultLiveDataService(
    private val connectionPool: ConnectionPool,
    private val convertFrameToPowerState: FrameConverter<PowerState> = PowerStateConverter(),
    private val createRequestLiveDataFrame: FrameCreator<Nothing?> = RequestLiveDataCreator()
) : LiveDataService {

    private val logger = KotlinLogging.logger {}

    override fun readPowerState() =
        connectionPool.executeAndRelease {
            val request = createRequestLiveDataFrame(null)
            logger.trace { "Requesting current power state: $request" }
            val response = it.send(request)
            logger.trace { "Received current power state: $response" }
            convertFrameToPowerState(response)
        }

}
