package de.jnkconsulting.e3dc.easyrscp.api.frame.tags

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Namespace
import de.jnkconsulting.e3dc.easyrscp.api.frame.Tag

/**
 * Contains tags for reading out and controlling the connected wallboxes
 *
 * @param namespace Der Namespace des Tags für die Abbildung des jeweiligen Bereichs
 * @param hex Code of the tag in HexString format (0x0304001)
 * @param type Tag data type [DataType]
 *
 * @since 2.0
 */
enum class WBTag(
    override val namespace: Namespace = Namespace.WB,
    override val hex: String,
    override val type: DataType
) : Tag {

    /**
     * hex = "0x0E040000", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_DATA&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_DATA:).
     *
     * Original E3DC Documentation:
     *
     * en: Contains all request TAGs, the container MUST contain an index
     *
     * de: Beinhaltet alle Anfrage-TAGs, der Container MUSS einen Index enthalten
     *
     */
    REQ_DATA(hex = "0x0E040000", type = DataType.CONTAINER),

    /**
     * hex = "0x0E040001", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.INDEX&labels=documentation&body=Documentation+update+for+enum+WBTag.INDEX:).
     *
     * Original E3DC Documentation:
     *
     * en: Index of the requested device (0?x) 0xFF -> GroupController
     *
     * de: Index des angefragten Gerätes (0?x) 0xFF -> GroupController
     *
     */
    INDEX(hex = "0x0E040001", type = DataType.UCHAR8),

    /**
     * hex = "0x0E840000", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.DATA&labels=documentation&body=Documentation+update+for+enum+WBTag.DATA:).
     *
     * Original E3DC Documentation:
     *
     * en: Response with all data of the REQ_DATA request
     *
     * de: Antwort mit allen Daten der REQ_DATA Anfrage
     *
     */
    DATA(hex = "0x0E840000", type = DataType.CONTAINER),

    /**
     * hex = "0x0E000001", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_ENERGY_ALL&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_ENERGY_ALL:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_ENERGY_ALL(hex = "0x0E000001", type = DataType.NONE),

    /**
     * hex = "0x0E000002", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_ENERGY_SOLAR&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_ENERGY_SOLAR:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_ENERGY_SOLAR(hex = "0x0E000002", type = DataType.NONE),

    /**
     * hex = "0x0E000003", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_SOC&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_SOC:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_SOC(hex = "0x0E000003", type = DataType.NONE),

    /**
     * hex = "0x0E000004", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_STATUS&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_STATUS:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container! Not meaningful as long as the e-cars do not yet support it
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden! Nicht aussagekräftig solange die E-Cars das noch nicht unterstützen
     *
     */
    REQ_STATUS(hex = "0x0E000004", type = DataType.NONE),

    /**
     * hex = "0x0E000005", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_ERROR_CODE&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_ERROR_CODE:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_ERROR_CODE(hex = "0x0E000005", type = DataType.NONE),

    /**
     * hex = "0x0E000006", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_MODE&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_MODE:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_MODE(hex = "0x0E000006", type = DataType.NONE),

    /**
     * hex = "0x0E000007", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_APP_SOFTWARE&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_APP_SOFTWARE:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_APP_SOFTWARE(hex = "0x0E000007", type = DataType.NONE),

    /**
     * hex = "0x0E000008", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_BOOTLOADER_SOFTWARE&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_BOOTLOADER_SOFTWARE:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_BOOTLOADER_SOFTWARE(hex = "0x0E000008", type = DataType.NONE),

    /**
     * hex = "0x0E000009", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_HW_VERSION&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_HW_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_HW_VERSION(hex = "0x0E000009", type = DataType.NONE),

    /**
     * hex = "0x0E00000A", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_FLASH_VERSION&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_FLASH_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_FLASH_VERSION(hex = "0x0E00000A", type = DataType.NONE),

    /**
     * hex = "0x0E00000B", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_DEVICE_ID&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_DEVICE_ID:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_DEVICE_ID(hex = "0x0E00000B", type = DataType.NONE),

    /**
     * hex = "0x0E060000", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_DEVICE_STATE&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_DEVICE_STATE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DEVICE_STATE(hex = "0x0E060000", type = DataType.NONE),

    /**
     * hex = "0x0E00000C", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_PM_POWER_L1&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_PM_POWER_L1:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_PM_POWER_L1(hex = "0x0E00000C", type = DataType.NONE),

    /**
     * hex = "0x0E00000D", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_PM_POWER_L2&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_PM_POWER_L2:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_PM_POWER_L2(hex = "0x0E00000D", type = DataType.NONE),

    /**
     * hex = "0x0E00000E", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_PM_POWER_L3&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_PM_POWER_L3:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_PM_POWER_L3(hex = "0x0E00000E", type = DataType.NONE),

    /**
     * hex = "0x0E00000F", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_PM_ACTIVE_PHASES&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_PM_ACTIVE_PHASES:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_PM_ACTIVE_PHASES(hex = "0x0E00000F", type = DataType.NONE),

    /**
     * hex = "0x0E000011", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_PM_MODE&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_PM_MODE:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_PM_MODE(hex = "0x0E000011", type = DataType.NONE),

    /**
     * hex = "0x0E000012", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_PM_ENERGY_L1&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_PM_ENERGY_L1:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_PM_ENERGY_L1(hex = "0x0E000012", type = DataType.NONE),

    /**
     * hex = "0x0E000013", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_PM_ENERGY_L2&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_PM_ENERGY_L2:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_PM_ENERGY_L2(hex = "0x0E000013", type = DataType.NONE),

    /**
     * hex = "0x0E000014", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_PM_ENERGY_L3&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_PM_ENERGY_L3:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_PM_ENERGY_L3(hex = "0x0E000014", type = DataType.NONE),

    /**
     * hex = "0x0E000015", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_PM_DEVICE_ID&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_PM_DEVICE_ID:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_PM_DEVICE_ID(hex = "0x0E000015", type = DataType.NONE),

    /**
     * hex = "0x0E000016", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_PM_ERROR_CODE&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_PM_ERROR_CODE:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_PM_ERROR_CODE(hex = "0x0E000016", type = DataType.NONE),

    /**
     * hex = "0x0E000029", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_PM_DEVICE_STATE&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_PM_DEVICE_STATE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_PM_DEVICE_STATE(hex = "0x0E000029", type = DataType.NONE),

    /**
     * hex = "0x0E000017", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_PM_FIRMWARE_VERSION&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_PM_FIRMWARE_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_PM_FIRMWARE_VERSION(hex = "0x0E000017", type = DataType.NONE),

    /**
     * hex = "0x0E00001F", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_DIAG_INFOS&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_DIAG_INFOS:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_DIAG_INFOS(hex = "0x0E00001F", type = DataType.NONE),

    /**
     * hex = "0x0E000020", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_DIAG_WARNINGS&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_DIAG_WARNINGS:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_DIAG_WARNINGS(hex = "0x0E000020", type = DataType.NONE),

    /**
     * hex = "0x0E000021", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_DIAG_ERRORS&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_DIAG_ERRORS:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_DIAG_ERRORS(hex = "0x0E000021", type = DataType.NONE),

    /**
     * hex = "0x0E000022", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_DIAG_TEMP_1&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_DIAG_TEMP_1:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_DIAG_TEMP_1(hex = "0x0E000022", type = DataType.NONE),

    /**
     * hex = "0x0E000023", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_DIAG_TEMP_2&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_DIAG_TEMP_2:).
     *
     * Original E3DC Documentation:
     *
     * en: Can only be used within a REQ_WB_DATA container!
     *
     * de: Kann nur innerhalb eines REQ_WB_DATA Container verwendet werden!
     *
     */
    REQ_DIAG_TEMP_2(hex = "0x0E000023", type = DataType.NONE),

    /**
     * hex = "0x0E800001", type = DataType.UINT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.ENERGY_ALL&labels=documentation&body=Documentation+update+for+enum+WBTag.ENERGY_ALL:).
     *
     * Original E3DC Documentation:
     *
     * en: Current power on L1 (Really????)
     *
     *
     * de: Aktuelle Leistung auf L1 (wirklich????)
     *
     */
    ENERGY_ALL(hex = "0x0E800001", type = DataType.UINT32),

    /**
     * hex = "0x0E800002", type = DataType.UINT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.ENERGY_SOLAR&labels=documentation&body=Documentation+update+for+enum+WBTag.ENERGY_SOLAR:).
     *
     * Original E3DC Documentation:
     *
     * en: Current power on L2 (Really????)
     *
     * de: Aktuelle Leistung auf L2 (wirklich????)
     */
    ENERGY_SOLAR(hex = "0x0E800002", type = DataType.UINT32),

    /**
     * hex = "0x0E800003", type = DataType.UINT16
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.SOC&labels=documentation&body=Documentation+update+for+enum+WBTag.SOC:).
     *
     * Original E3DC Documentation:
     *
     * en: Current power on L3 (Really????)
     *
     * de: Aktuelle Leistung auf L3 (wirklich????)
     */
    SOC(hex = "0x0E800003", type = DataType.UINT16),

    /**
     * hex = "0x0E800004", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.STATUS&labels=documentation&body=Documentation+update+for+enum+WBTag.STATUS:).
     *
     * Original E3DC Documentation:
     *
     * en: just the three lowest bits of activePhases are used to define what phase is switched on.
     * If the lowest bit is 1 phase1 is active if the lowest bit is 0 phase 1 is inactive ...
     *
     * static const unsigned char PHASE_1 = 1
     * static const unsigned char PHASE_2 = 2
     * static const unsigned char PHASE_3 = 4
     * f.e. if active Phases = 7 -> all phases are active
     *
     *
     * de: Nur die drei niedrigsten Bits von activePhases werden verwendet, um festzulegen, welche Phase
     * eingeschaltet ist. Wenn das niedrigste Bit 1 ist, ist Phase 1 aktiv, wenn das niedrigste Bit 0 ist, ist Phase 1 inaktiv ...
     *
     * static const unsigned char PHASE_1 = 1
     * static const unsigned char PHASE_2 = 2
     * static const unsigned char PHASE_3 = 4
     * f.e. if active Phases = 7 -> all phases are active
     */
    STATUS(hex = "0x0E800004", type = DataType.UCHAR8),

    /**
     * hex = "0x0E800005", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.ERROR_CODE&labels=documentation&body=Documentation+update+for+enum+WBTag.ERROR_CODE:).
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
     * de: wird verwendet, um das Fehlerbit zu identifizieren, wenn der Fehlercode verfügbar
     * ist mode = ERROR_ACTIVE_MODE. ACTIVE_MODE sonst. Alle anderen Modi ignorieren.
     *
     * static const unsigned char ACTIVE_MODE = 0
     * static const unsigned char PASSIVE_MODE = 1
     * static const unsigned char DIAGNOSE_MODE = 2
     * static const unsigned char ERROR_ACTIVE_MODE = 3
     * static const unsigned char ERROR_PASSIVE_MODE = 4
     */
    ERROR_CODE(hex = "0x0E800005", type = DataType.UCHAR8),

    /**
     * hex = "0x0E800006", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.MODE&labels=documentation&body=Documentation+update+for+enum+WBTag.MODE:).
     *
     * Original E3DC Documentation:
     *
     * en: Energy counter L1 (Really???)
     *
     *
     * de: Energiezähler L1 (Wirklich???)
     */
    MODE(hex = "0x0E800006", type = DataType.UCHAR8),

    /**
     * hex = "0x0E800007", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.APP_SOFTWARE&labels=documentation&body=Documentation+update+for+enum+WBTag.APP_SOFTWARE:).
     *
     * Original E3DC Documentation:
     *
     * en: Energy counter L2 (Really???)
     *
     *
     * de: Energiezähler L2 (Wirklich???)
     */
    APP_SOFTWARE(hex = "0x0E800007", type = DataType.UCHAR8),

    /**
     * hex = "0x0E800008", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.BOOTLOADER_SOFTWARE&labels=documentation&body=Documentation+update+for+enum+WBTag.BOOTLOADER_SOFTWARE:).
     *
     * Original E3DC Documentation:
     *
     * en: Energy counter L3 (Really???)
     *
     *
     * de: Energiezähler L3 (Wirklich???)
     */
    BOOTLOADER_SOFTWARE(hex = "0x0E800008", type = DataType.UCHAR8),

    /**
     * hex = "0x0E800009", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.HW_VERSION&labels=documentation&body=Documentation+update+for+enum+WBTag.HW_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en: ID of that device (Really???)
     *
     *
     * de: ID des Geräts (Wirklich???)
     */
    HW_VERSION(hex = "0x0E800009", type = DataType.UCHAR8),

    /**
     * hex = "0x0E80000A", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.FLASH_VERSION&labels=documentation&body=Documentation+update+for+enum+WBTag.FLASH_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en: Last reported error code (see mode if error has relevance) (Oh E3DC, What have you done?)
     *
     *
     * de: Letzter gemeldeter Fehlercode (siehe Modus, wenn der Fehler relevant ist) (Oh E3DC, was hast du getan?)
     */
    FLASH_VERSION(hex = "0x0E80000A", type = DataType.UCHAR8),

    /**
     * hex = "0x0E80000B", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.DEVICE_ID&labels=documentation&body=Documentation+update+for+enum+WBTag.DEVICE_ID:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DEVICE_ID(hex = "0x0E80000B", type = DataType.UCHAR8),

    /**
     * hex = "0x0E860000", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.DEVICE_STATE&labels=documentation&body=Documentation+update+for+enum+WBTag.DEVICE_STATE:).
     *
     * Original E3DC Documentation:
     *
     * en: DEVICE_CONNECTED & DEVICE_WORKING & DEVICE_IN_SERVICE
     *
     *
     * de: DEVICE_CONNECTED & DEVICE_WORKING & DEVICE_IN_SERVICE
     *
     */
    DEVICE_STATE(hex = "0x0E860000", type = DataType.CONTAINER),

    /**
     * hex = "0x0E860001", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.DEVICE_CONNECTED&labels=documentation&body=Documentation+update+for+enum+WBTag.DEVICE_CONNECTED:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DEVICE_CONNECTED(hex = "0x0E860001", type = DataType.BOOL),

    /**
     * hex = "0x0E860002", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.DEVICE_WORKING&labels=documentation&body=Documentation+update+for+enum+WBTag.DEVICE_WORKING:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DEVICE_WORKING(hex = "0x0E860002", type = DataType.BOOL),

    /**
     * hex = "0x0E860003", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.DEVICE_IN_SERVICE&labels=documentation&body=Documentation+update+for+enum+WBTag.DEVICE_IN_SERVICE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DEVICE_IN_SERVICE(hex = "0x0E860003", type = DataType.BOOL),

    /**
     * hex = "0x0EFFFFFF", type = DataType.ERROR
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.GENERAL_ERROR&labels=documentation&body=Documentation+update+for+enum+WBTag.GENERAL_ERROR:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x0EFFFFFF", type = DataType.ERROR),

    /**
     * hex = "0x0E80000C", type = DataType.DOUBLE64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.PM_POWER_L1&labels=documentation&body=Documentation+update+for+enum+WBTag.PM_POWER_L1:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PM_POWER_L1(hex = "0x0E80000C", type = DataType.DOUBLE64),

    /**
     * hex = "0x0E80000D", type = DataType.DOUBLE64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.PM_POWER_L2&labels=documentation&body=Documentation+update+for+enum+WBTag.PM_POWER_L2:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PM_POWER_L2(hex = "0x0E80000D", type = DataType.DOUBLE64),

    /**
     * hex = "0x0E80000E", type = DataType.DOUBLE64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.PM_POWER_L3&labels=documentation&body=Documentation+update+for+enum+WBTag.PM_POWER_L3:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PM_POWER_L3(hex = "0x0E80000E", type = DataType.DOUBLE64),

    /**
     * hex = "0x0E80000F", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.PM_ACTIVE_PHASES&labels=documentation&body=Documentation+update+for+enum+WBTag.PM_ACTIVE_PHASES:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PM_ACTIVE_PHASES(hex = "0x0E80000F", type = DataType.UCHAR8),

    /**
     * hex = "0x0E800011", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.PM_MODE&labels=documentation&body=Documentation+update+for+enum+WBTag.PM_MODE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PM_MODE(hex = "0x0E800011", type = DataType.UCHAR8),

    /**
     * hex = "0x0E800012", type = DataType.DOUBLE64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.PM_ENERGY_L1&labels=documentation&body=Documentation+update+for+enum+WBTag.PM_ENERGY_L1:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PM_ENERGY_L1(hex = "0x0E800012", type = DataType.DOUBLE64),

    /**
     * hex = "0x0E800013", type = DataType.DOUBLE64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.PM_ENERGY_L2&labels=documentation&body=Documentation+update+for+enum+WBTag.PM_ENERGY_L2:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PM_ENERGY_L2(hex = "0x0E800013", type = DataType.DOUBLE64),

    /**
     * hex = "0x0E800014", type = DataType.DOUBLE64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.PM_ENERGY_L3&labels=documentation&body=Documentation+update+for+enum+WBTag.PM_ENERGY_L3:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PM_ENERGY_L3(hex = "0x0E800014", type = DataType.DOUBLE64),

    /**
     * hex = "0x0E800015", type = DataType.UINT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.PM_DEVICE_ID&labels=documentation&body=Documentation+update+for+enum+WBTag.PM_DEVICE_ID:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PM_DEVICE_ID(hex = "0x0E800015", type = DataType.UINT32),

    /**
     * hex = "0x0E800016", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.PM_ERROR_CODE&labels=documentation&body=Documentation+update+for+enum+WBTag.PM_ERROR_CODE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PM_ERROR_CODE(hex = "0x0E800016", type = DataType.UCHAR8),

    /**
     * hex = "0x0E800029", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.PM_DEVICE_STATE&labels=documentation&body=Documentation+update+for+enum+WBTag.PM_DEVICE_STATE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PM_DEVICE_STATE(hex = "0x0E800029", type = DataType.NONE),

    /**
     * hex = "0x0E800030", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.PM_DEVICE_STATE_CONNECTED&labels=documentation&body=Documentation+update+for+enum+WBTag.PM_DEVICE_STATE_CONNECTED:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PM_DEVICE_STATE_CONNECTED(hex = "0x0E800030", type = DataType.NONE),

    /**
     * hex = "0x0E800031", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.PM_DEVICE_STATE_WORKING&labels=documentation&body=Documentation+update+for+enum+WBTag.PM_DEVICE_STATE_WORKING:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PM_DEVICE_STATE_WORKING(hex = "0x0E800031", type = DataType.NONE),

    /**
     * hex = "0x0E800032", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.PM_DEVICE_STATE_IN_SERVICE&labels=documentation&body=Documentation+update+for+enum+WBTag.PM_DEVICE_STATE_IN_SERVICE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PM_DEVICE_STATE_IN_SERVICE(hex = "0x0E800032", type = DataType.NONE),

    /**
     * hex = "0x0E800017", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.PM_FIRMWARE_VERSION&labels=documentation&body=Documentation+update+for+enum+WBTag.PM_FIRMWARE_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PM_FIRMWARE_VERSION(hex = "0x0E800017", type = DataType.UCHAR8),

    /**
     * hex = "0x0E80001F", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.DIAG_INFOS&labels=documentation&body=Documentation+update+for+enum+WBTag.DIAG_INFOS:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DIAG_INFOS(hex = "0x0E80001F", type = DataType.NONE),

    /**
     * hex = "0x0E800020", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.DIAG_WARNINGS&labels=documentation&body=Documentation+update+for+enum+WBTag.DIAG_WARNINGS:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DIAG_WARNINGS(hex = "0x0E800020", type = DataType.NONE),

    /**
     * hex = "0x0E800021", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.DIAG_ERRORS&labels=documentation&body=Documentation+update+for+enum+WBTag.DIAG_ERRORS:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DIAG_ERRORS(hex = "0x0E800021", type = DataType.NONE),

    /**
     * hex = "0x0E800022", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.DIAG_TEMP_1&labels=documentation&body=Documentation+update+for+enum+WBTag.DIAG_TEMP_1:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DIAG_TEMP_1(hex = "0x0E800022", type = DataType.NONE),

    /**
     * hex = "0x0E800023", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.DIAG_TEMP_2&labels=documentation&body=Documentation+update+for+enum+WBTag.DIAG_TEMP_2:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DIAG_TEMP_2(hex = "0x0E800023", type = DataType.NONE),

    /**
     * hex = "0x0E041000", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_AVAILABLE_SOLAR_POWER&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_AVAILABLE_SOLAR_POWER:).
     *
     * Original E3DC Documentation:
     *
     * en: Contains TAG_WB_INDEX, the value decides which wallbox is queried
     *
     * de: Beinhaltet TAG_WB_INDEX, der Value entscheidet welche Wallbox abgefragt wird
     *
     */
    REQ_AVAILABLE_SOLAR_POWER(hex = "0x0E041000", type = DataType.CONTAINER),

    /**
     * hex = "0x0E041001", type = DataType.UINT16
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.POWER&labels=documentation&body=Documentation+update+for+enum+WBTag.POWER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    POWER(hex = "0x0E041001", type = DataType.UINT16),

    /**
     * hex = "0x0E041002", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.STATUS_BIT&labels=documentation&body=Documentation+update+for+enum+WBTag.STATUS_BIT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    STATUS_BIT(hex = "0x0E041002", type = DataType.UCHAR8),

    /**
     * hex = "0x0E841000", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.AVAILABLE_SOLAR_POWER&labels=documentation&body=Documentation+update+for+enum+WBTag.AVAILABLE_SOLAR_POWER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    AVAILABLE_SOLAR_POWER(hex = "0x0E841000", type = DataType.CONTAINER),

    /**
     * hex = "0x0E000030", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_SET_MODE&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_SET_MODE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_MODE(hex = "0x0E000030", type = DataType.CONTAINER),

    /**
     * hex = "0x0E040031", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.MODE_PARAM_MODE&labels=documentation&body=Documentation+update+for+enum+WBTag.MODE_PARAM_MODE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MODE_PARAM_MODE(hex = "0x0E040031", type = DataType.UCHAR8),

    /**
     * hex = "0x0E040032", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.MODE_PARAM_MAX_CURRENT&labels=documentation&body=Documentation+update+for+enum+WBTag.MODE_PARAM_MAX_CURRENT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MODE_PARAM_MAX_CURRENT(hex = "0x0E040032", type = DataType.UCHAR8),

    /**
     * hex = "0x0E000031", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.SET_MODE&labels=documentation&body=Documentation+update+for+enum+WBTag.SET_MODE:).
     *
     * Original E3DC Documentation:
     *
     * en: err value, 0 for successfully set mode
     *
     *
     * de: err-Wert, 0 für erfolgreich eingestellten Modus
     */
    SET_MODE(hex = "0x0E000031", type = DataType.UCHAR8),

    /**
     * hex = "0x0E041010", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_SET_EXTERN&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_SET_EXTERN:).
     *
     * Original E3DC Documentation:
     *
     * en: Expects EXTERN_DATA (length 6) and EXTERN_DATA_LEN =6 /
     * Byte 1:   1-sun mode / 2-mixed mode
     * Byte 2:   Current limitation for all  /    Modes, [1 ? 32] A /
     * Byte 3:  PreCharge (1: +5% / 2: -5%)
     * Byte 4: > 0: Exchange number of phases
     * Byte 5: > 0: Type2, abort charging
     * Byte 6: > 0: Socket outlet with earthing contact, confirmation for ?AN?
     *
     *
     * de: Erwartet EXTERN_DATA (Länge 6) und EXTERN_DATA_LEN =6 /
     * Byte 1:   1-Sonnenmode / 2-Mischmode
     * Byte 2:   Strombegrenzung für alle  /    Modes, [1 ? 32] A /
     * Byte 3:  PreCharge (1: +5% / 2: -5%)
     * Byte 4: > 0: Anzahl Phasen tauschen
     * Byte 5: > 0: Typ2, Laden abbrechen
     * Byte 6: > 0: Schuko, Bestätigung für ?AN?
     */
    REQ_SET_EXTERN(hex = "0x0E041010", type = DataType.CONTAINER),

    /**
     * hex = "0x0E841010", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.SET_EXTERN&labels=documentation&body=Documentation+update+for+enum+WBTag.SET_EXTERN:).
     *
     * Original E3DC Documentation:
     *
     * en: no content
     *
     *
     * de: kein Inhalt
     */
    SET_EXTERN(hex = "0x0E841010", type = DataType.NONE),

    /**
     * hex = "0x0E042010", type = DataType.BYTEARRAY
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.EXTERN_DATA&labels=documentation&body=Documentation+update+for+enum+WBTag.EXTERN_DATA:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    EXTERN_DATA(hex = "0x0E042010", type = DataType.BYTEARRAY),

    /**
     * hex = "0x0E042011", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.EXTERN_DATA_LEN&labels=documentation&body=Documentation+update+for+enum+WBTag.EXTERN_DATA_LEN:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    EXTERN_DATA_LEN(hex = "0x0E042011", type = DataType.UCHAR8),

    /**
     * hex = "0x0E041011", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_EXTERN_DATA_SUN&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_EXTERN_DATA_SUN:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_EXTERN_DATA_SUN(hex = "0x0E041011", type = DataType.NONE),

    /**
     * hex = "0x0E041012", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_EXTERN_DATA_NET&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_EXTERN_DATA_NET:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_EXTERN_DATA_NET(hex = "0x0E041012", type = DataType.NONE),

    /**
     * hex = "0x0E041013", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_EXTERN_DATA_ALL&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_EXTERN_DATA_ALL:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_EXTERN_DATA_ALL(hex = "0x0E041013", type = DataType.NONE),

    /**
     * hex = "0x0E041014", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_EXTERN_DATA_ALG&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_EXTERN_DATA_ALG:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_EXTERN_DATA_ALG(hex = "0x0E041014", type = DataType.NONE),

    /**
     * hex = "0x0E841011", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.EXTERN_DATA_SUN&labels=documentation&body=Documentation+update+for+enum+WBTag.EXTERN_DATA_SUN:).
     *
     * Original E3DC Documentation:
     *
     * en: contains EXTERN_DATA (length 7) and EXTERN_DATA_LEN =7
     * Byte 1-2: uint16, Solar power in W
     * Byte 3-6: uint32, Solar energy in Wh
     * Byte 7: uint8, Amount of sun in %
     *
     *
     * de: enthält EXTERN_DATA (Länge 7) und EXTERN_DATA_LEN =7
     * Byte 1-2: uint16, Sonnenleistung in W
     * Byte 3-6: uint32, Sonnenenergie in Wh
     * Byte 7: uint8, Sonnenmenge in %
     */
    EXTERN_DATA_SUN(hex = "0x0E841011", type = DataType.CONTAINER),

    /**
     * hex = "0x0E841012", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.EXTERN_DATA_NET&labels=documentation&body=Documentation+update+for+enum+WBTag.EXTERN_DATA_NET:).
     *
     * Original E3DC Documentation:
     *
     * en: contains EXTERN_DATA (length 7) and EXTERN_DATA_LEN =7
     * Byte 1-2: uint16, Grid power in W
     * Byte 3-6: uint32, Grid energy in Wh
     * Byte 7: uint8, Grid amount in %
     *
     *
     * de: enthält EXTERN_DATA (Länge 7) und EXTERN_DATA_LEN =7
     * Byte 1-2: uint16, Netzleistung in W
     * Byte 3-6: uint32, Netzenergie in Wh
     * Byte 7: uint8, Netzmenge in %
     */
    EXTERN_DATA_NET(hex = "0x0E841012", type = DataType.CONTAINER),

    /**
     * hex = "0x0E841013", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.EXTERN_DATA_ALL&labels=documentation&body=Documentation+update+for+enum+WBTag.EXTERN_DATA_ALL:).
     *
     * Original E3DC Documentation:
     *
     * en: contains EXTERN_DATA (length 7) and EXTERN_DATA_LEN =7
     * Byte 1-2: uint16, Total output in W
     * Byte 3-6: uint32, Total energy in Wh
     * Byte 7: uint8, Total amount in %
     *
     *
     * de: enthält EXTERN_DATA (Länge 7) und EXTERN_DATA_LEN =7
     * Byte 1-2: uint16, Gesamtleistung in W
     * Byte 3-6: uint32, Gesamtenergie in Wh
     * Byte 7: uint8, Gesamtmenge in %
     */
    EXTERN_DATA_ALL(hex = "0x0E841013", type = DataType.CONTAINER),

    /**
     * hex = "0x0E841014", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.EXTERN_DATA_ALG&labels=documentation&body=Documentation+update+for+enum+WBTag.EXTERN_DATA_ALG:).
     *
     * Original E3DC Documentation:
     *
     * en: contains EXTERN_DATA (length 7) and EXTERN_DATA_LEN =7
     * Byte 1: uint8, PreCharge in %
     * Byte 2: uint8, 1: Sun mode, 0: Mixed mode
     * Byte 3: uint8, 1: Car charges, 0: does not charge
     * Byte 4: uint8, 1: Type2 locked, 0: unlocked
     * Byte 5: uint8, Number of active phases [0-3]
     * Byte 6: uint4 low, 1: Schuko occupied, uint4 high, 1: Schuko on
     *
     *
     * de: enthält EXTERN_DATA (Länge 7) und EXTERN_DATA_LEN =7
     * Byte 1: uint8, PreCharge in %
     * Byte 2: uint8, 1: Sun mode, 0: Misch modus
     * Byte 3: uint8, 1: Auto lädt, 0: lädt nicht
     * Byte 4: uint8, 1: Typ2 verriegelt, 0: entr.
     * Byte 5: uint8, Anzahl akt. Phasen [0-3]
     * Byte 6: uint4 low, 1: Schuko belegt, uint4 high, 1: Schuko an
     */
    EXTERN_DATA_ALG(hex = "0x0E841014", type = DataType.CONTAINER),

    /**
     * hex = "0x0E041015", type = DataType.UINT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_SET_BAT_CAPACITY&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_SET_BAT_CAPACITY:).
     *
     * Original E3DC Documentation:
     *
     * en: Set capacity in Wh
     *
     *
     * de: Kapazität in Wh einstellen
     */
    REQ_SET_BAT_CAPACITY(hex = "0x0E041015", type = DataType.UINT32),

    /**
     * hex = "0x0E041018", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_SET_PARAM_1&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_SET_PARAM_1:).
     *
     * Original E3DC Documentation:
     *
     * en: Expects EXTERN_DATA (length 6) and EXTERN_DATA_LEN =6
     * Byte 1: User Parameter, uint16 Byte 0
     * Byte 2: User Parameter, uint16 Byte 1
     * Byte 3: Maximum charging current, uint8
     * Byte 4: Phase voltage, uint8
     * Byte 5: Display language, uint8
     * Byte 6: Display design, uint8
     *
     *
     * de: Erwartet EXTERN_DATA (Länge 6) und EXTERN_DATA_LEN =6
     * Byte 1: User Parameter, uint16 Byte 0
     * Byte 2: User Parameter, uint16 Byte 1
     * Byte 3: Maximaler Ladestrom, uint8
     * Byte 4: Phasenspannung, uint8
     * Byte 5: Display Sprache, uint8
     * Byte 6: Display Design, uint8
     */
    REQ_SET_PARAM_1(hex = "0x0E041018", type = DataType.CONTAINER),

    /**
     * hex = "0x0E041019", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_SET_PARAM_2&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_SET_PARAM_2:).
     *
     * Original E3DC Documentation:
     *
     * en: Expects EXTERN_DATA (length 6) and EXTERN_DATA_LEN =6
     * Byte 1: ISstart, uint8 in A
     * Byte 2: ISmin, uint8 in A
     * Byte 3: ISmax, uint8 in A
     * Byte 4 ? 6: No content
     *
     *
     * de: Erwartet EXTERN_DATA (Länge 6) und EXTERN_DATA_LEN =6
     * Byte 1: ISstart, uint8 in A
     * Byte 2: ISmin, uint8 in A
     * Byte 3: ISmax, uint8 in A
     * Byte 4 ? 6: Kein Inhalt
     */
    REQ_SET_PARAM_2(hex = "0x0E041019", type = DataType.CONTAINER),

    /**
     * hex = "0x0E841015", type = DataType.UINT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.SET_BAT_CAPACITY&labels=documentation&body=Documentation+update+for+enum+WBTag.SET_BAT_CAPACITY:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_BAT_CAPACITY(hex = "0x0E841015", type = DataType.UINT32),

    /**
     * hex = "0x0E841018", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.SET_PARAM_1&labels=documentation&body=Documentation+update+for+enum+WBTag.SET_PARAM_1:).
     *
     * Original E3DC Documentation:
     *
     * en: contains EXTERN_DATA (length 6) and EXTERN_DATA_LEN =6
     * Byte 1: User Parameter, uint16 Byte 0
     * Byte 2: User Parameter, uint16 Byte 1
     * Byte 3: Maximum charging current, uint8
     * Byte 4: Phase voltage, uint8
     * Byte 5: Display language, uint8
     * Byte 6: Display design, uint8
     *
     *
     * de: enthält EXTERN_DATA (Länge 6) und EXTERN_DATA_LEN =6
     * Byte 1: User Parameter, uint16 Byte 0
     * Byte 2: User Parameter, uint16 Byte 1
     * Byte 3: Maximaler Ladestrom, uint8
     * Byte 4: Phasenspannung, uint8
     * Byte 5: Display Sprache, uint8
     * Byte 6: Display Design, uint8
     */
    SET_PARAM_1(hex = "0x0E841018", type = DataType.CONTAINER),

    /**
     * hex = "0x0E841019", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.SET_PARAM_2&labels=documentation&body=Documentation+update+for+enum+WBTag.SET_PARAM_2:).
     *
     * Original E3DC Documentation:
     *
     * en: contains EXTERN_DATA (length 6) and EXTERN_DATA_LEN =6
     * Byte 1: ISstart, uint8 in A
     * Byte 2: ISmin, uint8 in A
     * Byte 3: ISmax, uint8 in A
     * Byte 4 ? 6: No content
     *
     *
     * de: enthält EXTERN_DATA (Länge 6) und EXTERN_DATA_LEN =6
     * Byte 1: ISstart, uint8 in A
     * Byte 2: ISmin, uint8 in A
     * Byte 3: ISmax, uint8 in A
     * Byte 4 ? 6: Kein Inhalt
     */
    SET_PARAM_2(hex = "0x0E841019", type = DataType.CONTAINER),

    /**
     * hex = "0x0E04101A", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_PARAM_2&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_PARAM_2:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_PARAM_2(hex = "0x0E04101A", type = DataType.NONE),

    /**
     * hex = "0x0E84101A", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.RSP_PARAM_2&labels=documentation&body=Documentation+update+for+enum+WBTag.RSP_PARAM_2:).
     *
     * Original E3DC Documentation:
     *
     * en: contains EXTERN_DATA (length 6) and EXTERN_DATA_LEN =6
     * Byte 1: ISstart, uint8 in A
     * Byte 2: ISmin, uint8 in A
     * Byte 3: ISmax, uint8 in A
     * Byte 4 ? 6: no content
     *
     *
     * de: enthält EXTERN_DATA (Länge 6) und EXTERN_DATA_LEN =6
     * Byte 1: ISstart, uint8 in A
     * Byte 2: ISmin, uint8 in A
     * Byte 3: ISmax, uint8 in A
     * Byte 4 ? 6: Kein Inhalt
     */
    RSP_PARAM_2(hex = "0x0E84101A", type = DataType.CONTAINER),

    /**
     * hex = "0x0E04101B", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.REQ_PARAM_1&labels=documentation&body=Documentation+update+for+enum+WBTag.REQ_PARAM_1:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_PARAM_1(hex = "0x0E04101B", type = DataType.NONE),

    /**
     * hex = "0x0E84101B", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+WBTag.RSP_PARAM_1&labels=documentation&body=Documentation+update+for+enum+WBTag.RSP_PARAM_1:).
     *
     * Original E3DC Documentation:
     *
     * en: contains EXTERN_DATA (length 6) and EXTERN_DATA_LEN =6
     * Byte 1: User Parameter, uint16 Byte 0
     * Byte 2: User Parameter, uint16 Byte 1
     * Byte 3: Maximum charging current, uint8
     * Byte 4: Phase voltage, uint8
     * Byte 5: Display language, uint8
     * Byte 6: Display design, uint8
     *
     *
     * de: enthält EXTERN_DATA (Länge 6) und EXTERN_DATA_LEN =6
     * Byte 1: User Parameter, uint16 Byte 0
     * Byte 2: User Parameter, uint16 Byte 1
     * Byte 3: Maximaler Ladestrom, uint8
     * Byte 4: Phasenspannung, uint8
     * Byte 5: Display Sprache, uint8
     * Byte 6: Display Design, uint8
     */
    RSP_PARAM_1(hex = "0x0E84101B", type = DataType.CONTAINER),

}
