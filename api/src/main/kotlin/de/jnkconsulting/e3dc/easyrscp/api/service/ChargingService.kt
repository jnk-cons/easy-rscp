package de.jnkconsulting.e3dc.easyrscp.api.service

import de.jnkconsulting.e3dc.easyrscp.api.service.model.ChargingConfiguration
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ChargingLimits
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
}
