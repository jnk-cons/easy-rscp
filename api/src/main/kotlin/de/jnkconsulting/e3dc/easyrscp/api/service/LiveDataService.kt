package de.jnkconsulting.e3dc.easyrscp.api.service

import de.jnkconsulting.e3dc.easyrscp.api.service.model.PowerState

/**
 * Service that provides live data from RSCP interface
 *
 * @since 2.0
 */
interface LiveDataService {

    /**
     * Reads and returns the current live data of the home power plant energy system.
     *
     * @return Current measured values of the energy system
     *
     * @since 2.0
     */
    fun readPowerState(): PowerState
}
