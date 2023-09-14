package de.jnkconsulting.e3dc.easyrscp.api.frame

/**
 * Shows the available namespaces for communication with the home power plant
 *
 * @param code Namespace prefix, defined by E3DC
 *
 * @since 2.0
 */
enum class Namespace(val code: Byte) {
    RSCP(0x00.toByte()),

    /**
     * Energy Management System
     */
    EMS(0x01.toByte()),

    /**
     * Photovoltaic inverter
     */
    PVI(0x02.toByte()),

    /**
     * Battery
     */
    BAT(0x03.toByte()),

    /**
     * Battery DCDC ??
     */
    DCDC(0x04.toByte()),

    /**
     * Power Management
     */
    PM(0x05.toByte()),

    /**
     * Database
     */
    DB(0x06.toByte()),

    /**
     * ??
     */
    FMS(0x07.toByte()),

    /**
     * Server related (User management, status etc.)
     */
    SRV(0x08.toByte()),

    /**
     * Home automation
     */
    HA(0x09.toByte()),

    /**
     * System information
     */
    INFO(0x0A.toByte()),

    /**
     * Emergency power
     */
    EP(0x0B.toByte()),

    /**
     * System controls
     */
    SYS(0x0C.toByte()),

    /**
     * Update Management
     */
    UM(0x0D.toByte()),

    /**
     * Wallbox
     */
    WB(0x0E.toByte()),

    /**
     * This is not an E3DC namespace, but serves as auxiliary objects for namespaces that are not known
     */
    UNKNOWN(0xFF.toByte());


    companion object {
        fun byCode(code: Byte) =
            values()
                .find { it.code == code }
                ?: UNKNOWN

    }


}
