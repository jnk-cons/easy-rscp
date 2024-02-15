package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.bytes.fromHexString
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.WBTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class WallboxPowerStateConverterTest {
    val toTest = WallboxPowerStateConverter()

    @Test
    fun `test conversion green`() {
        val frame = FrameBuilder()
            .addData(
                DataBuilder().tag(WBTag.DATA).container(
                    DataBuilder().tag(WBTag.INDEX).uchar8(0).build(),
                    DataBuilder().tag(WBTag.EXTERN_DATA_SUN).container(
                        DataBuilder().tag(WBTag.EXTERN_DATA_LEN).int32(8).build(),
                        DataBuilder().tag(WBTag.EXTERN_DATA).bytearray("0000e01f00000000".fromHexString()).build(),
                    ).build(),
                    DataBuilder().tag(WBTag.EXTERN_DATA_ALL).container(
                        DataBuilder().tag(WBTag.EXTERN_DATA_LEN).int32(8).build(),
                        DataBuilder().tag(WBTag.EXTERN_DATA).bytearray("f104522f00000000".fromHexString()).build(),
                    ).build()
                ).build(),
                DataBuilder().tag(WBTag.DATA).container(
                    DataBuilder().tag(WBTag.INDEX).uchar8(1).build(),
                    DataBuilder().tag(WBTag.EXTERN_DATA_SUN).container(
                        DataBuilder().tag(WBTag.EXTERN_DATA_LEN).int32(8).build(),
                        DataBuilder().tag(WBTag.EXTERN_DATA).bytearray("f104522f00000000".fromHexString()).build(),
                    ).build(),
                    DataBuilder().tag(WBTag.EXTERN_DATA_ALL).container(
                        DataBuilder().tag(WBTag.EXTERN_DATA_LEN).int32(8).build(),
                        DataBuilder().tag(WBTag.EXTERN_DATA).bytearray("0000e01f00000000".fromHexString()).build(),
                    ).build()
                ).build(),
            )
            .build()

        val result = toTest.invoke(frame)

        assertEquals(2, result.size)
        assertEquals(0, result[0].id)
        assertEquals(1265, result[0].powerW)
        assertEquals(0, result[0].solarPowerW)

        assertEquals(1, result[1].id)
        assertEquals(0, result[1].powerW)
        assertEquals(1265, result[1].solarPowerW)
    }

    @Test
    fun `test that blocks are skipped if index block is missing`() {
        val frame = FrameBuilder()
            .addData(
                DataBuilder().tag(WBTag.DATA).container(
                    DataBuilder().tag(WBTag.EXTERN_DATA_SUN).container(
                        DataBuilder().tag(WBTag.EXTERN_DATA_LEN).int32(8).build(),
                        DataBuilder().tag(WBTag.EXTERN_DATA).bytearray("0000e01f00000000".fromHexString()).build(),
                    ).build(),
                    DataBuilder().tag(WBTag.EXTERN_DATA_ALL).container(
                        DataBuilder().tag(WBTag.EXTERN_DATA_LEN).int32(8).build(),
                        DataBuilder().tag(WBTag.EXTERN_DATA).bytearray("f104522f00000000".fromHexString()).build(),
                    ).build()
                ).build(),
                DataBuilder().tag(WBTag.DATA).container(
                    DataBuilder().tag(WBTag.INDEX).uchar8(1).build(),
                    DataBuilder().tag(WBTag.EXTERN_DATA_SUN).container(
                        DataBuilder().tag(WBTag.EXTERN_DATA_LEN).int32(8).build(),
                        DataBuilder().tag(WBTag.EXTERN_DATA).bytearray("f104522f00000000".fromHexString()).build(),
                    ).build(),
                    DataBuilder().tag(WBTag.EXTERN_DATA_ALL).container(
                        DataBuilder().tag(WBTag.EXTERN_DATA_LEN).int32(8).build(),
                        DataBuilder().tag(WBTag.EXTERN_DATA).bytearray("0000e01f00000000".fromHexString()).build(),
                    ).build()
                ).build(),
            )
            .build()

        val result = toTest.invoke(frame)

        assertEquals(1, result.size)
        assertEquals(1, result[0].id)
        assertEquals(0, result[0].powerW)
        assertEquals(1265, result[0].solarPowerW)
    }

    @Test
    fun `test that blocks are skipped if sun block is missing`()  {
        val frame = FrameBuilder()
            .addData(
                DataBuilder().tag(WBTag.DATA).container(
                    DataBuilder().tag(WBTag.INDEX).uchar8(0).build(),
                    DataBuilder().tag(WBTag.EXTERN_DATA_ALL).container(
                        DataBuilder().tag(WBTag.EXTERN_DATA_LEN).int32(8).build(),
                        DataBuilder().tag(WBTag.EXTERN_DATA).bytearray("f104522f00000000".fromHexString()).build(),
                    ).build()
                ).build(),
                DataBuilder().tag(WBTag.DATA).container(
                    DataBuilder().tag(WBTag.INDEX).uchar8(1).build(),
                    DataBuilder().tag(WBTag.EXTERN_DATA_SUN).container(
                        DataBuilder().tag(WBTag.EXTERN_DATA_LEN).int32(8).build(),
                        DataBuilder().tag(WBTag.EXTERN_DATA).bytearray("f104522f00000000".fromHexString()).build(),
                    ).build(),
                    DataBuilder().tag(WBTag.EXTERN_DATA_ALL).container(
                        DataBuilder().tag(WBTag.EXTERN_DATA_LEN).int32(8).build(),
                        DataBuilder().tag(WBTag.EXTERN_DATA).bytearray("0000e01f00000000".fromHexString()).build(),
                    ).build()
                ).build(),
            )
            .build()

        val result = toTest.invoke(frame)

        assertEquals(1, result.size)
        assertEquals(1, result[0].id)
        assertEquals(0, result[0].powerW)
        assertEquals(1265, result[0].solarPowerW)
    }

    @Test
    fun `test that blocks are skipped if all block is missing`()  {
        val frame = FrameBuilder()
            .addData(
                DataBuilder().tag(WBTag.DATA).container(
                    DataBuilder().tag(WBTag.INDEX).uchar8(0).build(),
                    DataBuilder().tag(WBTag.EXTERN_DATA_SUN).container(
                        DataBuilder().tag(WBTag.EXTERN_DATA_LEN).int32(8).build(),
                        DataBuilder().tag(WBTag.EXTERN_DATA).bytearray("0000e01f00000000".fromHexString()).build(),
                    ).build()
                ).build(),
                DataBuilder().tag(WBTag.DATA).container(
                    DataBuilder().tag(WBTag.INDEX).uchar8(1).build(),
                    DataBuilder().tag(WBTag.EXTERN_DATA_SUN).container(
                        DataBuilder().tag(WBTag.EXTERN_DATA_LEN).int32(8).build(),
                        DataBuilder().tag(WBTag.EXTERN_DATA).bytearray("f104522f00000000".fromHexString()).build(),
                    ).build(),
                    DataBuilder().tag(WBTag.EXTERN_DATA_ALL).container(
                        DataBuilder().tag(WBTag.EXTERN_DATA_LEN).int32(8).build(),
                        DataBuilder().tag(WBTag.EXTERN_DATA).bytearray("0000e01f00000000".fromHexString()).build(),
                    ).build()
                ).build(),
            )
            .build()

        val result = toTest.invoke(frame)

        assertEquals(1, result.size)
        assertEquals(1, result[0].id)
        assertEquals(0, result[0].powerW)
        assertEquals(1265, result[0].solarPowerW)
    }
}
