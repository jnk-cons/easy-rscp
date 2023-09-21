package de.jnkconsulting.e3dc.easyrscp.service

import de.jnkconsulting.e3dc.easyrscp.api.connection.ConnectionPool
import de.jnkconsulting.e3dc.easyrscp.api.service.InfoService
import de.jnkconsulting.e3dc.easyrscp.api.service.model.SystemInfo
import de.jnkconsulting.e3dc.easyrscp.service.converter.FrameConverter
import de.jnkconsulting.e3dc.easyrscp.service.converter.SystemInfoConverter
import de.jnkconsulting.e3dc.easyrscp.service.creator.FrameCreator
import de.jnkconsulting.e3dc.easyrscp.service.creator.RequestSystemInfosCreator
import mu.KotlinLogging

/**
 * Default implementation of the InfoService
 *
 * @param connectionPool ConnectionPool to use
 * @param convertFrameToSystemInfo Converter to create a [SystemInfo] object from a frame. By default, an instance of [SystemInfoConverter] is used
 * @param createReadSystemInfoFrame Creator for frames to query some basic system informations about the home power plant. By default, an instance of [RequestSystemInfosCreator] is used
 *
 * @since 2.0
 */
class DefaultInfoService(
    private val connectionPool: ConnectionPool,
    private val convertFrameToSystemInfo: FrameConverter<SystemInfo> = SystemInfoConverter(),
    private val createReadSystemInfoFrame: FrameCreator<Nothing?> = RequestSystemInfosCreator()
): InfoService {

    private val logger = KotlinLogging.logger {  }


    override fun readSystemInfo() =
        connectionPool.executeAndRelease {
            val request = createReadSystemInfoFrame(null)
            logger.trace { "Requesting system informations: $request" }
            val response = it.send(request)
            logger.trace { "Received system informations: $response" }
            convertFrameToSystemInfo(response)
        }

}
