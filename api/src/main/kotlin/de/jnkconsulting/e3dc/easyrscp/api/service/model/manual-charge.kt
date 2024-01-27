package de.jnkconsulting.e3dc.easyrscp.api.service.model

import java.time.Instant

data class ManualChargeState(
    val active: Boolean,
    val chargedEnergyWh: Double,
    val lastRun: Instant
)
