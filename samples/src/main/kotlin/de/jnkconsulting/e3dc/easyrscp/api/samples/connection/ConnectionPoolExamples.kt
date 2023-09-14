package de.jnkconsulting.e3dc.easyrscp.api.samples.connection

import de.jnkconsulting.e3dc.easyrscp.api.connection.ConnectionPool
import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame

/**
 * A simple example to send a frame to the E3DC home power plant with the connection pool and return the result frame.
 */
fun sendAndReleaseHandling(pool: ConnectionPool, toSend: Frame): Frame {
    val connection = pool.getConnection()
    try {
        return connection.send(toSend)
    } finally {
        pool.releaseConnection(connection)
    }
}

/**
 * Identical result to [sendAndReleaseHandling], but using the [ConnectionPool.executeAndRelease] function.
 */
fun sendAndReleaseUsingExecuteAndRelease(pool: ConnectionPool, toSend: Frame) =
    pool.executeAndRelease { it.send(toSend) }
