package de.jnkconsulting.e3dc.easyrscp.service

import de.jnkconsulting.e3dc.easyrscp.api.connection.ConnectionPool
import de.jnkconsulting.e3dc.easyrscp.api.service.ChargingService
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ChargingConfiguration
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ChargingLimits
import de.jnkconsulting.e3dc.easyrscp.api.service.model.WriteChargingLimitsResult
import de.jnkconsulting.e3dc.easyrscp.service.converter.FrameConverter
import de.jnkconsulting.e3dc.easyrscp.service.creator.FrameCreator
import de.jnkconsulting.e3dc.easyrscp.service.converter.ChargingConfigurationConverter
import de.jnkconsulting.e3dc.easyrscp.service.converter.WriteChargingLimitsResultConverter
import de.jnkconsulting.e3dc.easyrscp.service.creator.RequestChargingConfigurationCreator
import de.jnkconsulting.e3dc.easyrscp.service.creator.SetPowerSettingsCreator
import mu.KotlinLogging

/**
 * Service implementation to read and control the charging behavior of the home power plant.
 *
 * @param connectionPool ConnectionPool to use
 * @param convertFrameToChargingConfiguration Converter to create a [ChargingConfiguration] object from a frame. By default, an instance of [ChargingConfigurationConverter] is used
 * @param convertFrameToWriteChargingLimitsResult Converter to create a [WriteChargingLimitsResult] object from a frame. By default, an instance of [WriteChargingLimitsResultConverter] is used
 * @param createRequestChargingConfigurationFrame Creator for frames to query the configuration of the charging system from the home power plant. By default, an instance of [RequestChargingConfigurationCreator] is used
 * @param createSetPowerSettingsFrame Creator for frames to query the configuration of the charging system from the home power plant. By default, an instance of [SetPowerSettingsCreator] is used
 *
 * @since 2.0
 */
class DefaultChargingService(
    private val connectionPool: ConnectionPool,
    private val convertFrameToChargingConfiguration: FrameConverter<ChargingConfiguration> = ChargingConfigurationConverter(),
    private val convertFrameToWriteChargingLimitsResult: FrameConverter<WriteChargingLimitsResult> = WriteChargingLimitsResultConverter(),
    private val createRequestChargingConfigurationFrame: FrameCreator<Nothing?> = RequestChargingConfigurationCreator(),
    private val createSetPowerSettingsFrame: FrameCreator<ChargingLimits> = SetPowerSettingsCreator()
): ChargingService {

    private val logger = KotlinLogging.logger {  }

    override fun readConfiguration() =
        connectionPool.executeAndRelease {
            val request = createRequestChargingConfigurationFrame(null)
            logger.trace { "Requesting charging configuration: $request" }
            val response = it.send(request)
            logger.trace { "Received charging configuration: $response" }
            convertFrameToChargingConfiguration(response)
        }

    override fun writeLimits(limits: ChargingLimits) =
        connectionPool.executeAndRelease {
            val writeRequest = createSetPowerSettingsFrame(limits)
            logger.trace { "Writing charging limits: $writeRequest" }
            val writeResponse = it.send(writeRequest)
            logger.trace { "Received write charging limits response: $writeResponse" }
            convertFrameToWriteChargingLimitsResult(writeResponse)
        }

}
