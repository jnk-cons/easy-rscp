package de.jnkconsulting.e3dc.easyrscp.api.connection

import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import java.io.Closeable


/**
 * Connection to the home power plant. Provides the ability to send and receive frames.
 *
 * @since 2.0
 */
interface HomePowerPlantConnection : Closeable {

    /**
     * Establishes the connection to the home power plant. If a connection already exists, this is a no-op.
     *
     * @since 2.0
     */
    fun connect()

    /**
     * Closes the connection to the home power plant. If there is no connection, this is a no-op.
     * [close] calls [disconnect].
     *
     * @since 2.0
     */
    fun disconnect()

    /**
     * Checks if there is a connection
     *
     * @return true, if the connection exists, otherwise false
     *
     * @since 2.0
     */
    fun isConnected(): Boolean

    /**
     * Sends a [frame] to the home power plant and returns the response
     *
     * @since 2.0
     */
    fun send(frame: Frame): Frame
}
