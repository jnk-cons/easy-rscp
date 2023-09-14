package de.jnkconsulting.e3dc.easyrscp.connection

import de.jnkconsulting.e3dc.easyrscp.api.connection.E3DCConnectionData
import de.jnkconsulting.e3dc.easyrscp.api.connection.SocketFactory
import de.jnkconsulting.e3dc.easyrscp.api.crypt.AESCipher
import de.jnkconsulting.e3dc.easyrscp.api.crypt.AESCipherFactory
import de.jnkconsulting.e3dc.easyrscp.api.frame.FrameParser
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.BatTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.net.Socket

class DefaultHomePowerPlantConnectionTest {
    private lateinit var toTest: DefaultHomePowerPlantConnection

    private val connectionData = mockk<E3DCConnectionData>()
    private val socketFactory = mockk<SocketFactory>()
    private val socket = mockk<Socket>()
    private val aesFactory = mockk<AESCipherFactory>()
    private val aes = mockk<AESCipher>()
    private val frameParser = mockk<FrameParser>()

    private val testFrame = FrameBuilder()
        .enableChecksum()
        .addData(
            DataBuilder()
                .tag(BatTag.DEVICE_NAME)
                .string("Junit test")
                .build()
        )
        .build()

    private val plainData = testFrame.asByteArray()
    private val encryptedData = "dummy".toByteArray()

    @Nested
    inner class Connect {
        @Test
        fun `creates a new connection`() {
            every { socketFactory.createSocket(connectionData) } returns socket

            toTest.connect()

            verify(exactly = 1) { socketFactory.createSocket(connectionData) }
        }

        @Test
        fun `does nothing, using a already connected connection`() {
            every { socketFactory.createSocket(connectionData) } returns socket
            every { socket.isConnected } returns true

            toTest.connect()
            toTest.connect()

            verify(exactly = 1) { socketFactory.createSocket(connectionData) }
            verify(exactly = 1) { socket.isConnected }
        }
    }

    @Nested
    inner class Disconnect {

        @Test
        fun `disconnect() closes the connection`() {
            every { socketFactory.createSocket(connectionData) } returns socket
            every { socket.isConnected } returns true
            every { socket.close() } returns Unit

            toTest.connect()
            toTest.disconnect()

            verify(exactly = 1) { socketFactory.createSocket(connectionData) }
            verify(exactly = 1) { socket.isConnected }
            verify(exactly = 1) { socket.close() }
        }

        @Test
        fun `close() closes the connection`() {
            every { socketFactory.createSocket(connectionData) } returns socket
            every { socket.isConnected } returns true
            every { socket.close() } returns Unit

            toTest.connect()
            toTest.close()

            verify(exactly = 1) { socketFactory.createSocket(connectionData) }
            verify(exactly = 1) { socket.isConnected }
            verify(exactly = 1) { socket.close() }
        }

        @Test
        fun `does nothing if already disconnected`() {
            every { socketFactory.createSocket(connectionData) } returns socket
            every { socket.isConnected } returns false

            toTest.connect()
            toTest.disconnect()

            verify(exactly = 1) { socketFactory.createSocket(connectionData) }
            verify(exactly = 1) { socket.isConnected }
            verify(exactly = 0) { socket.close() }
        }

    }

    @Nested
    inner class IsConnected {

        @Test
        fun `returns false if the socket is null`() {
            assertFalse(toTest.isConnected())
        }

        @Test
        fun `returns false if the socket is not connected`() {
            every { socketFactory.createSocket(connectionData) } returns socket
            every { socket.isConnected } returns false
            toTest.connect()
            assertFalse(toTest.isConnected())

            verify(exactly = 1) { socketFactory.createSocket(connectionData) }
            verify(exactly = 1) { socket.isConnected }
        }

        @Test
        fun `returns true if the socket is connected`() {
            every { socketFactory.createSocket(connectionData) } returns socket
            every { socket.isConnected } returns true
            toTest.connect()
            assertTrue(toTest.isConnected())

            verify(exactly = 1) { socketFactory.createSocket(connectionData) }
            verify(exactly = 1) { socket.isConnected }
        }

    }

    @Nested
    inner class SendAndReceive {
        @Test
        fun `test RSCP send and receive workflow`() {
            every { socketFactory.createSocket(connectionData) } returns socket
            every { aes.encrypt(plainData) } returns encryptedData
            every { socket.isConnected } returns true
            val outputStream = ByteArrayOutputStream()
            every { socket.getOutputStream() } returns outputStream
            every { socket.getInputStream() } returns ByteArrayInputStream(encryptedData)
            every { aes.decrypt(encryptedData) } returns plainData
            every { frameParser.parseRSCPFrame(plainData) } returns testFrame


            toTest.connect()
            val result = toTest.send(testFrame)

            assertEquals(testFrame, result)

            verify(exactly = 1) { aes.encrypt(plainData) }
            verify(exactly = 1) { aes.decrypt(encryptedData) }
            verify(exactly = 1) { frameParser.parseRSCPFrame(plainData) }
        }
    }

    @BeforeEach
    fun init() {
        every { aesFactory.buildCipher() } returns aes
        toTest = DefaultHomePowerPlantConnection(connectionData, aesFactory, socketFactory, frameParser)
    }
}
