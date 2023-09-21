package de.jnkconsulting.e3dc.easyrscp.api.frame.tags

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Namespace
import de.jnkconsulting.e3dc.easyrscp.api.frame.Tag

/**
 * Contains tags for reading and controlling the battery
 *
 * @param namespace Der Namespace des Tags für die Abbildung des jeweiligen Bereichs
 * @param hex Code of the tag in HexString format (0x0304001)
 * @param type Tag data type [DataType]
 *
 * @since 2.0
 */
enum class BatTag(
    override val namespace: Namespace = Namespace.BAT,
    override val hex: String,
    override val type: DataType
) : Tag {

    /**
     * hex = "0x03040000", type = DataType.CONTAINER
     *
     * Original E3DC Documentation:
     *
     * en: Contains all request TAGs, the container MUST contain an index
     *
     * de: Beinhaltet alle Anfrage-TAGs, der Container MUSS einen Index enthalten
     *
     */
    REQ_DATA(hex = "0x03040000", type = DataType.CONTAINER),

    /**
     * hex = "0x03040001", type = DataType.UINT16
     *
     * Original E3DC Documentation:
     *
     * en: Index of the requested device (at the moment always 0 for the battery), can occur in the request and in the response.
     *
     * de: Index des angefragten Gerätes (Im Moment immer 0 bei der Batterie), kann in der Anfrage und in der Antwort vorkommen.
     *
     */
    INDEX(hex = "0x03040001", type = DataType.UINT16),

    /**
     * hex = "0x03840000", type = DataType.CONTAINER
     *
     * Original E3DC Documentation:
     *
     * en: Response with all data of the REQ_DATA request
     *
     * de: Antwort mit allen Daten der REQ_DATA Anfrage
     *
     */
    DATA(hex = "0x03840000", type = DataType.CONTAINER),

    /**
     * hex = "0x03800001", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en: Return value for calculated SOC value
     *
     * de: Rückgabewert für errechnet SOC Wert
     *
     */
    RSOC(hex = "0x03800001", type = DataType.FLOAT32),

    /**
     * hex = "0x03800002", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en: Return value for total battery voltage
     *
     * de: Rückgabewert für gesamte Batteriespannung
     *
     */
    MODULE_VOLTAGE(hex = "0x03800002", type = DataType.FLOAT32),

    /**
     * hex = "0x03800003", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en: Return value for total battery current
     *
     * de: Rückgabewert für gesamten Batteriestrom
     *
     */
    CURRENT(hex = "0x03800003", type = DataType.FLOAT32),

    /**
     * hex = "0x03800004", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en: Return value for maximum battery voltage
     *
     * de: Rückgabewert für maximale Batteriespannung
     *
     */
    MAX_BAT_VOLTAGE(hex = "0x03800004", type = DataType.FLOAT32),

    /**
     * hex = "0x03800005", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en: Return value for maximum battery charging current
     *
     * de: Rückgabewert für maximale Batterieladestrom
     *
     */
    MAX_CHARGE_CURRENT(hex = "0x03800005", type = DataType.FLOAT32),

    /**
     * hex = "0x03800006", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en: Return value for end-of-discharge voltage
     *
     * de: Rückgabewert für Entladeschlussspannung
     *
     */
    EOD_VOLTAGE(hex = "0x03800006", type = DataType.FLOAT32),

    /**
     * hex = "0x03800007", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en: Return value for maximum battery discharge current
     *
     * de: Rückgabewert für maximale Batterieentladestrom
     *
     */
    MAX_DISCHARGE_CURRENT(hex = "0x03800007", type = DataType.FLOAT32),

    /**
     * hex = "0x03800008", type = DataType.UINT32
     *
     * Original E3DC Documentation:
     *
     * en: Return value for battery charge cycles
     *
     * de: Rückgabewert für Batterieladezyklen
     *
     */
    CHARGE_CYCLES(hex = "0x03800008", type = DataType.UINT32),

    /**
     * hex = "0x03800009", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en: Return value for the terminal voltage
     *
     * de: Rückgabewert für die Terminalspannung
     *
     */
    TERMINAL_VOLTAGE(hex = "0x03800009", type = DataType.FLOAT32),

    /**
     * hex = "0x0380000A", type = DataType.BITFIELD
     *
     * Original E3DC Documentation:
     *
     * en: Return value for battery status
     *
     * de: Rückgabewert für Batteriestatus
     *
     */
    STATUS_CODE(hex = "0x0380000A", type = DataType.BITFIELD),

    /**
     * hex = "0x0380000B", type = DataType.BITFIELD
     *
     * Original E3DC Documentation:
     *
     * en: Return value for battery error
     *
     * de: Rückgabewert für Batteriefehler
     *
     */
    ERROR_CODE(hex = "0x0380000B", type = DataType.BITFIELD),

    /**
     * hex = "0x0380000C", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en: Return value for battery designation
     *
     * de: Rückgabewert für Batteriebezeichnung
     *
     */
    DEVICE_NAME(hex = "0x0380000C", type = DataType.STRING),

    /**
     * hex = "0x0380000D", type = DataType.UCHAR8
     *
     * Original E3DC Documentation:
     *
     * en: Return value for number of DCBs found
     *
     * de: Rückgabewert für Anzahl der gefundenen DCBs
     *
     */
    DCB_COUNT(hex = "0x0380000D", type = DataType.UCHAR8),

    /**
     * hex = "0x03800016", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MAX_DCB_CELL_TEMPERATURE(hex = "0x03800016", type = DataType.FLOAT32),

    /**
     * hex = "0x03800017", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     *
     */
    MIN_DCB_CELL_TEMPERATURE(hex = "0x03800017", type = DataType.FLOAT32),

    /**
     * hex = "0x03800019", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en: A container with all temperatures for the requested DCB.
     *
     * de: Ein Container mit allen Temperaturen für die angefragte DCB.
     */
    DCB_CELL_TEMPERATURE(hex = "0x03800019", type = DataType.FLOAT32),

    /**
     * hex = "0x0380001B", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en: A container with all voltages for the requested DCB.
     *
     * de: Ein Container mit allen Spannungen für die angefragte DCB.
     *
     */
    DCB_CELL_VOLTAGE(hex = "0x0380001B", type = DataType.FLOAT32),

    /**
     * hex = "0x0380001E", type = DataType.BOOL
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    READY_FOR_SHUTDOWN(hex = "0x0380001E", type = DataType.BOOL),

    /**
     * hex = "0x03800020", type = DataType.CONTAINER
     *
     * Original E3DC Documentation:
     *
     * en: This container contains the response to a REQ_INFO. It always contains the following TAGs:
     * BAT_RSOC, BAT_MODULE_VOLTAGE, BAT_CURRENT, BAT_MAX_DCB_CELL_TEMPERATURE, BAT_STATUS_CODE, BAT_ERROR_CODE, BAT_CHARGE_CYCLES.
     *
     *
     * de: Dieser Container beinhaltet die Antwort auf ein REQ_INFO. Es beinhaltet immer die folgenden TAGs:
     * BAT_RSOC, BAT_MODULE_VOLTAGE, BAT_CURRENT, BAT_MAX_DCB_CELL_TEMPERATURE, BAT_STATUS_CODE, BAT_ERROR_CODE, BAT_CHARGE_CYCLES
     *
     */
    INFO(hex = "0x03800020", type = DataType.CONTAINER),

    /**
     * hex = "0x03800021", type = DataType.UCHAR8
     *
     * Original E3DC Documentation:
     *
     * en: Battery training mode
     * 0=Not in training
     * 1=Training mode Discharge
     * 2=Training mode Charging
     *
     *
     * de: Batterietrainingmodus
     * 0=Nicht im Training
     * 1=Trainingmodus Entladen
     * 2=Trainingmodus Laden
     *
     */
    TRAINING_MODE(hex = "0x03800021", type = DataType.UCHAR8),

    /**
     * hex = "0x03000001", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_RSOC(hex = "0x03000001", type = DataType.NONE),

    /**
     * hex = "0x03000002", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_MODULE_VOLTAGE(hex = "0x03000002", type = DataType.NONE),

    /**
     * hex = "0x03000003", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_CURRENT(hex = "0x03000003", type = DataType.NONE),

    /**
     * hex = "0x03000004", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_MAX_BAT_VOLTAGE(hex = "0x03000004", type = DataType.NONE),

    /**
     * hex = "0x03000005", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_MAX_CHARGE_CURRENT(hex = "0x03000005", type = DataType.NONE),

    /**
     * hex = "0x03000006", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_EOD_VOLTAGE(hex = "0x03000006", type = DataType.NONE),

    /**
     * hex = "0x03000007", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_MAX_DISCHARGE_CURRENT(hex = "0x03000007", type = DataType.NONE),

    /**
     * hex = "0x03000008", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_CHARGE_CYCLES(hex = "0x03000008", type = DataType.NONE),

    /**
     * hex = "0x03000009", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_TERMINAL_VOLTAGE(hex = "0x03000009", type = DataType.NONE),

    /**
     * hex = "0x0300000A", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_STATUS_CODE(hex = "0x0300000A", type = DataType.NONE),

    /**
     * hex = "0x0300000B", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_ERROR_CODE(hex = "0x0300000B", type = DataType.NONE),

    /**
     * hex = "0x0300000C", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_DEVICE_NAME(hex = "0x0300000C", type = DataType.NONE),

    /**
     * hex = "0x0300000D", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_DCB_COUNT(hex = "0x0300000D", type = DataType.NONE),

    /**
     * hex = "0x03000016", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_MAX_DCB_CELL_TEMPERATURE(hex = "0x03000016", type = DataType.NONE),

    /**
     * hex = "0x03000017", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_MIN_DCB_CELL_TEMPERATURE(hex = "0x03000017", type = DataType.NONE),

    /**
     * hex = "0x0300001E", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_READY_FOR_SHUTDOWN(hex = "0x0300001E", type = DataType.NONE),

    /**
     * hex = "0x03000020", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_INFO(hex = "0x03000020", type = DataType.NONE),

    /**
     * hex = "0x03000021", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_BAT_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_BAT_DATA Container verwendet werden!
     *
     */
    REQ_TRAINING_MODE(hex = "0x03000021", type = DataType.NONE),

    /**
     * hex = "0x03800100", type = DataType.UINT16
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_INDEX(hex = "0x03800100", type = DataType.UINT16),

    /**
     * hex = "0x03800101", type = DataType.UINT64
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_LAST_MESSAGE_TIMESTAMP(hex = "0x03800101", type = DataType.UINT64),

    /**
     * hex = "0x03800102", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_MAX_CHARGE_VOLTAGE(hex = "0x03800102", type = DataType.FLOAT32),

    /**
     * hex = "0x03800103", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_MAX_CHARGE_CURRENT(hex = "0x03800103", type = DataType.FLOAT32),

    /**
     * hex = "0x03800104", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_END_OF_DISCHARGE(hex = "0x03800104", type = DataType.FLOAT32),

    /**
     * hex = "0x03800105", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_MAX_DISCHARGE_CURRENT(hex = "0x03800105", type = DataType.FLOAT32),

    /**
     * hex = "0x03800106", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_FULL_CHARGE_CAPACITY(hex = "0x03800106", type = DataType.FLOAT32),

    /**
     * hex = "0x03800107", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_REMAINING_CAPACITY(hex = "0x03800107", type = DataType.FLOAT32),

    /**
     * hex = "0x03800108", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_SOC(hex = "0x03800108", type = DataType.FLOAT32),

    /**
     * hex = "0x03800109", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_SOH(hex = "0x03800109", type = DataType.FLOAT32),

    /**
     * hex = "0x03800110", type = DataType.UINT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_CYCLE_COUNT(hex = "0x03800110", type = DataType.UINT32),

    /**
     * hex = "0x03800111", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_CURRENT(hex = "0x03800111", type = DataType.FLOAT32),

    /**
     * hex = "0x03800112", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_VOLTAGE(hex = "0x03800112", type = DataType.FLOAT32),

    /**
     * hex = "0x03800113", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_CURRENT_AVG_30S(hex = "0x03800113", type = DataType.FLOAT32),

    /**
     * hex = "0x03800114", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_VOLTAGE_AVG_30S(hex = "0x03800114", type = DataType.FLOAT32),

    /**
     * hex = "0x03800115", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_DESIGN_CAPACITY(hex = "0x03800115", type = DataType.FLOAT32),

    /**
     * hex = "0x03800116", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_DESIGN_VOLTAGE(hex = "0x03800116", type = DataType.FLOAT32),

    /**
     * hex = "0x03800117", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_CHARGE_LOW_TEMPERATURE(hex = "0x03800117", type = DataType.FLOAT32),

    /**
     * hex = "0x03800118", type = DataType.FLOAT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_CHARGE_HIGH_TEMPERATURE(hex = "0x03800118", type = DataType.FLOAT32),

    /**
     * hex = "0x03800119", type = DataType.UINT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_MANUFACTURE_DATE(hex = "0x03800119", type = DataType.UINT32),

    /**
     * hex = "0x03800120", type = DataType.UINT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_SERIALNO(hex = "0x03800120", type = DataType.UINT32),

    /**
     * hex = "0x03800121", type = DataType.UINT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_PROTOCOL_VERSION(hex = "0x03800121", type = DataType.UINT32),

    /**
     * hex = "0x03800122", type = DataType.UINT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_FW_VERSION(hex = "0x03800122", type = DataType.UINT32),

    /**
     * hex = "0x03800123", type = DataType.UINT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_DATA_TABLE_VERSION(hex = "0x03800123", type = DataType.UINT32),

    /**
     * hex = "0x03800124", type = DataType.UINT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_PCB_VERSION(hex = "0x03800124", type = DataType.UINT32),

    /**
     * hex = "0x03060000", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DEVICE_STATE(hex = "0x03060000", type = DataType.NONE),

    /**
     * hex = "0x03860000", type = DataType.CONTAINER
     *
     * Original E3DC Documentation:
     *
     * en: DEVICE_CONNECTED & DEVICE_WORKING & DEVICE_IN_SERVICE
     *
     * de: DEVICE_CONNECTED & DEVICE_WORKING & DEVICE_IN_SERVICE
     *
     */
    DEVICE_STATE(hex = "0x03860000", type = DataType.CONTAINER),

    /**
     * hex = "0x03860001", type = DataType.BOOL
     *
     * Original E3DC Documentation:
     *
     * en: Occurs only in the BAT_DEVICE_STATE response
     *
     * de: Kommt nur im BAT_DEVICE_STATE Antwort vor
     *
     */
    DEVICE_CONNECTED(hex = "0x03860001", type = DataType.BOOL),

    /**
     * hex = "0x03860002", type = DataType.BOOL
     *
     * Original E3DC Documentation:
     *
     * en: Occurs only in the BAT_DEVICE_STATE response
     *
     * de: Kommt nur im BAT_DEVICE_STATE Antwort vor
     *
     */
    DEVICE_WORKING(hex = "0x03860002", type = DataType.BOOL),

    /**
     * hex = "0x03860003", type = DataType.BOOL
     *
     * Original E3DC Documentation:
     *
     * en: Occurs only in the BAT_DEVICE_STATE response
     *
     * de: Kommt nur im BAT_DEVICE_STATE Antwort vor
     *
     */
    DEVICE_IN_SERVICE(hex = "0x03860003", type = DataType.BOOL),

    /**
     * hex = "0x03FFFFFF", type = DataType.ERROR
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x03FFFFFF", type = DataType.ERROR),


}
