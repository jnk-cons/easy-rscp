package de.jnkconsulting.e3dc.easyrscp.api.service.model


/**
 * Displays the current energy flow of the wallbox
 *
 * @param id Id of the wallbox at the home power station
 * @param powerW Complete energy consumption in W
 * @param solarPowerW Share of solar energy in [powerW] (W)
 *
 * @since 2.3
 */
data class WallboxPowerState(
    val id: Int,
    val powerW: Int,
    val solarPowerW: Int,
)



