package de.jnkconsulting.e3dc.easyrscp.service.builder

import de.jnkconsulting.e3dc.easyrscp.api.service.ChargingService
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ChargingConfiguration
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ChargingLimits
import de.jnkconsulting.e3dc.easyrscp.api.service.model.WriteChargingLimitsResult
import de.jnkconsulting.e3dc.easyrscp.connection.ConnectionBuilder
import de.jnkconsulting.e3dc.easyrscp.service.DefaultChargingService
import de.jnkconsulting.e3dc.easyrscp.service.converter.ChargingConfigurationConverter
import de.jnkconsulting.e3dc.easyrscp.service.converter.FrameConverter
import de.jnkconsulting.e3dc.easyrscp.service.converter.WriteChargingLimitsResultConverter
import de.jnkconsulting.e3dc.easyrscp.service.creator.FrameCreator
import de.jnkconsulting.e3dc.easyrscp.service.creator.RequestChargingConfigurationCreator
import de.jnkconsulting.e3dc.easyrscp.service.creator.SetPowerSettingsCreator

/**
 * [ServiceBuilder] implementation that creates instances of the [ChargingService] type.
 *
 * The Builder offers optional extension points in frame conversion and frame generation:
 * - [withChargingConfigurationFrameConverter]
 * - [withWriteChargingLimitsResultFrameConverter]
 * - [withRequestChargingConfigurationFrameCreator]
 * - [withSetPowerSettingsFrameCreator]
 *
 * @since 2.0
 */
class ChargingServiceBuilder: DefaultServiceBuilder<ChargingService>() {

    private var convertFrameToChargingConfiguration: FrameConverter<ChargingConfiguration>? = null
    private var convertFrameToWriteChargingLimitsResult: FrameConverter<WriteChargingLimitsResult>? = null
    private var createRequestChargingConfigurationFrame: FrameCreator<Nothing?>? = null
    private var createSetPowerSettingsFrame: FrameCreator<ChargingLimits>? = null

    /**
     * Function is only overwritten to increase usability in java. Without that, the Java compiler would generate an error, because here a
     * [DefaultServiceBuilder] instance is supplied and no [ChargingServiceBuilder] instance ...
     */
    override fun withConnectionBuilder(connectionBuilder: ConnectionBuilder): ChargingServiceBuilder {
        return super.withConnectionBuilder(connectionBuilder) as ChargingServiceBuilder
    }

    /**
     * Sets the converter to create a [ChargingConfiguration] object from a response frame. Optional setting.
     * By default an instance of the type [ChargingConfigurationConverter] is used.
     *
     * @param converter Converter to use
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withChargingConfigurationFrameConverter(converter: FrameConverter<ChargingConfiguration>): ChargingServiceBuilder =
        converter
            .let {
                convertFrameToChargingConfiguration = it
                this
            }

    /**
     * Sets the converter to create a [WriteChargingLimitsResult] object from a response frame. Optional setting.
     * By default an instance of the type [WriteChargingLimitsResultConverter] is used.
     *
     * @param converter Converter to use
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withWriteChargingLimitsResultFrameConverter(converter: FrameConverter<WriteChargingLimitsResult>): ChargingServiceBuilder =
        converter
            .let {
                convertFrameToWriteChargingLimitsResult = it
                this
            }

    /**
     * Sets the frame generator to request frames for reading the load configuration from the home power plant. Optional setting.
     * By default, an instance of the type [RequestChargingConfigurationCreator] is used.
     *
     * @param creator Creator to use
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withRequestChargingConfigurationFrameCreator(creator: FrameCreator<Nothing?>): ChargingServiceBuilder =
        creator
            .let {
                this.createRequestChargingConfigurationFrame = it
                this
            }

    /**
     * Sets the frame generator to request frames for setting charging limitations to the home power plant. Optional setting.
     * By default, an instance of the type [SetPowerSettingsCreator] is used.
     *
     * @param creator Creator to use
     *
     * @return this reference
     *
     * @since 2.0
     */
    fun withSetPowerSettingsFrameCreator(creator: FrameCreator<ChargingLimits>): ChargingServiceBuilder =
        creator
            .let {
                this.createSetPowerSettingsFrame = it
                this
            }

    private fun buildChargingConfigurationFrameConverter() =
        convertFrameToChargingConfiguration ?: ChargingConfigurationConverter()

    private fun buildWriteChargingLimitsResultFrameConverter() =
        convertFrameToWriteChargingLimitsResult ?: WriteChargingLimitsResultConverter()

    private fun buildRequestChargingConfigurationFrameCreator() =
        createRequestChargingConfigurationFrame ?: RequestChargingConfigurationCreator()

    private fun buildSetPowerSettingsFrameCreator() =
        createSetPowerSettingsFrame ?: SetPowerSettingsCreator()

    override fun buildService() =
        DefaultChargingService(
            connectionPool = getConnectionBuilder().buildConnectionPool(),
            convertFrameToChargingConfiguration = buildChargingConfigurationFrameConverter(),
            convertFrameToWriteChargingLimitsResult = buildWriteChargingLimitsResultFrameConverter(),
            createRequestChargingConfigurationFrame = buildRequestChargingConfigurationFrameCreator(),
            createSetPowerSettingsFrame = buildSetPowerSettingsFrameCreator(),
        )
}
