package de.jnkconsulting.e3dc.easyrscp.service.builder

import de.jnkconsulting.e3dc.easyrscp.api.service.LiveDataService
import de.jnkconsulting.e3dc.easyrscp.api.service.model.PowerState
import de.jnkconsulting.e3dc.easyrscp.connection.ConnectionBuilder
import de.jnkconsulting.e3dc.easyrscp.service.DefaultLiveDataService
import de.jnkconsulting.e3dc.easyrscp.service.converter.FrameConverter
import de.jnkconsulting.e3dc.easyrscp.service.converter.PowerStateConverter
import de.jnkconsulting.e3dc.easyrscp.service.creator.FrameCreator
import de.jnkconsulting.e3dc.easyrscp.service.creator.RequestLiveDataCreator

/**
 * [ServiceBuilder] implementation that creates instances of the [LiveDataService] type.
 *
 * The Builder offers optional extension points in frame conversion and frame generation:
 * - [withPowerStateFrameConverter]
 * - [withRequestLiveDataFrameCreator]
 *
 * @since 2.0
 */
class LiveDataServiceBuilder: DefaultServiceBuilder<LiveDataService>() {

    private var convertFrameToPowerState: FrameConverter<PowerState>? = null
    private var createRequestLiveDataFrame: FrameCreator<Nothing?>? = null

    /**
     * Function is only overwritten to increase usability in java. Without that, the Java compiler would generate an error, because here a
     * [DefaultServiceBuilder] instance is supplied and no [LiveDataServiceBuilder] instance ...
     */
    override fun withConnectionBuilder(connectionBuilder: ConnectionBuilder): LiveDataServiceBuilder {
        return super.withConnectionBuilder(connectionBuilder) as LiveDataServiceBuilder
    }

    /**
     * Sets the converter to create a [PowerState] object from a response frame. Optional setting.
     * By default an instance of the type [PowerStateConverter] is used.
     *
     * @param converter Converter to use
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withPowerStateFrameConverter(converter: FrameConverter<PowerState>) =
        converter
            .let {
                convertFrameToPowerState = it
                this
            }

    /**
     * Sets the creator of request frames to load the current live data production data from the house power plant database. Optional setting.
     * By default, an instance of the type [RequestLiveDataCreator] is used.
     *
     * @param creator Creator to use
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withRequestLiveDataFrameCreator(creator: FrameCreator<Nothing?>) =
        creator
            .let {
                this.createRequestLiveDataFrame = it
                this
            }

    private fun buildPowerStateFrameConverter() =
        convertFrameToPowerState ?: PowerStateConverter()

    private fun buildRequestLiveDataFrameCreator() =
        createRequestLiveDataFrame ?: RequestLiveDataCreator()

    override fun buildService() =
        DefaultLiveDataService(
            connectionPool = getConnectionBuilder().buildConnectionPool(),
            convertFrameToPowerState = buildPowerStateFrameConverter(),
            createRequestLiveDataFrame = buildRequestLiveDataFrameCreator(),
        )
}
