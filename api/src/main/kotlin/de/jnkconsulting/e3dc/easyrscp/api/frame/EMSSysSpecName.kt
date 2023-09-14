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
     * Speculation: Describes whether the Hybrid operating mode is supported
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    HYBRID_MODE_SUPPORTED("hybridModeSupported"),

    /**
     * Returns the installed battery capacity. Presumed unit is kWh
     *
     * ATTENTION: It is known that the values are not always correct!!! Do not rely on the value. This is probably a setup error of the installer.
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    INSTALLED_BATTERY_CAPACITY("installedBatteryCapacity"),

    /**
     * Unknown: Probably the maximum possible AC power across all phases?. Unit ... Watt?
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_AC_POWER("maxAcPower"),

    /**
     * Maximum possible charging power of the battery in watts. This value may differ from the maximum possible charging power of the system itself. See [MAX_CHARGE_POWER].
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_BATTERY_CHARGE_POWER("maxBatChargePower"),

    /**
     * Maximum possible discharging power of the battery in watts. This value may differ from the maximum possible discharging power of the system itself. See [MAX_DISCHARGE_POWER].
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_BATTERY_DISCHARGE_POWER("maxBatDischargPower"),

    /**
     * Maximum possible charging power of the system in watts. This value may differ from the maximum possible charging power of the battery. See [MAX_BATTERY_CHARGE_POWER].
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_CHARGE_POWER("maxChargePower"),

    /**
     * Maximum possible discharging power of the system in watts. This value may differ from the maximum possible discharging power of the battery. See [MAX_BATTERY_DISCHARGE_POWER].
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_DISCHARGE_POWER("maxDischargePower"),

    /**
     * Unknown. In my system the value is identical to [MAX_CHARGE_POWER] and [MAX_BATTERY_CHARGE_POWER]. Therefore the unit is pretty sure Watt.
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_FBC_CHARGE_POWER("maxFbcChargePower"),

    /**
     * Unknown. In my system the value is identical to [MAX_DISCHARGE_POWER] and [MAX_BATTERY_DISCHARGE_POWER]. Therefore the unit is pretty sure Watt.
     *
     * The values container has the [Tag] of type [EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_FBC_DISCHARGE_POWER("maxFbcDischargePower"),


    /**
     * Should presumably provide the peak power in watts. My system returns here an int container with data type [DataType.ERROR]. Therefore: One does not know
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_PV_POWER("maxPvPower"),

    /**
     * Unknown. Probably the maximum power in watts, from when the battery is charged. I guess [MIN_START_CHARGE_POWER] and [MAX_START_CHARGE_POWER] give the limits for the charge limit (See [EMSTag.MAX_CHARGE_POWER] and [EMSTag.MAX_DISCHARGE_POWER])
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_START_CHARGE_POWER("maxStartChargePower"),

    /**
     * Unknown. Probably the maximum power in watts, from when the battery is discharged. I guess [MIN_START_CHARGE_POWER] and [MAX_START_CHARGE_POWER] give the limits for the charge limit (See [EMSTag.MAX_CHARGE_POWER] and [EMSTag.MAX_DISCHARGE_POWER])
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MAX_START_DISCHARGE_POWER("maxStartDischargePower"),

    /**
     * Unknown. Probably the minimum power in watts, from when the battery is charged. I guess [MIN_START_CHARGE_POWER] and [MAX_START_CHARGE_POWER] give the limits for the charge limit (See [EMSTag.MAX_CHARGE_POWER] and [EMSTag.MAX_DISCHARGE_POWER]
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MIN_START_CHARGE_POWER("minStartChargePower"),
    /**
     * Unknown. Probably the minimum power in watts, from when the battery is discharged. I guess [MIN_START_CHARGE_POWER] and [MAX_START_CHARGE_POWER] give the limits for the charge limit (See [EMSTag.MAX_CHARGE_POWER] and [EMSTag.MAX_DISCHARGE_POWER]
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    MIN_START_DISCHARGE_POWER("minStartDischargePower"),

    /**
     * Recommended minimum charge limit of the battery in watts
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    RECOMMENDED_MIN_CHARGE_LIMIT("recommendedMinChargeLimit"),

    /**
     * Recommended minimum discharge limit of the battery in watts
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    RECOMMENDED_MIN_DISCHARGE_LIMIT("recommendedMinDischargeLimit"),

    /**
     * Default value in watts, from when the battery is charged. At least the assumption. However, an EMSTag for this value is missing. For the discharge process the value is present. See [EMSTag.DISCHARGE_START_POWER].
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    START_CHARGE_DEFAULT("startChargeDefault"),

    /**
     * Default value in watts, from when the battery is discharged. See [EMSTag.DISCHARGE_START_POWER].
     *
     * The values container has the [Tag] [de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag.SYS_SPEC_VALUE_INT]
     */
    START_DISCHARGE_DEFAULT("startDischargeDefault")
}
