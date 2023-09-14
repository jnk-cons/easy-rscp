package de.jnkconsulting.e3dc.easyrscp.api.service.model

import java.time.Duration
import java.time.Instant

/**
 * Represents data from the home power plant database
 *
 * @param start Start time for which the data is valid
 * @param duration Duration for which the data are valid
 * @param batteryIn Energy charged into the battery in Wh
 * @param batteryOut Energy drawn from the battery in Wh
 * @param gridIn Energy fed into the grid in Wh
 * @param gridOut Energy drawn from the grid in Wh
 * @param pvDelivery Energy produced by the PV system in Wh
 * @param houseConsumption Consumed energy of the house in Wh
 * @param selfSufficiency Independence from an external power supply in percent
 * @param selfConsumption Share of self-consumption of self-generated energy in percent
 *
 * @since 2.0
 */
data class HistoryData(
    val start: Instant,
    val duration: Duration,
    val batteryIn: Float,
    val batteryOut: Float,
    val gridIn: Float,
    val gridOut: Float,
    val pvDelivery: Float,
    val houseConsumption: Float,
    val selfSufficiency: Percentage,
    val selfConsumption: Percentage
)
