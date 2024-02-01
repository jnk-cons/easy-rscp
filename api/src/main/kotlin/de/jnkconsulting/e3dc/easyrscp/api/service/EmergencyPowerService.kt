package de.jnkconsulting.e3dc.easyrscp.api.service

import de.jnkconsulting.e3dc.easyrscp.api.service.model.EmergencyPowerState
import de.jnkconsulting.e3dc.easyrscp.api.service.model.Percentage

/**
 * Service to control the emergency power system
 *
 * @since 2.2
 */
interface EmergencyPowerService {

    /**
     * Removes the emergency power reserve. The battery capacity is then fully available for the domestic supply
     *
     * @return Status after removal
     *
     * @since 2.2
     */
    fun removeReserve(): EmergencyPowerState

    /**
     * Sets the emergency power reserve to the specified value. The value is interpreted as watt hours
     *
     * @param reserve Emergency power reserve in watt hours. If 0.0f is set, the call to the function corresponds to [removeReserve]
     *
     * @return Status after set
     *
     * @since 2.2
     */
    fun setReserveWH(reserve: Float): EmergencyPowerState

    /**
     * Sets the emergency power reserve to the specified value. The value is interpreted as a percentage of the maximum battery capacity
     *
     * @param reserve Emergency power reserve in percentage. Min 0.0, Max 1.0. If 0.0f is set, the call to the function corresponds to [removeReserve]
     *
     * @return Status after set
     *
     * @since 2.2
     */
    fun setReservePercentage(reserve: Percentage): EmergencyPowerState

    /**
     * Reads out the current status of the emergency drum function of the home power station
     *
     * @return Status of the emergency power function
     *
     * @since 2.2
     */
    fun readState(): EmergencyPowerState
}


