package de.jnkconsulting.e3dc.easyrscp.api.frame.tags

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Namespace
import de.jnkconsulting.e3dc.easyrscp.api.frame.Tag

/**
 * Contains tags for querying and controlling the Energy Management System. This can be used to for example,
 * the charging/discharging power, wallbox priority and similar can be configured.
 *
 * @param namespace Der Namespace des Tags für die Abbildung des jeweiligen Bereichs
 * @param hex Code of the tag in HexString format (0x0304001)
 * @param type Tag data type [DataType]
 *
 * @since 2.0
 */
enum class EMSTag(
    override val namespace: Namespace = Namespace.EMS,
    override val hex: String,
    override val type: DataType
) : Tag {

    /**
     * Request parameter to get the current energy supplied by the PV system. E3DC says that the unit is in watts. But this refers to the parameter in the response. Here the data type is [DataType.NONE].
     *
     * A data block of the type [EMSTag.POWER_PV] is supplied as a response.
     *
     * Original E3DC Documentation:
     *
     * en: PV power of the S10s in W
     *
     * de: PV-Leistung des S10s in W
     */
    REQ_POWER_PV(hex = "0x01000001", type = DataType.NONE),

    /**
     * Request parameter to get the current amount of energy that is charged into or drawn from the battery. E3DC says that the unit is in watts. But this refers to the parameter in the response. Here the data type is [DataType.NONE].
     *
     * A data block of the type [EMSTag.POWER_BAT] is supplied as a response.
     *
     * Original E3DC Documentation:
     *
     * en: Battery power of the S10s in W (-=discharged / +=charged)
     *
     * de: Batterie-Leistung des S10s in W (-=entladen / +=laden)
     */
    REQ_POWER_BAT(hex = "0x01000002", type = DataType.NONE),

    /**
     * Request parameters to obtain the current amount of energy consumed by the house. E3DC says that the unit is in watts. But this refers to the parameter in the response. Here the data type is [DataType.NONE].
     *
     * A data block of the type [EMSTag.POWER_HOME] is supplied as a response.
     *
     * Original E3DC Documentation:
     *
     * en: House consumption power in W
     *
     * de: Hausverbrauchsleistung in W
     */
    REQ_POWER_HOME(hex = "0x01000003", type = DataType.NONE),

    /**
     * Request parameters to obtain the current amount of energy being fed in or drawn from the grid. E3DC says that the unit is in watts. But this refers to the parameter in the response. Here the data type is [DataType.NONE].
     *
     * A data block of the type [EMSTag.POWER_GRID] is supplied as a response.
     *
     * Original E3DC Documentation:
     *
     * en: Power at the grid feed-in point in W (-=feed-in / +=feed-in)
     *
     * de: Leistung am Netzeinspeisepunkt in W (-=Einspeisung / +=Bezug)
     */
    REQ_POWER_GRID(hex = "0x01000004", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en: Power of an additionally existing feeder in W
     *
     * de: Leistung eines zusätzlich vorhandenen Einspeisers in W
     */
    REQ_POWER_ADD(hex = "0x01000005", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en: Self-sufficiency in %
     *
     * de: Autarkie in %
     */
    REQ_AUTARKY(hex = "0x01000006", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en: Self-consumption in %
     *
     * de: Eigenverbrauch in %
     */
    REQ_SELF_CONSUMPTION(hex = "0x01000007", type = DataType.NONE),

    /**
     * Request parameter to get the current battery charge level. E3DC says that the unit is in percent. But this refers to the parameter in the response. Here the data type is [DataType.NONE].
     *
     * A data block of the type [EMSTag.BAT_SOC] is supplied as a response.
     *
     * Original E3DC Documentation:
     *
     * en: Battery charge level in %
     *
     * de: Batterieladezustand in %
     */
    REQ_BAT_SOC(hex = "0x01000008", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en: Query of the operating mode
     *
     * de: Abfrage des Betriebsmodus
     */
    REQ_COUPLING_MODE(hex = "0x01000009", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_STORED_ERRORS(hex = "0x0100000A", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_MODE(hex = "0x01000011", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_BALANCED_PHASES(hex = "0x01000012", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_INSTALLED_PEAK_POWER(hex = "0x01000013", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DERATE_AT_PERCENT_VALUE(hex = "0x01000014", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DERATE_AT_POWER_VALUE(hex = "0x01000015", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_ERROR_BUZZER_ENABLED(hex = "0x01000016", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_BALANCED_PHASES(hex = "0x01000017", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_INSTALLED_PEAK_POWER(hex = "0x01000018", type = DataType.UINT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_DERATE_PERCENT(hex = "0x01000019", type = DataType.FLOAT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_ERROR_BUZZER_ENABLED(hex = "0x0100001A", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_START_ADJUST_BATTERY_VOLTAGE(hex = "0x0100001B", type = DataType.FLOAT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_CANCEL_ADJUST_BATTERY_VOLTAGE(hex = "0x0100001C", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_ADJUST_BATTERY_VOLTAGE_STATUS(hex = "0x0100001D", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_CONFIRM_ERRORS(hex = "0x0100001E", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_POWER_WB_ALL(hex = "0x0100001F", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_POWER_WB_SOLAR(hex = "0x01000020", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en: Enquire if an additional power meter is installed to measure additional sources.
     *
     * de: Anfragetag ob ein zusätzlicher Leistungsmesser installiert ist, der zusäztliche Quellen misst
     */
    REQ_EXT_SRC_AVAILABLE(hex = "0x01000021", type = DataType.NONE),

    /**
     * Response parameter to an [EMSTag.REQ_POWER_PV] request parameter. Contains the current amount of energy supplied by the PV system in watts.
     *
     * Original E3DC Documentation:
     *
     * en: PV power of the S10s in W
     *
     * de: PV-Leistung des S10s in W
     */
    POWER_PV(hex = "0x01800001", type = DataType.INT32),

    /**
     * Response parameter to an [EMSTag.REQ_POWER_BAT] request parameter. Contains the current amount of energy drawn from the battery (negative value), or loaded into the battery (positive value) in watts.
     *
     * Original E3DC Documentation:
     *
     * en: Battery power of the S10s in W (-=discharged / +=charged)
     *
     * de: Batterie-Leistung des S10s in W (-=entladen / +=laden)
     */
    POWER_BAT(hex = "0x01800002", type = DataType.INT32),

    /**
     * Response parameter to an [EMSTag.REQ_POWER_HOME] request parameter. Contains the amount of energy currently consumed by the house in watts.
     *
     * Original E3DC Documentation:
     *
     * en: House consumption power in W
     *
     * de: Hausverbrauchsleistung in W
     */
    POWER_HOME(hex = "0x01800003", type = DataType.INT32),

    /**
     * Response parameter to an [EMSTag.REQ_POWER_GRID] request parameter. Contains the amount of energy that is currently fed into the grid (negative value) or drawn from the grid (positive value) in watts.
     *
     * Original E3DC Documentation:
     *
     * en: Power at the grid feed-in point in W (-=feed-in / +=feed-out)
     *
     * de: Leistung am Netzeinspeisepunkt in W (-=Einspeisung / +=Bezug)
     */
    POWER_GRID(hex = "0x01800004", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en: Power of an additionally existing feeder in W
     *
     * de: Leistung eines zusätzlich vorhandenen Einspeisers in W
     */
    POWER_ADD(hex = "0x01800005", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en: Self-sufficiency in %
     *
     * de: Autarkie in %
     */
    AUTARKY(hex = "0x01800006", type = DataType.FLOAT32),

    /**
     * Original E3DC Documentation:
     *
     * en: Self-consumption in %
     *
     * de: Eigenverbrauch in %
     */
    SELF_CONSUMPTION(hex = "0x01800007", type = DataType.FLOAT32),

    /**
     * Response parameter to an [EMSTag.REQ_BAT_SOC] request parameter. Contains the current battery charge level in percent (0 - 100)..
     *
     * Original E3DC Documentation:
     *
     * en: Battery charge level in %
     *
     * de: Batterieladezustand in %
     */
    BAT_SOC(hex = "0x01800008", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en: Operating mode
     *
     * de: Betriebsmodus
     *
     * 0=DC
     * 1=DC-MultiWR
     * 2=AC
     * 3=HYBRID
     * 4=ISLAND
     */
    COUPLING_MODE(hex = "0x01800009", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en: If the EMS is in error state, an error message is transmitted!
     *
     * de: Wenn das EMS im Fehlerzustand ist, wird eine Fehlermeldung übertragen!
     */
    STORED_ERRORS(hex = "0x0180000A", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en: If the EMS is in error state, an error message is transmitted!
     *
     * de: Wenn das EMS im Fehlerzustand ist, wird eine Fehlermeldung übertragen!
     */
    ERROR_CONTAINER(hex = "0x0180000B", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en: If the EMS is in error state, an error message is transmitted!
     *
     * de: Wenn das EMS im Fehlerzustand ist, wird eine Fehlermeldung übertragen!
     */
    ERROR_TYPE(hex = "0x0180000C", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en: If the EMS is in error state, an error message is transmitted!
     *
     * de: Wenn das EMS im Fehlerzustand ist, wird eine Fehlermeldung übertragen!
     */
    ERROR_SOURCE(hex = "0x0180000D", type = DataType.STRING),

    /**
     * Original E3DC Documentation:
     *
     * en: If the EMS is in error state, an error message is transmitted!
     *
     * de: Wenn das EMS im Fehlerzustand ist, wird eine Fehlermeldung übertragen!
     */
    ERROR_MESSAGE(hex = "0x0180000E", type = DataType.STRING),

    /**
     * Original E3DC Documentation:
     *
     * en: If the EMS is in error state, an error message is transmitted!
     *
     * de: Wenn das EMS im Fehlerzustand ist, wird eine Fehlermeldung übertragen!
     */
    ERROR_CODE(hex = "0x0180000F", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en: If the EMS is in error state, an error message is transmitted!
     *
     * de: Wenn das EMS im Fehlerzustand ist, wird eine Fehlermeldung übertragen!
     */
    ERROR_TIMESTAMP(hex = "0x01800010", type = DataType.UINT64),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MODE(hex = "0x01800011", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    BALANCED_PHASES(hex = "0x01800012", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    INSTALLED_PEAK_POWER(hex = "0x01800013", type = DataType.UINT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DERATE_AT_PERCENT_VALUE(hex = "0x01800014", type = DataType.FLOAT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DERATE_AT_POWER_VALUE(hex = "0x01800015", type = DataType.FLOAT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    ERROR_BUZZER_ENABLED(hex = "0x01800016", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_BALANCED_PHASES(hex = "0x01800017", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_INSTALLED_PEAK_POWER(hex = "0x01800018", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_DERATE_PERCENT(hex = "0x01800019", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_ERROR_BUZZER_ENABLED(hex = "0x0180001A", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    START_ADJUST_BATTERY_VOLTAGE(hex = "0x0180001B", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    CANCEL_ADJUST_BATTERY_VOLTAGE(hex = "0x0180001C", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    ADJUST_BATTERY_VOLTAGE_STATUS(hex = "0x0180001D", type = DataType.UINT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    CONFIRM_ERRORS(hex = "0x0180001E", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    POWER_WB_ALL(hex = "0x0180001F", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    POWER_WB_SOLAR(hex = "0x01800020", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    EXT_SRC_AVAILABLE(hex = "0x01800021", type = DataType.CHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en: This TAG can be used to intervene in the control of the S10s.
     * In DC systems, the charging power is limited to the applied PV power; in AC and hybrid systems, the charging power can also be greater than the PV power.
     * Caution: If this command is used to intervene, any feed-in reduction that may have been set will NOT be taken into account!
     * Attention: The command must be set at least every 30 seconds, otherwise the EMS goes into normal mode.
     *
     *
     * de: Mit diesem TAG kann in die Regelung des S10s eingegriffen werden.
     * Bei DC-Systemen ist die Ladeleistung auf die anliegende PV-Leistung beschränkt, bei AC und Hybrid-Systemen
     * kann die Ladeleistung auch größer der PV-Leistung sein.
     * Achtung: Wenn mit diesem Kommando eingegriffen wird, wird eine eventuell gesetzte Einspeisereduzierung NICHT beachtet!
     * Achtung: Das Kommando muss mindestens alle 30 Sekunden gesetzt werden, ansonsten geht das EMS in den Normalmodus.
     *
     */
    REQ_SET_POWER(hex = "0x01000030", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en: The mode the S10 should go into
     * 0=AUTO/NORMAL MODE
     * 1=IDLE MODE
     * 2=DISCHARGE MODE
     * 3=LOAD MODE
     * 4=NET_LOAD MODE
     *
     *
     * de: Der Modus in den das S10 gehen soll:
     *
     * 0=AUTO/NORMAL MODUS
     * 1=IDLE MODUS
     * 2=ENTLADEN MODUS
     * 3=LADEN MODUS
     * 4=NETZ_LADE MODUS
     */
    REQ_SET_POWER_MODE(hex = "0x01000031", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_POWER_VALUE(hex = "0x01000032", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en: The response to a REQ_SET_POWER. The received values are reflected back.
     *
     * de: Die Antwort auf einen REQ_SET_POWER. Es werden die empfangenen Werte zurückgespiegelt.
     *
     */
    SET_POWER(hex = "0x01800030", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en: Returns the current status of the EMS.
     *
     * de: Liefert den aktuellen Status des EMS.
     */
    REQ_STATUS(hex = "0x01000040", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    STATUS(hex = "0x01800040", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_USED_CHARGE_LIMIT(hex = "0x01000041", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_BAT_CHARGE_LIMIT(hex = "0x01000042", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DCDC_CHARGE_LIMIT(hex = "0x01000043", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_USER_CHARGE_LIMIT(hex = "0x01000044", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_USED_DISCHARGE_LIMIT(hex = "0x01000045", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_BAT_DISCHARGE_LIMIT(hex = "0x01000046", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DCDC_DISCHARGE_LIMIT(hex = "0x01000047", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_USER_DISCHARGE_LIMIT(hex = "0x01000048", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    USED_CHARGE_LIMIT(hex = "0x01800041", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    BAT_CHARGE_LIMIT(hex = "0x01800042", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCDC_CHARGE_LIMIT(hex = "0x01800043", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    USER_CHARGE_LIMIT(hex = "0x01800044", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    USED_DISCHARGE_LIMIT(hex = "0x01800045", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    BAT_DISCHARGE_LIMIT(hex = "0x01800046", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCDC_DISCHARGE_LIMIT(hex = "0x01800047", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    USER_DISCHARGE_LIMIT(hex = "0x01800048", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en: Sets a control offset on the battery power controller
     *
     * de: Setzt einen Regelungsoffset auf den Batterieleistungssteuerung
     *
     */
    REQ_SET_POWER_CONTROL_OFFSET(hex = "0x01000060", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en: Reply with the offset actually set
     *
     * de: Antwort mit dem tatsächlich gesetzten Offset
     */
    SET_POWER_CONTROL_OFFSET(hex = "0x01800060", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_REMAINING_BAT_CHARGE_POWER(hex = "0x01000071", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en: Still possible charging power after subtracting the current charging power from the current limit
     *
     * de: Noch mögliche Ladeleistung nach Abzug der momentanen Ladeleistung vom momentanen Limit
     *
     */
    REMAINING_BAT_CHARGE_POWER(hex = "0x01800071", type = DataType.UINT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_REMAINING_BAT_DISCHARGE_POWER(hex = "0x01000072", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en: Still possible discharge capacity after subtracting the current discharge capacity from the current limit
     *
     * de: Noch mögliche Entladeleistung nach Abzug der momentanen Entladeleistung vom momentanen Limit
     *
     */
    REMAINING_BAT_DISCHARGE_POWER(hex = "0x01800072", type = DataType.UINT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_EMERGENCY_POWER_STATUS(hex = "0x01000073", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     *
     * 0x00=NOT_POSSIBLE
     * 0x01=ACTIVE
     * 0x02=NOT_ACTIVE
     * 0x03=NOT_AVAILABLE
     * 0x04=SWITCH_IN_ISLAND_STATE
     */
    EMERGENCY_POWER_STATUS(hex = "0x01800073", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en: Starts or stops the emergency power mode
     *
     * de: Startet oder stoppt den Notstrommodus
     *
     * 0x00=NORMAL_GRID_MODE
     * 0x01=EMERGENCY_MODE
     * 0x02=ISLAND_NO_POWER_MODE
     */
    REQ_SET_EMERGENCY_POWER(hex = "0x01000074", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_EMERGENCY_POWER(hex = "0x01800074", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en: The available solar power is overwritten with this value! (This value is sent to the WallBox)
     *
     * de: Die verfügbare Solarleistung wird mit diesem Wert überschrieben! (Dieser Wert wird an die WallBox gesendet)
     *
     */
    REQ_SET_OVERRIDE_AVAILABLE_POWER(hex = "0x01000075", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_OVERRIDE_AVAILABLE_POWER(hex = "0x01800075", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     * 1=Mode activated
     * 0=Mode deactivated
     * 0xFF=Activation not possible (BatteryBeforeCar still active?)
     *
     *
     * de:
     * 1=Modus aktiviert
     * 0=Modus deaktiviert
     * 0xFF=Aktivierung nicht möglich (BatteryBeforeCar noch aktiv?)
     *
     */
    SET_BATTERY_TO_CAR_MODE(hex = "0x01800076", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en: Activates, deactivates the BatteryToCar mode
     *
     * de: Aktiviert, deaktiviert den BatteryToCar Modus
     */
    REQ_SET_BATTERY_TO_CAR_MODE(hex = "0x01000076", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en: 1 = Mode activated / 0 = Mode deactivated
     *
     * de: 1 = Modus aktiviert / 0 = Modus deaktiviert
     *
     */
    BATTERY_TO_CAR_MODE(hex = "0x01800077", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en: Status query of the BatteryToCar mode
     *
     * de: Statusabfrage des BatteryToCar Modus
     */
    REQ_BATTERY_TO_CAR_MODE(hex = "0x01000077", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     * 1=Mode activated
     * 0=Mode deactivated
     * 0xFF=Activation not possible (BatteryToCar still active?)
     *
     *
     * de:
     * 1=Modus aktiviert
     * 0=Modus deaktiviert
     * 0xFF=Aktivierung nicht möglich (BatteryToCar noch aktiv?)
     *
     */
    SET_BATTERY_BEFORE_CAR_MODE(hex = "0x01800078", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en: Activates, deactivates the BatteryBeforeCar mode
     *
     * de: Aktiviert, deaktiviert den BatteryBeforeCar Modus
     *
     */
    REQ_SET_BATTERY_BEFORE_CAR_MODE(hex = "0x01000078", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en: 1 = Mode activated / 0 = Mode deactivated
     *
     * de: 1 = Modus aktiviert / 0 = Modus deaktiviert
     *
     */
    BATTERY_BEFORE_CAR_MODE(hex = "0x01800079", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en: Status query of the BatteryBeforeCar mode
     *
     * de: Statusabfrage des BatteryBeforeCar Modus
     *
     */
    REQ_BATTERY_BEFORE_CAR_MODE(hex = "0x01000079", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_GET_IDLE_PERIODS(hex = "0x01000080", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GET_IDLE_PERIODS(hex = "0x01800080", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_IDLE_PERIODS(hex = "0x01000081", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_IDLE_PERIODS(hex = "0x01800081", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IDLE_PERIOD(hex = "0x01000082", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IDLE_PERIOD_TYPE(hex = "0x01000083", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IDLE_PERIOD_DAY(hex = "0x01000084", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IDLE_PERIOD_START(hex = "0x01000085", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IDLE_PERIOD_END(hex = "0x01000086", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IDLE_PERIOD_HOUR(hex = "0x01000087", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IDLE_PERIOD_MINUTE(hex = "0x01000088", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IDLE_PERIOD_ACTIVE(hex = "0x01000089", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_IDLE_PERIOD_CHANGE_MARKER(hex = "0x0100008A", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IDLE_PERIOD_CHANGE_MARKER(hex = "0x0180008A", type = DataType.UCHAR8),

    /**
     * Request parameter to query the current energy settings of the home power plant. A data block of the type [EMSTag.GET_POWER_SETTINGS] is supplied as a response.
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_GET_POWER_SETTINGS(hex = "0x0100008B", type = DataType.NONE),

    /**
     * Response parameter to a [EMSTag.REQ_GET_POWER_SETTINGS] request parameter. Contains the current energy settings of the home power plant.
     * So far it is known that the container can contain the following data blocks. It is unclear whether this is always the case.
     *
     * - [EMSTag.POWER_LIMITS_USED]
     * - [EMSTag.MAX_CHARGE_POWER]
     * - [EMSTag.MAX_DISCHARGE_POWER]
     * - [EMSTag.DISCHARGE_START_POWER]
     * - [EMSTag.POWERSAVE_ENABLED]
     * - [EMSTag.WEATHER_REGULATED_CHARGE_ENABLED]
     * - [EMSTag.WEATHER_FORECAST_MODE]
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GET_POWER_SETTINGS(hex = "0x0180008B", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en: Used to set the power settings. Can contain the following TAGs:
     * POWER_LIMITS_USED, MAX_CHARGE_POWER, MAX_DISCHARGE_POWER, MINIMUM_DISCHARGE_POWER, POWERSAVE_ENABLED, WEATHER_REGULATED_CHARGE_ENABLED
     *
     *
     * de: Wird zum setzen der Power Settings verwendet. Kann folgende TAGs enthalten:
     * POWER_LIMITS_USED, MAX_CHARGE_POWER, MAX_DISCHARGE_POWER, MINIMUM_DISCHARGE_POWER, POWERSAVE_ENABLED, WEATHER_REGULATED_CHARGE_ENABLED
     *
     */
    REQ_SET_POWER_SETTINGS(hex = "0x0100008C", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en: Contains the response to the setting of the PowerSettings. Returns a corresponding element for each value
     * set. with return code for each value set. May contain the following TAGS:
     * RES_POWER_LIMITS_USED, RES_MAX_CHARGE_POWER, RES_MAX_DISCHARGE_POWER, RES_MINIMUM_DISCHARGE_POWER, RES_POWERSAVE_ENABLED, RES_WEATHER_REGULATED_CHARGE_ENABLED
     *
     *
     * de: Enthält die Antwort auf das Setzen der PowerSettings. Gibt für jeden gesetzen Wert ein entsprechendes Element
     * mit Rückgabecode zurück. Kann die Folgenden TAGS enthalten:
     * RES_POWER_LIMITS_USED, RES_MAX_CHARGE_POWER, RES_MAX_DISCHARGE_POWER, RES_MINIMUM_DISCHARGE_POWER, RES_POWERSAVE_ENABLED, RES_WEATHER_REGULATED_CHARGE_ENABLED
     *
     */
    SET_POWER_SETTINGS(hex = "0x0180008C", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    POWER_LIMITS_USED(hex = "0x01000100", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    RES_POWER_LIMITS_USED(hex = "0x01800100", type = DataType.CHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MAX_CHARGE_POWER(hex = "0x01000101", type = DataType.UINT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     * 1 if successful, but the limit is below the recommended limit.
     * 0 Values set successfully
     * -1 Value outside the permissible range
     * -2 set currently not possible, try again later
     *
     *
     * de:
     * 1 bei Erfolg, allerdings ist das limit unterhalb des empfohlenden Limits
     * 0 Werte erfolgreich gesetzt
     * -1 Wert außerhalb des zulässigen Bereichs
     * -2 setzen momentan nicht möglich, später erneut versuchen
     *
     */
    RES_MAX_CHARGE_POWER(hex = "0x01800101", type = DataType.CHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MAX_DISCHARGE_POWER(hex = "0x01000102", type = DataType.UINT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     * 1 if successful, but the limit is below the recommended limit.
     * 0 Values set successfully
     * -1 Value outside the permissible range
     * -2 set currently not possible, try again later
     *
     *
     * de:
     * 1 bei Erfolg, allerdings ist das limit unterhalb des empfohlenden Limits
     * 0 Werte erfolgreich gesetzt
     * -1 Wert außerhalb des zulässigen Bereichs
     * -2 setzen momentan nicht möglich, später erneut versuchen
     *
     */
    RES_MAX_DISCHARGE_POWER(hex = "0x01800102", type = DataType.CHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DISCHARGE_START_POWER(hex = "0x01000103", type = DataType.UINT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     * 0 Values set successfully
     * -1 Value outside the permissible range
     * -2 set currently not possible, try again later
     *
     *
     * de:
     * 0 Werte erfolgreich gesetzt
     * -1 Wert außerhalb des zulässigen Bereichs
     * -2 setzen momentan nicht möglich, später erneut versuchen
     *
     */
    RES_DISCHARGE_START_POWER(hex = "0x01800103", type = DataType.CHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    POWERSAVE_ENABLED(hex = "0x01000104", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    RES_POWERSAVE_ENABLED(hex = "0x01800104", type = DataType.CHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    WEATHER_REGULATED_CHARGE_ENABLED(hex = "0x01000105", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    WEATHER_FORECAST_MODE(hex = "0x01000106", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    RES_WEATHER_REGULATED_CHARGE_ENABLED(hex = "0x01800105", type = DataType.CHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SETTINGS_CHANGE_MARKER(hex = "0x0100008D", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SETTINGS_CHANGE_MARKER(hex = "0x0180008D", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_GET_MANUAL_CHARGE(hex = "0x0100008E", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GET_MANUAL_CHARGE(hex = "0x0180008E", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MANUAL_CHARGE_START_COUNTER(hex = "0x01000150", type = DataType.UINT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MANUAL_CHARGE_ACTIVE(hex = "0x01000151", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MANUAL_CHARGE_ENERGY_COUNTER(hex = "0x01000152", type = DataType.UINT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MANUAL_CHARGE_LASTSTART(hex = "0x01000153", type = DataType.TIMESTAMP),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_START_MANUAL_CHARGE(hex = "0x0100008F", type = DataType.UINT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    START_MANUAL_CHARGE(hex = "0x0180008F", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_START_EMERGENCYPOWER_TEST(hex = "0x01000090", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en: Returns the number of started emergency power tests as a response
     *
     * de: Gibt als Rückantwort die Anzahl der gestarteten Notstromtests zurück
     *
     */
    START_EMERGENCYPOWER_TEST(hex = "0x01800090", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_GET_GENERATOR_STATE(hex = "0x01000091", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     * 0x00=Idle
     * 0x01=HeatUp
     * 0x02=HeatUpDone
     * 0x03=Starting
     * 0x04=StartingPause
     * 0x05=Running
     * 0x06=Stopping
     * 0x07=Stopped
     * 0x10=RelaisControlMode
     * 0xFF=No generator available or generator interface does not communicate
     *
     *
     * de:
     * 0x00=Idle
     * 0x01=HeatUp
     * 0x02=HeatUpDone
     * 0x03=Starting
     * 0x04=StartingPause
     * 0x05=Running
     * 0x06=Stopping
     * 0x07=Stopped
     * 0x10=RelaisControlMode
     * 0xFF=Kein Generator vorhanden oder Generatorinterface kommuniziert nicht
     *
     */
    GET_GENERATOR_STATE(hex = "0x01800091", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     * 0x01=Manual generator stop (if currently active) and activate normal operation.
     * 0x02=Manual generator start
     *
     *
     * de:
     * 0x01=Manueller Generatorstop (falls aktuell aktiv) und aktivieren des Normalbetrieb
     * 0x02=Manueller Generatorstart
     *
     */
    REQ_SET_GENERATOR_MODE(hex = "0x01000092", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en: Returns as response
     * 0x01=Successful
     * 0xFE=Unknown generator mode
     * 0xFF=No generator present or generator interface not communicating
     *
     *
     * de: Gibt als Rückantwort
     * 0x01=Erfolgreich
     * 0xFE=Unbekannter Generatormodus
     * 0xFF=Kein Generator vorhanden oder Generatorinterface kommuniziert nicht
     *
     */
    SET_GENERATOR_MODE(hex = "0x01800092", type = DataType.UCHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_EMERGENCYPOWER_TEST_STATUS(hex = "0x01000093", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    EMERGENCYPOWER_TEST_STATUS(hex = "0x01800093", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    EPTEST_NEXT_TESTSTART(hex = "0x01000094", type = DataType.TIMESTAMP),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    EPTEST_START_COUNTER(hex = "0x01000095", type = DataType.UINT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    EPTEST_RUNNING(hex = "0x01000096", type = DataType.BOOL),

    /**
     * Request parameter to retrieve the system specification of the home power plant. A block of the type [EMSTag.GET_SYS_SPECS] is delivered as a response
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_GET_SYS_SPECS(hex = "0x01000097", type = DataType.NONE),

    /**
     * Response parameter to a request parameter of type [EMSTag.REQ_GET_SYS_SPECS].
     *
     * This container contains a list of further data blocks, each of which is again a container of type [EMSTag.SYS_SPEC].
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: Enthält 1 -x Untercontainer vom Typ SYS_SPEC
     *
     * @see de.jnkconsulting.e3dc.easyrscp.api.frame.SysSpecData
     */
    GET_SYS_SPECS(hex = "0x01800098", type = DataType.CONTAINER),

    /**
     * Single response container delivered within [EMSTag.GET_SYS_SPECS] data blocks.
     *
     * Each container consists of three data blocks:
     * - [EMSTag.SYS_SPEC_INDEX]
     * - [EMSTag.SYS_SPEC_NAME]
     * - [EMSTag.SYS_SPEC_VALUE_INT] or [EMSTag.SYS_SPEC_VALUE_STRING]
     *
     * Original E3DC Documentation:
     *
     * en: Contains the elements SYS_SPEC_INDEX, SYS_SPEC_NAME, SYS_SPEC_VALUE and identifies a system property.
     *
     * de: Enthält die Elemente SYS_SPEC_INDEX, SYS_SPEC_NAME, SYS_SPEC_VALUE und kennzeichnet eine Systemeigenschaft
     *
     * @see de.jnkconsulting.e3dc.easyrscp.api.frame.SysSpecData
     */
    SYS_SPEC(hex = "0x01000099", type = DataType.CONTAINER),

    /**
     * Data block indicating the position (index) of the enclosing [EMSTag.SYS_SPEC] data block in the [EMSTag.GET_SYS_SPECS] container.
     *
     * Original E3DC Documentation:
     *
     * en: The index of the system property
     *
     * de: Der Index der Systemeigenschaft
     *
     */
    SYS_SPEC_INDEX(hex = "0x0100009A", type = DataType.INT32),

    /**
     * Data block which specifies the name of the specification value. This data block occurs within an [EMSTag.SYS_SPEC] container.
     *
     * The possible values have an enum character. All known values can be taken from the class [de.jnkconsulting.e3dc.easyrscp.api.frame.EMSSysSpecName].
     *
     * Original E3DC Documentation:
     *
     * en: The name of the system property
     *
     * de: Der Name der Systemeigenschaft
     *
     * @see de.jnkconsulting.e3dc.easyrscp.api.frame.EMSSysSpecName
     */
    SYS_SPEC_NAME(hex = "0x0100009B", type = DataType.STRING),

    /**
     * Data block that specifies the value of a system property as [Int]. This data block occurs within an [EMSTag.SYS_SPEC] container.
     *
     * Original E3DC Documentation:
     *
     * en: The value of the system property
     *
     * de: Der Wert der Systemeigenschaft
     *
     */
    SYS_SPEC_VALUE_INT(hex = "0x0100009C", type = DataType.INT32),

    /**
     * Data block that specifies the value of a system property as a string. This data block occurs within an [EMSTag.SYS_SPEC] container.
     *
     *
     * ATTENTION: Until now I have never seen this block. At my home power plant only blocks of type [EMSTag.SYS_SPEC_VALUE_INT] are delivered
     *
     * Original E3DC Documentation:
     *
     * en: The value of the system property as a string
     *
     * de: Der Wert der Systemeigenschaft als String
     *
     */
    SYS_SPEC_VALUE_STRING(hex = "0x0100009D", type = DataType.STRING),

    /**
     * Original E3DC Documentation:
     *
     * en: Query whether the S10-EMS is ready for operation.
     *
     * de: Abfrage ob das S10-EMS betriebsbereit ist.
     *
     */
    REQ_ALIVE(hex = "0x01050000", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    ALIVE(hex = "0x01850000", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x01FFFFFF", type = DataType.ERROR),

}


