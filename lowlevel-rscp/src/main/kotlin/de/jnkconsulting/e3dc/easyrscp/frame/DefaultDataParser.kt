package de.jnkconsulting.e3dc.easyrscp.frame

import de.jnkconsulting.e3dc.easyrscp.api.bytes.POSITIONS
import de.jnkconsulting.e3dc.easyrscp.api.bytes.SIZES
import de.jnkconsulting.e3dc.easyrscp.api.bytes.emptyByteBuffer
import de.jnkconsulting.e3dc.easyrscp.api.frame.Data
import de.jnkconsulting.e3dc.easyrscp.api.frame.DataParser

/**
 * Simple implementation to create objects from binary data [Data].
 *
 * @since 2.0
 */
class DefaultDataParser: DataParser {
    override fun parseRSCPData(data: ByteArray): List<Data> {
        val result = mutableListOf<Data>()

        var bytesParsed = 0
        while (bytesParsed < data.size) {
            val deserializedData = readSingleData(data, bytesParsed)
            result.add(deserializedData)
            bytesParsed += deserializedData.asByteArray().size
        }

        return result
    }

    private fun readSingleData(data: ByteArray, offset: Int) =
        DataBuilder()
            .tag(readTag(data, offset))
            .raw(
                value =readValue(offset, data),
                type = readType(data, offset))
            .build()

    private fun readValue(offset: Int, data: ByteArray): ByteArray {
        val valueLength = readDataLength(data, offset)
        val startOfDataSection = offset + POSITIONS.dataValueSection
        return data.sliceArray(IntRange(startOfDataSection, startOfDataSection + valueLength.toInt() - 1))
    }

    private fun readDataLength(data: ByteArray, offset: Int) =
        emptyByteBuffer(Short.SIZE_BYTES)
            .put(data, offset + POSITIONS.dataValueLength, SIZES.dataValueLengthSize)
            .flip()
            .getShort()

    private fun readType(data: ByteArray, offset: Int) =
        data
            .sliceArray(IntRange(offset + POSITIONS.dataType, offset + POSITIONS.dataValueLength - 1))
            .reversedArray()[0]

    private fun readTag(data: ByteArray, offset: Int) =
        data
            .sliceArray(IntRange(offset, offset + SIZES.dataTagSize - 1))
            .reversedArray()


}
