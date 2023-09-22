package de.jnkconsulting.e3dc.easyrscp.connection

import de.jnkconsulting.e3dc.easyrscp.api.connection.E3DCConnectionData
import de.jnkconsulting.e3dc.easyrscp.api.connection.SocketFactory
import java.net.Socket

/**
 * Simple implementation of the [SocketFactory].
 *
 * Sockets are configured with tcpNoDelay = false (See [Socket.getTcpNoDelay]) and soTimeout (See [Socket.getSoTimeout]) from the [E3DCConnectionData] object.
 *
 * @since 2.0
 */
class DefaultSocketFactory: SocketFactory {
    override fun createSocket(connectionData: E3DCConnectionData): Socket =
        Socket(connectionData.address, connectionData.port).apply {
            tcpNoDelay = true
            soTimeout = connectionData.timeoutMillis.toInt()
        }
}
