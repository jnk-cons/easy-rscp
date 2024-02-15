package de.jnkconsulting.e3dc.easyrscp.api.service.model

import java.time.Instant

/**
 * Represents the current status of the home power plant, in which the basic values are mapped.
 *
 * @param timestamp Timestamp at which the values were measured
 * @param pvDelivery Current power supply from the photovoitaik modules in watts
 * @param gridDelivery Current power delivery from (positive value) or to (negative value) the grid in watts
 * @param batteryDelivery Current power delivery from (positive value) or into (negative value) the battery in watts
 * @param houseConsumption Current power consumption of the house in watts
 * @param batteryChargingLevel Current battery charge level
 * @param wallboxConsumption Current energy consumption of all connected wallboxes. The value is not(!) included in [houseConsumption]. Specified in watts
 * @param wallboxProportionateSolarShare Proportion of energy in [wallboxConsumption] that is generated from solar energy. Specified in watts
 *
 * @since 2.0
 *
 * @since 2.3
 * - Added [wallboxConsumption] and [wallboxProportionateSolarShare]
 */
data class PowerState(
    val timestamp: Instant,
    val pvDelivery: Int,
    val gridDelivery: Int,
    val batteryDelivery: Int,
    val houseConsumption: Int,
    val batteryChargingLevel: Percentage,
    val wallboxConsumption: Int,
    val wallboxProportionateSolarShare: Int
)
