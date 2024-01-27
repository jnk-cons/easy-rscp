package de.jnkconsulting.e3dc.easyrscp.service

import de.jnkconsulting.e3dc.easyrscp.api.connection.ConnectionPool
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.BatTag
import de.jnkconsulting.e3dc.easyrscp.api.service.BatteryService
import de.jnkconsulting.e3dc.easyrscp.api.service.LiveDataService
import de.jnkconsulting.e3dc.easyrscp.api.service.model.*
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import de.jnkconsulting.e3dc.easyrscp.service.converter.FrameConverter
import de.jnkconsulting.e3dc.easyrscp.service.converter.PowerStateConverter
import de.jnkconsulting.e3dc.easyrscp.service.creator.BatteryInfoRequestCreator
import de.jnkconsulting.e3dc.easyrscp.service.creator.DCBInfoRequestCreator
import de.jnkconsulting.e3dc.easyrscp.service.creator.FrameCreator
import de.jnkconsulting.e3dc.easyrscp.service.creator.RequestLiveDataCreator
import mu.KotlinLogging

/**
 * Implementation to query battery information from the home power plant
 *
 * Fyi: The information is determined using a request sequence, so this service does not allow you to use your own converters
 *
 * @param connectionPool Connection pool to be used
 * @param batInfoRequestCreator Creator for requesting battery information
 * @param dcbInfoRequestCreator Creator for requesting information about a single battery module
 *
 * @since 2.1
 */
class DefaultBatteryService(
    private val connectionPool: ConnectionPool,
    private val batInfoRequestCreator: FrameCreator<Int> = BatteryInfoRequestCreator(),
    private val dcbInfoRequestCreator: FrameCreator<Pair<Int, Int>> = DCBInfoRequestCreator()
) : BatteryService {

    private val logger = KotlinLogging.logger {}
    override fun readSpecification(): List<BatterySpec> {
        return connectionPool.executeAndRelease {
            val result = mutableListOf<BatterySpec>()
            for (batIndex in 0..9) {
                val dcbSpecs = mutableListOf<DCBSpec>()
                val batInfoRequest = batInfoRequestCreator.invoke(batIndex)
                val batInfoResponse = it.send(batInfoRequest)
                if (batInfoResponse.isDataBlockInError(BatTag.DATA)) {
                    // no more batteries in the HPS
                    break
                }
                val dcbCount = batInfoResponse.byteByTag(BatTag.DCB_COUNT, BatTag.DATA)

                for (dcbIndex in 0..<dcbCount) {
                    val dcbInfoRequest = dcbInfoRequestCreator.invoke(batIndex to dcbIndex)
                    val dcbInfoResponse = it.send(dcbInfoRequest)
                    dcbSpecs.add(
                        DCBSpec(
                            index = dcbIndex,
                            capacityAh = dcbInfoResponse.floatByTag(BatTag.DCB_DESIGN_CAPACITY, BatTag.DATA, BatTag.DCB_INFO),
                            maxChargeCurrentA = dcbInfoResponse.floatByTag(BatTag.DCB_MAX_CHARGE_CURRENT, BatTag.DATA, BatTag.DCB_INFO),
                            maxDischargeCurrentA = dcbInfoResponse.floatByTag(BatTag.DCB_MAX_DISCHARGE_CURRENT, BatTag.DATA, BatTag.DCB_INFO),
                            fullChargeCapacityAh = dcbInfoResponse.floatByTag(BatTag.DCB_FULL_CHARGE_CAPACITY, BatTag.DATA, BatTag.DCB_INFO),
                            voltage = dcbInfoResponse.floatByTag(BatTag.DCB_DESIGN_VOLTAGE, BatTag.DATA, BatTag.DCB_INFO),
                            maxChargingTempCelsius = dcbInfoResponse.floatByTag(BatTag.DCB_CHARGE_HIGH_TEMPERATURE, BatTag.DATA, BatTag.DCB_INFO),
                            minChargingTempCelsius = dcbInfoResponse.floatByTag(BatTag.DCB_CHARGE_LOW_TEMPERATURE, BatTag.DATA, BatTag.DCB_INFO),
                            serialCells = dcbInfoResponse.intByTag(BatTag.DCB_NR_SERIES_CELL, BatTag.DATA, BatTag.DCB_INFO),
                            parallelCells = dcbInfoResponse.intByTag(BatTag.DCB_NR_PARALLEL_CELL, BatTag.DATA, BatTag.DCB_INFO),
                    ))
                }
                result.add(
                    BatterySpec(
                        index = batIndex.toShort(),
                        name = batInfoResponse.stringByTag(BatTag.DEVICE_NAME, BatTag.DATA),
                        maxChargingTempCelsius = batInfoResponse.intByTag(BatTag.CHARGE_HIGH_TEMP, BatTag.DATA),
                        minChargingTempCelsius = batInfoResponse.intByTag(BatTag.CHARGE_LOW_TEMP, BatTag.DATA),
                        voltage = batInfoResponse.floatByTag(BatTag.DESIGN_VOLTAGE, BatTag.DATA),
                        capacityAh = batInfoResponse.floatByTag(BatTag.DESIGN_CAPACITY, BatTag.DATA),
                        capacityWh = batInfoResponse.floatByTag(BatTag.SPECIFIED_CAPACITY, BatTag.DATA, BatTag.SPECIFICATION),
                        maxChargeCurrentA = batInfoResponse.floatByTag(BatTag.MAX_CHARGE_CURRENT, BatTag.DATA),
                        maxDischargeCurrentA = batInfoResponse.floatByTag(BatTag.MAX_DISCHARGE_CURRENT, BatTag.DATA),
                        dcbSpecs = dcbSpecs.toList(),
                ))
            }
            result
        }
    }

    override fun readMonitoringData(): List<BatteryStatus> {
        return connectionPool.executeAndRelease {
            val result = mutableListOf<BatteryStatus>()
            for (batIndex in 0..9) {
                val dcbStatus = mutableListOf<DCBStatus>()
                val batInfoRequest = batInfoRequestCreator.invoke(batIndex)
                val batInfoResponse = it.send(batInfoRequest)
                if (batInfoResponse.isDataBlockInError(BatTag.DATA)) {
                    // no more batteries in the HPS
                    break
                }
                val dcbCount = batInfoResponse.byteByTag(BatTag.DCB_COUNT, BatTag.DATA)

                for (dcbIndex in 0..<dcbCount) {
                    val dcbInfoRequest = dcbInfoRequestCreator.invoke(batIndex to dcbIndex)
                    val dcbInfoResponse = it.send(dcbInfoRequest)

                    dcbStatus.add(
                        DCBStatus(
                            index = dcbIndex,
                            voltage = dcbInfoResponse.floatByTag(BatTag.DCB_VOLTAGE, BatTag.DATA, BatTag.DCB_INFO),
                            voltageAVG30s = dcbInfoResponse.floatByTag(BatTag.DCB_VOLTAGE_AVG_30S, BatTag.DATA, BatTag.DCB_INFO),
                            currentA = dcbInfoResponse.floatByTag(BatTag.DCB_CURRENT, BatTag.DATA, BatTag.DCB_INFO),
                            currentAVG30s = dcbInfoResponse.floatByTag(BatTag.DCB_CURRENT_AVG_30S, BatTag.DATA, BatTag.DCB_INFO),
                            temperaturesCelsius = dcbInfoResponse
                                .containerByTag(BatTag.DATA, BatTag.DATA, BatTag.DCB_ALL_CELL_TEMPERATURES)
                                .map { data ->
                                    data.valueAsFloat()?: 0.0f
                                }
                        ))
                }
                val trainingModeRAW = batInfoResponse.byteByTag(BatTag.TRAINING_MODE, BatTag.DATA)
                val trainingMode = when(trainingModeRAW) {
                    0.toByte() -> TrainingMode.NOT_IN_TRAINING
                    1.toByte() -> TrainingMode.TRAINING_DISCHARGE
                    2.toByte() -> TrainingMode.TRAINING_CHARGE
                    else -> TrainingMode.UNKNOWN
                }
                result.add(
                    BatteryStatus(
                        index = batIndex.toShort(),
                        trainingModeActive = trainingMode != TrainingMode.NOT_IN_TRAINING,
                        connected = batInfoResponse.booleanByTag(BatTag.DEVICE_CONNECTED, BatTag.DATA, BatTag.DEVICE_STATE),
                        working = batInfoResponse.booleanByTag(BatTag.DEVICE_WORKING, BatTag.DATA, BatTag.DEVICE_STATE),
                        inService = batInfoResponse.booleanByTag(BatTag.DEVICE_IN_SERVICE, BatTag.DATA, BatTag.DEVICE_STATE),
                        asoc = batInfoResponse.floatByTag(BatTag.ASOC, BatTag.DATA) / 100.0f,
                        realRsoc = batInfoResponse.floatByTag(BatTag.RSOC_REAL, BatTag.DATA) / 100.0f,
                        voltage = batInfoResponse.floatByTag(BatTag.MODULE_VOLTAGE, BatTag.DATA),
                        dcbStatus = dcbStatus,
                        trainingMode = trainingMode
                    ))
            }
            result
        }
    }

}
