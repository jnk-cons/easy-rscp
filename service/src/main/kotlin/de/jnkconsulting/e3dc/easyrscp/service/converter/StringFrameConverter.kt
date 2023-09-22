package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.bytes.toHexString
import de.jnkconsulting.e3dc.easyrscp.api.frame.Data
import de.jnkconsulting.e3dc.easyrscp.api.frame.DataParser
import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame

/**
 * Simple implementation of the [FrameConverter] interface to convert a complete frame into a string. The individual data fields are output per line.
 * Container data indented accordingly.
 *
 * @since 2.0
 */
class StringFrameConverter: FrameConverter<String> {

    override fun invoke(frame: Frame): String =
        StringBuilder()
            .append("Timestamp:\t${frame.timestamp}\n")
            .append("WithChecksum:\t${frame.isChecksumEnabled()}\n")
            .also { out ->
                frame.data.forEach { out.append(convertData(it, 1, frame.parser)) }
            }
            .toString()

    private fun convertData(toPrint: Data, level: Int, parser: DataParser): String {
        val tabs = "\t".repeat(level)
        val result = StringBuilder()
            .append("${tabs}Tag:\t${toPrint.tagObject().namespace}.${toPrint.tagObject()} - ${toPrint.tag.toHexString()}\n")
            .append("${tabs}Type:\t${toPrint.typeObject()} - ${byteArrayOf(toPrint.type).toHexString()}\n")

        if (toPrint.typeObject() == DataType.CONTAINER) {
            toPrint.valueAsContainer(parser)
                .forEach { result.append(convertData(it, level + 1, parser)).append("\n") }
        }
        else {
            result.append("${tabs}Value:\t${toPrint.valueAsString()} - ${toPrint.value.toHexString()}\n")
        }
        return result.toString()
    }
}
