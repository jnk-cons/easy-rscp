package de.jnkconsulting.e3dc.easyrscp.frame

import de.jnkconsulting.e3dc.easyrscp.api.bytes.fromHexString
import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.UnknownTag
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.BatTag
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class DefaultWBExternalDataParserTest {

    private val toTest = DefaultWBExternalDataParser(DefaultDataParser())

    @Test
    fun `test parsing green`() {
        val input = DataBuilder()
            .tag(WBTag.EXTERN_DATA_SUN)
            .container(
                DataBuilder().tag(WBTag.EXTERN_DATA_LEN).int32(8).build(),
                DataBuilder().tag(WBTag.EXTERN_DATA).bytearray("f104522f00000000".fromHexString()).build(),
            )
            .build()

        val result = toTest.parseEnergyData(input)

        Assertions.assertEquals(1265, result.powerW)
    }

    @Test
    fun `test IllegalArgumentException is thrown if tag is not supported`() {
        val input = DataBuilder()
            .tag(WBTag.DEVICE_NAME)
            .container(
                DataBuilder().tag(WBTag.EXTERN_DATA_LEN).int32(8).build(),
                DataBuilder().tag(WBTag.EXTERN_DATA).bytearray("f104522f00000000".fromHexString()).build(),
            )
            .build()

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            toTest.parseEnergyData(input)
        }
    }

    @Test
    fun `test IllegalArgumentException is thrown if EXTERN_DATA block is missing`() {
        val input = DataBuilder()
            .tag(WBTag.EXTERN_DATA_SUN)
            .container(
                DataBuilder().tag(WBTag.EXTERN_DATA_LEN).int32(8).build()
            )
            .build()

        Assertions.assertThrows(IllegalArgumentException::class.java) {
            toTest.parseEnergyData(input)
        }
    }
}
