package de.jnkconsulting.e3dc.easyrscp.frame

import de.jnkconsulting.e3dc.easyrscp.api.bytes.POSITIONS
import de.jnkconsulting.e3dc.easyrscp.api.bytes.SIZES
import de.jnkconsulting.e3dc.easyrscp.api.frame.DataParser
import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.FrameParser
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.time.Instant

/**
 * Simple implementation to create objects from binary data [Frame].
 *
 * @param dataParser Parser for the data section in a frame
 *
 * @since 2.0
 */
class DefaultFrameParser(private val dataParser: DataParser): FrameParser {


    override fun parseRSCPFrame(frame: ByteArray): Frame {
        val frameBuilder = FrameBuilder()
        val frameBuffer = ByteBuffer.wrap(frame).order(ByteOrder.LITTLE_ENDIAN).rewind()

        val checksumEnabled = isChecksumsEnabled(frameBuffer)
        val timestamp = readTimestamp(frameBuffer)
        val data = readDataSection(frameBuffer)

        return frameBuilder
            .timestamp(timestamp)
            .withChecksumEnabled(checksumEnabled)
            .addData(
                dataParser
                    .parseRSCPData(data)
            )
            .build()
    }

    private fun readDataSection(frameBuffer: ByteBuffer) =
        readDataSectionLength(frameBuffer)
            .let { dataSectionLength ->
                ByteArray(dataSectionLength.toInt())
                    .also {
                        frameBuffer
                            .position(POSITIONS.frameDataSection)
                            .get(it, 0, dataSectionLength.toInt())
                    }
            }


    private fun readDataSectionLength(frameBuffer: ByteBuffer) =
        frameBuffer.getShort(POSITIONS.frameHeaderDataLength)

    private fun isChecksumsEnabled(frameBuffer: ByteBuffer) =
        readControlBytes(frameBuffer)
            .let { it[1].toInt() == 17 }

    private fun readControlBytes(frameBuffer: ByteBuffer) =
        ByteArray(SIZES.frameHeaderControlBytes)
            .also {
                frameBuffer
                    .position(POSITIONS.frameHeaderControlBytes)
                    .get(it, 0, SIZES.frameHeaderControlBytes)
            }


    private fun readTimestamp(frameBuffer: ByteBuffer) =
         Instant.ofEpochSecond(
            frameBuffer.getLong(POSITIONS.frameHeaderTimestampEpochSeconds),
            frameBuffer.getInt(POSITIONS.frameHeaderTimestampEpochNanos).toLong())
}
