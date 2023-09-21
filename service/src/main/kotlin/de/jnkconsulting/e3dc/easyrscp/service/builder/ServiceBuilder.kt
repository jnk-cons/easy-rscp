package de.jnkconsulting.e3dc.easyrscp.service.builder

import de.jnkconsulting.e3dc.easyrscp.connection.ConnectionBuilder

/**
 * Definition of a Service Builder
 *
 * @param S Type of the generated service
 *
 * @since 2.0
 */
interface ServiceBuilder<S> {

    /**
     * Sets the ready configured [ConnectionBuilder] that creates the communication objects.
     *
     * @param connectionBuilder Required connection builder
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withConnectionBuilder(connectionBuilder: ConnectionBuilder): ServiceBuilder<S>

    /**
     * Creates a new service instance
     *
     * @return Service instance
     *
     * @since 2.0
     */
    fun buildService(): S
}

/**
 * Simple ServiceBuilder that takes over the management of the [ConnectionBuilder].
 *
 * @param S Type of the generated service
 *
 * @since 2.0
 */
abstract class DefaultServiceBuilder<S> : ServiceBuilder<S> {

    private var connectionBuilder: ConnectionBuilder? = null

    override fun withConnectionBuilder(connectionBuilder: ConnectionBuilder): ServiceBuilder<S> =
        connectionBuilder
            .let {
                this.connectionBuilder = it
                this
            }

    protected fun getConnectionBuilder() =
        connectionBuilder ?: throw IllegalStateException("connectionBuilder is a mandatory information")

}
