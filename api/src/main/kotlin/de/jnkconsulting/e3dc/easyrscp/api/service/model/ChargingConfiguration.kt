package de.jnkconsulting.e3dc.easyrscp.api.service.model

/**
 * Charging configuration of the home power plant
 *
 * @param maxPossibleChargingPower Maximum possible charging power in watts
 * @param maxPossibleDischargingPower Maximum possible discharge power in watts
 * @param minPossibleChargingPower Minimum possible charging power in watts
 * @param minPossibleDischargingPower Minimum possible discharge power in watts
 * @param defaultStartChargingThreshold Default settings of the system, from when the battery is charged in watts
 *
 * @since 2.0
 */
data class ChargingConfiguration(
    val maxPossibleChargingPower: Int,
    val maxPossibleDischargingPower: Int,
    val minPossibleChargingPower: Int,
    val minPossibleDischargingPower: Int,
    val defaultStartChargingThreshold: Int,
    val currentLimitations: ChargingLimits
)

/**
 * Charge limit settings on the home power plant
 *
 * @param maxCurrentChargingPower Maximum charging power in watts
 * @param maxCurrentDischargingPower Maximum discharge power in watts
 * @param dischargeStartPower Limit above which current is drawn from the battery in watts
 * @param chargingLimitationsEnabled If true, the configuration is active, otherwise false
 *
 * @since 2.0
 */
data class ChargingLimits(
    val maxCurrentChargingPower: Int,
    val maxCurrentDischargingPower: Int,
    val dischargeStartPower: Int,
    val chargingLimitationsEnabled: Boolean
)

/**
 * ResultCodes for writing [ChargingLimits].
 *
 * @since 2.0
 */
data class WriteChargingLimitsResult(
    val maxCurrentChargingPower: ResultCode,
    val maxCurrentDischargingPower: ResultCode,
    val dischargeStartPower: ResultCode,
    val chargingLimitationsEnabled: ResultCode
)
