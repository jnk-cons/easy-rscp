package de.jnkconsulting.e3dc.easyrscp.connection

import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame

/**
 * Listener that can be registered to instances of type [DefaultHomePowerPlantConnection] to receive lifecycle events in the request/response process of a frame.
 *
 * All functions are stored with empty default implementations, so that implementing classes only need to override the functions that are needed.
 *
 * Call order in a normal request/response cycle:
 *
 * Before encrypting the request frame
 * - [onRSCPRequestResponseEvent]
 * - [onBeforeRequestFrameEncryption]
 *
 * Before sending the encrypted frame
 * - [onRSCPRequestResponseEvent]
 * - [onBeforeRequestSend]
 *
 * After sending the encrypted frame
 * - [onRSCPRequestResponseEvent]
 * - [onAfterRequestSend]
 *
 * After receiving the encrypted response from the home power plant.
 * - [onRSCPRequestResponseEvent]
 * - [onAnswerReceived]
 *
 * After decrypting the answer from the home power plant
 * - [onRSCPRequestResponseEvent]
 * - [onAnswerDecrypted]
 *
 * After parsing the decrypted response to a [Frame].
 * - [onRSCPRequestResponseEvent]
 * - [onAnswerDecrypted]
 *
 * @since 2.0
 */
interface RSCPRequestResponseListener {
    /**
     * Called before encrypting the request [Frame]
     *
     * @param event Event data
     *
     * @since 2.0
     */
    fun onBeforeRequestFrameEncryption(event: RSCPBeforeRequestEncryptionEvent) {}

    /**
     * Called before sending the encrypted binary data
     *
     * @param event Event data
     *
     * @since 2.0
     */
    fun onBeforeRequestSend(event: RSCPBeforeRequestSendEvent) {}

    /**
     * Called after sending the encrypted binary data
     *
     * @param event Event data
     *
     * @since 2.0
     */
    fun onAfterRequestSend(event: RSCPAfterRequestSendEvent) {}

    /**
     * Called after receiving the encrypted response from the home power plant
     *
     * @param event Event data
     *
     * @since 2.0
     */
    fun onAnswerReceived(event: RSCPAnswerReceivedEvent) {}

    /**
     * Called after the response from the home power plant has been decrypted
     *
     * @param event Event data
     *
     * @since 2.0
     */
    fun onAnswerDecrypted(event: RSCPAnswerDecryptedEvent) {}

    /**
     * Called after the response from the home power plant has been deserialized to a [Frame].
     *
     * @param event Event data
     *
     * @since 2.0
     */
    fun onAnswerParsed(event: RSCPAnswerParsedEvent) {}

    /**
     * Called for each [RSCPRequestResponseEvent] that occurs.
     *
     * @param event Event data
     *
     * @since 2.0
     */
    fun onRSCPRequestResponseEvent(event: RSCPRequestResponseEvent) {}
}

/**
 * Describes an event that can occur in the request/response cycle of a frame.
 *
 * @since 2.0
 */
interface RSCPRequestResponseEvent {
    /**
     * Unencrypted request frame
     *
     * @since 2.0
     */
    val requestFrame: Frame
}


/**
 * Event that holds the data before the request is encrypted
 *
 * @since 2.0
 */
data class RSCPBeforeRequestEncryptionEvent(
    override val requestFrame: Frame
) : RSCPRequestResponseEvent

/**
 * Event that holds the data before sending the request [Frame].
 *
 * @since 2.0
 */
class RSCPBeforeRequestSendEvent(
    override val requestFrame: Frame,
    /**
     * Encrypted frame data. This binary data is sent to the home power plant
     *
     * @since 2.0
     */
    val encryptedFrame: ByteArray
) : RSCPRequestResponseEvent

/**
 * Event that holds the data after sending the request [Frame].
 *
 * @since 2.0
 */
class RSCPAfterRequestSendEvent(
    override val requestFrame: Frame,
    /**
     * Encrypted frame data. This binary data was sent to the home power plant
     *
     * @since 2.0
     */
    val sentData: ByteArray
) : RSCPRequestResponseEvent

/**
 * Event that holds the data received from the home power plant.
 *
 * @since 2.0
 */
class RSCPAnswerReceivedEvent(
    override val requestFrame: Frame,
    /**
     * Encrypted binary data received from the home power plant
     *
     * @since 2.0
     */
    val encryptedAnswer: ByteArray
) : RSCPRequestResponseEvent

/**
 * Event containing the data after decryption of the response from the home power plant
 *
 * @since 2.0
 */
class RSCPAnswerDecryptedEvent(
    override val requestFrame: Frame,
    /**
     * Decrypted binary data
     */
    val decryptedAnswer: ByteArray
) : RSCPRequestResponseEvent

/**
 * Event containing the data after parsing the decrypted binary data from the home power plant
 *
 * @since 2.0
 */
class RSCPAnswerParsedEvent(
    override val requestFrame: Frame,
    /**
     * Response frame from home power plant
     *
     * @since 2.0
     */
    val answerFrame: Frame
) : RSCPRequestResponseEvent
