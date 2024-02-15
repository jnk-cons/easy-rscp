package de.jnkconsulting.e3dc.easyrscp.api.service.model


/**
 * Contains informations about a connected wallbox
 *
 * @param id Id of the wallbox at the home power station
 * @param name The display name of the wallbox in the home power station
 *
 * @since 2.3
 */
data class WallboxInfo(
    val id: Int,
    val name: String
)
