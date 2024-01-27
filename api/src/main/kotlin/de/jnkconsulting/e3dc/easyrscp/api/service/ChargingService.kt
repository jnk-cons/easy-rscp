package de.jnkconsulting.e3dc.easyrscp.api.service

import de.jnkconsulting.e3dc.easyrscp.api.service.model.ChargingConfiguration
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ChargingLimits
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ManualChargeState
import de.jnkconsulting.e3dc.easyrscp.api.service.model.WriteChargingLimitsResult

/**
 * Service to read and influence the charging behavior of the home power plant
 *
 * @since 2.0
 */
interface ChargingService {

    /**
     * Reads the current configuration.
     *
     * The configuration contains both specification values and configured limits
     *
     * @return Current configuration
     *
     * @since 2.0
     */
    fun readConfiguration(): ChargingConfiguration

    /**
     * Writes the load limits to the home power plant
     *
     * @param limits Limits to be activated
     *
     * @return ResultCodes from home power plant
     *
     * @since 2.0
     */
    fun writeLimits(limits: ChargingLimits): WriteChargingLimitsResult

    /**
     * Reads out the status of manual battery charging
     *
     * @return Status of manual battery charging
     *
     * @since 2.2
     */
    fun readManualChargeState(): ManualChargeState

    /**
     * Starts a manual charging process for the battery. Attention: If there is not enough excess production, the battery is charged with mains power.
     *
     * Most home power stations only allow one manual charge per day. easy-rscp has no influence on this.
     *
     * The status of the charging process can be monitored using the [readManualChargeState] function.
     *
     * @param amountWh Amount of energy to be charged in Wh
     *
     * @return true if the start of the loading process was successful. Otherwise false
     *
     * @since 2.2
     *
     */
    fun startManualCharge(amountWh: Int): Boolean

    /**
     * Stops a manual charging process.
     *
     * @return true if stopping the charging process was successful or no charging process is currently taking place. Otherwise false
     *
     * @since 2.2
     */
    fun stopManualCharge(): Boolean
}
