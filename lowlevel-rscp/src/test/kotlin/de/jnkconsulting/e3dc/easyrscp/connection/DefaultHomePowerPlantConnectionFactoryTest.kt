package de.jnkconsulting.e3dc.easyrscp.connection

import de.jnkconsulting.e3dc.easyrscp.api.connection.E3DCConnectionData
import de.jnkconsulting.e3dc.easyrscp.api.connection.SocketFactory
import de.jnkconsulting.e3dc.easyrscp.api.crypt.AESCipher
import de.jnkconsulting.e3dc.easyrscp.api.crypt.AESCipherFactory
import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.FrameParser
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.RSCPTag
import de.jnkconsulting.e3dc.easyrscp.frame.DefaultDataParser
import de.jnkconsulting.e3dc.easyrscp.frame.DefaultFrameParser
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.net.Socket

class DefaultHomePowerPlantConnectionFactoryTest {
    private val connectionData: E3DCConnectionData = mockk {
        every { user } returns "portal-user"
        every { portalPassword } returns "portal-password"
    }
    private val aesCipherFactory = mockk<AESCipherFactory>()
    private val socketFactory = mockk<SocketFactory>()
    private val frameParser = mockk<FrameParser>()
    private val aes = mockk<AESCipher>()
    private val socket = mockk<Socket>()
    private val answerFrame = mockk<Frame>()

    private val encryptedAuthenticationFrame = "encrypted".toByteArray()
    private val encryptedAuthenticationAnswer = "answer".toByteArray()
    private val decryptedAuthenticationAnswer = "decrypted-answer".toByteArray()

    private lateinit var toTest: DefaultHomePowerPlantConnectionFactory

    @Test
    fun `test open connection returns a valid connection`() {
        every { aesCipherFactory.buildCipher() } returns aes
        every { socketFactory.createSocket(connectionData) } returns socket
        every { socket.isConnected } returns true

        val aesCryptSlot = slot<ByteArray>()
        every { aes.encrypt(capture(aesCryptSlot)) } returns encryptedAuthenticationFrame
        val socketOutput = ByteArrayOutputStream()
        every { socket.getOutputStream() } returns socketOutput
        every { socket.getInputStream() } returns ByteArrayInputStream(encryptedAuthenticationAnswer)
        every { aes.decrypt(encryptedAuthenticationAnswer) } returns decryptedAuthenticationAnswer
        every { frameParser.parseRSCPFrame(decryptedAuthenticationAnswer) } returns answerFrame

        val result = toTest.openConnection()

        assertNotNull(result)

        val sendFrame = DefaultFrameParser(DefaultDataParser()).parseRSCPFrame(aesCryptSlot.captured)
        val frameData = sendFrame.data
        assertEquals(1, frameData.size)
        val frameContainer = sendFrame.data[0]
        assertEquals(RSCPTag.REQ_AUTHENTICATION, frameContainer.tagObject())
        val containerData = frameContainer.valueAsContainer(DefaultDataParser())
        assertEquals(2, containerData.size)
        assertEquals(RSCPTag.AUTHENTICATION_USER, containerData[0].tagObject())
        assertEquals("portal-user", containerData[0].valueAsString())
        assertEquals(RSCPTag.AUTHENTICATION_PASSWORD, containerData[1].tagObject())
        assertEquals("portal-password", containerData[1].valueAsString())

        verify { aes.encrypt(any()) }
        verify { aes.decrypt(encryptedAuthenticationAnswer) }
        verify { frameParser.parseRSCPFrame(decryptedAuthenticationAnswer) }
    }

    @BeforeEach
    fun init() {
        toTest = DefaultHomePowerPlantConnectionFactory(
            connectionData = connectionData,
            aesFactory = aesCipherFactory,
            socketFactory = socketFactory,
            frameParser = frameParser,
        )
    }
}
