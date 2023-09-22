package de.jnkconsulting.e3dc.easyrscp.api.frame.tags

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Namespace
import de.jnkconsulting.e3dc.easyrscp.api.frame.Tag

/**
 * Contains tags for reading and controlling the PowerManagement System
 *
 * @param namespace Der Namespace des Tags für die Abbildung des jeweiligen Bereichs
 * @param hex Code of the tag in HexString format (0x0304001)
 * @param type Tag data type [DataType]
 *
 * @since 2.0
 */
enum class PMTag(
    override val namespace: Namespace = Namespace.PM,
    override val hex: String,
    override val type: DataType
) : Tag {

    /**
     * hex = "0x05040000", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_DATA&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_DATA:).
     *
     * Original E3DC Documentation:
     *
     * en: Contains all request TAGs, the container MUST contain an index
     *
     * de: Beinhaltet alle Anfrage-TAGs, der Container MUSS einen Index enthalten
     *
     */
    REQ_DATA(hex = "0x05040000", type = DataType.CONTAINER),

    /**
     * hex = "0x05040001", type = DataType.UINT16
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.INDEX&labels=documentation&body=Documentation+update+for+enum+PMTag.INDEX:).
     *
     * Original E3DC Documentation:
     *
     * en: Index of the requested device (0?x), must be included in request and is included in response
     *
     * de: Index des angefragten Gerätes (0?x), muss in Anfrage und ist in Antwort enthalten
     *
     */
    INDEX(hex = "0x05040001", type = DataType.UINT16),

    /**
     * hex = "0x05840000", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.DATA&labels=documentation&body=Documentation+update+for+enum+PMTag.DATA:).
     *
     * Original E3DC Documentation:
     *
     * en: Response with all data of the REQ_DATA request
     *
     * de: Antwort mit allen Daten der REQ_DATA Anfrage
     *
     */
    DATA(hex = "0x05840000", type = DataType.CONTAINER),

    /**
     * hex = "0x05000001", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_POWER_L1&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_POWER_L1:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_PM_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_PM_DATA Container verwendet werden!
     *
     */
    REQ_POWER_L1(hex = "0x05000001", type = DataType.NONE),

    /**
     * hex = "0x05000002", type = DataType.NONE
     *
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_POWER_L2&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_POWER_L2:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_PM_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_PM_DATA Container verwendet werden!
     *
     */
    REQ_POWER_L2(hex = "0x05000002", type = DataType.NONE),

    /**
     * hex = "0x05000003", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_POWER_L3&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_POWER_L3:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_PM_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_PM_DATA Container verwendet werden!
     */
    REQ_POWER_L3(hex = "0x05000003", type = DataType.NONE),

    /**
     * hex = "0x05000004", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_ACTIVE_PHASES&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_ACTIVE_PHASES:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_PM_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_PM_DATA Container verwendet werden!
     */
    REQ_ACTIVE_PHASES(hex = "0x05000004", type = DataType.NONE),

    /**
     * hex = "0x05000005", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_MODE&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_MODE:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_PM_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_PM_DATA Container verwendet werden!
     */
    REQ_MODE(hex = "0x05000005", type = DataType.NONE),

    /**
     * hex = "0x05000006", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_ENERGY_L1&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_ENERGY_L1:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_PM_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_PM_DATA Container verwendet werden!
     */
    REQ_ENERGY_L1(hex = "0x05000006", type = DataType.NONE),

    /**
     * hex = "0x05000007", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_ENERGY_L2&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_ENERGY_L2:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_PM_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_PM_DATA Container verwendet werden!
     */
    REQ_ENERGY_L2(hex = "0x05000007", type = DataType.NONE),

    /**
     * hex = "0x05000008", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_ENERGY_L3&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_ENERGY_L3:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_PM_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_PM_DATA Container verwendet werden!
     */
    REQ_ENERGY_L3(hex = "0x05000008", type = DataType.NONE),

    /**
     * hex = "0x05000009", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_DEVICE_ID&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_DEVICE_ID:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_PM_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_PM_DATA Container verwendet werden!
     */
    REQ_DEVICE_ID(hex = "0x05000009", type = DataType.NONE),

    /**
     * hex = "0x0500000A", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_ERROR_CODE&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_ERROR_CODE:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_PM_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_PM_DATA Container verwendet werden!
     */
    REQ_ERROR_CODE(hex = "0x0500000A", type = DataType.NONE),

    /**
     * hex = "0x0500000B", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_SET_PHASE_ELIMINATION&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_SET_PHASE_ELIMINATION:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_PM_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_PM_DATA Container verwendet werden!
     */
    REQ_SET_PHASE_ELIMINATION(hex = "0x0500000B", type = DataType.UCHAR8),

    /**
     * hex = "0x05000018", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_GET_PHASE_ELIMINATION&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_GET_PHASE_ELIMINATION:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_PM_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_PM_DATA Container verwendet werden!
     */
    REQ_GET_PHASE_ELIMINATION(hex = "0x05000018", type = DataType.UCHAR8),

    /**
     * hex = "0x0500000C", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_FIRMWARE_VERSION&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_FIRMWARE_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_PM_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_PM_DATA Container verwendet werden!
     */
    REQ_FIRMWARE_VERSION(hex = "0x0500000C", type = DataType.NONE),

    /**
     * hex = "0x05000011", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_VOLTAGE_L1&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_VOLTAGE_L1:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_PM_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_PM_DATA Container verwendet werden!
     */
    REQ_VOLTAGE_L1(hex = "0x05000011", type = DataType.NONE),

    /**
     * hex = "0x05000012", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_VOLTAGE_L2&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_VOLTAGE_L2:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_PM_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_PM_DATA Container verwendet werden!
     */
    REQ_VOLTAGE_L2(hex = "0x05000012", type = DataType.NONE),

    /**
     * hex = "0x05000013", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_VOLTAGE_L3&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_VOLTAGE_L3:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_PM_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_PM_DATA Container verwendet werden!
     */
    REQ_VOLTAGE_L3(hex = "0x05000013", type = DataType.NONE),

    /**
     * hex = "0x05000014", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_TYPE&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_TYPE:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_PM_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_PM_DATA Container verwendet werden!
     */
    REQ_TYPE(hex = "0x05000014", type = DataType.NONE),

    /**
     * hex = "0x05800001", type = DataType.DOUBLE64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.POWER_L1&labels=documentation&body=Documentation+update+for+enum+PMTag.POWER_L1:).
     *
     * Original E3DC Documentation:
     *
     * en: Current power on L1
     *
     *
     * de: Aktuelle Leistung an L1
     */
    POWER_L1(hex = "0x05800001", type = DataType.DOUBLE64),

    /**
     * hex = "0x05800002", type = DataType.DOUBLE64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.POWER_L2&labels=documentation&body=Documentation+update+for+enum+PMTag.POWER_L2:).
     *
     * Original E3DC Documentation:
     *
     * en: Current power on L2
     *
     *
     * de: Aktuelle Leistung an L2
     */
    POWER_L2(hex = "0x05800002", type = DataType.DOUBLE64),

    /**
     * hex = "0x05800003", type = DataType.DOUBLE64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.POWER_L3&labels=documentation&body=Documentation+update+for+enum+PMTag.POWER_L3:).
     *
     * Original E3DC Documentation:
     *
     * en: Current power on L3
     *
     *
     * de: Aktuelle Leistung an L3
     */
    POWER_L3(hex = "0x05800003", type = DataType.DOUBLE64),

    /**
     * hex = "0x05800004", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.ACTIVE_PHASES&labels=documentation&body=Documentation+update+for+enum+PMTag.ACTIVE_PHASES:).
     *
     * Original E3DC Documentation:
     *
     * en: just the three lowest bits of activePhases are used to define what phase is switched on.
     * If the lowest bit is 1 phase1 is active. If the lowest bit is 0 phase 1 is inactive
     *
     * static const unsigned char PHASE_1 = 1
     * static const unsigned char PHASE_2 = 2
     * static const unsigned char PHASE_3 = 4
     * f.e. if active Phases = 7 -> all phases are active
     *
     *
     * de: Nur die drei niedrigsten Bits von activePhases werden verwendet, um zu bestimmen, welche Phase eingeschaltet ist.
     * Wenn das niedrigste Bit 1 ist, ist Phase 1 aktiv. Wenn das niedrigste Bit 0 ist, ist Phase 1 inaktiv.
     *
     * static const unsigned char PHASE_1 = 1
     * static const unsigned char PHASE_2 = 2
     * static const unsigned char PHASE_3 = 4
     * f.e. if active Phases = 7 -> all phases are active
     */
    ACTIVE_PHASES(hex = "0x05800004", type = DataType.UCHAR8),

    /**
     * hex = "0x05800005", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.MODE&labels=documentation&body=Documentation+update+for+enum+PMTag.MODE:).
     *
     * Original E3DC Documentation:
     *
     * en: used to identify the error bit, if error code is available mode = ERROR_ACTIVE_MODE. ACTIVE_MODE else.
     * Ignore all other modes.
     *
     * static const unsigned char ACTIVE_MODE = 0
     * static const unsigned char PASSIVE_MODE = 1
     * static const unsigned char DIAGNOSE_MODE = 2
     * static const unsigned char ERROR_ACTIVE_MODE = 3
     * static const unsigned char ERROR_PASSIVE_MODE = 4
     *
     *
     * de: wird verwendet, um das Fehlerbit zu identifizieren, wenn der Fehlercode verfügbar ist mode = ERROR_ACTIVE_MODE.
     * ACTIVE_MODE sonst. Alle anderen Modi ignorieren.
     *
     * static const unsigned char ACTIVE_MODE = 0
     * static const unsigned char PASSIVE_MODE = 1
     * static const unsigned char DIAGNOSE_MODE = 2
     * static const unsigned char ERROR_ACTIVE_MODE = 3
     * static const unsigned char ERROR_PASSIVE_MODE = 4
     */
    MODE(hex = "0x05800005", type = DataType.UCHAR8),

    /**
     * hex = "0x05800006", type = DataType.DOUBLE64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.ENERGY_L1&labels=documentation&body=Documentation+update+for+enum+PMTag.ENERGY_L1:).
     *
     * Original E3DC Documentation:
     *
     * en: Energy counter L1
     *
     *
     * de: Energiezähler L1
     */
    ENERGY_L1(hex = "0x05800006", type = DataType.DOUBLE64),

    /**
     * hex = "0x05800007", type = DataType.DOUBLE64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.ENERGY_L2&labels=documentation&body=Documentation+update+for+enum+PMTag.ENERGY_L2:).
     *
     * Original E3DC Documentation:
     *
     * en: Energy counter L2
     *
     *
     * de: Energiezähler L2
     */
    ENERGY_L2(hex = "0x05800007", type = DataType.DOUBLE64),

    /**
     * hex = "0x05800008", type = DataType.DOUBLE64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.ENERGY_L3&labels=documentation&body=Documentation+update+for+enum+PMTag.ENERGY_L3:).
     *
     * Original E3DC Documentation:
     *
     * en: Energy counter L3
     *
     *
     * de: Energiezähler L3
     */
    ENERGY_L3(hex = "0x05800008", type = DataType.DOUBLE64),

    /**
     * hex = "0x05800009", type = DataType.UINT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.DEVICE_ID&labels=documentation&body=Documentation+update+for+enum+PMTag.DEVICE_ID:).
     *
     * Original E3DC Documentation:
     *
     * en: ID of that device
     *
     *
     * de: ID des Geräts
     */
    DEVICE_ID(hex = "0x05800009", type = DataType.UINT32),

    /**
     * hex = "0x0580000A", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.ERROR_CODE&labels=documentation&body=Documentation+update+for+enum+PMTag.ERROR_CODE:).
     *
     * Original E3DC Documentation:
     *
     * en: Last reported error code (see mode if error has relevance)
     *
     *
     * de: Letzter gemeldeter Fehlercode (siehe Modus, wenn der Fehler relevant ist)
     */
    ERROR_CODE(hex = "0x0580000A", type = DataType.UCHAR8),

    /**
     * hex = "0x0580000B", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.SET_PHASE_ELIMINATION&labels=documentation&body=Documentation+update+for+enum+PMTag.SET_PHASE_ELIMINATION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_PHASE_ELIMINATION(hex = "0x0580000B", type = DataType.BOOL),

    /**
     * hex = "0x05800018", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.GET_PHASE_ELIMINATION&labels=documentation&body=Documentation+update+for+enum+PMTag.GET_PHASE_ELIMINATION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GET_PHASE_ELIMINATION(hex = "0x05800018", type = DataType.BOOL),

    /**
     * hex = "0x0580000C", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.FIRMWARE_VERSION&labels=documentation&body=Documentation+update+for+enum+PMTag.FIRMWARE_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    FIRMWARE_VERSION(hex = "0x0580000C", type = DataType.UCHAR8),

    /**
     * hex = "0x05800011", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.VOLTAGE_L1&labels=documentation&body=Documentation+update+for+enum+PMTag.VOLTAGE_L1:).
     *
     * Original E3DC Documentation:
     *
     * en: Current voltage on L1 0 if not supported, use ACTIVE_PHASES to detect a broken phase
     *
     *
     * de: Aktuelle Spannung an L1 0, falls nicht unterstützt, ACTIVE_PHASES verwenden, um einen Phasenbruch zu erkennen
     */
    VOLTAGE_L1(hex = "0x05800011", type = DataType.FLOAT32),

    /**
     * hex = "0x05800012", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.VOLTAGE_L2&labels=documentation&body=Documentation+update+for+enum+PMTag.VOLTAGE_L2:).
     *
     * Original E3DC Documentation:
     *
     * en: Current voltage on L2
     *
     *
     * de: Aktuelle Spannung an L2
     */
    VOLTAGE_L2(hex = "0x05800012", type = DataType.FLOAT32),

    /**
     * hex = "0x05800013", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.VOLTAGE_L3&labels=documentation&body=Documentation+update+for+enum+PMTag.VOLTAGE_L3:).
     *
     * Original E3DC Documentation:
     *
     * en: Current voltage on L3
     *
     *
     * de: Aktuelle Spannung an L3
     */
    VOLTAGE_L3(hex = "0x05800013", type = DataType.FLOAT32),

    /**
     * hex = "0x05800014", type = DataType.UINT16
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.TYPE&labels=documentation&body=Documentation+update+for+enum+PMTag.TYPE:).
     *
     * Original E3DC Documentation:
     *
     * en: Power meter type:
     * 0=PM_TYPE_UNDEFINED
     * 1=PM_TYPE_ROOT
     * 2=PM_TYPE_ADDITIONAL
     * 3=PM_TYPE_ADDITIONAL_PRODUCTION
     * 4=PM_TYPE_ADDITIONAL_CONSUMPTION
     * 5=PM_TYPE_FARM
     * 6=PM_TYPE_UNUSED
     * 7=PM_TYPE_WALLBOX
     * 8=PM_TYPE_FARM_ADDITIONAL
     *
     *
     * de: Leistungsmesser Typ:
     * 0=PM_TYPE_UNDEFINED
     * 1=PM_TYPE_ROOT
     * 2=PM_TYPE_ADDITIONAL
     * 3=PM_TYPE_ADDITIONAL_PRODUCTION
     * 4=PM_TYPE_ADDITIONAL_CONSUMPTION
     * 5=PM_TYPE_FARM
     * 6=PM_TYPE_UNUSED
     * 7=PM_TYPE_WALLBOX
     * 8=PM_TYPE_FARM_ADDITIONAL
     *
     */
    TYPE(hex = "0x05800014", type = DataType.UINT16),

    /**
     * hex = "0x05800051", type = DataType.UINT64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.CS_START_TIME&labels=documentation&body=Documentation+update+for+enum+PMTag.CS_START_TIME:).
     *
     * Original E3DC Documentation:
     *
     * en: can only be used within a REQ_PM_COMM_STATE container!
     *
     * de: kann nur innerhalb eines REQ_PM_COMM_STATE Container verwendet werden!
     *
     */
    CS_START_TIME(hex = "0x05800051", type = DataType.UINT64),

    /**
     * hex = "0x05800052", type = DataType.UINT64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.CS_LAST_TIME&labels=documentation&body=Documentation+update+for+enum+PMTag.CS_LAST_TIME:).
     *
     * Original E3DC Documentation:
     *
     * en: can only be used within a REQ_PM_COMM_STATE container!
     *
     * de: kann nur innerhalb eines REQ_PM_COMM_STATE Container verwendet werden!
     */
    CS_LAST_TIME(hex = "0x05800052", type = DataType.UINT64),

    /**
     * hex = "0x05800053", type = DataType.UINT64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.CS_SUCC_FRAMES_ALL&labels=documentation&body=Documentation+update+for+enum+PMTag.CS_SUCC_FRAMES_ALL:).
     *
     * Original E3DC Documentation:
     *
     * en: can only be used within a REQ_PM_COMM_STATE container!
     *
     * de: kann nur innerhalb eines REQ_PM_COMM_STATE Container verwendet werden!
     */
    CS_SUCC_FRAMES_ALL(hex = "0x05800053", type = DataType.UINT64),

    /**
     * hex = "0x05800054", type = DataType.UINT64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.CS_SUCC_FRAMES_100&labels=documentation&body=Documentation+update+for+enum+PMTag.CS_SUCC_FRAMES_100:).
     *
     * Original E3DC Documentation:
     *
     * en: can only be used within a REQ_PM_COMM_STATE container!
     *
     * de: kann nur innerhalb eines REQ_PM_COMM_STATE Container verwendet werden!
     */
    CS_SUCC_FRAMES_100(hex = "0x05800054", type = DataType.UINT64),

    /**
     * hex = "0x05800055", type = DataType.UINT64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.CS_EXP_FRAMES_ALL&labels=documentation&body=Documentation+update+for+enum+PMTag.CS_EXP_FRAMES_ALL:).
     *
     * Original E3DC Documentation:
     *
     * en: can only be used within a REQ_PM_COMM_STATE container!
     *
     * de: kann nur innerhalb eines REQ_PM_COMM_STATE Container verwendet werden!
     */
    CS_EXP_FRAMES_ALL(hex = "0x05800055", type = DataType.UINT64),

    /**
     * hex = "0x05800056", type = DataType.UINT64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.CS_EXP_FRAMES_100&labels=documentation&body=Documentation+update+for+enum+PMTag.CS_EXP_FRAMES_100:).
     *
     * Original E3DC Documentation:
     *
     * en: can only be used within a REQ_PM_COMM_STATE container!
     *
     * de: kann nur innerhalb eines REQ_PM_COMM_STATE Container verwendet werden!
     */
    CS_EXP_FRAMES_100(hex = "0x05800056", type = DataType.UINT64),

    /**
     * hex = "0x05800057", type = DataType.UINT64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.CS_ERR_FRAMES_ALL&labels=documentation&body=Documentation+update+for+enum+PMTag.CS_ERR_FRAMES_ALL:).
     *
     * Original E3DC Documentation:
     *
     * en: can only be used within a REQ_PM_COMM_STATE container!
     *
     * de: kann nur innerhalb eines REQ_PM_COMM_STATE Container verwendet werden!
     */
    CS_ERR_FRAMES_ALL(hex = "0x05800057", type = DataType.UINT64),

    /**
     * hex = "0x05800058", type = DataType.UINT64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.CS_ERR_FRAMES_100&labels=documentation&body=Documentation+update+for+enum+PMTag.CS_ERR_FRAMES_100:).
     *
     * Original E3DC Documentation:
     *
     * en: can only be used within a REQ_PM_COMM_STATE container!
     *
     * de: kann nur innerhalb eines REQ_PM_COMM_STATE Container verwendet werden!
     */
    CS_ERR_FRAMES_100(hex = "0x05800058", type = DataType.UINT64),

    /**
     * hex = "0x05800059", type = DataType.UINT64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.CS_UNK_FRAMES&labels=documentation&body=Documentation+update+for+enum+PMTag.CS_UNK_FRAMES:).
     *
     * Original E3DC Documentation:
     *
     * en: can only be used within a REQ_PM_COMM_STATE container!
     *
     * de: kann nur innerhalb eines REQ_PM_COMM_STATE Container verwendet werden!
     */
    CS_UNK_FRAMES(hex = "0x05800059", type = DataType.UINT64),

    /**
     * hex = "0x0580005A", type = DataType.UINT64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.CS_ERR_FRAME&labels=documentation&body=Documentation+update+for+enum+PMTag.CS_ERR_FRAME:).
     *
     * Original E3DC Documentation:
     *
     * en: can only be used within a REQ_PM_COMM_STATE container!
     *
     * de: kann nur innerhalb eines REQ_PM_COMM_STATE Container verwendet werden!
     */
    CS_ERR_FRAME(hex = "0x0580005A", type = DataType.UINT64),

    /**
     * hex = "0x05060000", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.REQ_DEVICE_STATE&labels=documentation&body=Documentation+update+for+enum+PMTag.REQ_DEVICE_STATE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DEVICE_STATE(hex = "0x05060000", type = DataType.NONE),

    /**
     * hex = "0x05860000", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.DEVICE_STATE&labels=documentation&body=Documentation+update+for+enum+PMTag.DEVICE_STATE:).
     *
     * Original E3DC Documentation:
     *
     * en: DEVICE_CONNECTED & DEVICE_WORKING & DEVICE_IN_SERVICE
     *
     *
     * de: DEVICE_CONNECTED & DEVICE_WORKING & DEVICE_IN_SERVICE
     *
     */
    DEVICE_STATE(hex = "0x05860000", type = DataType.CONTAINER),

    /**
     * hex = "0x05860001", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.DEVICE_CONNECTED&labels=documentation&body=Documentation+update+for+enum+PMTag.DEVICE_CONNECTED:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DEVICE_CONNECTED(hex = "0x05860001", type = DataType.BOOL),

    /**
     * hex = "0x05860002", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.DEVICE_WORKING&labels=documentation&body=Documentation+update+for+enum+PMTag.DEVICE_WORKING:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DEVICE_WORKING(hex = "0x05860002", type = DataType.BOOL),

    /**
     * hex = "0x05860003", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.DEVICE_IN_SERVICE&labels=documentation&body=Documentation+update+for+enum+PMTag.DEVICE_IN_SERVICE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DEVICE_IN_SERVICE(hex = "0x05860003", type = DataType.BOOL),

    /**
     * hex = "0x05FFFFFF", type = DataType.ERROR
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PMTag.GENERAL_ERROR&labels=documentation&body=Documentation+update+for+enum+PMTag.GENERAL_ERROR:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x05FFFFFF", type = DataType.ERROR),


}