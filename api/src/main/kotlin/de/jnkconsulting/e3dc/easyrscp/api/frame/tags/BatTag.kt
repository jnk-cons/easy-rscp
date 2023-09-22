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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_DATA&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_DATA:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.INDEX&labels=documentation&body=Documentation+update+for+enum+BatTag.INDEX:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DATA&labels=documentation&body=Documentation+update+for+enum+BatTag.DATA:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.RSOC&labels=documentation&body=Documentation+update+for+enum+BatTag.RSOC:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.MODULE_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.MODULE_VOLTAGE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.CURRENT:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.MAX_BAT_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.MAX_BAT_VOLTAGE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.MAX_CHARGE_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.MAX_CHARGE_CURRENT:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.EOD_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.EOD_VOLTAGE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.MAX_DISCHARGE_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.MAX_DISCHARGE_CURRENT:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.CHARGE_CYCLES&labels=documentation&body=Documentation+update+for+enum+BatTag.CHARGE_CYCLES:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.TERMINAL_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.TERMINAL_VOLTAGE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.STATUS_CODE&labels=documentation&body=Documentation+update+for+enum+BatTag.STATUS_CODE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.ERROR_CODE&labels=documentation&body=Documentation+update+for+enum+BatTag.ERROR_CODE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DEVICE_NAME&labels=documentation&body=Documentation+update+for+enum+BatTag.DEVICE_NAME:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_COUNT&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_COUNT:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.MAX_DCB_CELL_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+BatTag.MAX_DCB_CELL_TEMPERATURE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.MIN_DCB_CELL_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+BatTag.MIN_DCB_CELL_TEMPERATURE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_CELL_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_CELL_TEMPERATURE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_CELL_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_CELL_VOLTAGE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.READY_FOR_SHUTDOWN&labels=documentation&body=Documentation+update+for+enum+BatTag.READY_FOR_SHUTDOWN:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.INFO&labels=documentation&body=Documentation+update+for+enum+BatTag.INFO:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.TRAINING_MODE&labels=documentation&body=Documentation+update+for+enum+BatTag.TRAINING_MODE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_RSOC&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_RSOC:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_MODULE_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MODULE_VOLTAGE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_CURRENT:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_MAX_BAT_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MAX_BAT_VOLTAGE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_MAX_CHARGE_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MAX_CHARGE_CURRENT:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_EOD_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_EOD_VOLTAGE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_MAX_DISCHARGE_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MAX_DISCHARGE_CURRENT:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_CHARGE_CYCLES&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_CHARGE_CYCLES:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_TERMINAL_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_TERMINAL_VOLTAGE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_STATUS_CODE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_STATUS_CODE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_ERROR_CODE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_ERROR_CODE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_DEVICE_NAME&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_DEVICE_NAME:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_DCB_COUNT&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_DCB_COUNT:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_MAX_DCB_CELL_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MAX_DCB_CELL_TEMPERATURE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_MIN_DCB_CELL_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_MIN_DCB_CELL_TEMPERATURE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_READY_FOR_SHUTDOWN&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_READY_FOR_SHUTDOWN:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_INFO&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_INFO:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_TRAINING_MODE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_TRAINING_MODE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_INDEX&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_INDEX:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_LAST_MESSAGE_TIMESTAMP&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_LAST_MESSAGE_TIMESTAMP:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_MAX_CHARGE_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_MAX_CHARGE_VOLTAGE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_MAX_CHARGE_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_MAX_CHARGE_CURRENT:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_END_OF_DISCHARGE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_END_OF_DISCHARGE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_MAX_DISCHARGE_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_MAX_DISCHARGE_CURRENT:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_FULL_CHARGE_CAPACITY&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_FULL_CHARGE_CAPACITY:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_REMAINING_CAPACITY&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_REMAINING_CAPACITY:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_SOC&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_SOC:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_SOH&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_SOH:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_CYCLE_COUNT&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_CYCLE_COUNT:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_CURRENT&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_CURRENT:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_VOLTAGE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_CURRENT_AVG_30S&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_CURRENT_AVG_30S:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_VOLTAGE_AVG_30S&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_VOLTAGE_AVG_30S:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_DESIGN_CAPACITY&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_DESIGN_CAPACITY:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_DESIGN_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_DESIGN_VOLTAGE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_CHARGE_LOW_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_CHARGE_LOW_TEMPERATURE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_CHARGE_HIGH_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_CHARGE_HIGH_TEMPERATURE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_MANUFACTURE_DATE&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_MANUFACTURE_DATE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_SERIALNO&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_SERIALNO:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_PROTOCOL_VERSION&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_PROTOCOL_VERSION:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_FW_VERSION&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_FW_VERSION:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_DATA_TABLE_VERSION&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_DATA_TABLE_VERSION:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DCB_PCB_VERSION&labels=documentation&body=Documentation+update+for+enum+BatTag.DCB_PCB_VERSION:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.REQ_DEVICE_STATE&labels=documentation&body=Documentation+update+for+enum+BatTag.REQ_DEVICE_STATE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DEVICE_STATE&labels=documentation&body=Documentation+update+for+enum+BatTag.DEVICE_STATE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DEVICE_CONNECTED&labels=documentation&body=Documentation+update+for+enum+BatTag.DEVICE_CONNECTED:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DEVICE_WORKING&labels=documentation&body=Documentation+update+for+enum+BatTag.DEVICE_WORKING:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.DEVICE_IN_SERVICE&labels=documentation&body=Documentation+update+for+enum+BatTag.DEVICE_IN_SERVICE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+BatTag.GENERAL_ERROR&labels=documentation&body=Documentation+update+for+enum+BatTag.GENERAL_ERROR:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x03FFFFFF", type = DataType.ERROR),


}