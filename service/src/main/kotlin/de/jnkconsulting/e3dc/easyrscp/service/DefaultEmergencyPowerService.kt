package de.jnkconsulting.e3dc.easyrscp.service

import de.jnkconsulting.e3dc.easyrscp.api.connection.ConnectionPool
import de.jnkconsulting.e3dc.easyrscp.api.connection.HomePowerPlantConnection
import de.jnkconsulting.e3dc.easyrscp.api.service.EmergencyPowerService
import de.jnkconsulting.e3dc.easyrscp.api.service.model.BatteryUnit
import de.jnkconsulting.e3dc.easyrscp.api.service.model.EmergencyPowerState
import de.jnkconsulting.e3dc.easyrscp.api.service.model.Percentage
import de.jnkconsulting.e3dc.easyrscp.service.converter.EmergencyPowerStateConverter
import de.jnkconsulting.e3dc.easyrscp.service.converter.FrameConverter
import de.jnkconsulting.e3dc.easyrscp.service.creator.FrameCreator
import de.jnkconsulting.e3dc.easyrscp.service.creator.PowerReserveInput
import de.jnkconsulting.e3dc.easyrscp.service.creator.ReadEmergencyPowerStateCreator
import de.jnkconsulting.e3dc.easyrscp.service.creator.SetEmergencyPowerReserveCreator
import mu.KotlinLogging

/**
 * Default implementation of the EmergencyPowerService
 *
 * @param connectionPool ConnectionPool to use
 * @param convertFrameToEmergencyPowerState Converter to create a [EmergencyPowerState] object from a frame. By default, an instance of [EmergencyPowerStateConverter] is used
 * @param createReadStateFrame Creator for frames to query the emergency power state of the home power plant. By default, an instance of [ReadEmergencyPowerStateCreator] is used
 * @param createSetEmergencyPowerReserveFrame Creator for frames to setting emergency power reserve of the home power plant. By default, an instance of [SetEmergencyPowerReserveCreator] is used
 *
 * @since 2.2
 */
class DefaultEmergencyPowerService(
    private val connectionPool: ConnectionPool,
    private val convertFrameToEmergencyPowerState: FrameConverter<EmergencyPowerState> = EmergencyPowerStateConverter(),
    private val createReadStateFrame: FrameCreator<Nothing?> = ReadEmergencyPowerStateCreator(),
    private val createSetEmergencyPowerReserveFrame: FrameCreator<PowerReserveInput> = SetEmergencyPowerReserveCreator()
): EmergencyPowerService {

    private val logger = KotlinLogging.logger {  }

    override fun removeReserve() =
        setEmergencyPowerReserve(0.0f, BatteryUnit.PERCENTAGE)

    override fun setReserveWH(reserve: Float) =
        setEmergencyPowerReserve(reserve, BatteryUnit.WATT_HOURS)

    override fun setReservePercentage(reserve: Percentage) =
        setEmergencyPowerReserve(reserve, BatteryUnit.PERCENTAGE)

    override fun readState() =
        connectionPool.executeAndRelease {
            readEPState(it)
        }

    private fun setEmergencyPowerReserve(value: Float, unit: BatteryUnit) =
        connectionPool.executeAndRelease {
            val request = createSetEmergencyPowerReserveFrame(PowerReserveInput(value, unit))
            logger.trace { "Setting emergency power reserve: $request" }
            val response = it.send(request)
            logger.trace { "Setting emergency power reserve response: $response" }
            readEPState(it)
        }

    private fun readEPState(it: HomePowerPlantConnection): EmergencyPowerState {
        val request = createReadStateFrame(null)
        logger.trace { "Requesting emergency power state: $request" }
        val response = it.send(request)
        logger.trace { "Received emergency power state: $response" }
        return convertFrameToEmergencyPowerState(response)
    }
}
