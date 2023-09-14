package de.jnkconsulting.e3dc.easyrscp.connection

import de.jnkconsulting.e3dc.easyrscp.api.connection.HomePowerPlantConnection
import de.jnkconsulting.e3dc.easyrscp.api.connection.HomePowerPlantConnectionFactory
import io.mockk.every
import org.junit.jupiter.api.Assertions.*
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.util.concurrent.TimeoutException
import kotlin.concurrent.thread

class SingleInstanceConnectionPoolTest {
    private val connector = mockk<HomePowerPlantConnectionFactory>()
    private val connection = mockk<HomePowerPlantConnection>()
    private lateinit var toTest: SingleInstanceConnectionPool

    @BeforeEach
    fun init() {
        toTest = SingleInstanceConnectionPool(
            connector = connector,
            timeoutMillis = 3000)
    }
    @Test
    fun `test that getConnection returns a connection`() {
        every { connector.openConnection() } returns connection

        val result = toTest.getConnection()
        assertNotNull(result)

        verify(exactly = 1) { connector.openConnection() }
    }

    @Test
    fun `test that getConnection throws an TimeoutException`() {
        every { connector.openConnection() } returns connection

        val result = toTest.getConnection()
        assertNotNull(result)
        val ex = assertThrows(TimeoutException::class.java) {
            toTest.getConnection()
        }
        assertNotNull(ex)

        verify(exactly = 1) { connector.openConnection() }
    }

    @Test
    fun `test that getConnection returns a connection after release`() {
        every { connector.openConnection() } returns connection
        every { connection.isConnected() } returns true

        val result = toTest.getConnection()
        assertNotNull(result)

        thread {
            Thread.sleep(500)
            toTest.releaseConnection(result)
        }
        val result2 = toTest.getConnection()
        assertNotNull(result2)
        assertEquals(result, result2)

        verify(exactly = 1) { connector.openConnection() }
        verify(exactly = 1) { connection.isConnected() }
    }


}
