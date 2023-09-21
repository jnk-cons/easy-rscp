package de.jnkconsulting.e3dc.easyrscp.service.builder

import de.jnkconsulting.e3dc.easyrscp.api.service.InfoService
import de.jnkconsulting.e3dc.easyrscp.api.service.model.SystemInfo
import de.jnkconsulting.e3dc.easyrscp.connection.ConnectionBuilder
import de.jnkconsulting.e3dc.easyrscp.service.DefaultInfoService
import de.jnkconsulting.e3dc.easyrscp.service.converter.FrameConverter
import de.jnkconsulting.e3dc.easyrscp.service.converter.SystemInfoConverter
import de.jnkconsulting.e3dc.easyrscp.service.creator.FrameCreator
import de.jnkconsulting.e3dc.easyrscp.service.creator.RequestSystemInfosCreator

/**
 * [ServiceBuilder] implementation that creates instances of the [InfoService] type.
 *
 * The Builder offers optional extension points in frame conversion and frame generation:
 * - [withSystemInfoFrameConverter]
 * - [withRequestReadSystemInfoCreator]
 *
 * @since 2.0
 */
class InfoServiceBuilder: DefaultServiceBuilder<InfoService>() {

    private var convertFrameToSystemInfo: FrameConverter<SystemInfo>? = null
    private var createReadSystemInfoFrame: FrameCreator<Nothing?>? = null

    /**
     * Function is only overwritten to increase usability in java. Without that, the Java compiler would generate an error, because here a
     * [DefaultServiceBuilder] instance is supplied and no [InfoServiceBuilder] instance ...
     */
    override fun withConnectionBuilder(connectionBuilder: ConnectionBuilder): InfoServiceBuilder {
        return super.withConnectionBuilder(connectionBuilder) as InfoServiceBuilder
    }

    /**
     * Sets the converter to create a [SystemInfo] object from a response frame. Optional setting.
     * By default an instance of the type [SystemInfoConverter] is used.
     *
     * @param converter Converter to use
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withSystemInfoFrameConverter(converter: FrameConverter<SystemInfo>) =
        converter
            .let {
                convertFrameToSystemInfo = it
                this
            }

    /**
     * Sets the creator of request frames to load the basic system information's from the house power plant database. Optional setting.
     * By default, an instance of the type [RequestSystemInfosCreator] is used.
     *
     * @param creator Creator to use
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withRequestReadSystemInfoCreator(creator: FrameCreator<Nothing?>) =
        creator
            .let {
                this.createReadSystemInfoFrame = it
                this
            }

    private fun buildSystemInfoFrameConverter() =
        convertFrameToSystemInfo ?: SystemInfoConverter()

    private fun buildRequestSystemInfosFrameCreator() =
        createReadSystemInfoFrame ?: RequestSystemInfosCreator()

    override fun buildService() =
        DefaultInfoService(
            connectionPool = getConnectionBuilder().buildConnectionPool(),
            convertFrameToSystemInfo = buildSystemInfoFrameConverter(),
            createReadSystemInfoFrame = buildRequestSystemInfosFrameCreator(),
        )
}
