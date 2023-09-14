package de.jnkconsulting.e3dc.easyrscp.api.frame

import de.jnkconsulting.e3dc.easyrscp.api.bytes.SIZES
import de.jnkconsulting.e3dc.easyrscp.api.bytes.emptyByteBuffer
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.BatTag
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.InfoTag
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.PMTag
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.Instant

class DataTest {
    @Nested
    inner class ContainerTests {
        private val parserMock = mockk<DataParser>()

        @Test
        fun `test that container data is parsed`() {
            val expectedData = listOf<Data>()
            val fakeContainerData = ByteArray(127)
            val d = Data(BatTag.DATA, DataType.CONTAINER, fakeContainerData)

            every { parserMock.parseRSCPData(fakeContainerData) } returns expectedData

            assertEquals(expectedData, d.valueAsContainer(parserMock))
        }
    }

    @Nested
    inner class BooleanTests {
        @Test
        fun `test that typed value is false`() {
            val d = Data(BatTag.DEVICE_CONNECTED, DataType.BOOL, ByteArray(1).also { it[0] = 0x00})

            assertFalse(d.valueAsBoolean()!!)
        }

        @Test
        fun `test that typed value is true`() {
            val d = Data(BatTag.DEVICE_CONNECTED, DataType.BOOL, ByteArray(1).also { it[0] = 0xFF.toByte()})

            assertTrue(d.valueAsBoolean()!!)
        }

        @Test
        fun `test that null is returned if different type is used`() {
            val d = Data(BatTag.DEVICE_NAME, DataType.STRING, "testMe".toByteArray())

            assertNull(d.valueAsBoolean())
        }
    }

    @Nested
    inner class ByteTests {
        @Test
        fun `test that typed value is returned for signed`() {
            val d = Data(EMSTag.RES_DISCHARGE_START_POWER, DataType.CHAR8, emptyByteBuffer(1).put(0x17).array())

            assertEquals(0x17, d.valueAsByte())
        }

        @Test
        fun `test that typed value is returned for unsigned`() {
            val d = Data(BatTag.DCB_COUNT, DataType.UCHAR8, emptyByteBuffer(1).put(0x17).array())

            assertEquals(0x17, d.valueAsByte())
        }

        @Test
        fun `test that null is returned if different type is used`() {
            val d = Data(BatTag.DEVICE_NAME, DataType.STRING, "testMe".toByteArray())

            assertNull(d.valueAsByte())
        }
    }

    @Nested
    inner class ShortTests {
        @Test
        fun `test that typed value is returned for signed`() {
            val d = Data(EMSTag.RES_DISCHARGE_START_POWER, DataType.INT16, emptyByteBuffer(Short.SIZE_BYTES).putShort(12).array())

            assertEquals(12.toShort(), d.valueAsShort())
        }

        @Test
        fun `test that typed value is returned for unsigned`() {
            val d = Data(BatTag.DCB_INDEX, DataType.UINT16, emptyByteBuffer(Short.SIZE_BYTES).putShort(12).array())

            assertEquals(12.toShort(), d.valueAsShort())
        }

        @Test
        fun `test that null is returned if different type is used`() {
            val d = Data(BatTag.DEVICE_NAME, DataType.STRING, "testMe".toByteArray())

            assertNull(d.valueAsShort())
        }
    }

    @Nested
    inner class IntTests {
        @Test
        fun `test that typed value is returned for signed`() {
            val d = Data(EMSTag.BAT_CHARGE_LIMIT, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(982326).array())

            assertEquals(982326, d.valueAsInt())
        }

        @Test
        fun `test that typed value is returned for unsigned`() {
            val d = Data(BatTag.CHARGE_CYCLES, DataType.UINT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(982326).array())

            assertEquals(982326, d.valueAsInt())
        }

        @Test
        fun `test that null is returned if different type is used`() {
            val d = Data(BatTag.DEVICE_NAME, DataType.STRING, "testMe".toByteArray())

            assertNull(d.valueAsInt())
        }
    }

    @Nested
    inner class LongTests {
        @Test
        fun `test that typed value is returned for signed`() {
            val d = Data(BatTag.DCB_LAST_MESSAGE_TIMESTAMP, DataType.INT64, emptyByteBuffer(Long.SIZE_BYTES).putLong(Long.MAX_VALUE).array())

            assertEquals(Long.MAX_VALUE, d.valueAsLong())
        }

        @Test
        fun `test that typed value is returned for unsigned`() {
            val d = Data(BatTag.DCB_LAST_MESSAGE_TIMESTAMP, DataType.UINT64, emptyByteBuffer(Long.SIZE_BYTES).putLong(Long.MAX_VALUE).array())

            assertEquals(Long.MAX_VALUE, d.valueAsLong())
        }

        @Test
        fun `test that null is returned if different type is used`() {
            val d = Data(BatTag.DEVICE_NAME, DataType.STRING, "testMe".toByteArray())

            assertNull(d.valueAsLong())
        }
    }

    @Nested
    inner class FloatTests {
        @Test
        fun `test that typed value is returned`() {
            val d = Data(BatTag.CURRENT, DataType.FLOAT32, emptyByteBuffer(Float.SIZE_BYTES).putFloat(Float.MAX_VALUE).array())

            assertEquals(Float.MAX_VALUE, d.valueAsFloat())
        }

        @Test
        fun `test that null is returned if different type is used`() {
            val d = Data(BatTag.DEVICE_NAME, DataType.STRING, "testMe".toByteArray())

            assertNull(d.valueAsFloat())
        }
    }

    @Nested
    inner class DoubleTests {
        @Test
        fun `test that typed value is returned`() {
            val d = Data(PMTag.ENERGY_L1, DataType.DOUBLE64, emptyByteBuffer(Double.SIZE_BYTES).putDouble(Double.MAX_VALUE).array())

            assertEquals(Double.MAX_VALUE, d.valueAsDouble())
        }

        @Test
        fun `test that null is returned if different type is used`() {
            val d = Data(BatTag.DEVICE_NAME, DataType.STRING, "testMe".toByteArray())

            assertNull(d.valueAsDouble())
        }
    }

    @Nested
    inner class TimestampTests {
        @Test
        fun `test that typed value is returned as instant`() {
            val ts = Instant.now()
            val d = Data(InfoTag.TIME, DataType.TIMESTAMP,
                emptyByteBuffer(SIZES.timestampEpochSeconds + SIZES.timestampEpochNanos)
                    .putLong(ts.epochSecond)
                    .putInt(ts.nano)
                    .array())

            assertEquals(ts.epochSecond, d.valueAsInstant()!!.epochSecond)
            assertEquals(ts.nano, d.valueAsInstant()!!.nano)
        }

        @Test
        fun `test that typed value is returned as duration`() {
            val ts = Instant.now()
            val d = Data(InfoTag.TIME, DataType.TIMESTAMP,
                emptyByteBuffer(SIZES.timestampEpochSeconds + SIZES.timestampEpochNanos)
                    .putLong(ts.epochSecond)
                    .putInt(ts.nano)
                    .array())

            assertEquals(ts.epochSecond, d.valueAsDuration()!!.seconds)
            assertEquals(ts.nano, d.valueAsDuration()!!.nano)
        }

        @Test
        fun `test that null is returned if different type is used`() {
            val d = Data(BatTag.DEVICE_NAME, DataType.STRING, "testMe".toByteArray())

            assertNull(d.valueAsDouble())
        }
    }

    @Nested
    inner class StringTests {
        @Test
        fun `test that value is returned as string`() {
            val d = Data(BatTag.DEVICE_NAME, DataType.STRING, "test".toByteArray())

            assertEquals("test", d.valueAsString())
        }

        @Test
        fun `test that value is returned as none`() {
            val d = Data(BatTag.DEVICE_NAME, DataType.NONE, ByteArray(0))

            assertEquals("[NONE]", d.valueAsString())
        }

        @Test
        fun `test that value is returned as formatted byte`() {
            val d = Data(EMSTag.RES_DISCHARGE_START_POWER, DataType.CHAR8, emptyByteBuffer(1).put(0x17).array())

            assertEquals("23", d.valueAsString())
        }

        @Test
        fun `test that value is returned as formatted short`() {
            val d = Data(EMSTag.RES_DISCHARGE_START_POWER, DataType.INT16, emptyByteBuffer(Short.SIZE_BYTES).putShort(12).array())

            assertEquals("12", d.valueAsString())
        }

        @Test
        fun `test that value is returned as formatted int`() {
            val d = Data(EMSTag.BAT_CHARGE_LIMIT, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(982326).array())

            assertEquals("982326", d.valueAsString())
        }

        @Test
        fun `test that value is returned as formatted float`() {
            val d = Data(BatTag.CURRENT, DataType.FLOAT32, emptyByteBuffer(Float.SIZE_BYTES).putFloat(12.53f).array())

            assertEquals("12,53", d.valueAsString())
        }

        @Test
        fun `test that value is returned as formatted double`() {
            val d = Data(PMTag.ENERGY_L1, DataType.DOUBLE64, emptyByteBuffer(Double.SIZE_BYTES).putDouble(44.32).array())

            assertEquals("44,32", d.valueAsString())
        }

        @Test
        fun `test that value is returned as container`() {
            val d = Data(PMTag.ENERGY_L1, DataType.CONTAINER, ByteArray(0))

            assertEquals("[CONTAINER]", d.valueAsString())
        }

    }
}
