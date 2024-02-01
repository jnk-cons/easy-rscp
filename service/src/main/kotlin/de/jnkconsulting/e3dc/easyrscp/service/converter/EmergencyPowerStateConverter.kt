package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EPTag
import de.jnkconsulting.e3dc.easyrscp.api.service.model.EmergencyPowerState

/**
 * Converter to build a [EmergencyPowerState] object from a frame
 *
 * @since 2.2
 */
class EmergencyPowerStateConverter: FrameConverter<EmergencyPowerState> {

    override fun invoke(frame: Frame): EmergencyPowerState =
        EmergencyPowerState(
            reserveWh = frame.floatByTag(EPTag.PARAM_EP_RESERVE_ENERGY, EPTag.EP_RESERVE),
            reservePercentage = frame.floatByTag(EPTag.PARAM_EP_RESERVE, EPTag.EP_RESERVE) / 100.0f,
            connectedToGrid = frame.booleanByTag(EPTag.IS_GRID_CONNECTED),
            readyForSwitch = frame.booleanByTag(EPTag.IS_READY_FOR_SWITCH),
            emergencyPowerPossible = frame.booleanByTag(EPTag.IS_POSSIBLE),
            invalidState = frame.booleanByTag(EPTag.IS_INVALID_STATE),
            island = frame.booleanByTag(EPTag.IS_ISLAND_GRID),
        )
}
