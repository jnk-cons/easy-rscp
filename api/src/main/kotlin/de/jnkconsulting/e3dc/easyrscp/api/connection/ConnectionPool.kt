package de.jnkconsulting.e3dc.easyrscp.api.connection

/**
 * Connection Pool that maintains connections to the E3DC home power plant.
 *
 * Each implementation ensures that you always get an already authenticated connection.
 *
 * @sample de.jnkconsulting.e3dc.easyrscp.api.samples.connection.sendAndReleaseUsingExecuteAndRelease
 *
 * @since 2.0
 */
interface ConnectionPool {
    /**
     * Provides an already authenticated connection to the E3DC home power plant.
     *
     * @sample de.jnkconsulting.e3dc.easyrscp.api.samples.connection.sendAndReleaseHandling
     *
     * @return Authenticated connection to the home power plant
     * @since 2.0
     */
    fun getConnection(): HomePowerPlantConnection

    /**
     * Releases the connection [toRelease] to the E3DC home power plant.
     *
     * It is up to the implementation whether the connection is closed directly or pooled for later use.
     *
     * @sample de.jnkconsulting.e3dc.easyrscp.api.samples.connection.sendAndReleaseHandling
     *
     * @param toRelease Connection to be released
     * @since 2.0
     */
    fun releaseConnection(toRelease: HomePowerPlantConnection)

    /**
     * Executes the passed function and returns a connection to the E3DC home power plant for use with pure
     * @see [getConnection]. The connection is released after the code is executed @see [releaseConnection].
     *
     * @sample de.jnkconsulting.e3dc.easyrscp.api.samples.connection.sendAndReleaseUsingExecuteAndRelease
     *
     * @param receiver Function to be executed
     * @return Return value of the passed function
     * @since 2.0
     */
    fun <R> executeAndRelease(receiver: (connection: HomePowerPlantConnection) -> R): R

    /**
     * Closes all connections in the pool
     * @since 2.0
     */
    fun shutdown()
}
