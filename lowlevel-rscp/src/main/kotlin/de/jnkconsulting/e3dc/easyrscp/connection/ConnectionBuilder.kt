package de.jnkconsulting.e3dc.easyrscp.connection

import de.jnkconsulting.e3dc.easyrscp.api.connection.ConnectionPool
import de.jnkconsulting.e3dc.easyrscp.api.connection.E3DCConnectionData
import de.jnkconsulting.e3dc.easyrscp.api.connection.HomePowerPlantConnectionFactory
import de.jnkconsulting.e3dc.easyrscp.api.connection.SocketFactory
import de.jnkconsulting.e3dc.easyrscp.api.crypt.AESCipherFactory
import de.jnkconsulting.e3dc.easyrscp.api.frame.FrameParser
import de.jnkconsulting.e3dc.easyrscp.crypt.BouncyCastleAESCipherFactory
import de.jnkconsulting.e3dc.easyrscp.frame.DefaultDataParser
import de.jnkconsulting.e3dc.easyrscp.frame.DefaultFrameParser

/**
 * Builder to create the different connection objects.
 *
 * @since 2.0
 */
class ConnectionBuilder {

    private var address: String = ""
    private var port: Int = 5033
    private var portalUser: String = ""
    private var rscpPassword: String = ""
    private var portalPassword: String = ""
    private var socketTimeoutMillis: Long = 10000

    private var cipherFactory: AESCipherFactory? = null
    private var socketFactory: SocketFactory? = null
    private var frameParser: FrameParser? = null
    private val requestResponseListener: MutableList<RSCPRequestResponseListener> = mutableListOf()
    private var connectionPool: ConnectionPool? = null
    private var connectionPoolTimeoutMillis: Long = 10000
    private fun validateForConnectionData() {
        validateMandatoryStringParameter(address, "address")
        validateMandatoryStringParameter(portalUser, "portalUser")
        validateMandatoryStringParameter(rscpPassword, "rscpPassword")
        validateMandatoryStringParameter(portalPassword, "portalPassword")
    }

    private fun validateForCipher() {
        validateMandatoryStringParameter(rscpPassword, "rscpPassword")
    }

    private fun validateMandatoryStringParameter(value: String, parameter: String) {
        if (value.isBlank()) {
            throw IllegalStateException("$parameter is a mandatory information")
        }
    }

    /**
     * Sets the IP address or the domain name of the home power plant (Without port!)
     * 
     * @param address IP address or domain name
     *
     * @return this reference
     *
     * @see 2.0
     */
    fun withAddress(address: String): ConnectionBuilder =
        address
            .let {
                this.address = it
                this
            }

    /**
     * Port on which the RSCP service in the home power plant listens. The specification is optional. By default, 5033 is used. For farms it should be 5034.
     *
     * @param port Port of the RSCP service in the home power plant
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withPort(port: Int): ConnectionBuilder =
        port
            .let {
                this.port = it
                this
            }

    /**
     * Username from the E3DC portal.
     *
     * @param portalUser E3DC Portal Username
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withPortalUser(portalUser: String): ConnectionBuilder =
        portalUser
            .let {
                this.portalUser = it
                this
            }

    /**
     * Password from the E3DC Portal
     *
     * @param portalPassword E3DC Portal password
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withPortalPassword(portalPassword: String): ConnectionBuilder =
        portalPassword
            .let {
                this.portalPassword = it
                this
            }

    /**
     * RSCP Password. This is used to encrypt the transmission. The same value must be selected as was stored at the home power plant.
     *
     * @param rscpPassword RSCP Password for encryption
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withRSCPPassword(rscpPassword: String): ConnectionBuilder =
        rscpPassword
            .let {
                this.rscpPassword = it
                this
            }

    /**
     * If you want to use your own implementation for encryption, you can set a factory here. The setting is optional.
     * By default [BouncyCastleAESCipherFactory] is used.
     *
     * @param cipherFactory Factory to use
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withCipherFactory(cipherFactory: AESCipherFactory): ConnectionBuilder =
        cipherFactory
            .let {
                this.cipherFactory = it
                this
            }

    /**
     * Timeout in milliseconds for establishing the connection. Optional specification. By default 10000ms is used.
     *
     * @param timeout Timeout in milliseconds
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withSocketTimeoutMillis(timeout: Long): ConnectionBuilder =
        timeout
            .let {
                this.socketTimeoutMillis = it
                this
            }

    /**
     * If you want to use your own SocketFactory, you can set the instance here. Optional specification.
     * By default an instance of type [DefaultSocketFactory] is used.
     *
     * @param socketFactory Factory to be used
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withSocketFactory(socketFactory: SocketFactory): ConnectionBuilder =
        socketFactory
            .let {
                this.socketFactory = it
                this
            }

    /**
     * If you want to use your own frame parser, you can set the instance here. Optional specification.
     * By default an instance of type [DefaultFrameParser] is used.
     *
     * @param frameParser Parser to use
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withFrameParser(frameParser: FrameParser): ConnectionBuilder =
        frameParser
            .let {
                this.frameParser = it
                this
            }

    /**
     * If you want to use your own ConnectionPool, you can set it here. Optional specification.
     * By default an instance of the type [SingleInstanceConnectionPool] is used.
     *
     * @param connectionPool ConnectionPool to use
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withConnectionPool(connectionPool: ConnectionPool): ConnectionBuilder =
        connectionPool
            .let {
                this.connectionPool = it
                this
            }

    /**
     * Timeout in milliseconds how long the [SingleInstanceConnectionPool] waits for a free connection before generating
     * an error. Optional specification. The default is 10000ms.
     *
     * The value only has relevance if NO own ConnectionPool is set with [withConnectionPool].
     *
     * @param timeout Timeout in milleseconds
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withConnectionPoolTimeoutMillis(timeout: Long): ConnectionBuilder =
        timeout
            .let {
                this.connectionPoolTimeoutMillis = it
                this
            }

    /**
     * Adds listeners that are called when passing through a request/response cycle
     *
     * @param listener Listeners to be added
     *
     * @return this reference
     *
     * @since 2.0
     */
   fun addRequestResponseListener(vararg listener: RSCPRequestResponseListener): ConnectionBuilder =
       requestResponseListener
           .addAll(listener)
           .let { this }

    /**
     * Creates a new [HomePowerPlantConnectionFactory] instance.
     *
     * @return Newly created implementation of the [HomePowerPlantConnectionFactory] interface.
     *
     * @since 2.0
     */
    fun buildConnectionFactory(): HomePowerPlantConnectionFactory {
        return DefaultHomePowerPlantConnectionFactory(
            connectionData = buildConnectionData(),
            aesFactory = buildCipherFactory(),
            socketFactory = buildSocketFactory(),
            frameParser = buildFrameParser(),
            requestResponseListener = requestResponseListener
        )
    }

    /**
     * Creates a new instance with the configured connection data
     *
     * @return Newly created instance of the connection data [E3DCConnectionData].
     *
     * @since 2.0
     */
    fun buildConnectionData(): E3DCConnectionData {
        validateForConnectionData()
        return E3DCConnectionData(
            address = address,
            port = port,
            portalUser = portalUser,
            portalPassword = portalPassword,
            rscpPassword = rscpPassword,
            timeoutMillis = socketTimeoutMillis,
        )
    }

    /**
     * Returns either the instance of [AESCipherFactory] set by [withCipherFactory] or creates a new one of type [BouncyCastleAESCipherFactory].
     *
     * @return An instance of the type [AESCipherFactory].
     *
     * @since 2.0
     */
    fun buildCipherFactory(): AESCipherFactory =
        cipherFactory ?: buildOwnCipherFactor()

    /**
     * Either returns the instance of a [SocketFactory] previously set by [withSocketFactory] or creates a new one of type [DefaultSocketFactory].
     *
     * @return An instance of the type [SocketFactory].
     *
     * @since 2.0
     */
    fun buildSocketFactory(): SocketFactory =
        socketFactory ?: buildOwnSocketFactory()

    /**
     * Returns either the instance of a [ConnectionPool] set by [withConnectionPool] or creates a new one of type [SingleInstanceConnectionPool].
     *
     * @return An instance of the type [ConnectionPool].
     *
     * @since 2.0
     */
    fun buildConnectionPool(): ConnectionPool =
        connectionPool ?: buildOwnConnectionPool()

    private fun buildOwnConnectionPool(): ConnectionPool =
        SingleInstanceConnectionPool(
            connector = buildConnectionFactory(),
            timeoutMillis = connectionPoolTimeoutMillis
        )

    private fun buildOwnSocketFactory(): SocketFactory = DefaultSocketFactory()

    private fun buildOwnCipherFactor(): AESCipherFactory {
        validateForCipher()
        return BouncyCastleAESCipherFactory(rscpPassword)
    }

    private fun buildFrameParser() =
        frameParser ?: buildOwnFrameParser()
    private fun buildOwnFrameParser() : FrameParser = DefaultFrameParser(DefaultDataParser())

}
