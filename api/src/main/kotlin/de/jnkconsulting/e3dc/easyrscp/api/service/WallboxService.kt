package de.jnkconsulting.e3dc.easyrscp.api.service

import de.jnkconsulting.e3dc.easyrscp.api.service.model.WallboxInfo
import de.jnkconsulting.e3dc.easyrscp.api.service.model.WallboxPowerState

/**
 * Service to manage the connected wallboxes
 *
 * @since 2.3
 */
interface WallboxService {

    /**
     * Reads out the connected wallboxes
     *
     * @return Information about the connected wallboxes
     *
     * @since 2.3
     */
    fun readConnectedWallboxes(): List<WallboxInfo>

    /**
     * List the live consumption data of the Wallbozen.
     *
     * @param ids IDs of the wallboxes that are to be queried
     *
     * @return Query result with the live data of the Wallbozen
     *
     * @throws IllegalArgumentException If [ids] is empty
     *
     * @since 2.3
     */
    fun readPowerState(vararg ids: Int): List<WallboxPowerState>
}
