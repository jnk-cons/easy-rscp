package de.jnkconsulting.e3dc.easyrscp.connection

import de.jnkconsulting.e3dc.easyrscp.api.connection.ConnectionPool
import de.jnkconsulting.e3dc.easyrscp.api.connection.HomePowerPlantConnection
import de.jnkconsulting.e3dc.easyrscp.api.connection.HomePowerPlantConnectionFactory
import mu.KotlinLogging
import java.io.IOException
import java.util.concurrent.TimeoutException

/**
 * [ConnectionPool] which uses exactly one connection to the home power plant.
 *
 * The one connection is kept ThreadSave and it is ensured that only one connection, which is not currently in use by another thread is used.
 *
 * @param connector Factory to be used to connect to the home power plant
 * @param timeoutMillis Timeout in milliseconds. A call to [getConnection] waits at most this time for a free connection before throwing a [TimeoutException].
 *
 * @since 2.0
 */
class SingleInstanceConnectionPool(
    private val connector: HomePowerPlantConnectionFactory,
    private val timeoutMillis: Long = 10000): ConnectionPool {

    private val logger = KotlinLogging.logger {}

    private val lock = Any()
    private var connection: HomePowerPlantConnection? = null
    private var free = true

    override fun getConnection(): HomePowerPlantConnection {
        synchronized(lock) {
            if (free) {
                return ensureConnectionIsOpen()
            }
        }
        Thread.sleep(timeoutMillis)
        synchronized(lock) {
            if (free) {
                return ensureConnectionIsOpen()
            }
        }
        throw TimeoutException("Could not get a connection within the configured timeout of $timeoutMillis ms")
    }

    override fun releaseConnection(toRelease: HomePowerPlantConnection) {
        synchronized(lock) {
            free = true
        }
    }

    override fun <R> executeAndRelease(receiver: (connection: HomePowerPlantConnection) -> R): R {
        return getConnection().let {
            try {
                receiver(it)
            } catch (e : IOException) {
                shutdown()
                logger.error(e) { "Communication error against e3dc system. Shutting down connection to reestablish connection on next call" }
                throw IOException(e.message, e)
            }
            finally {
                releaseConnection(it)
            }
        }
    }

    override fun shutdown() {
        synchronized(lock) {
            try {
                connection?.disconnect()
            } catch (e : IOException) {
                logger.error(e) { "Error closing connection" }
            }
            connection = null
        }
    }

    private fun ensureConnectionIsOpen() =
        synchronized(lock) {
            connection
                .let {
                    when(it != null && it.isConnected()) {
                        true -> it
                            .also { logger.trace { "Returning already opened connection" } }
                            .also { free = false }
                        false -> connector
                            .also { logger.trace { "Opening new connection" } }
                            .openConnection()
                            .also { connection = it; free = false }
                    }
                }
        }

}
