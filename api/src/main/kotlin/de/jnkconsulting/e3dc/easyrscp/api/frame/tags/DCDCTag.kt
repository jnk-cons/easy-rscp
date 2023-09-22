package de.jnkconsulting.e3dc.easyrscp.api.frame.tags

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Namespace
import de.jnkconsulting.e3dc.easyrscp.api.frame.Tag

/**
 * Contains tags for reading and controlling the Battery DCDC ?????
 *
 * @param namespace Der Namespace des Tags für die Abbildung des jeweiligen Bereichs
 * @param hex Code of the tag in HexString format (0x0304001)
 * @param type Tag data type [DataType]
 *
 * @since 2.0
 */
enum class DCDCTag(
    override val namespace: Namespace = Namespace.DCDC,
    override val hex: String,
    override val type: DataType
) : Tag {

    /**
     * hex = "0x04040000", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.REQ_DATA&labels=documentation&body=Documentation+update+for+enum+DCDCTag.REQ_DATA:).
     *
     * Original E3DC Documentation:
     *
     * en: Contains all request TAGs, the container MUST contain an index
     *
     * de: Beinhaltet alle Anfrage-TAGs, der Container MUSS einen Index enthalten
     *
     */
    REQ_DATA(hex = "0x04040000", type = DataType.CONTAINER),

    /**
     * hex = "0x04040001", type = DataType.UINT16
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.INDEX&labels=documentation&body=Documentation+update+for+enum+DCDCTag.INDEX:).
     *
     * Original E3DC Documentation:
     *
     * en: Index of the requested device (0?n for the FBC Nr or 0xFF for group), Occurs in the request and in the answer to the DATA tag
     *
     * de: Index des angefragten Gerätes (0?n für die FBC Nr oder 0xFF für Gruppe), Kommt in der Anfrage und in der Antwort zum DATA-Tag vor
     *
     */
    INDEX(hex = "0x04040001", type = DataType.UINT16),

    /**
     * hex = "0x04840000", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.DATA&labels=documentation&body=Documentation+update+for+enum+DCDCTag.DATA:).
     *
     * Original E3DC Documentation:
     *
     * en: Response with all data of the REQ_DATA request
     *
     * de: Antwort mit allen Daten der REQ_DATA Anfrage
     *
     */
    DATA(hex = "0x04840000", type = DataType.CONTAINER),

    /**
     * hex = "0x04000001", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.REQ_I_BAT&labels=documentation&body=Documentation+update+for+enum+DCDCTag.REQ_I_BAT:).
     *
     * Original E3DC Documentation:
     *
     * en: As parameter the index of the DCDC is required. Index 0 is for GroupController.
     *
     * de: Als Parameter wird der Index des DCDCs benötigt. Index 0 ist für GroupController.
     *
     */
    REQ_I_BAT(hex = "0x04000001", type = DataType.NONE),

    /**
     * hex = "0x04000002", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.REQ_U_BAT&labels=documentation&body=Documentation+update+for+enum+DCDCTag.REQ_U_BAT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_U_BAT(hex = "0x04000002", type = DataType.NONE),

    /**
     * hex = "0x04000003", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.REQ_P_BAT&labels=documentation&body=Documentation+update+for+enum+DCDCTag.REQ_P_BAT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_P_BAT(hex = "0x04000003", type = DataType.NONE),

    /**
     * hex = "0x04000004", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.REQ_I_DCL&labels=documentation&body=Documentation+update+for+enum+DCDCTag.REQ_I_DCL:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_I_DCL(hex = "0x04000004", type = DataType.NONE),

    /**
     * hex = "0x04000005", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.REQ_U_DCL&labels=documentation&body=Documentation+update+for+enum+DCDCTag.REQ_U_DCL:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_U_DCL(hex = "0x04000005", type = DataType.NONE),

    /**
     * hex = "0x04000006", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.REQ_P_DCL&labels=documentation&body=Documentation+update+for+enum+DCDCTag.REQ_P_DCL:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_P_DCL(hex = "0x04000006", type = DataType.NONE),

    /**
     * hex = "0x04000008", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.REQ_FIRMWARE_VERSION&labels=documentation&body=Documentation+update+for+enum+DCDCTag.REQ_FIRMWARE_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_FIRMWARE_VERSION(hex = "0x04000008", type = DataType.NONE),

    /**
     * hex = "0x04000009", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.REQ_FPGA_FIRMWARE&labels=documentation&body=Documentation+update+for+enum+DCDCTag.REQ_FPGA_FIRMWARE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_FPGA_FIRMWARE(hex = "0x04000009", type = DataType.NONE),

    /**
     * hex = "0x0400000A", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.REQ_SERIAL_NUMBER&labels=documentation&body=Documentation+update+for+enum+DCDCTag.REQ_SERIAL_NUMBER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SERIAL_NUMBER(hex = "0x0400000A", type = DataType.NONE),

    /**
     * hex = "0x0400000B", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.REQ_BOARD_VERSION&labels=documentation&body=Documentation+update+for+enum+DCDCTag.REQ_BOARD_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_BOARD_VERSION(hex = "0x0400000B", type = DataType.NONE),

    /**
     * hex = "0x0400000C", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.REQ_FLASH_FILE_LIST&labels=documentation&body=Documentation+update+for+enum+DCDCTag.REQ_FLASH_FILE_LIST:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_FLASH_FILE_LIST(hex = "0x0400000C", type = DataType.NONE),

    /**
     * hex = "0x0400000E", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.REQ_IS_FLASHING&labels=documentation&body=Documentation+update+for+enum+DCDCTag.REQ_IS_FLASHING:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_IS_FLASHING(hex = "0x0400000E", type = DataType.NONE),

    /**
     * hex = "0x0400000F", type = DataType.STRING
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.REQ_FLASH&labels=documentation&body=Documentation+update+for+enum+DCDCTag.REQ_FLASH:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_FLASH(hex = "0x0400000F", type = DataType.STRING),

    /**
     * hex = "0x04000010", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.REQ_STATUS&labels=documentation&body=Documentation+update+for+enum+DCDCTag.REQ_STATUS:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_STATUS(hex = "0x04000010", type = DataType.NONE),

    /**
     * hex = "0x04000013", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.REQ_STATUS_AS_STRING&labels=documentation&body=Documentation+update+for+enum+DCDCTag.REQ_STATUS_AS_STRING:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_STATUS_AS_STRING(hex = "0x04000013", type = DataType.NONE),

    /**
     * hex = "0x04800001", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.I_BAT&labels=documentation&body=Documentation+update+for+enum+DCDCTag.I_BAT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    I_BAT(hex = "0x04800001", type = DataType.FLOAT32),

    /**
     * hex = "0x04800002", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.U_BAT&labels=documentation&body=Documentation+update+for+enum+DCDCTag.U_BAT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    U_BAT(hex = "0x04800002", type = DataType.FLOAT32),

    /**
     * hex = "0x04800003", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.P_BAT&labels=documentation&body=Documentation+update+for+enum+DCDCTag.P_BAT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    P_BAT(hex = "0x04800003", type = DataType.FLOAT32),

    /**
     * hex = "0x04800004", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.I_DCL&labels=documentation&body=Documentation+update+for+enum+DCDCTag.I_DCL:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    I_DCL(hex = "0x04800004", type = DataType.FLOAT32),

    /**
     * hex = "0x04800005", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.U_DCL&labels=documentation&body=Documentation+update+for+enum+DCDCTag.U_DCL:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    U_DCL(hex = "0x04800005", type = DataType.FLOAT32),

    /**
     * hex = "0x04800006", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.P_DCL&labels=documentation&body=Documentation+update+for+enum+DCDCTag.P_DCL:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    P_DCL(hex = "0x04800006", type = DataType.FLOAT32),

    /**
     * hex = "0x04800008", type = DataType.STRING
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.FIRMWARE_VERSION&labels=documentation&body=Documentation+update+for+enum+DCDCTag.FIRMWARE_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    FIRMWARE_VERSION(hex = "0x04800008", type = DataType.STRING),

    /**
     * hex = "0x04800009", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.FPGA_FIRMWARE&labels=documentation&body=Documentation+update+for+enum+DCDCTag.FPGA_FIRMWARE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    FPGA_FIRMWARE(hex = "0x04800009", type = DataType.UCHAR8),

    /**
     * hex = "0x0480000A", type = DataType.STRING
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.SERIAL_NUMBER&labels=documentation&body=Documentation+update+for+enum+DCDCTag.SERIAL_NUMBER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SERIAL_NUMBER(hex = "0x0480000A", type = DataType.STRING),

    /**
     * hex = "0x0480000B", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.BOARD_VERSION&labels=documentation&body=Documentation+update+for+enum+DCDCTag.BOARD_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    BOARD_VERSION(hex = "0x0480000B", type = DataType.UCHAR8),

    /**
     * hex = "0x0480000C", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.FLASH_FILE_LIST&labels=documentation&body=Documentation+update+for+enum+DCDCTag.FLASH_FILE_LIST:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    FLASH_FILE_LIST(hex = "0x0480000C", type = DataType.CONTAINER),

    /**
     * hex = "0x0480000D", type = DataType.STRING
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.FLASH_FILE&labels=documentation&body=Documentation+update+for+enum+DCDCTag.FLASH_FILE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    FLASH_FILE(hex = "0x0480000D", type = DataType.STRING),

    /**
     * hex = "0x0480000E", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.IS_FLASHING&labels=documentation&body=Documentation+update+for+enum+DCDCTag.IS_FLASHING:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IS_FLASHING(hex = "0x0480000E", type = DataType.BOOL),

    /**
     * hex = "0x0480000F", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.FLASH&labels=documentation&body=Documentation+update+for+enum+DCDCTag.FLASH:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    FLASH(hex = "0x0480000F", type = DataType.BOOL),

    /**
     * hex = "0x04800010", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.STATUS&labels=documentation&body=Documentation+update+for+enum+DCDCTag.STATUS:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    STATUS(hex = "0x04800010", type = DataType.CONTAINER),

    /**
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.STATE&labels=documentation&body=Documentation+update+for+enum+DCDCTag.STATE:).
     * hex = "0x04800011", type = DataType.UCHAR8
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    STATE(hex = "0x04800011", type = DataType.UCHAR8),

    /**
     * hex = "0x04800012", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.SUBSTATE&labels=documentation&body=Documentation+update+for+enum+DCDCTag.SUBSTATE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SUBSTATE(hex = "0x04800012", type = DataType.UCHAR8),

    /**
     * hex = "0x04800013", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.STATUS_AS_STRING&labels=documentation&body=Documentation+update+for+enum+DCDCTag.STATUS_AS_STRING:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    STATUS_AS_STRING(hex = "0x04800013", type = DataType.CONTAINER),

    /**
     * hex = "0x04800014", type = DataType.STRING
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.STATE_AS_STRING&labels=documentation&body=Documentation+update+for+enum+DCDCTag.STATE_AS_STRING:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    STATE_AS_STRING(hex = "0x04800014", type = DataType.STRING),

    /**
     * hex = "0x04800015", type = DataType.STRING
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.SUBSTATE_AS_STRING&labels=documentation&body=Documentation+update+for+enum+DCDCTag.SUBSTATE_AS_STRING:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SUBSTATE_AS_STRING(hex = "0x04800015", type = DataType.STRING),

    /**
     * hex = "0x04060000", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.REQ_DEVICE_STATE&labels=documentation&body=Documentation+update+for+enum+DCDCTag.REQ_DEVICE_STATE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DEVICE_STATE(hex = "0x04060000", type = DataType.NONE),

    /**
     * hex = "0x04860000", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.DEVICE_STATE&labels=documentation&body=Documentation+update+for+enum+DCDCTag.DEVICE_STATE:).
     *
     * Original E3DC Documentation:
     *
     * en: DEVICE_CONNECTED & DEVICE_WORKING & DEVICE_IN_SERVICE
     *
     * de: DEVICE_CONNECTED & DEVICE_WORKING & DEVICE_IN_SERVICE
     *
     */
    DEVICE_STATE(hex = "0x04860000", type = DataType.CONTAINER),

    /**
     * hex = "0x04860001", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.DEVICE_CONNECTED&labels=documentation&body=Documentation+update+for+enum+DCDCTag.DEVICE_CONNECTED:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DEVICE_CONNECTED(hex = "0x04860001", type = DataType.BOOL),

    /**
     * hex = "0x04860002", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.DEVICE_WORKING&labels=documentation&body=Documentation+update+for+enum+DCDCTag.DEVICE_WORKING:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DEVICE_WORKING(hex = "0x04860002", type = DataType.BOOL),

    /**
     * hex = "0x04860003", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.DEVICE_IN_SERVICE&labels=documentation&body=Documentation+update+for+enum+DCDCTag.DEVICE_IN_SERVICE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DEVICE_IN_SERVICE(hex = "0x04860003", type = DataType.BOOL),

    /**
     * hex = "0x04FFFFFF", type = DataType.ERROR
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+DCDCTag.GENERAL_ERROR&labels=documentation&body=Documentation+update+for+enum+DCDCTag.GENERAL_ERROR:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x04FFFFFF", type = DataType.ERROR),

}
