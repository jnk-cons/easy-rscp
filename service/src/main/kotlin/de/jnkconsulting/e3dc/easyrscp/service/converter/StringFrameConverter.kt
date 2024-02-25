package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.bytes.toHexString
import de.jnkconsulting.e3dc.easyrscp.api.frame.Data
import de.jnkconsulting.e3dc.easyrscp.api.frame.DataParser
import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.RSCPTag

/**
 * Simple implementation of the [FrameConverter] interface to convert a complete frame into a string. The individual data fields are output per line.
 * Container data indented accordingly.
 *
 * @param omitAuthenticationCredentials If true (default), the values of the tags of Type [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.RSCPTag.AUTHENTICATION_USER], [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.RSCPTag.AUTHENTICATION_PASSWORD] and [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.RSCPTag.REQ_SET_ENCRYPTION_PASSPHRASE] are masked with three ***. If set to false, the original value is shown.
 *
 * @since 2.0
 *
 * @since 2.3.1
 * - added parameter omitAuthenticationCredentials
 */
class StringFrameConverter(
    private val omitAuthenticationCredentials: Boolean = true): FrameConverter<String> {

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
            result.append("${tabs}Value:\t")
            if (shouldMask(toPrint)) {
                result.append("*** - ***\n")
            }
            else {
                result.append("${toPrint.valueAsString()} - ${toPrint.value.toHexString()}\n")
            }
        }
        return result.toString()
    }

    private fun shouldMask(toPrint: Data) =
        omitAuthenticationCredentials && TAGS_TO_OMIT.contains(toPrint.tagObject())

    companion object {
        val TAGS_TO_OMIT = setOf(
            RSCPTag.AUTHENTICATION_USER,
            RSCPTag.AUTHENTICATION_PASSWORD,
            RSCPTag.REQ_SET_ENCRYPTION_PASSPHRASE)
    }
}
