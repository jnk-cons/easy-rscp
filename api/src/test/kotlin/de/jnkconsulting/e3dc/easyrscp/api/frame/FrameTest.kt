package de.jnkconsulting.e3dc.easyrscp.api.frame

import de.jnkconsulting.e3dc.easyrscp.api.bytes.FIXED_VALUES
import de.jnkconsulting.e3dc.easyrscp.api.bytes.SIZES
import de.jnkconsulting.e3dc.easyrscp.api.bytes.emptyByteBuffer
import de.jnkconsulting.e3dc.easyrscp.api.bytes.toHexString
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.BatTag
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.DBTag
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ResultCode
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.time.Duration
import java.time.Instant


class FrameTest {

    private val timestamp = Instant.ofEpochSecond(1692363307)
    private val dataParser = mockk<DataParser>()


    @Nested
    inner class DataByTagTests {

        @Test
        fun `test finds toplevel data`() {
            val targetData = Data(BatTag.DEVICE_NAME, DataType.STRING, "test".toByteArray())
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    targetData
                ),
                parser = dataParser,
            )

            val result = toTest.dataByTag(BatTag.DEVICE_NAME)
            Assertions.assertEquals(targetData, result)
        }

        @Test
        fun `tests finds data level 1`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DEVICE_NAME, DataType.STRING, "test".toByteArray())
            val containerBytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerBytes) } returns listOf(pv, targetData)

            val container = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerBytes)
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    container
                ),
                parser = dataParser,
            )

            val result = toTest.dataByTag(BatTag.DEVICE_NAME, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(targetData, result)
        }

        @Test
        fun `tests finds data level 2`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DEVICE_NAME, DataType.STRING, "test".toByteArray())
            val containerLevel2Bytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerLevel2Bytes) } returns listOf(pv, targetData)
            val containerLevel2 = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerLevel2Bytes)

            val grid = Data(EMSTag.POWER_GRID, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(33).array())
            val containerLevel1Bytes = grid.asByteArray() + containerLevel2.asByteArray()
            val containerLevel1 = Data(DBTag.HISTORY_DATA_WEEK, DataType.CONTAINER, containerLevel1Bytes)
            every { dataParser.parseRSCPData(containerLevel1Bytes) } returns listOf(grid, containerLevel2)

            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    containerLevel1
                ),
                parser = dataParser,
            )

            val result = toTest.dataByTag(BatTag.DEVICE_NAME, DBTag.HISTORY_DATA_WEEK, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(targetData, result)
        }
    }

    @Nested
    inner class IntByTagTests {

        @Test
        fun `test finds toplevel data`() {
            val targetData = Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(5).array())
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    targetData
                ),
                parser = dataParser,
            )

            val result = toTest.intByTag(BatTag.DCB_INDEX)
            Assertions.assertEquals(5, result)
        }

        @Test
        fun `tests finds data level 1`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(5).array())
            val containerBytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerBytes) } returns listOf(pv, targetData)

            val container = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerBytes)
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    container
                ),
                parser = dataParser,
            )

            val result = toTest.intByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(5, result)
        }

        @Test
        fun `tests finds data level 2`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(5).array())
            val containerLevel2Bytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerLevel2Bytes) } returns listOf(pv, targetData)
            val containerLevel2 = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerLevel2Bytes)

            val grid = Data(EMSTag.POWER_GRID, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(33).array())
            val containerLevel1Bytes = grid.asByteArray() + containerLevel2.asByteArray()
            val containerLevel1 = Data(DBTag.HISTORY_DATA_WEEK, DataType.CONTAINER, containerLevel1Bytes)
            every { dataParser.parseRSCPData(containerLevel1Bytes) } returns listOf(grid, containerLevel2)

            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    containerLevel1
                ),
                parser = dataParser,
            )

            val result = toTest.intByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_WEEK, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(5, result)
        }

        @Test
        fun `tests that 0 is returned, if not found`() {
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(5).array())
                ),
                parser = dataParser,
            )

            val result = toTest.intByTag(BatTag.INFO)
            Assertions.assertEquals(0, result)
        }
    }

    @Nested
    inner class ShortByTagTests {

        @Test
        fun `test finds toplevel data`() {
            val targetData = Data(BatTag.DCB_INDEX, DataType.INT16, emptyByteBuffer(Short.SIZE_BYTES).putShort(5).array())
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    targetData
                ),
                parser = dataParser,
            )

            val result = toTest.shortByTag(BatTag.DCB_INDEX)
            Assertions.assertEquals(5.toShort(), result)
        }

        @Test
        fun `tests finds data level 1`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.INT16, emptyByteBuffer(Short.SIZE_BYTES).putShort(5).array())
            val containerBytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerBytes) } returns listOf(pv, targetData)

            val container = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerBytes)
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    container
                ),
                parser = dataParser,
            )

            val result = toTest.shortByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(5.toShort(), result)
        }

        @Test
        fun `tests finds data level 2`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.INT16, emptyByteBuffer(Short.SIZE_BYTES).putShort(5).array())
            val containerLevel2Bytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerLevel2Bytes) } returns listOf(pv, targetData)
            val containerLevel2 = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerLevel2Bytes)

            val grid = Data(EMSTag.POWER_GRID, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(33).array())
            val containerLevel1Bytes = grid.asByteArray() + containerLevel2.asByteArray()
            val containerLevel1 = Data(DBTag.HISTORY_DATA_WEEK, DataType.CONTAINER, containerLevel1Bytes)
            every { dataParser.parseRSCPData(containerLevel1Bytes) } returns listOf(grid, containerLevel2)

            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    containerLevel1
                ),
                parser = dataParser,
            )

            val result = toTest.shortByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_WEEK, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(5.toShort(), result)
        }

        @Test
        fun `tests that 0 is returned, if not found`() {
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(5).array())
                ),
                parser = dataParser,
            )

            val result = toTest.shortByTag(BatTag.INFO)
            Assertions.assertEquals(0.toShort(), result)
        }
    }

    @Nested
    inner class ByteByTagTests {

        @Test
        fun `test finds toplevel data`() {
            val targetData = Data(BatTag.DCB_INDEX, DataType.UCHAR8, emptyByteBuffer(Byte.SIZE_BYTES).put(5.toByte()).array())
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    targetData
                ),
                parser = dataParser,
            )

            val result = toTest.byteByTag(BatTag.DCB_INDEX)
            Assertions.assertEquals(5.toByte(), result)
        }

        @Test
        fun `tests finds data level 1`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.UCHAR8, emptyByteBuffer(Byte.SIZE_BYTES).put(5.toByte()).array())
            val containerBytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerBytes) } returns listOf(pv, targetData)

            val container = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerBytes)
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    container
                ),
                parser = dataParser,
            )

            val result = toTest.byteByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(5.toByte(), result)
        }

        @Test
        fun `tests finds data level 2`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.UCHAR8, emptyByteBuffer(Byte.SIZE_BYTES).put(5.toByte()).array())
            val containerLevel2Bytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerLevel2Bytes) } returns listOf(pv, targetData)
            val containerLevel2 = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerLevel2Bytes)

            val grid = Data(EMSTag.POWER_GRID, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(33).array())
            val containerLevel1Bytes = grid.asByteArray() + containerLevel2.asByteArray()
            val containerLevel1 = Data(DBTag.HISTORY_DATA_WEEK, DataType.CONTAINER, containerLevel1Bytes)
            every { dataParser.parseRSCPData(containerLevel1Bytes) } returns listOf(grid, containerLevel2)

            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    containerLevel1
                ),
                parser = dataParser,
            )

            val result = toTest.byteByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_WEEK, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(5.toByte(), result)
        }

        @Test
        fun `tests that 0 is returned, if not found`() {
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(5).array())
                ),
                parser = dataParser,
            )

            val result = toTest.byteByTag(BatTag.INFO)
            Assertions.assertEquals(0.toByte(), result)
        }
    }

    @Nested
    inner class LongByTagTests {

        @Test
        fun `test finds toplevel data`() {
            val targetData = Data(BatTag.DCB_INDEX, DataType.INT64, emptyByteBuffer(Long.SIZE_BYTES).putLong(5.toLong()).array())
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    targetData
                ),
                parser = dataParser,
            )

            val result = toTest.longByTag(BatTag.DCB_INDEX)
            Assertions.assertEquals(5.toLong(), result)
        }

        @Test
        fun `tests finds data level 1`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.INT64, emptyByteBuffer(Long.SIZE_BYTES).putLong(5.toLong()).array())
            val containerBytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerBytes) } returns listOf(pv, targetData)

            val container = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerBytes)
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    container
                ),
                parser = dataParser,
            )

            val result = toTest.longByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(5.toLong(), result)
        }

        @Test
        fun `tests finds data level 2`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.INT64, emptyByteBuffer(Long.SIZE_BYTES).putLong(5.toLong()).array())
            val containerLevel2Bytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerLevel2Bytes) } returns listOf(pv, targetData)
            val containerLevel2 = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerLevel2Bytes)

            val grid = Data(EMSTag.POWER_GRID, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(33).array())
            val containerLevel1Bytes = grid.asByteArray() + containerLevel2.asByteArray()
            val containerLevel1 = Data(DBTag.HISTORY_DATA_WEEK, DataType.CONTAINER, containerLevel1Bytes)
            every { dataParser.parseRSCPData(containerLevel1Bytes) } returns listOf(grid, containerLevel2)

            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    containerLevel1
                ),
                parser = dataParser,
            )

            val result = toTest.longByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_WEEK, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(5.toLong(), result)
        }

        @Test
        fun `tests that 0 is returned, if not found`() {
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(5).array())
                ),
                parser = dataParser,
            )

            val result = toTest.longByTag(BatTag.INFO)
            Assertions.assertEquals(0.toLong(), result)
        }
    }

    @Nested
    inner class FloatByTagTests {

        @Test
        fun `test finds toplevel data`() {
            val targetData = Data(BatTag.DCB_INDEX, DataType.FLOAT32, emptyByteBuffer(Float.SIZE_BYTES).putFloat(5.2f).array())
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    targetData
                ),
                parser = dataParser,
            )

            val result = toTest.floatByTag(BatTag.DCB_INDEX)
            Assertions.assertEquals(5.2f, result)
        }

        @Test
        fun `tests finds data level 1`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.FLOAT32, emptyByteBuffer(Float.SIZE_BYTES).putFloat(5.2f).array())
            val containerBytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerBytes) } returns listOf(pv, targetData)

            val container = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerBytes)
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    container
                ),
                parser = dataParser,
            )

            val result = toTest.floatByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(5.2f, result)
        }

        @Test
        fun `tests finds data level 2`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.FLOAT32, emptyByteBuffer(Float.SIZE_BYTES).putFloat(5.2f).array())
            val containerLevel2Bytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerLevel2Bytes) } returns listOf(pv, targetData)
            val containerLevel2 = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerLevel2Bytes)

            val grid = Data(EMSTag.POWER_GRID, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(33).array())
            val containerLevel1Bytes = grid.asByteArray() + containerLevel2.asByteArray()
            val containerLevel1 = Data(DBTag.HISTORY_DATA_WEEK, DataType.CONTAINER, containerLevel1Bytes)
            every { dataParser.parseRSCPData(containerLevel1Bytes) } returns listOf(grid, containerLevel2)

            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    containerLevel1
                ),
                parser = dataParser,
            )

            val result = toTest.floatByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_WEEK, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(5.2f, result)
        }

        @Test
        fun `tests that 0 is returned, if not found`() {
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(5).array())
                ),
                parser = dataParser,
            )

            val result = toTest.floatByTag(BatTag.INFO)
            Assertions.assertEquals(0.0f, result)
        }
    }

    @Nested
    inner class DoubleByTagTests {

        @Test
        fun `test finds toplevel data`() {
            val targetData = Data(BatTag.DCB_INDEX, DataType.DOUBLE64, emptyByteBuffer(Double.SIZE_BYTES).putDouble(5.2).array())
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    targetData
                ),
                parser = dataParser,
            )

            val result = toTest.doubleByTag(BatTag.DCB_INDEX)
            Assertions.assertEquals(5.2, result)
        }

        @Test
        fun `tests finds data level 1`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.DOUBLE64, emptyByteBuffer(Double.SIZE_BYTES).putDouble(5.2).array())
            val containerBytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerBytes) } returns listOf(pv, targetData)

            val container = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerBytes)
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    container
                ),
                parser = dataParser,
            )

            val result = toTest.doubleByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(5.2, result)
        }

        @Test
        fun `tests finds data level 2`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.DOUBLE64, emptyByteBuffer(Double.SIZE_BYTES).putDouble(5.2).array())
            val containerLevel2Bytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerLevel2Bytes) } returns listOf(pv, targetData)
            val containerLevel2 = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerLevel2Bytes)

            val grid = Data(EMSTag.POWER_GRID, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(33).array())
            val containerLevel1Bytes = grid.asByteArray() + containerLevel2.asByteArray()
            val containerLevel1 = Data(DBTag.HISTORY_DATA_WEEK, DataType.CONTAINER, containerLevel1Bytes)
            every { dataParser.parseRSCPData(containerLevel1Bytes) } returns listOf(grid, containerLevel2)

            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    containerLevel1
                ),
                parser = dataParser,
            )

            val result = toTest.doubleByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_WEEK, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(5.2, result)
        }

        @Test
        fun `tests that 0 is returned, if not found`() {
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(5).array())
                ),
                parser = dataParser,
            )

            val result = toTest.doubleByTag(BatTag.INFO)
            Assertions.assertEquals(0.0, result)
        }
    }

    @Nested
    inner class BooleanByTagTests {

        @Test
        fun `test finds toplevel data`() {
            val targetData = Data(BatTag.DCB_INDEX, DataType.BOOL, ByteArray(1).also { it[0] = 1.toByte() })
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    targetData
                ),
                parser = dataParser,
            )

            val result = toTest.booleanByTag(BatTag.DCB_INDEX)
            Assertions.assertTrue(result)
        }

        @Test
        fun `tests finds data level 1`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.BOOL, ByteArray(1).also { it[0] = 1.toByte() })
            val containerBytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerBytes) } returns listOf(pv, targetData)

            val container = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerBytes)
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    container
                ),
                parser = dataParser,
            )

            val result = toTest.booleanByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_DAY)
            Assertions.assertTrue(result)
        }

        @Test
        fun `tests finds data level 2`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.BOOL, ByteArray(1).also { it[0] = 1.toByte() })
            val containerLevel2Bytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerLevel2Bytes) } returns listOf(pv, targetData)
            val containerLevel2 = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerLevel2Bytes)

            val grid = Data(EMSTag.POWER_GRID, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(33).array())
            val containerLevel1Bytes = grid.asByteArray() + containerLevel2.asByteArray()
            val containerLevel1 = Data(DBTag.HISTORY_DATA_WEEK, DataType.CONTAINER, containerLevel1Bytes)
            every { dataParser.parseRSCPData(containerLevel1Bytes) } returns listOf(grid, containerLevel2)

            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    containerLevel1
                ),
                parser = dataParser,
            )

            val result = toTest.booleanByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_WEEK, DBTag.HISTORY_DATA_DAY)
            Assertions.assertTrue(result)
        }

        @Test
        fun `tests that 0 is returned, if not found`() {
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(5).array())
                ),
                parser = dataParser,
            )

            val result = toTest.booleanByTag(BatTag.INFO)
            Assertions.assertFalse(result)
        }
    }

    @Nested
    inner class ContainerByTagTests {

        @Test
        fun `test finds toplevel data`() {
            val targetData = Data(BatTag.DCB_INDEX, DataType.CONTAINER, "dummy".toByteArray())
            val expected = listOf<Data>()
            every { dataParser.parseRSCPData("dummy".toByteArray()) } returns expected
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    targetData
                ),
                parser = dataParser,
            )

            val result = toTest.containerByTag(BatTag.DCB_INDEX)
            Assertions.assertEquals(expected, result)
        }

        @Test
        fun `tests finds data level 1`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.CONTAINER, "dummy".toByteArray())
            val expected = listOf<Data>()
            every { dataParser.parseRSCPData("dummy".toByteArray()) } returns expected
            val containerBytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerBytes) } returns listOf(pv, targetData)

            val container = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerBytes)
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    container
                ),
                parser = dataParser,
            )

            val result = toTest.containerByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(expected, result)
        }

        @Test
        fun `tests finds data level 2`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.CONTAINER, "dummy".toByteArray())
            val expected = listOf<Data>()
            every { dataParser.parseRSCPData("dummy".toByteArray()) } returns expected
            val containerLevel2Bytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerLevel2Bytes) } returns listOf(pv, targetData)
            val containerLevel2 = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerLevel2Bytes)

            val grid = Data(EMSTag.POWER_GRID, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(33).array())
            val containerLevel1Bytes = grid.asByteArray() + containerLevel2.asByteArray()
            val containerLevel1 = Data(DBTag.HISTORY_DATA_WEEK, DataType.CONTAINER, containerLevel1Bytes)
            every { dataParser.parseRSCPData(containerLevel1Bytes) } returns listOf(grid, containerLevel2)

            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    containerLevel1
                ),
                parser = dataParser,
            )

            val result = toTest.containerByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_WEEK, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(expected, result)
        }

        @Test
        fun `tests that an empty list is returned, if not found`() {
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(5).array())
                ),
                parser = dataParser,
            )

            val result = toTest.containerByTag(BatTag.INFO)
            Assertions.assertTrue(result.isEmpty())
        }
    }

    @Nested
    inner class StringByTagTests {

        @Test
        fun `test finds toplevel data`() {
            val targetData = Data(BatTag.DCB_INDEX, DataType.STRING, "test".toByteArray())
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    targetData
                ),
                parser = dataParser,
            )

            val result = toTest.stringByTag(BatTag.DCB_INDEX)
            Assertions.assertEquals("test", result)
        }

        @Test
        fun `tests finds data level 1`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.STRING, "test".toByteArray())
            val containerBytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerBytes) } returns listOf(pv, targetData)

            val container = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerBytes)
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    container
                ),
                parser = dataParser,
            )

            val result = toTest.stringByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals("test", result)
        }

        @Test
        fun `tests finds data level 2`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.STRING, "test".toByteArray())
            val containerLevel2Bytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerLevel2Bytes) } returns listOf(pv, targetData)
            val containerLevel2 = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerLevel2Bytes)

            val grid = Data(EMSTag.POWER_GRID, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(33).array())
            val containerLevel1Bytes = grid.asByteArray() + containerLevel2.asByteArray()
            val containerLevel1 = Data(DBTag.HISTORY_DATA_WEEK, DataType.CONTAINER, containerLevel1Bytes)
            every { dataParser.parseRSCPData(containerLevel1Bytes) } returns listOf(grid, containerLevel2)

            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    containerLevel1
                ),
                parser = dataParser,
            )

            val result = toTest.stringByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_WEEK, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals("test", result)
        }

        @Test
        fun `tests that the empty String is returned, if not found`() {
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(5).array())
                ),
                parser = dataParser,
            )

            val result = toTest.stringByTag(BatTag.INFO)
            Assertions.assertEquals("", result)
        }
    }

    @Nested
    inner class InstantByTagTests {

        private val timestampValue: ByteArray = emptyByteBuffer(SIZES.timestampEpochSeconds + SIZES.timestampEpochNanos)
            .putLong(timestamp.epochSecond)
            .putInt(timestamp.nano)
            .array()

        @Test
        fun `test finds toplevel data`() {
            val targetData = Data(BatTag.DCB_INDEX, DataType.TIMESTAMP, timestampValue)
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    targetData
                ),
                parser = dataParser,
            )

            val result = toTest.instantByTag(BatTag.DCB_INDEX)
            Assertions.assertEquals(timestamp, result)
        }

        @Test
        fun `tests finds data level 1`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.TIMESTAMP, timestampValue)
            val containerBytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerBytes) } returns listOf(pv, targetData)

            val container = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerBytes)
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    container
                ),
                parser = dataParser,
            )

            val result = toTest.instantByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(timestamp, result)
        }

        @Test
        fun `tests finds data level 2`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.TIMESTAMP, timestampValue)
            val containerLevel2Bytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerLevel2Bytes) } returns listOf(pv, targetData)
            val containerLevel2 = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerLevel2Bytes)

            val grid = Data(EMSTag.POWER_GRID, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(33).array())
            val containerLevel1Bytes = grid.asByteArray() + containerLevel2.asByteArray()
            val containerLevel1 = Data(DBTag.HISTORY_DATA_WEEK, DataType.CONTAINER, containerLevel1Bytes)
            every { dataParser.parseRSCPData(containerLevel1Bytes) } returns listOf(grid, containerLevel2)

            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    containerLevel1
                ),
                parser = dataParser,
            )

            val result = toTest.instantByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_WEEK, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(timestamp, result)
        }

        @Test
        fun `tests that now() is returned, if not found`() {
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(5).array())
                ),
                parser = dataParser,
            )

            val result = toTest.instantByTag(BatTag.INFO)
            val now = Instant.now()
            val lowerBound: Instant = now.minus(Duration.ofMinutes(1))
            val upperBound: Instant = now.plus(Duration.ofMinutes(1))
            Assertions.assertTrue(result.isAfter(lowerBound) && result.isBefore(upperBound))
        }
    }

    @Nested
    inner class DurationByTagTests {

        private val timestampValue: ByteArray = emptyByteBuffer(SIZES.timestampEpochSeconds + SIZES.timestampEpochNanos)
            .putLong(timestamp.epochSecond)
            .putInt(timestamp.nano)
            .array()

        private val expectedDuration = Duration.ofSeconds(timestamp.epochSecond, timestamp.nano.toLong())

        @Test
        fun `test finds toplevel data`() {
            val targetData = Data(BatTag.DCB_INDEX, DataType.TIMESTAMP, timestampValue)
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    targetData
                ),
                parser = dataParser,
            )

            val result = toTest.durationByTag(BatTag.DCB_INDEX)
            Assertions.assertEquals(expectedDuration, result)
        }

        @Test
        fun `tests finds data level 1`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.TIMESTAMP, timestampValue)
            val containerBytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerBytes) } returns listOf(pv, targetData)

            val container = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerBytes)
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    container
                ),
                parser = dataParser,
            )

            val result = toTest.durationByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(expectedDuration, result)
        }

        @Test
        fun `tests finds data level 2`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.TIMESTAMP, timestampValue)
            val containerLevel2Bytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerLevel2Bytes) } returns listOf(pv, targetData)
            val containerLevel2 = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerLevel2Bytes)

            val grid = Data(EMSTag.POWER_GRID, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(33).array())
            val containerLevel1Bytes = grid.asByteArray() + containerLevel2.asByteArray()
            val containerLevel1 = Data(DBTag.HISTORY_DATA_WEEK, DataType.CONTAINER, containerLevel1Bytes)
            every { dataParser.parseRSCPData(containerLevel1Bytes) } returns listOf(grid, containerLevel2)

            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    containerLevel1
                ),
                parser = dataParser,
            )

            val result = toTest.durationByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_WEEK, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(expectedDuration, result)
        }

        @Test
        fun `tests that now() is returned, if not found`() {
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(5).array())
                ),
                parser = dataParser,
            )

            val result = toTest.durationByTag(BatTag.INFO)
            val now = Instant.now()
            val lowerBound: Instant = now.minus(Duration.ofMinutes(1))
            val upperBound: Instant = now.plus(Duration.ofMinutes(1))
            Assertions.assertTrue(result.toMillis() > lowerBound.toEpochMilli() && result.toMillis() < upperBound.toEpochMilli())
        }
    }

    @Nested
    inner class ResultCodeByTagTests {

        @Test
        fun `test finds toplevel data`() {
            val targetData = Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(ResultCode.ACCESS_DENIED.rscpCode).array())
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    targetData
                ),
                parser = dataParser,
            )

            val result = toTest.resultCodeByTag(BatTag.DCB_INDEX)
            Assertions.assertEquals(ResultCode.ACCESS_DENIED, result)
        }

        @Test
        fun `tests finds data level 1`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(ResultCode.ACCESS_DENIED.rscpCode).array())
            val containerBytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerBytes) } returns listOf(pv, targetData)

            val container = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerBytes)
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    container
                ),
                parser = dataParser,
            )

            val result = toTest.resultCodeByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(ResultCode.ACCESS_DENIED, result)
        }

        @Test
        fun `tests finds data level 2`() {
            val pv = Data(EMSTag.POWER_PV, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array())
            val targetData = Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(ResultCode.ACCESS_DENIED.rscpCode).array())
            val containerLevel2Bytes = pv.asByteArray() + targetData.asByteArray()
            every { dataParser.parseRSCPData(containerLevel2Bytes) } returns listOf(pv, targetData)
            val containerLevel2 = Data(DBTag.HISTORY_DATA_DAY, DataType.CONTAINER, containerLevel2Bytes)

            val grid = Data(EMSTag.POWER_GRID, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(33).array())
            val containerLevel1Bytes = grid.asByteArray() + containerLevel2.asByteArray()
            val containerLevel1 = Data(DBTag.HISTORY_DATA_WEEK, DataType.CONTAINER, containerLevel1Bytes)
            every { dataParser.parseRSCPData(containerLevel1Bytes) } returns listOf(grid, containerLevel2)

            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    containerLevel1
                ),
                parser = dataParser,
            )

            val result = toTest.resultCodeByTag(BatTag.DCB_INDEX, DBTag.HISTORY_DATA_WEEK, DBTag.HISTORY_DATA_DAY)
            Assertions.assertEquals(ResultCode.ACCESS_DENIED, result)
        }

        @Test
        fun `tests that UNKNOWN is returned, if not found`() {
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(EMSTag.POWER_HOME, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(12).array()),
                    Data(BatTag.DCB_INDEX, DataType.INT32, emptyByteBuffer(Int.SIZE_BYTES).putInt(5).array())
                ),
                parser = dataParser,
            )

            val result = toTest.resultCodeByTag(BatTag.INFO)
            Assertions.assertEquals(ResultCode.UNKNOWN, result)
        }
    }

    @Nested
    inner class ChecksumTestes {

        @Test
        fun `test that isChecksumEnabled returns true if controlbytes are == 17`() {
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithChecksum,
                data = listOf(
                    Data(BatTag.DEVICE_NAME, DataType.STRING, "test".toByteArray())
                ),
                parser = dataParser,
            )

            Assertions.assertTrue(toTest.isChecksumEnabled())
        }

        @Test
        fun `test that isChecksumEnabled returns false if controlbytes are != 17`() {
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(BatTag.DEVICE_NAME, DataType.STRING, "test".toByteArray())
                ),
                parser = dataParser,
            )

            Assertions.assertFalse(toTest.isChecksumEnabled())
        }

        @Test
        fun `test serialization with checksums enabled`() {
            val expected = "e3dc00112b6adf6400000000000000000b000c0080030d040074657374c36b5a12"
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithChecksum,
                data = listOf(
                    Data(BatTag.DEVICE_NAME, DataType.STRING, "test".toByteArray())
                ),
                parser = dataParser,
            )

            val result = toTest.asByteArray().toHexString()
            Assertions.assertEquals(expected, result)
        }

        @Test
        fun `test serializiation with checksums disabled`() {
            val expected = "e3dc00102b6adf6400000000000000000b000c0080030d040074657374"
            val toTest = Frame(
                timestamp = timestamp,
                controlBytes = FIXED_VALUES.controlBytesWithoutChecksum,
                data = listOf(
                    Data(BatTag.DEVICE_NAME, DataType.STRING, "test".toByteArray())
                ),
                parser = dataParser,
            )

            val result = toTest.asByteArray().toHexString()
            Assertions.assertEquals(expected, result)
        }
    }
}
