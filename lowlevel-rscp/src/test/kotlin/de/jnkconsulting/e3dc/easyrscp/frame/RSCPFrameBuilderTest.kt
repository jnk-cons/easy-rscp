package de.jnkconsulting.e3dc.easyrscp.frame

import de.jnkconsulting.e3dc.easyrscp.api.bytes.FIXED_VALUES
import de.jnkconsulting.e3dc.easyrscp.api.bytes.toHexString
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.BatTag
import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.Instant

class RSCPFrameBuilderTest {

    private val timestamp = Instant.ofEpochSecond(1692363307)

    @Nested
    inner class ChecksumEnabledTests {
        @Test
        fun `test build with single data`() {
            val expected = "e3dc00112b6adf6400000000000000000800010086030101000155519433"
            val singleData = DataBuilder()
                .tag(BatTag.DEVICE_CONNECTED)
                .bool(true)
                .build()

            val result = FrameBuilder()
                .enableChecksum()
                .addData(singleData)
                .timestamp(timestamp)
                .build()

            assertEquals(timestamp, result.timestamp)
            assertArrayEquals(FIXED_VALUES.controlBytesWithChecksum, result.controlBytes)
            assertEquals(1, result.data.size)
            assertEquals(singleData, result.data[0])
            assertEquals(expected, result.asByteArray().toHexString())
        }

        @Test
        fun `test build with multiple data`() {
            val expected = "e3dc00112b6adf640000000000000000300001008603010100010100040304020064000c0080030d180045787472656d6520706f77657266756c2062617474657279e08ab95f"
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

            val result = FrameBuilder()
                .enableChecksum()
                .addData(data1, data2, data3)
                .timestamp(timestamp)
                .build()



            assertEquals(timestamp, result.timestamp)
            assertArrayEquals(FIXED_VALUES.controlBytesWithChecksum, result.controlBytes)
            assertEquals(3, result.data.size)
            assertEquals(data1, result.data[0])
            assertEquals(data2, result.data[1])
            assertEquals(data3, result.data[2])
            assertEquals(expected, result.asByteArray().toHexString())
        }
    }

    @Nested
    inner class ChecksumDisabledTests {
        @Test
        fun `test build with single data`() {
            val expected = "e3dc00102b6adf64000000000000000008000100860301010001"
            val singleData = DataBuilder()
                .tag(BatTag.DEVICE_CONNECTED)
                .bool(true)
                .build()

            val result = FrameBuilder()
                .disableChecksum()
                .addData(singleData)
                .timestamp(timestamp)
                .build()

            assertEquals(timestamp, result.timestamp)
            assertArrayEquals(FIXED_VALUES.controlBytesWithoutChecksum, result.controlBytes)
            assertEquals(1, result.data.size)
            assertEquals(singleData, result.data[0])
            assertEquals(expected, result.asByteArray().toHexString())
        }

        @Test
        fun `test build with multiple data`() {
            val expected = "e3dc00102b6adf640000000000000000300001008603010100010100040304020064000c0080030d180045787472656d6520706f77657266756c2062617474657279"
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

            val result = FrameBuilder()
                .disableChecksum()
                .addData(data1, data2, data3)
                .timestamp(timestamp)
                .build()



            assertEquals(timestamp, result.timestamp)
            assertArrayEquals(FIXED_VALUES.controlBytesWithoutChecksum, result.controlBytes)
            assertEquals(3, result.data.size)
            assertEquals(data1, result.data[0])
            assertEquals(data2, result.data[1])
            assertEquals(data3, result.data[2])
            assertEquals(expected, result.asByteArray().toHexString())
        }
    }

}
