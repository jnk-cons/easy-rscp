package de.jnkconsulting.e3dc.easyrscp.frame

import de.jnkconsulting.e3dc.easyrscp.api.bytes.FIXED_VALUES
import de.jnkconsulting.e3dc.easyrscp.api.frame.Data
import de.jnkconsulting.e3dc.easyrscp.api.frame.DataParser
import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import java.time.Instant

/**
 * Builder class to create instances of the [Frame] type
 *
 * @sample de.jnkconsulting.e3dc.easyrscp.frame.samples.createQueryCurrentPowerState
 *
 * @since 2.0
 */
class FrameBuilder {

    private var timestamp : Instant? = null
    private var data = mutableListOf<Data>()
    private var controlBytes = FIXED_VALUES.controlBytesWithChecksum
    private var parser: DataParser = DefaultDataParser()

    /**
     * Parser to use for container data. If not set, the [DefaultDataParser] is used
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withParser(parser: DataParser) =
        parser
            .also { this.parser = it }
            .let { this }

    /**
     * Timestamp specified in the frame as the creation time.
     *
     * The call is optional. If the timestamp is null at the time [build] is called, a new timestamp is generated. See [Instant.now]
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun timestamp(timestamp: Instant) =
        timestamp
            .also { this.timestamp = it }
            .let { this }

    /**
     * Adds a single data block
     *
     * @param toAdd Data block to be added
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun addData(toAdd: Data) =
        data
            .add(toAdd)
            .let { this }

    /**
     * Adds all data to the passed [toAdd] collection.
     *
     * @param toAdd Data blocks to be added
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun addData(toAdd: Collection<Data>) =
        data
            .addAll(toAdd)
            .let { this }

    /**
     * Adds all data of the passed [toAdd] parameters.
     *
     * @param toAdd Data blocks to be added
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun addData(vararg toAdd: Data) =
        data
            .addAll(toAdd)
            .let { this }

    /**
     * Activates the checksum function (defaul)
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun enableChecksum() =
        this
            .also {
                controlBytes = FIXED_VALUES.controlBytesWithChecksum
            }

    /**
     * Disables the checksum function
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun disableChecksum() =
        this
            .also {
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum
            }

    /**
     * Activates or deactivates checksum calculation for the frame to build
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withChecksumEnabled(enabled: Boolean) =
        when (enabled) {
            true -> enableChecksum()
            false -> disableChecksum()
        }

    /**
     * Creates a new frame based on the previously configured parameters
     *
     * @return RSCP Frame
     *
     * @since 2.0
     */
    fun build() =
        Frame(
            timestamp = timestamp?: Instant.now(),
            controlBytes = controlBytes,
            data = data,
            parser = this.parser
        )

}
