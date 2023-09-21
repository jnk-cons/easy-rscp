package de.jnkconsulting.e3dc.easyrscp.api.frame

/**
 * Shows the available namespaces for communication with the home power plant
 *
 * @param code Namespace prefix, defined by E3DC
 *
 * @since 2.0
 */
enum class Namespace(val code: Byte) {
    /**
     * Protocoll relatedl; code = 0x00
     */
    RSCP(code = 0x00.toByte()),

    /**
     * Energy Management System; code = 0x01
     */
    EMS(code = 0x01.toByte()),

    /**
     * Photovoltaic inverter; code = 0x02
     */
    PVI(code = 0x02.toByte()),

    /**
     * Battery; code = 0x03
     */
    BAT(code = 0x03.toByte()),

    /**
     * Battery DCDC ??; code = 0x04
     */
    DCDC(code = 0x04.toByte()),

    /**
     * Power Management; code = 0x05
     */
    PM(code = 0x05.toByte()),

    /**
     * Database; code = 0x06
     */
    DB(code = 0x06.toByte()),

    /**
     * ??; code = 0x07
     */
    FMS(code = 0x07.toByte()),

    /**
     * Server related (User management, status etc.); code = 0x08
     */
    SRV(code = 0x08.toByte()),

    /**
     * Home automation; code = 0x09
     */
    HA(code = 0x09.toByte()),

    /**
     * System information; code = 0x0A
     */
    INFO(code = 0x0A.toByte()),

    /**
     * Emergency power; code = 0x0B
     */
    EP(code = 0x0B.toByte()),

    /**
     * System controls; code = 0x0C
     */
    SYS(code = 0x0C.toByte()),

    /**
     * Update Management; code = 0x0D
     */
    UM(code = 0x0D.toByte()),

    /**
     * Wallbox; code = 0x0E
     */
    WB(code = 0x0E.toByte()),

    /**
     * This is not an E3DC namespace, but serves as auxiliary objects for namespaces that are not known; code = 0xFF
     */
    UNKNOWN(code = 0xFF.toByte());


    companion object {
        fun byCode(code: Byte) =
            values()
                .find { it.code == code }
                ?: UNKNOWN

    }


}
