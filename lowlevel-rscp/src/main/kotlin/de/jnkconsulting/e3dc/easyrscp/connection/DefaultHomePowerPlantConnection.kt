package de.jnkconsulting.e3dc.easyrscp.connection

import de.jnkconsulting.e3dc.easyrscp.api.connection.E3DCConnectionData
import de.jnkconsulting.e3dc.easyrscp.api.connection.HomePowerPlantConnection
import de.jnkconsulting.e3dc.easyrscp.api.connection.SocketFactory
import de.jnkconsulting.e3dc.easyrscp.api.crypt.AESCipherFactory
import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.FrameParser
import de.jnkconsulting.e3dc.easyrscp.frame.DefaultDataParser
import de.jnkconsulting.e3dc.easyrscp.frame.DefaultFrameParser
import mu.KotlinLogging
import java.io.ByteArrayOutputStream
import java.io.DataInputStream
import java.io.DataOutputStream
import java.lang.IllegalStateException
import java.net.Socket

/**
 * Simple implementation of [HomePowerPlantConnection].
 *
 * @param connectionData Connection data to the home power plant
 * @param aesFactory Factory to encrypt the data before sending and decrypt the responses
 * @param socketFactory [SocketFactory] to use. If not specified, an instance of [DefaultSocketFactory] is created and used.
 * @param frameParser [FrameParser] to use to convert the responses from the home power plant into [Frame] objects. If not specified, an instance of type [DefaultFrameParser] is created and used
 * @param listener Listeners to get informed about the lifecycle of sending/receiving frames
 *
 * @since 2.0
 */
class DefaultHomePowerPlantConnection(
    private val connectionData: E3DCConnectionData,
    aesFactory: AESCipherFactory,
    private val socketFactory: SocketFactory = DefaultSocketFactory(),
    private val frameParser: FrameParser = DefaultFrameParser(DefaultDataParser()),
    private val listener: List<RSCPRequestResponseListener> = listOf()
): HomePowerPlantConnection {

    private val logger = KotlinLogging.logger {}
    private var socket: Socket? = null
    private val aes = aesFactory.buildCipher()

    override fun connect() {
        if (isConnected()) {
            logger.trace { "Already connected. Skip connection attempt." }
        }
        else {
            logger.trace { "Open connection to $connectionData." }
            socket = socketFactory.createSocket(connectionData)
            logger.trace { "Connection to $connectionData established." }
        }
    }

    override fun disconnect() {
        if (isConnected()) {
            logger.trace { "Close the connection to $connectionData." }
            socket?.close()
        }
        else {
            logger.trace { "Connection to $connectionData has already been closed." }
        }
    }

    override fun isConnected() = socket != null && socket!!.isConnected

    override fun send(frame: Frame) =
        when (isConnected()) {
            true -> sendAndReceive(frame)
            false -> throw "Connection not established. First call connect()."
                            .also { logger.error { it } }
                            .let { IllegalStateException(it) }
        }


    private fun sendAndReceive(frame: Frame) =
        frame
            .also { onBeforeRequestEncryption(frame) }
            .let { aes.encrypt(frame.asByteArray()) }
            .also { onBeforeSend(frame, it) }
            .also {
                DataOutputStream(socket!!.getOutputStream()).run {
                    write(it)
                    flush()
                }
            }
            .also { onAfterSend(frame, it) }
            .let { readDataFromE3DC() }
            .also { onAnswerReceived(frame, it) }
            .let { aes.decrypt(it) }
            .also { onAnswerDecrypted(frame, it) }
            .let { frameParser.parseRSCPFrame(it) }
            .also { onAnswerParsed(frame, it) }

    private fun onBeforeRequestEncryption(frame: Frame) {
        logger.trace { "Encrypt frame: $frame" }
        val event = RSCPBeforeRequestEncryptionEvent(frame)
        listener.forEach {
            it.onRSCPRequestResponseEvent(event)
            it.onBeforeRequestFrameEncryption(event)
        }
    }

    private fun onBeforeSend(frame: Frame, encryptedData: ByteArray) {
        logger.trace { "Encryption successful. Send ${encryptedData.size} bytes to $connectionData." }
        val event = RSCPBeforeRequestSendEvent(frame, encryptedData)
        listener.forEach {
            it.onRSCPRequestResponseEvent(event)
            it.onBeforeRequestSend(event)
        }
    }

    private fun onAfterSend(frame: Frame, sentData: ByteArray) {
        logger.trace { "Data sent successfully. Read response." }
        val event = RSCPAfterRequestSendEvent(frame, sentData)
        listener.forEach {
            it.onRSCPRequestResponseEvent(event)
            it.onAfterRequestSend(event)
        }
    }

    private fun onAnswerReceived(frame: Frame, encryptedAnswer: ByteArray) {
        logger.trace { "${encryptedAnswer.size} bytes Received. Decrypt data." }
        val event = RSCPAnswerReceivedEvent(frame, encryptedAnswer)
        listener.forEach {
            it.onRSCPRequestResponseEvent(event)
            it.onAnswerReceived(event)
        }
    }

    private fun onAnswerDecrypted(frame: Frame, decryptedAnswer: ByteArray) {
        logger.trace { "Data successfully decrypted. Parse the data to the frame." }
        val event = RSCPAnswerDecryptedEvent(frame, decryptedAnswer)
        listener.forEach {
            it.onRSCPRequestResponseEvent(event)
            it.onAnswerDecrypted(event)
        }
    }

    private fun onAnswerParsed(frame: Frame, answer: Frame) {
        logger.trace { "Parsing of the frame successful: $answer" }
        val event = RSCPAnswerParsedEvent(frame, answer)
        listener.forEach {
            it.onRSCPRequestResponseEvent(event)
            it.onAnswerParsed(event)
        }
    }

    private fun readDataFromE3DC(): ByteArray {
        val streamIn = DataInputStream(socket!!.getInputStream())
        val buffer = ByteArrayOutputStream()
        val currentBlock = ByteArray(4096)
        do {
            val bytesRead = streamIn.read(currentBlock, 0, currentBlock.size)
            if (bytesRead == -1) {
                logger.error { "Error reading the response. This can happen among other things if the e3dc system has terminated the connection or the authentication has failed." }
                throw IllegalStateException("Error reading the response. This can happen among other things if the e3dc system has terminated the connection or the authentication has failed.")
            }
            buffer.write(currentBlock, 0, bytesRead)
        } while (streamIn.available() > 0)
        return buffer.toByteArray()
    }

    override fun close() {
        disconnect()
    }
}
