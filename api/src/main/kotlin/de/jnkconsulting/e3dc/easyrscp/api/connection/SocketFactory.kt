package de.jnkconsulting.e3dc.easyrscp.api.connection

import java.net.Socket

/**
 * Factory to establish a socket connection to a home power plant
 *
 * @since 2.0
 */
interface SocketFactory {

    /**
     * Creates a new socket connection to the home power plant specified in [connectionData].
     *
     * @param connectionData Connection data of the home power plant
     * @return Socket connection to the home power plant
     *
     * @since 2.0
     */
    fun createSocket(connectionData: E3DCConnectionData): Socket
}
