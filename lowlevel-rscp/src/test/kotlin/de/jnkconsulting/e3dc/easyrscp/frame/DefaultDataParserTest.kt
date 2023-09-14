package de.jnkconsulting.e3dc.easyrscp.frame

import de.jnkconsulting.e3dc.easyrscp.api.bytes.fromHexString
import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.UnknownTag
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.BatTag
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DefaultDataParserTest {


    @Test
    fun `test parsing of one data sections`() {
        val data = DataBuilder()
            .tag(BatTag.DEVICE_CONNECTED)
            .bool(true)
            .build()

        val asBytes = data.asByteArray()
        val parsingResult = DefaultDataParser().parseRSCPData(asBytes)

        Assertions.assertArrayEquals(asBytes, parsingResult[0].asByteArray())
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

        val asBytes = data1.asByteArray() + data2.asByteArray() + data3.asByteArray()
        val parsingResult = DefaultDataParser().parseRSCPData(asBytes)

        Assertions.assertArrayEquals(data1.asByteArray(), parsingResult[0].asByteArray())
        Assertions.assertArrayEquals(data2.asByteArray(), parsingResult[1].asByteArray())
        Assertions.assertArrayEquals(data3.asByteArray(), parsingResult[2].asByteArray())
    }

    @Test
    fun `test parsing of unknown tag`() {
        val data = DataBuilder()
            .tag("0x09111111".fromHexString())
            .string("test")
            .build()

        val asBytes = data.asByteArray()
        val parsingResult = DefaultDataParser().parseRSCPData(asBytes)
        Assertions.assertEquals(UnknownTag("0x09111111"), parsingResult[0].tagObject())
        Assertions.assertArrayEquals(asBytes, parsingResult[0].asByteArray())
    }

    @Test
    fun `test parsing of unknown type`() {
        val data = DataBuilder()
            .tag(BatTag.DEVICE_NAME)
            .raw("test".toByteArray(), 0xAA.toByte())
            .build()

        val asBytes = data.asByteArray()
        val parsingResult = DefaultDataParser().parseRSCPData(asBytes)
        Assertions.assertEquals(DataType.UNKNOWN, parsingResult[0].typeObject())
        Assertions.assertArrayEquals(asBytes, parsingResult[0].asByteArray())
    }

}
