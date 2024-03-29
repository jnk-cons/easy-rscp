package de.jnkconsulting.e3dc.easyrscp.api.service.model

/**
 * Contains the specification data of the battery
 *
 * @param index ID of the battery in the E3DC system
 * @param name Name of the battery stored in the E3DC system
 * @param maxChargingTempCelsius Maximum possible charging temperature in Celsius. fyi: I don't know why the temperature is an Int value for the battery and a float for the DCB module ... BUT, it is like this in the protocol
 * @param minChargingTempCelsius Maximum possible discharging temperature in Celsius. fyi: I don't know why the temperature is an Int value for the battery and a float for the DCB module ... BUT, it is like this in the protocol
 * @param voltage Voltage for which the battery was specified in volts
 * @param capacityAh Capacity in Ah. Supplied by the system and NOT calculated. May therefore deviate slightly from the theoretically calculated value
 * @param capacityWh Kapazität in Wh. Supplied by the system and NOT calculated. May therefore deviate slightly from the theoretically calculated value
 * @param maxChargeCurrentA Maximum charging current in A
 * @param maxDischargeCurrentA Maximum discharging current in A
 * @param dcbSpecs List of specifications for the individual modules
 *
 * @since 2.1
 */
data class BatterySpec(
    val index: Short,
    val name: String,
    val maxChargingTempCelsius: Int,
    val minChargingTempCelsius: Int,
    val voltage: Float,
    val capacityAh: Float,
    val capacityWh: Percentage,
    val maxChargeCurrentA: Float,
    val maxDischargeCurrentA: Float,
    val dcbSpecs: List<DCBSpec>
)

/**
 * Contains the specification of a battery module
 *
 * @param index ID of the module in the battery
 * @param capacityAh Capacity of the module in Ah. Supplied by the system and NOT calculated. May therefore deviate slightly from the theoretically calculated value
 * @param maxChargeCurrentA Maximum charging current in A
 * @param maxDischargeCurrentA Maximum discharging current in A
 * @param fullChargeCapacityAh Capacity of the module in Ah, from when the system displays 100% charge status
 * @param voltage Voltage for which the module was specified in volts
 * @param maxChargingTempCelsius Maximum possible charging temperature in Celsius. . fyi: I don't know why the temperature is an Int value for the battery and a float for the DCB module ... BUT, it is like this in the protocol
 * @param minChargingTempCelsius Maximum possible discharging temperature in Celsius. . fyi: I don't know why the temperature is an Int value for the battery and a float for the DCB module ... BUT, it is like this in the protocol
 * @param serialCells Series-connected cells of the module
 * @param parallelCells Cells of the module connected in parallel
 *
 * @since 2.1
 */
data class DCBSpec(
    val index: Int,
    val capacityAh: Float,
    val maxChargeCurrentA: Float,
    val maxDischargeCurrentA: Float,
    val fullChargeCapacityAh: Float,
    val voltage: Float,
    val maxChargingTempCelsius: Float,
    val minChargingTempCelsius: Float,
    val serialCells: Int,
    val parallelCells: Int,
)

/**
 * Contains information on the current status of the battery
 *
 * @param index ID of the battery in the E3DC system
 * @param trainingModeActive Information on whether the battery is in training mode. Deprecated in 2.2. Use [trainingMode] instead
 * @param connected Information on whether the battery is connected to the system (battery disconnect switch on the home power station)
 * @param working Information on whether the battery is working correctly
 * @param inService Information on whether the battery is in maintenance mode
 * @param asoc Actual soc of the battery between 0 and 1.0
 * @param realRsoc Current charge level as a percentage of the battery without taking into account the reserve for absolute deep discharge and theoretically possible full charge. The value should therefore never reach completely 0 and never completely 1
 * @param voltage Current battery voltage
 * @param dcbStatus Status of the individual battery modules
 * @param trainingMode Current status of the training mode
 *
 * @since 2.1
 * @since 2.2
 * - new property [trainingMode]
 * - deprecated property [trainingModeActive] -> Will be removed in 2.4
 */
data class BatteryStatus(
    val index: Short,
    @Deprecated("Use trainingMode Parameter instead. Will be removed in version 2.4")
    val trainingModeActive: Boolean,
    val connected: Boolean,
    val working: Boolean,
    val inService: Boolean,
    val asoc: Float,
    val realRsoc: Float,
    val voltage: Float,
    val dcbStatus: List<DCBStatus>,
    val trainingMode: TrainingMode
)

/**
 * Contains current status information on a battery module
 *
 * @param index ID of the module in the battery
 * @param voltage Current voltage
 * @param voltageAVG30s Average voltage of the last 30 seconds
 * @param currentA Current amperage in A
 * @param currentAVG30s Average current in the last 30 seconds
 * @param temperaturesCelsius Current temperature values of the respective sensors in Celsius
 *
 * @since 2.1
 */
data class DCBStatus(
    val index: Int,
    val voltage: Float,
    val voltageAVG30s: Float,
    val currentA: Float,
    val currentAVG30s: Float,
    val temperaturesCelsius: List<Float>
)

/**
 * Contains the status value of the battery training
 *
 * @since 2.2
 */
enum class TrainingMode {
    NOT_IN_TRAINING,
    TRAINING_DISCHARGE,
    TRAINING_CHARGE,
    UNKNOWN
}
