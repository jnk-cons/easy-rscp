package de.jnkconsulting.e3dc.easyrscp.api.service

import de.jnkconsulting.e3dc.easyrscp.api.service.model.SystemInfo

/**
 * Service that provides basic system informations about the home power plant
 *
 * @since 2.0
 */
interface InfoService {

    /**
     * Reads the base system information from the home power plant
     *
     * @return Provides the basic system information
     *
     * @since 2.0
     */
    fun readSystemInfo(): SystemInfo
}
