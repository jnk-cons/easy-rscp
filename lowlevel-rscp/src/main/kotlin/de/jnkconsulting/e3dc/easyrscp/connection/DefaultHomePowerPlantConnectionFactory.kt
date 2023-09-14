package de.jnkconsulting.e3dc.easyrscp.connection

import de.jnkconsulting.e3dc.easyrscp.api.connection.E3DCConnectionData
import de.jnkconsulting.e3dc.easyrscp.api.connection.HomePowerPlantConnectionFactory
import de.jnkconsulting.e3dc.easyrscp.api.connection.SocketFactory
import de.jnkconsulting.e3dc.easyrscp.api.crypt.AESCipherFactory
import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.FrameParser
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.RSCPTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.DefaultDataParser
import de.jnkconsulting.e3dc.easyrscp.frame.DefaultFrameParser
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import mu.KotlinLogging

/**
 * Farbrik that creates instances of the [DefaultHomePowerPlantConnection] type.
 *
 * @param connectionData Connection data to the home power plant
 * @param aesFactory Factory to encrypt the data before sending and decrypt the responses
 * @param socketFactory [SocketFactory] to use. If not specified, an instance of [DefaultSocketFactory] is created and used.
 * @param frameParser FrameParser] to use to convert the responses from the home power plant into [Frame] objects. If not specified, an instance of type [DefaultFrameParser] is created and used
 *
 * @since 2.0
 */
class DefaultHomePowerPlantConnectionFactory(
    private val connectionData: E3DCConnectionData,
    private val aesFactory: AESCipherFactory,
    private val socketFactory: SocketFactory = DefaultSocketFactory(),
    private val frameParser: FrameParser = DefaultFrameParser(DefaultDataParser()),
    private val requestResponseListener: List<RSCPRequestResponseListener> = listOf()
): HomePowerPlantConnectionFactory {
    private val logger = KotlinLogging.logger {}


    override fun openConnection() =
        DefaultHomePowerPlantConnection(connectionData, aesFactory, socketFactory, frameParser, requestResponseListener)
            .also { logger.trace { "New connection object created for $connectionData. Send authentication frame." } }
            .also { it.connect() }
            .also { it.send(buildAuthenticationFrame()).also { logger.trace { "Authentication answer received: $it" } } }
            .also { logger.trace { "Authentication frame send to $connectionData." } }

    private fun buildAuthenticationFrame() =
        FrameBuilder()
            .addData(
                DataBuilder()
                    .tag(RSCPTag.REQ_AUTHENTICATION)
                    .container(
                        DataBuilder().tag(RSCPTag.AUTHENTICATION_USER).string(connectionData.user).build(),
                        DataBuilder().tag(RSCPTag.AUTHENTICATION_PASSWORD).string(connectionData.portalPassword).build(),
                    )
                    .build()
            )
            .build()


}
