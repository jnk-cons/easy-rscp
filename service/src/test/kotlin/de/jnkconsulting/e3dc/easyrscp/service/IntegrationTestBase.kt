package de.jnkconsulting.e3dc.easyrscp.service

import de.jnkconsulting.e3dc.easyrscp.api.connection.ConnectionPool
import de.jnkconsulting.e3dc.easyrscp.api.connection.E3DCConnectionData
import de.jnkconsulting.e3dc.easyrscp.connection.DefaultHomePowerPlantConnectionFactory
import de.jnkconsulting.e3dc.easyrscp.connection.SingleInstanceConnectionPool
import de.jnkconsulting.e3dc.easyrscp.crypt.BouncyCastleAESCipherFactory
import org.junit.jupiter.api.BeforeEach

open class IntegrationTestBase {
    private lateinit var host: String
    private lateinit var user: String
    private lateinit var rscpPassword: String
    private lateinit var portalPassword: String
    lateinit var connectionPool: ConnectionPool

    @BeforeEach
    fun setUp() {
        host = System.getenv("E3DC_HOST")
        user = System.getenv("E3DC_USER")
        rscpPassword = System.getenv("RSCP_PASSWORD")
        portalPassword = System.getenv("E3DC_PORTAL_PASSWORD")
        val connector = DefaultHomePowerPlantConnectionFactory(
            connectionData = E3DCConnectionData(
                address = host,
                portalUser = user,
                rscpPassword = rscpPassword,
                portalPassword = portalPassword,
            ),
            aesFactory = BouncyCastleAESCipherFactory(rscpPassword),
            requestResponseListener = listOf(PrintRequestAndAnswerFrameListener())
        )
        connectionPool = SingleInstanceConnectionPool(connector)
    }
}
