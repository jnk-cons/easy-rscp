package de.jnkconsulting.e3dc.easyrscp.frame

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.BatTag
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.Instant

class DefaultFrameParserTest {
    private val timestamp = Instant.ofEpochSecond(1692363307)

    @Nested
    inner class WithChecksumEnabled {
        @Test
        fun `test parsing of a frame with one data sections`() {
            val data = DataBuilder()
                .tag(BatTag.DEVICE_CONNECTED)
                .bool(true)
                .build()

            val frame = FrameBuilder()
                .timestamp(timestamp)
                .enableChecksum()
                .addData(data)
                .build()

            val asBytes = frame.asByteArray()
            val parsingResult = DefaultFrameParser(DefaultDataParser()).parseRSCPFrame(asBytes)

            Assertions.assertArrayEquals(asBytes, parsingResult.asByteArray())
        }

        @Test
        fun `test parsing of three data sections`() {

            val data1 = DataBuilder()
                .tag(BatTag.DEVICE_CONNECTED)
                .bool(true)
                .build()

            val data2 = DataBuilder()
                .tag(BatTag.INDEX)
                .int16(100)
                .build()

            val data3 = DataBuilder()
                .tag(BatTag.DEVICE_NAME)
                .string("Extreme powerful battery")
                .build()

            val frame = FrameBuilder()
                .timestamp(timestamp)
                .enableChecksum()
                .addData(data1, data2, data3)
                .build()

            val asBytes = frame.asByteArray()
            val parsingResult = DefaultFrameParser(DefaultDataParser()).parseRSCPFrame(asBytes)

            Assertions.assertArrayEquals(asBytes, parsingResult.asByteArray())
        }
    }

    @Nested
    inner class WithChecksumDisabled {
        @Test
        fun `test parsing of a frame with one data sections`() {
            val data = DataBuilder()
                .tag(BatTag.DEVICE_CONNECTED)
                .bool(true)
                .build()

            val frame = FrameBuilder()
                .timestamp(timestamp)
                .disableChecksum()
                .addData(data)
                .build()

            val asBytes = frame.asByteArray()
            val parsingResult = DefaultFrameParser(DefaultDataParser()).parseRSCPFrame(asBytes)

            Assertions.assertArrayEquals(asBytes, parsingResult.asByteArray())
        }

        @Test
        fun `test parsing of three data sections`() {

            val data1 = DataBuilder()
                .tag(BatTag.DEVICE_CONNECTED)
                .bool(true)
                .build()

            val data2 = DataBuilder()
                .tag(BatTag.INDEX)
                .int16(100)
                .build()

            val data3 = DataBuilder()
                .tag(BatTag.DEVICE_NAME)
                .string("Extreme powerful battery")
                .build()

            val frame = FrameBuilder()
                .timestamp(timestamp)
                .disableChecksum()
                .addData(data1, data2, data3)
                .build()

            val asBytes = frame.asByteArray()
            val parsingResult = DefaultFrameParser(DefaultDataParser()).parseRSCPFrame(asBytes)

            Assertions.assertArrayEquals(asBytes, parsingResult.asByteArray())
        }
    }


}
