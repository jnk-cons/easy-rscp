package de.jnkconsulting.e3dc.easyrscp.api.frame.tags

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Namespace
import de.jnkconsulting.e3dc.easyrscp.api.frame.Tag

/**
 * Contains system-relevant tags. For example, to restart the home power plant.
 *
 * @param namespace Der Namespace des Tags für die Abbildung des jeweiligen Bereichs
 * @param hex Code of the tag in HexString format (0x0304001)
 * @param type Tag data type [DataType]
 *
 * @since 2.0
 */
enum class SYSTag(
    override val namespace: Namespace = Namespace.SYS,
    override val hex: String,
    override val type: DataType
) : Tag {

    /**
     * hex = "0x0C000001", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SYSTEM_REBOOT(hex = "0x0C000001", type = DataType.NONE),

    /**
     * hex = "0x0C800001", type = DataType.INT32
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SYSTEM_REBOOT(hex = "0x0C800001", type = DataType.INT32),

    /**
     * hex = "0x0C000002", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_IS_SYSTEM_REBOOTING(hex = "0x0C000002", type = DataType.NONE),

    /**
     * hex = "0x0C800002", type = DataType.BOOL
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IS_SYSTEM_REBOOTING(hex = "0x0C800002", type = DataType.BOOL),

    /**
     * hex = "0x0C000003", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_RESTART_APPLICATION(hex = "0x0C000003", type = DataType.NONE),

    /**
     * hex = "0x0C800003", type = DataType.BOOL
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    RESTART_APPLICATION(hex = "0x0C800003", type = DataType.BOOL),

    /**
     * hex = "0x0C800011", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SCRIPT_FILE(hex = "0x0C800011", type = DataType.STRING),

    /**
     * hex = "0x0CFFFFFF", type = DataType.CONTAINER
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x0CFFFFFF", type = DataType.CONTAINER),


}
