package de.jnkconsulting.e3dc.easyrscp.api.frame

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag


/**
 * Previously known possible values in a [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.GET_SYS_SPECS] data block.
 *
 * A GET_SYS_SPECS block is a block of type [DataType.CONTAINER], which in turn contains blocks of type [DataType.CONTAINER] and the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC].
 * Jeder SYS_SPEC Block besteht aus drei weiteren Blöcken
 *
 * - [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_INDEX]
 * - [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_NAME]
 * - [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT] resp. [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_STRING]
 *
 * This enum maps the previously known values of [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_NAME].
 *
 * @param rscpName Name in the value of the [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_NAME] data block.
 *
 * @since 2.0
 */
enum class EMSSysSpecName(val rscpName: String)  {
    /**
     * Speculation: Describes whether the Hybrid operating mode is supported; rscpName = "hybridModeSupported"
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    HYBRID_MODE_SUPPORTED(rscpName = "hybridModeSupported"),

    /**
     * Returns the installed battery capacity. Presumed unit is kWh; rscpName = "installedBatteryCapacity"
     *
     * ATTENTION: It is known that the values are not always correct!!! Do not rely on the value. This is probably a setup error of the installer.
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    INSTALLED_BATTERY_CAPACITY(rscpName = "installedBatteryCapacity"),

    /**
     * Unknown: Probably the maximum possible AC power across all phases?. Unit ... Watt?; rscpName = "maxAcPower"
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_AC_POWER(rscpName = "maxAcPower"),

    /**
     * Maximum possible charging power of the battery in watts. This value may differ from the maximum possible charging power of the system itself. See [MAX_CHARGE_POWER]; rscpName = "maxBatChargePower"
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_BATTERY_CHARGE_POWER(rscpName = "maxBatChargePower"),

    /**
     * Maximum possible discharging power of the battery in watts. This value may differ from the maximum possible discharging power of the system itself. See [MAX_DISCHARGE_POWER]; rscpName = "maxBatDischargPower"
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_BATTERY_DISCHARGE_POWER(rscpName = "maxBatDischargPower"),

    /**
     * Maximum possible charging power of the system in watts. This value may differ from the maximum possible charging power of the battery. See [MAX_BATTERY_CHARGE_POWER]; rscpName = "maxChargePower"
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_CHARGE_POWER(rscpName = "maxChargePower"),

    /**
     * Maximum possible discharging power of the system in watts. This value may differ from the maximum possible discharging power of the battery. See [MAX_BATTERY_DISCHARGE_POWER]; rscpName = "maxDischargePower"
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_DISCHARGE_POWER(rscpName = "maxDischargePower"),

    /**
     * Unknown. In my system the value is identical to [MAX_CHARGE_POWER] and [MAX_BATTERY_CHARGE_POWER]. Therefore the unit is pretty sure Watt; rscpName = "maxFbcChargePower"
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_FBC_CHARGE_POWER(rscpName = "maxFbcChargePower"),

    /**
     * Unknown. In my system the value is identical to [MAX_DISCHARGE_POWER] and [MAX_BATTERY_DISCHARGE_POWER]. Therefore the unit is pretty sure Watt; rscpName = "maxFbcDischargePower")
     *
     * The values container has the [Tag] of type [EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_FBC_DISCHARGE_POWER(rscpName = "maxFbcDischargePower"),


    /**
     * Should presumably provide the peak power in watts. My system returns here an int container with data type [DataType.ERROR]. Therefore: One does not know; rscpName = "maxPvPower"
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_PV_POWER(rscpName = "maxPvPower"),

    /**
     * Unknown. Probably the maximum power in watts, from when the battery is charged. I guess [MIN_START_CHARGE_POWER] and [MAX_START_CHARGE_POWER] give the limits for the charge limit (See [EMSTag.MAX_CHARGE_POWER] and [EMSTag.MAX_DISCHARGE_POWER]); rscpName = "maxStartChargePower"
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_START_CHARGE_POWER(rscpName = "maxStartChargePower"),

    /**
     * Unknown. Probably the maximum power in watts, from when the battery is discharged. I guess [MIN_START_CHARGE_POWER] and [MAX_START_CHARGE_POWER] give the limits for the charge limit (See [EMSTag.MAX_CHARGE_POWER] and [EMSTag.MAX_DISCHARGE_POWER]; rscpName = "maxStartDischargePower"
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_START_DISCHARGE_POWER(rscpName = "maxStartDischargePower"),

    /**
     * Unknown. Probably the minimum power in watts, from when the battery is charged. I guess [MIN_START_CHARGE_POWER] and [MAX_START_CHARGE_POWER] give the limits for the charge limit (See [EMSTag.MAX_CHARGE_POWER] and [EMSTag.MAX_DISCHARGE_POWER]; rscpName = "minStartChargePower"
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MIN_START_CHARGE_POWER(rscpName = "minStartChargePower"),
    /**
     * Unknown. Probably the minimum power in watts, from when the battery is discharged. I guess [MIN_START_CHARGE_POWER] and [MAX_START_CHARGE_POWER] give the limits for the charge limit (See [EMSTag.MAX_CHARGE_POWER] and [EMSTag.MAX_DISCHARGE_POWER]; rscpName = "minStartDischargePower"
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MIN_START_DISCHARGE_POWER(rscpName = "minStartDischargePower"),

    /**
     * Recommended minimum charge limit of the battery in watts; rscpName = "recommendedMinChargeLimit"
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    RECOMMENDED_MIN_CHARGE_LIMIT(rscpName = "recommendedMinChargeLimit"),

    /**
     * Recommended minimum discharge limit of the battery in watts; rscpName = "recommendedMinDischargeLimit"
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    RECOMMENDED_MIN_DISCHARGE_LIMIT(rscpName = "recommendedMinDischargeLimit"),

    /**
     * Default value in watts, from when the battery is charged. At least the assumption. However, an EMSTag for this value is missing. For the discharge process the value is present. See [EMSTag.DISCHARGE_START_POWER]; rscpName = "startChargeDefault"
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    START_CHARGE_DEFAULT(rscpName = "startChargeDefault"),

    /**
     * Default value in watts, from when the battery is discharged. See [EMSTag.DISCHARGE_START_POWER]; rscpName = "startDischargeDefault"
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    START_DISCHARGE_DEFAULT(rscpName = "startDischargeDefault")
}
