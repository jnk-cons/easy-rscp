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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_DATA&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_DATA:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.INDEX&labels=documentation&body=Documentation+update+for+enum+BatTag.INDEX:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DATA&labels=documentation&body=Documentation+update+for+enum+BatTag.DATA:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.RSOC&labels=documentation&body=Documentation+update+for+enum+BatTag.RSOC:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.MODULE_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.MODULE_VOLTAGE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.CURRENT:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.MAX_BAT_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.MAX_BAT_VOLTAGE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.MAX_CHARGE_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.MAX_CHARGE_CURRENT:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.EOD_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.EOD_VOLTAGE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.MAX_DISCHARGE_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.MAX_DISCHARGE_CURRENT:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.CHARGE_CYCLES&labels=documentation&body=Documentation+update+for+enum+BatTag.CHARGE_CYCLES:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.TERMINAL_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.TERMINAL_VOLTAGE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.STATUS_CODE&labels=documentation&body=Documentation+update+for+enum+BatTag.STATUS_CODE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.ERROR_CODE&labels=documentation&body=Documentation+update+for+enum+BatTag.ERROR_CODE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DEVICE_NAME&labels=documentation&body=Documentation+update+for+enum+BatTag.DEVICE_NAME:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_COUNT&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_COUNT:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.MAX_DCB_CELL_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+BatTag.MAX_DCB_CELL_TEMPERATURE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.MIN_DCB_CELL_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+BatTag.MIN_DCB_CELL_TEMPERATURE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_CELL_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_CELL_TEMPERATURE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_CELL_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_CELL_VOLTAGE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.READY_FOR_SHUTDOWN&labels=documentation&body=Documentation+update+for+enum+BatTag.READY_FOR_SHUTDOWN:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.INFO&labels=documentation&body=Documentation+update+for+enum+BatTag.INFO:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.TRAINING_MODE&labels=documentation&body=Documentation+update+for+enum+BatTag.TRAINING_MODE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_RSOC&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_RSOC:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_MODULE_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MODULE_VOLTAGE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_CURRENT:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_MAX_BAT_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MAX_BAT_VOLTAGE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_MAX_CHARGE_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MAX_CHARGE_CURRENT:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_EOD_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_EOD_VOLTAGE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_MAX_DISCHARGE_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MAX_DISCHARGE_CURRENT:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_CHARGE_CYCLES&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_CHARGE_CYCLES:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_TERMINAL_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_TERMINAL_VOLTAGE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_STATUS_CODE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_STATUS_CODE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_ERROR_CODE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_ERROR_CODE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_DEVICE_NAME&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_DEVICE_NAME:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_DCB_COUNT&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_DCB_COUNT:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_MAX_DCB_CELL_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MAX_DCB_CELL_TEMPERATURE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_MIN_DCB_CELL_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MIN_DCB_CELL_TEMPERATURE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_READY_FOR_SHUTDOWN&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_READY_FOR_SHUTDOWN:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_INFO&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_INFO:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_TRAINING_MODE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_TRAINING_MODE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_INDEX&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_INDEX:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_LAST_MESSAGE_TIMESTAMP&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_LAST_MESSAGE_TIMESTAMP:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_MAX_CHARGE_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_MAX_CHARGE_VOLTAGE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_MAX_CHARGE_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_MAX_CHARGE_CURRENT:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_END_OF_DISCHARGE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_END_OF_DISCHARGE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_MAX_DISCHARGE_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_MAX_DISCHARGE_CURRENT:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_FULL_CHARGE_CAPACITY&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_FULL_CHARGE_CAPACITY:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_REMAINING_CAPACITY&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_REMAINING_CAPACITY:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_SOC&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_SOC:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_SOH&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_SOH:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_CYCLE_COUNT&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_CYCLE_COUNT:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_CURRENT:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_VOLTAGE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_CURRENT_AVG_30S&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_CURRENT_AVG_30S:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_VOLTAGE_AVG_30S&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_VOLTAGE_AVG_30S:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_DESIGN_CAPACITY&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_DESIGN_CAPACITY:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_DESIGN_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_DESIGN_VOLTAGE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_CHARGE_LOW_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_CHARGE_LOW_TEMPERATURE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_CHARGE_HIGH_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_CHARGE_HIGH_TEMPERATURE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_MANUFACTURE_DATE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_MANUFACTURE_DATE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_SERIALNO&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_SERIALNO:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_PROTOCOL_VERSION&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_PROTOCOL_VERSION:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_FW_VERSION&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_FW_VERSION:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_DATA_TABLE_VERSION&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_DATA_TABLE_VERSION:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_PCB_VERSION&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_PCB_VERSION:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_DEVICE_STATE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_DEVICE_STATE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DEVICE_STATE&labels=documentation&body=Documentation+update+for+enum+BatTag.DEVICE_STATE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DEVICE_CONNECTED&labels=documentation&body=Documentation+update+for+enum+BatTag.DEVICE_CONNECTED:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DEVICE_WORKING&labels=documentation&body=Documentation+update+for+enum+BatTag.DEVICE_WORKING:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DEVICE_IN_SERVICE&labels=documentation&body=Documentation+update+for+enum+BatTag.DEVICE_IN_SERVICE:).
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
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.GENERAL_ERROR&labels=documentation&body=Documentation+update+for+enum+BatTag.GENERAL_ERROR:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x03FFFFFF", type = DataType.ERROR),

    /**
     * hex = "0x03000042", type = DataType.UINT16
     *
     * Requests information from the battery module. The value must be the number of the module. It is counted from 0 to the value of DCB_COUNT
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DCB_INFO(hex = "0x03000042", type = DataType.UINT16),

    /**
     * hex = "0x0300000E", type = DataType.NONE
     *
     * Ask for the actual RSOC. Whatever the actual RSOC is...
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_RSOC_REAL(hex = "0x0300000E", type = DataType.NONE),

    /**
     * hex = "0x0300000F", type = DataType.NONE
     *
     * Requests the absolute state-of-charge. In other words, how high the possible SOC is when the battery is fully charged, minus signs of ageing of the battery.
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_ASOC(hex = "0x0300000F", type = DataType.NONE),

    /**
     * hex = "0x03000010", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_FCC&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_FCC:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_FCC(hex = "0x03000010", type = DataType.NONE),

    /**
     * hex = "0x03000011", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_RC&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_RC:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_RC(hex = "0x03000011", type = DataType.NONE),

    /**
     * hex = "0x03000012", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_MAX_DCB_CELL_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MAX_DCB_CELL_CURRENT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_MAX_DCB_CELL_CURRENT(hex = "0x03000012", type = DataType.NONE),

    /**
     * hex = "0x03000013", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_MIN_DCB_CELL_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MIN_DCB_CELL_CURRENT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_MIN_DCB_CELL_CURRENT(hex = "0x03000013", type = DataType.NONE),

    /**
     * hex = "0x03000014", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_MAX_DCB_CELL_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MAX_DCB_CELL_VOLTAGE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_MAX_DCB_CELL_VOLTAGE(hex = "0x03000014", type = DataType.NONE),

    /**
     * hex = "0x03000015", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_MIN_DCB_CELL_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MIN_DCB_CELL_VOLTAGE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_MIN_DCB_CELL_VOLTAGE(hex = "0x03000015", type = DataType.NONE),

    /**
     * hex = "0x03000018", type = DataType.UINT16
     *
     * Queries the temperatures of all cells in the battery module. The value must be the number of the module. It is counted from 0 to the value of DCB_COUNT
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DCB_ALL_CELL_TEMPERATURES(hex = "0x03000018", type = DataType.UINT16),
    /**
     * hex = "0x0300001A", type = DataType.UINT16
     *
     * Queries the voltages of all cells in the battery module. The value must be the number of the module. It is counted from 0 to the value of DCB_COUNT
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DCB_ALL_CELL_VOLTAGES(hex = "0x0300001A", type = DataType.UINT16),
    /**
     * hex = "0x0300001C", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_OPEN_BREAKER&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_OPEN_BREAKER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_OPEN_BREAKER(hex = "0x0300001C", type = DataType.NONE),
    /**
     * hex = "0x0300001D", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_OPEN_BREAKER_CONFIRM&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_OPEN_BREAKER_CONFIRM:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_OPEN_BREAKER_CONFIRM(hex = "0x0300001D", type = DataType.NONE),
    /**
     * hex = "0x0300001F", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_FIRMWARE_VERSION&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_FIRMWARE_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_FIRMWARE_VERSION(hex = "0x0300001F", type = DataType.NONE),
    /**
     * hex = "0x03000022", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_UPDATE_STATUS&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_UPDATE_STATUS:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_UPDATE_STATUS(hex = "0x03000022", type = DataType.NONE),
    /**
     * hex = "0x03000023", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_SET_TRAINING_MODE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_SET_TRAINING_MODE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_TRAINING_MODE(hex = "0x03000023", type = DataType.NONE),
    /**
     * hex = "0x03000024", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_TIME_LAST_RESPONSE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_TIME_LAST_RESPONSE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_TIME_LAST_RESPONSE(hex = "0x03000024", type = DataType.NONE),
    /**
     * hex = "0x03000025", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_MANUFACTURER_NAME&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MANUFACTURER_NAME:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_MANUFACTURER_NAME(hex = "0x03000025", type = DataType.NONE),
    /**
     * hex = "0x03000026", type = DataType.NONE
     *
     * Requests the usable capacity. A block of type [USABLE_CAPACITY] is delivered as the response
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_USABLE_CAPACITY(hex = "0x03000026", type = DataType.NONE),
    /**
     * hex = "0x03000027", type = DataType.NONE
     *
     * Requests the remaining usable capacity. A block of type [USABLE_REMAINING_CAPACITY] is delivered as the response
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_USABLE_REMAINING_CAPACITY(hex = "0x03000027", type = DataType.NONE),
    /**
     * hex = "0x03000028", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_SET_A1_DATA&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_SET_A1_DATA:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_A1_DATA(hex = "0x03000028", type = DataType.NONE),
    /**
     * hex = "0x03000029", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_SET_A1_MODE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_SET_A1_MODE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_A1_MODE(hex = "0x03000029", type = DataType.NONE),
    /**
     * hex = "0x03000030", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_SET_A1_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_SET_A1_VOLTAGE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_A1_VOLTAGE(hex = "0x03000030", type = DataType.NONE),
    /**
     * hex = "0x03000031", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_SET_A1_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_SET_A1_CURRENT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_A1_CURRENT(hex = "0x03000031", type = DataType.NONE),
    /**
     * hex = "0x03000032", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_CONTROL_CODE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_CONTROL_CODE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_CONTROL_CODE(hex = "0x03000032", type = DataType.NONE),
    /**
     * hex = "0x03000043", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_SPECIFICATION&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_SPECIFICATION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SPECIFICATION(hex = "0x03000043", type = DataType.NONE),
    /**
     * hex = "0x03000044", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_INTERNALS&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_INTERNALS:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_INTERNALS(hex = "0x03000044", type = DataType.NONE),
    /**
     * hex = "0x03000045", type = DataType.NONE
     *
     * Queries the capacity of the battery as it was designed according to the specification. A block of type [DESIGN_CAPACITY] is delivered as the response
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DESIGN_CAPACITY(hex = "0x03000045", type = DataType.NONE),
    /**
     * hex = "0x03000046", type = DataType.NONE
     *
     * Queries the volate of the battery as it was designed according to the specification. A block of type [DESIGN_VOLTAGE] is delivered as the response
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DESIGN_VOLTAGE(hex = "0x03000046", type = DataType.NONE),
    /**
     * hex = "0x03000047", type = DataType.NONE
     *
     * Query of the highest possible temperature during charging. A block of the type [CHARGE_HIGH_TEMP] is delivered in response
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_CHARGE_HIGH_TEMP(hex = "0x03000047", type = DataType.NONE),
    /**
     * hex = "0x03000048", type = DataType.NONE
     *
     * Query of the lowest possible temperature during charging. A block of the type [CHARGE_LOW_TEMP] is delivered in response
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_CHARGE_LOW_TEMP(hex = "0x03000048", type = DataType.NONE),
    /**
     * hex = "0x03000049", type = DataType.NONE
     *
     * Query the date of manufacture of the battery. A block of the type [MANUFACTURE_DATE] is delivered in response
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_MANUFACTURE_DATE(hex = "0x03000049", type = DataType.NONE),
    /**
     * hex = "0x03000050", type = DataType.NONE
     *
     * Query the serial number. A block of the type [SERIALNO] is delivered in response
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SERIALNO(hex = "0x03000050", type = DataType.NONE),
    /**
     * hex = "0x03000051", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_DATA_TABLE_VERSION&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_DATA_TABLE_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DATA_TABLE_VERSION(hex = "0x03000051", type = DataType.NONE),
    /**
     * hex = "0x03000052", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_PROTOCOL_VERSION&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_PROTOCOL_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_PROTOCOL_VERSION(hex = "0x03000052", type = DataType.NONE),
    /**
     * hex = "0x03000053", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_PCB_VERSION&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_PCB_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_PCB_VERSION(hex = "0x03000053", type = DataType.NONE),
    /**
     * hex = "0x03000054", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_TOTAL_USE_TIME&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_TOTAL_USE_TIME:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_TOTAL_USE_TIME(hex = "0x03000054", type = DataType.NONE),
    /**
     * hex = "0x03000055", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_TOTAL_DISCHARGE_TIME&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_TOTAL_DISCHARGE_TIME:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_TOTAL_DISCHARGE_TIME(hex = "0x03000055", type = DataType.NONE),
    /**
     * hex = "0x03000056", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_AVAILABLE_BATTERIES&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_AVAILABLE_BATTERIES:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_AVAILABLE_BATTERIES(hex = "0x03000056", type = DataType.NONE),
    /**
     * hex = "0x03000060", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_OPEN_FET&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_OPEN_FET:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_OPEN_FET(hex = "0x03000060", type = DataType.NONE),
    /**
     * hex = "0x03000061", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_FET_STATE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_FET_STATE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_FET_STATE(hex = "0x03000061", type = DataType.NONE),
    /**
     * hex = "0x03000062", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_BATTERY_SOFT_ON&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_BATTERY_SOFT_ON:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_BATTERY_SOFT_ON(hex = "0x03000062", type = DataType.NONE),
    /**
     * hex = "0x03000130", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_MEASURED_RESISTANCE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MEASURED_RESISTANCE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_MEASURED_RESISTANCE(hex = "0x03000130", type = DataType.NONE),
    /**
     * hex = "0x03000044", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_RUN_MEASURED_RESISTANCE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_RUN_MEASURED_RESISTANCE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_RUN_MEASURED_RESISTANCE(hex = "0x03000131", type = DataType.NONE),
    /**
     * hex = "0x03800011", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.RC&labels=documentation&body=Documentation+update+for+enum+BatTag.RC:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    RC(hex = "0x03800011", type = DataType.NONE),
    /**
     * hex = "0x03800013", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.MIN_DCB_CELL_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.MIN_DCB_CELL_CURRENT:).
     *
     * Unit: Ampere
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MIN_DCB_CELL_CURRENT(hex = "0x03800013", type = DataType.FLOAT32),
    /**
     * hex = "0x03800014", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.MAX_DCB_CELL_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.MAX_DCB_CELL_VOLTAGE:).
     *
     * Unit: Volt
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MAX_DCB_CELL_VOLTAGE(hex = "0x03800014", type = DataType.FLOAT32),
    /**
     * hex = "0x03800015", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.MIN_DCB_CELL_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.MIN_DCB_CELL_VOLTAGE:).
     *
     * Unit: Volt
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MIN_DCB_CELL_VOLTAGE(hex = "0x03800015", type = DataType.FLOAT32),
    /**
     * hex = "0x03800018", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_ALL_CELL_TEMPERATURES&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_ALL_CELL_TEMPERATURES:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_ALL_CELL_TEMPERATURES(hex = "0x03800018", type = DataType.CONTAINER),
    /**
     * hex = "0x0380001A", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_ALL_CELL_VOLTAGES&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_ALL_CELL_VOLTAGES:).
     *
     * Unit: Volt
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_ALL_CELL_VOLTAGES(hex = "0x0380001A", type = DataType.FLOAT32),
    /**
     * hex = "0x0380001C", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.OPEN_BREAKER&labels=documentation&body=Documentation+update+for+enum+BatTag.OPEN_BREAKER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    OPEN_BREAKER(hex = "0x0380001C", type = DataType.NONE),
    /**
     * hex = "0x0380001D", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.OPEN_BREAKER_CONFIRM&labels=documentation&body=Documentation+update+for+enum+BatTag.OPEN_BREAKER_CONFIRM:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    OPEN_BREAKER_CONFIRM(hex = "0x0380001D", type = DataType.NONE),
    /**
     * hex = "0x0380001F", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.FIRMWARE_VERSION&labels=documentation&body=Documentation+update+for+enum+BatTag.FIRMWARE_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    FIRMWARE_VERSION(hex = "0x0380001F", type = DataType.NONE),
    /**
     * hex = "0x03800022", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.UPDATE_STATUS&labels=documentation&body=Documentation+update+for+enum+BatTag.UPDATE_STATUS:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    UPDATE_STATUS(hex = "0x03800022", type = DataType.NONE),
    /**
     * hex = "0x03800024", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.TIME_LAST_RESPONSE&labels=documentation&body=Documentation+update+for+enum+BatTag.TIME_LAST_RESPONSE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    TIME_LAST_RESPONSE(hex = "0x03800024", type = DataType.NONE),
    /**
     * hex = "0x03800025", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.MANUFACTURER_NAME&labels=documentation&body=Documentation+update+for+enum+BatTag.MANUFACTURER_NAME:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MANUFACTURER_NAME(hex = "0x03800025", type = DataType.NONE),
    /**
     * hex = "0x03800026", type = DataType.FLOAT32
     *
     * The usable capacity of the battery in Ah
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    USABLE_CAPACITY(hex = "0x03800026", type = DataType.FLOAT32),
    /**
     * hex = "0x03800027", type = DataType.FLOAT32
     *
     * Remaining capacity in Wh (or Ah??)
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    USABLE_REMAINING_CAPACITY(hex = "0x03800027", type = DataType.FLOAT32),
    /**
     * hex = "0x03800028", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.SET_A1_DATA&labels=documentation&body=Documentation+update+for+enum+BatTag.SET_A1_DATA:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_A1_DATA(hex = "0x03800028", type = DataType.NONE),
    /**
     * hex = "0x03800032", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.CONTROL_CODE&labels=documentation&body=Documentation+update+for+enum+BatTag.CONTROL_CODE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    CONTROL_CODE(hex = "0x03800032", type = DataType.NONE),
    /**
     * hex = "0x03800042", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_INFO&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_INFO:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_INFO(hex = "0x03800042", type = DataType.NONE),
    /**
     * hex = "0x03800043", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.SPECIFICATION&labels=documentation&body=Documentation+update+for+enum+BatTag.SPECIFICATION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SPECIFICATION(hex = "0x03800043", type = DataType.NONE),
    /**
     * hex = "0x03800044", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.INTERNALS&labels=documentation&body=Documentation+update+for+enum+BatTag.INTERNALS:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    INTERNALS(hex = "0x03800044", type = DataType.NONE),
    /**
     * hex = "0x03800045", type = DataType.FLOAT32
     *
     * Response block to a [REQ_DESIGN_CAPACITY] request. Contains the capacity of the battery as it was designed according to the specification in Ah.
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DESIGN_CAPACITY(hex = "0x03800045", type = DataType.FLOAT32),
    /**
     * hex = "0x03800046", type = DataType.FLOAT32
     *
     * Response block to a [REQ_DESIGN_VOLTAGE] request. Contains the voltage of the battery as it was designed according to the specification in Volts.
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DESIGN_VOLTAGE(hex = "0x03800046", type = DataType.FLOAT32),
    /**
     * hex = "0x03800047", type = DataType.FLOAT32
     *
     * Response block to a [REQ_CHARGE_HIGH_TEMP] request. Contains the maximum permissible charging temperature in Celsius.
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    CHARGE_HIGH_TEMP(hex = "0x03800047", type = DataType.FLOAT32),
    /**
     * hex = "0x03800048", type = DataType.NONE
     *
     * Response block to a [REQ_CHARGE_LOW_TEMP] request. Contains the minimum permissible charging temperature in Celsius.
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    CHARGE_LOW_TEMP(hex = "0x03800048", type = DataType.NONE),
    /**
     * hex = "0x03800049", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.MANUFACTURE_DATE&labels=documentation&body=Documentation+update+for+enum+BatTag.MANUFACTURE_DATE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MANUFACTURE_DATE(hex = "0x03800049", type = DataType.NONE),
    /**
     * hex = "0x03800050", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.SERIALNO&labels=documentation&body=Documentation+update+for+enum+BatTag.SERIALNO:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SERIALNO(hex = "0x03800050", type = DataType.STRING),
    /**
     * hex = "0x03800051", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DATA_TABLE_VERSION&labels=documentation&body=Documentation+update+for+enum+BatTag.DATA_TABLE_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DATA_TABLE_VERSION(hex = "0x03800051", type = DataType.NONE),
    /**
     * hex = "0x03800052", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.PROTOCOL_VERSION&labels=documentation&body=Documentation+update+for+enum+BatTag.PROTOCOL_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PROTOCOL_VERSION(hex = "0x03800052", type = DataType.NONE),
    /**
     * hex = "0x03800053", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.PCB_VERSION&labels=documentation&body=Documentation+update+for+enum+BatTag.PCB_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PCB_VERSION(hex = "0x03800053", type = DataType.NONE),
    /**
     * hex = "0x03800054", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.TOTAL_USE_TIME&labels=documentation&body=Documentation+update+for+enum+BatTag.TOTAL_USE_TIME:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    TOTAL_USE_TIME(hex = "0x03800054", type = DataType.NONE),
    /**
     * hex = "0x03800055", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.TOTAL_DISCHARGE_TIME&labels=documentation&body=Documentation+update+for+enum+BatTag.TOTAL_DISCHARGE_TIME:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    TOTAL_DISCHARGE_TIME(hex = "0x03800055", type = DataType.NONE),
    /**
     * hex = "0x03800057", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.AVAILABLE_BATTERIES&labels=documentation&body=Documentation+update+for+enum+BatTag.AVAILABLE_BATTERIES:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    AVAILABLE_BATTERIES(hex = "0x03800057", type = DataType.NONE),
    /**
     * hex = "0x03000058", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.REQ_BATTERY_SPEC&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_BATTERY_SPEC:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_BATTERY_SPEC(hex = "0x03000058", type = DataType.NONE),
    /**
     * hex = "0x03800058", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.BATTERY_SPEC&labels=documentation&body=Documentation+update+for+enum+BatTag.BATTERY_SPEC:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    BATTERY_SPEC(hex = "0x03800058", type = DataType.NONE),
    /**
     * hex = "0x03800059", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.INSTANCE_DESCRIPTOR&labels=documentation&body=Documentation+update+for+enum+BatTag.INSTANCE_DESCRIPTOR:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    INSTANCE_DESCRIPTOR(hex = "0x03800059", type = DataType.NONE),
    /**
     * hex = "0x03800061", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.FET_STATE&labels=documentation&body=Documentation+update+for+enum+BatTag.FET_STATE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    FET_STATE(hex = "0x03800061", type = DataType.NONE),
    /**
     * hex = "0x03800062", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.BATTERY_SOFT_ON&labels=documentation&body=Documentation+update+for+enum+BatTag.BATTERY_SOFT_ON:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    BATTERY_SOFT_ON(hex = "0x03800062", type = DataType.NONE),
    /**
     * hex = "0x03800125", type = DataType.FLOAT32
     *
     * Contains the specified capacity in Wh
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SPECIFIED_CAPACITY(hex = "0x03800125", type = DataType.FLOAT32),
    /**
     * hex = "0x03800126", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.SPECIFIED_DISCHARGE_POWER&labels=documentation&body=Documentation+update+for+enum+BatTag.SPECIFIED_DISCHARGE_POWER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SPECIFIED_DISCHARGE_POWER(hex = "0x03800126", type = DataType.NONE),
    /**
     * hex = "0x03800127", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.SPECIFIED_CHARGE_POWER&labels=documentation&body=Documentation+update+for+enum+BatTag.SPECIFIED_CHARGE_POWER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SPECIFIED_CHARGE_POWER(hex = "0x03800127", type = DataType.NONE),
    /**
     * hex = "0x03800128", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.SPECIFIED_MAX_DCB_COUNT&labels=documentation&body=Documentation+update+for+enum+BatTag.SPECIFIED_MAX_DCB_COUNT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SPECIFIED_MAX_DCB_COUNT(hex = "0x03800128", type = DataType.NONE),
    /**
     * hex = "0x03800129", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.ROLE&labels=documentation&body=Documentation+update+for+enum+BatTag.ROLE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    ROLE(hex = "0x03800129", type = DataType.NONE),
    /**
     * hex = "0x03800130", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.INTERNAL_CURRENT_AVG30&labels=documentation&body=Documentation+update+for+enum+BatTag.INTERNAL_CURRENT_AVG30:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    INTERNAL_CURRENT_AVG30(hex = "0x03800130", type = DataType.NONE),
    /**
     * hex = "0x03800131", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.INTERNAL_MTV_AVG30&labels=documentation&body=Documentation+update+for+enum+BatTag.INTERNAL_MTV_AVG30:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    INTERNAL_MTV_AVG30(hex = "0x03800131", type = DataType.NONE),
    /**
     * hex = "0x03800132", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.INTERNAL_MAX_CHARGE_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.INTERNAL_MAX_CHARGE_CURRENT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    INTERNAL_MAX_CHARGE_CURRENT(hex = "0x03800132", type = DataType.NONE),
    /**
     * hex = "0x03800133", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.INTERNAL_MAX_DISCHARGE_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.INTERNAL_MAX_DISCHARGE_CURRENT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    INTERNAL_MAX_DISCHARGE_CURRENT(hex = "0x03800133", type = DataType.NONE),
    /**
     * hex = "0x03800134", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.INTERNAL_MAX_CHARGE_CURR_PER_DCB&labels=documentation&body=Documentation+update+for+enum+BatTag.INTERNAL_MAX_CHARGE_CURR_PER_DCB:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    INTERNAL_MAX_CHARGE_CURR_PER_DCB(hex = "0x03800134", type = DataType.NONE),
    /**
     * hex = "0x03800135", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.INTERNAL_MAX_DISCHARGE_CURR_PER_DCB&labels=documentation&body=Documentation+update+for+enum+BatTag.INTERNAL_MAX_DISCHARGE_CURR_PER_DCB:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    INTERNAL_MAX_DISCHARGE_CURR_PER_DCB(hex = "0x03800135", type = DataType.NONE),
    /**
     * hex = "0x03800136", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.INTERNAL_MAX_CHARGE_CURR_DATA_LOG&labels=documentation&body=Documentation+update+for+enum+BatTag.INTERNAL_MAX_CHARGE_CURR_DATA_LOG:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    INTERNAL_MAX_CHARGE_CURR_DATA_LOG(hex = "0x03800136", type = DataType.NONE),
    /**
     * hex = "0x03800137", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.INTERNAL_MAX_DISCHARGE_CURR_DATA_LOG&labels=documentation&body=Documentation+update+for+enum+BatTag.INTERNAL_MAX_DISCHARGE_CURR_DATA_LOG:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    INTERNAL_MAX_DISCHARGE_CURR_DATA_LOG(hex = "0x03800137", type = DataType.NONE),
    /**
     * hex = "0x03800300", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_NR_SERIES_CELL&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_NR_SERIES_CELL:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_NR_SERIES_CELL(hex = "0x03800300", type = DataType.NONE),
    /**
     * hex = "0x03800301", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_NR_PARALLEL_CELL&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_NR_PARALLEL_CELL:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_NR_PARALLEL_CELL(hex = "0x03800301", type = DataType.NONE),
    /**
     * hex = "0x03800302", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_MANUFACTURE_NAME&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_MANUFACTURE_NAME:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_MANUFACTURE_NAME(hex = "0x03800302", type = DataType.NONE),
    /**
     * hex = "0x03800303", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_DEVICE_NAME&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_DEVICE_NAME:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_DEVICE_NAME(hex = "0x03800303", type = DataType.NONE),
    /**
     * hex = "0x03800304", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_SERIALCODE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_SERIALCODE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_SERIALCODE(hex = "0x03800304", type = DataType.NONE),
    /**
     * hex = "0x03800305", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_NR_SENSOR&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_NR_SENSOR:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_NR_SENSOR(hex = "0x03800305", type = DataType.NONE),
    /**
     * hex = "0x03800306", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_STATUS&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_STATUS:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_STATUS(hex = "0x03800306", type = DataType.NONE),
    /**
     * hex = "0x03800307", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_WARNING&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_WARNING:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_WARNING(hex = "0x03800307", type = DataType.NONE),
    /**
     * hex = "0x03800308", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_ALARM&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_ALARM:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_ALARM(hex = "0x03800308", type = DataType.NONE),
    /**
     * hex = "0x03800309", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.DCB_ERROR&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_ERROR:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DCB_ERROR(hex = "0x03800309", type = DataType.NONE),
    /**
     * hex = "0x0380000F", type = DataType.FLOAT32
     *
     * Contains the condition of the battery as a percentage, taking into account the effects of ageing
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    ASOC(hex = "0x0380000F", type = DataType.FLOAT32),
    /**
     * hex = "0x03800012", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.MAX_DCB_CELL_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.MAX_DCB_CELL_CURRENT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MAX_DCB_CELL_CURRENT(hex = "0x03800012", type = DataType.INT32),
    /**
     * hex = "0x0380000E", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+BatTag.RSOC_REAL&labels=documentation&body=Documentation+update+for+enum+BatTag.RSOC_REAL:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    RSOC_REAL(hex = "0x0380000E", type = DataType.FLOAT32),
}


