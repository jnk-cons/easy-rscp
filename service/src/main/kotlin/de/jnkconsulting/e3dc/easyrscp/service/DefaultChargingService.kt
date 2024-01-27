package de.jnkconsulting.e3dc.easyrscp.service

import de.jnkconsulting.e3dc.easyrscp.api.connection.ConnectionPool
import de.jnkconsulting.e3dc.easyrscp.api.connection.HomePowerPlantConnection
import de.jnkconsulting.e3dc.easyrscp.api.service.ChargingService
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ChargingConfiguration
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ChargingLimits
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ManualChargeState
import de.jnkconsulting.e3dc.easyrscp.api.service.model.WriteChargingLimitsResult
import de.jnkconsulting.e3dc.easyrscp.service.converter.*
import de.jnkconsulting.e3dc.easyrscp.service.creator.*
import mu.KotlinLogging

/**
 * Service implementation to read and control the charging behavior of the home power plant.
 *
 * @param connectionPool ConnectionPool to use
 * @param convertFrameToChargingConfiguration Converter to create a [ChargingConfiguration] object from a frame. By default, an instance of [ChargingConfigurationConverter] is used
 * @param convertFrameToWriteChargingLimitsResult Converter to create a [WriteChargingLimitsResult] object from a frame. By default, an instance of [WriteChargingLimitsResultConverter] is used
 * @param createRequestChargingConfigurationFrame Creator for frames to query the configuration of the charging system from the home power plant. By default, an instance of [RequestChargingConfigurationCreator] is used
 * @param createSetPowerSettingsFrame Creator for frames to query the configuration of the charging system from the home power plant. By default, an instance of [SetPowerSettingsCreator] is used
 * @param convertFrameToManualChargeState Converter to create a [ManualChargeState] object from a frame. Bu default, an instance of [ManualChargeStateConverter] is used
 * @param createRequestManualChargeState Creator for frames to query the manual charge statefrom the home power station. By default, an instance of [RequestManualChargeStateCreator] is used
 * @param convertFrameToStartManualChargeResponseState Converter to create a boolean result from an answer frame of a request manualm charge start request. Bu default, an instance of [StartManualChargeResponseConverter] is used
 * @param createRequestStartManualCharge Creator for frames to request the start of a manual battery charge. By default, an instance of [RequestStartManualChargeCreator] is used
 *
 * @since 2.0
 * @since 2.2
 * - new function [readManualChargeState]
 * - new function [startManualCharge]
 */
class DefaultChargingService(
    private val connectionPool: ConnectionPool,
    private val convertFrameToChargingConfiguration: FrameConverter<ChargingConfiguration> = ChargingConfigurationConverter(),
    private val convertFrameToWriteChargingLimitsResult: FrameConverter<WriteChargingLimitsResult> = WriteChargingLimitsResultConverter(),
    private val createRequestChargingConfigurationFrame: FrameCreator<Nothing?> = RequestChargingConfigurationCreator(),
    private val createSetPowerSettingsFrame: FrameCreator<ChargingLimits> = SetPowerSettingsCreator(),
    private val convertFrameToManualChargeState: FrameConverter<ManualChargeState> = ManualChargeStateConverter(),
    private val createRequestManualChargeState: FrameCreator<Nothing?> = RequestManualChargeStateCreator(),
    private val convertFrameToStartManualChargeResponseState: FrameConverter<Boolean> = StartManualChargeResponseConverter(),
    private val createRequestStartManualCharge: FrameCreator<Int> = RequestStartManualChargeCreator()
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

    override fun readManualChargeState() =
        connectionPool.executeAndRelease {
            executeReadManualChargeState(it)
        }

    override fun startManualCharge(amountWh: Int) =
        connectionPool.executeAndRelease {
            executeManualCharge(it, amountWh)
        }

    override fun stopManualCharge(): Boolean =
        connectionPool.executeAndRelease {
            val state = executeReadManualChargeState(it)
            if (state.active) {
                executeManualCharge(it, 0)
            }
            else {
                true
            }
        }

    private fun executeReadManualChargeState(connection: HomePowerPlantConnection): ManualChargeState {
        val request = createRequestManualChargeState(null)
        logger.trace { "Requesting manual charge state: $request" }
        val response = connection.send(request)
        logger.trace { "Received response for manual charge state: $response" }
        return convertFrameToManualChargeState(response)
    }

    private fun executeManualCharge(connection: HomePowerPlantConnection, amountWh: Int): Boolean {
        val request = createRequestStartManualCharge(amountWh)
        logger.trace { "Requesting start of manual charge: $request" }
        val response = connection.send(request)
        logger.trace { "Received response for start manual charge state: $response" }
        return convertFrameToStartManualChargeResponseState(response)
    }

}
