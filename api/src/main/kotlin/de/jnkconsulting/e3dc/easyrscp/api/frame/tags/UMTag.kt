package de.jnkconsulting.e3dc.easyrscp.api.frame.tags

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Namespace
import de.jnkconsulting.e3dc.easyrscp.api.frame.Tag

/**
 * Contains Tag for the Update Management System
 *
 * @param namespace Der Namespace des Tags für die Abbildung des jeweiligen Bereichs
 * @param hex Code of the tag in HexString format (0x0304001)
 * @param type Tag data type [DataType]
 *
 * @since 2.0
 */
enum class UMTag(
    override val namespace: Namespace = Namespace.UM,
    override val hex: String,
    override val type: DataType
) : Tag {

    /**
     * hex = "0x0D000001", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_UPDATE_STATUS(hex = "0x0D000001", type = DataType.NONE),

    /**
     * hex = "0x0D800001", type = DataType.INT32
     *
     * Original E3DC Documentation:
     *
     * en:
     * 0x00=IDLE
     * 0x01=UPDATE_CHECK_RUNNING
     * 0x02=UPDATING_MODULES_AND_FILES
     * 0x03=UPDATING_HARDWARE
     *
     *
     * de:
     * 0x00=IDLE
     * 0x01=UPDATE_CHECK_RUNNING
     * 0x02=UPDATING_MODULES_AND_FILES
     * 0x03=UPDATING_HARDWARE
     *
     */
    UPDATE_STATUS(hex = "0x0D800001", type = DataType.INT32),

    /**
     * hex = "0x0D000003", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_CHECK_FOR_UPDATES(hex = "0x0D000003", type = DataType.NONE),

    /**
     * hex = "0x0D800003", type = DataType.UCHAR8
     *
     * Original E3DC Documentation:
     *
     * en:
     * 0 = check not possible (no internet?)
     * 1 = check is executed, if something new is detected, it is installed
     *
     *
     * de:
     * 0 = check nicht möglich (kein Internet?)
     * 1 = check wird ausgeführt, wenn was neues entdeckt wird, wird es installiert
     *
     */
    CHECK_FOR_UPDATES(hex = "0x0D800003", type = DataType.UCHAR8),

    /**
     * hex = "0x0DFFFFFF", type = DataType.ERROR
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x0DFFFFFF", type = DataType.ERROR),

}
