 package de.jnkconsulting.e3dc.easyrscp.api.service.model


/**
 * Displays the current status of the emergency power function of the home power station
 *
 * @param reserveWh Currently set emergency power reserve in watt hours
 * @param reservePercentage Currently set emergency power reserve as a percentage of battery capacity
 * @param connectedToGrid true, if the home power station is connected to the power grid
 * @param readyForSwitch true when the home power station is ready to switch to emergency power mode
 * @param emergencyPowerPossible true, if the emergency drum function is available
 * @param island true when the home power station is in stand-alone mode
 * @param invalidState true if the emergency power function is not available
 *
 * @since 2.2
 */
data class EmergencyPowerState(
    val reserveWh: Float,
    val reservePercentage: Percentage,
    val connectedToGrid: Boolean,
    val readyForSwitch: Boolean,
    val emergencyPowerPossible: Boolean,
    val island: Boolean,
    val invalidState: Boolean
)
