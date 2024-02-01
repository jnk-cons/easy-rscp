package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag

/**
 * Converter to build the response of a [EMSTag.REQ_START_MANUAL_CHARGE] request
 *
 * @since 2.2
 */
class StartManualChargeResponseConverter: FrameConverter<Boolean> {

    override fun invoke(frame: Frame) =
        frame.booleanByTag(EMSTag.START_MANUAL_CHARGE)
}
