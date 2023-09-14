package de.jnkconsulting.e3dc.easyrscp.api.connection

/**
 * Factory, um Verbindungen zu einem Hauskraftwerk herzustellen
 *
 * @since 2.0
 */
interface HomePowerPlantConnectionFactory {

    /**
     * Opens a connection to a home power plant. The connection that is supplied is already connected and authenticated.
     *
     * @return Open and authenticated connection to the home power plant
     *
     * @since 2.0
     */
    fun openConnection(): HomePowerPlantConnection
}
