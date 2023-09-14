package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.InfoTag
import de.jnkconsulting.e3dc.easyrscp.api.service.model.ProductionDate
import de.jnkconsulting.e3dc.easyrscp.api.service.model.SystemInfo

/**
 * Converter to build a [SystemInfo] object from a frame
 *
 * @since 2.0
 */
class SystemInfoConverter: FrameConverter<SystemInfo> {

    override fun invoke(frame: Frame) =
        SystemInfo(
            serialNumber = frame.stringByTag(InfoTag.SERIAL_NUMBER),
            softwareVersion = frame.stringByTag(InfoTag.SW_RELEASE),
            productionDate = ProductionDate(frame.stringByTag(InfoTag.PRODUCTION_DATE)),
        )
}
