package de.jnkconsulting.e3dc.easyrscp.frame

import de.jnkconsulting.e3dc.easyrscp.api.bytes.toHexString
import de.jnkconsulting.e3dc.easyrscp.api.frame.*
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.Instant

class RSCPDataBuilderTest {

    @Nested
    inner class BooleanTests {
        @Test
        fun `test build with true`() {
            val expected = "01008603010100ff"
            val result = DataBuilder()
                .tag(BatTag.DEVICE_CONNECTED)
                .bool(true)
                .build()

            assertEquals(BatTag.DEVICE_CONNECTED, result.tagObject())
            assertEquals(DataType.BOOL, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }

        @Test
        fun `test build with false`() {
            val expected = "0100860301010000"
            val result = DataBuilder()
                .tag(BatTag.DEVICE_CONNECTED)
                .bool(false)
                .build()

            assertEquals(BatTag.DEVICE_CONNECTED, result.tagObject())
            assertEquals(DataType.BOOL, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }
    }

    @Nested
    inner class NoneTests {
        @Test
        fun `test build with none`() {
            val expected = "08000003000000"
            val result = DataBuilder()
                .tag(BatTag.REQ_CHARGE_CYCLES)
                .none()
                .build()

            assertEquals(BatTag.REQ_CHARGE_CYCLES, result.tagObject())
            assertEquals(DataType.NONE, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }
    }

    @Nested
    inner class TimestampTests {
        @Test
        fun `test build with timestamp`() {
            val expected = "0e00800a0f0c002b6adf640000000000000000"
            val result = DataBuilder()
                .tag(InfoTag.TIME)
                .timestamp(Instant.ofEpochSecond(1692363307))
                .build()

            assertEquals(InfoTag.TIME, result.tagObject())
            assertEquals(DataType.TIMESTAMP, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }

        @Test
        fun `test build with duration`() {
            val expected = "0e00800a0f0c002b6adf640000000000000000"
            val result = DataBuilder()
                .tag(InfoTag.TIME)
                .timestamp(Duration.ofSeconds(1692363307))
                .build()

            assertEquals(InfoTag.TIME, result.tagObject())
            assertEquals(DataType.TIMESTAMP, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }
    }

    @Nested
    inner class CharTests {
        @Test
        fun `test build with char8`() {
            val expected = "0401800102010012"
            val result = DataBuilder()
                .tag(EMSTag.RES_POWERSAVE_ENABLED)
                .char8(0x12)
                .build()

            assertEquals(EMSTag.RES_POWERSAVE_ENABLED, result.tagObject())
            assertEquals(DataType.CHAR8, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }

        @Test
        fun `test build with uchar8`() {
            val expected = "0800800103010012"
            val result = DataBuilder()
                .tag(EMSTag.BAT_SOC)
                .uchar8(0x12)
                .build()

            assertEquals(EMSTag.BAT_SOC, result.tagObject())
            assertEquals(DataType.UCHAR8, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }
    }

    @Nested
    inner class ShortTests {
        @Test
        fun `test build with int16`() {
            val expected = "010004030402006400"
            val result = DataBuilder()
                .tag(BatTag.INDEX)
                .int16(100)
                .build()

            assertEquals(BatTag.INDEX, result.tagObject())
            assertEquals(DataType.INT16, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }

        @Test
        fun `test build with uint16`() {
            val expected = "010004030502006400"
            val result = DataBuilder()
                .tag(BatTag.INDEX)
                .uint16(100)
                .build()

            assertEquals(BatTag.INDEX, result.tagObject())
            assertEquals(DataType.UINT16, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }
    }

    @Nested
    inner class IntTests {
        @Test
        fun `test build with int32`() {
            val expected = "420080010604005c040000"
            val result = DataBuilder()
                .tag(EMSTag.BAT_CHARGE_LIMIT)
                .int32(1116)
                .build()

            assertEquals(EMSTag.BAT_CHARGE_LIMIT, result.tagObject())
            assertEquals(DataType.INT32, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }

        @Test
        fun `test build with uint32`() {
            val expected = "030100010704005c040000"
            val result = DataBuilder()
                .tag(EMSTag.DISCHARGE_START_POWER)
                .uint32(1116)
                .build()

            assertEquals(EMSTag.DISCHARGE_START_POWER, result.tagObject())
            assertEquals(DataType.UINT32, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }
    }

    @Nested
    inner class LongTests {
        @Test
        fun `test build with int64`() {
            val expected = "01018003080800ffffffffffffff7f"
            val result = DataBuilder()
                .tag(BatTag.DCB_LAST_MESSAGE_TIMESTAMP)
                .int64(Long.MAX_VALUE)
                .build()

            assertEquals(BatTag.DCB_LAST_MESSAGE_TIMESTAMP, result.tagObject())
            assertEquals(DataType.INT64, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }

        @Test
        fun `test build with uint64`() {
            val expected = "01018003090800ffffffffffffff7f"
            val result = DataBuilder()
                .tag(BatTag.DCB_LAST_MESSAGE_TIMESTAMP)
                .uint64(Long.MAX_VALUE)
                .build()

            assertEquals(BatTag.DCB_LAST_MESSAGE_TIMESTAMP, result.tagObject())
            assertEquals(DataType.UINT64, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }
    }

    @Nested
    inner class FloatTests {
        @Test
        fun `test build with float32`() {
            val expected = "030080030a040033339c43"
            val result = DataBuilder()
                .tag(BatTag.CURRENT)
                .float32(312.4f)
                .build()

            assertEquals(BatTag.CURRENT, result.tagObject())
            assertEquals(DataType.FLOAT32, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }
    }

    @Nested
    inner class DoubleTests {
        @Test
        fun `test build with double64`() {
            val expected = "060080050b08003f355eba71111341"
            val result = DataBuilder()
                .tag(PMTag.ENERGY_L1)
                .double64(312412.432)
                .build()

            assertEquals(PMTag.ENERGY_L1, result.tagObject())
            assertEquals(DataType.DOUBLE64, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }
    }

    @Nested
    inner class BitfieldTests {
        @Test
        fun `test build with bitfield`() {
            val expected = "0a0080030c010001"
            val result = DataBuilder()
                .tag(BatTag.STATUS_CODE)
                .bitfield(0x01)
                .build()

            assertEquals(BatTag.STATUS_CODE, result.tagObject())
            assertEquals(DataType.BITFIELD, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }
    }

    @Nested
    inner class StringTests {
        @Test
        fun `test build with bitfield`() {
            val expected = "0c0080030d180045787472656d6520706f77657266756c2062617474657279"
            val result = DataBuilder()
                .tag(BatTag.DEVICE_NAME)
                .string("Extreme powerful battery")
                .build()

            assertEquals(BatTag.DEVICE_NAME, result.tagObject())
            assertEquals(DataType.STRING, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }
    }

    @Nested
    inner class ByteArrayTests {
        @Test
        fun `test build with bytearray`() {
            val expected = "1020040e100300010567"
            val result = DataBuilder()
                .tag(WBTag.EXTERN_DATA)
                .bytearray(byteArrayOf(0x01, 0x05, 0x67))
                .build()

            assertEquals(WBTag.EXTERN_DATA, result.tagObject())
            assertEquals(DataType.BYTEARRAY, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }
    }

    @Nested
    inner class ContainerTests {
        @Test
        fun `test build with some container data`() {
            val expected = "000004030e22000c0080030d040074657374030080030b08005c8fc2f5983be0400100860301010000"
            val result = DataBuilder()
                .tag(BatTag.REQ_DATA)
                .container(
                    listOf(
                        DataBuilder().tag(BatTag.DEVICE_NAME).string("test").build(),
                        DataBuilder().tag(BatTag.CURRENT).double64(33244.78).build(),
                        DataBuilder().tag(BatTag.DEVICE_CONNECTED).bool(false).build()
                    )
                )
                .build()

            assertEquals(BatTag.REQ_DATA, result.tagObject())
            assertEquals(DataType.CONTAINER, result.typeObject())
            assertEquals(expected, result.asByteArray().toHexString())
        }
    }
}

