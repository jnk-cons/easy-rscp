package de.jnkconsulting.e3dc.easyrscp.api.service

import de.jnkconsulting.e3dc.easyrscp.api.service.model.BatterySpec
import de.jnkconsulting.e3dc.easyrscp.api.service.model.BatteryStatus
import de.jnkconsulting.e3dc.easyrscp.api.service.model.PowerState

/**
 * Service to query the battery specification and status data
 *
 * @since 2.1
 */
interface BatteryService {

    /**
     * Liest die Batteriespezifikation aus dem E3DC Hauskraftwerk
     *
     * @return Specification of the battery. As a rule, the list contains only one element. Theoretically, however, a home power station can have several batteries
     *
     * @since 2.1
     */
    fun readSpecification(): List<BatterySpec>

    /**
     * Reads the current status data of the battery
     *
     * @return Current monitoring data. As a rule, the list contains only one element. Theoretically, however, a home power station can have several batteries
     *
     * @since 2.1
     */
    fun readMonitoringData(): List<BatteryStatus>
}
