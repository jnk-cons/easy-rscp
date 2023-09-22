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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+SYSTag.REQ_SYSTEM_REBOOT&labels=documentation&body=Documentation+update+for+enum+SYSTag.REQ_SYSTEM_REBOOT:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+SYSTag.SYSTEM_REBOOT&labels=documentation&body=Documentation+update+for+enum+SYSTag.SYSTEM_REBOOT:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+SYSTag.REQ_IS_SYSTEM_REBOOTING&labels=documentation&body=Documentation+update+for+enum+SYSTag.REQ_IS_SYSTEM_REBOOTING:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+SYSTag.IS_SYSTEM_REBOOTING&labels=documentation&body=Documentation+update+for+enum+SYSTag.IS_SYSTEM_REBOOTING:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+SYSTag.REQ_RESTART_APPLICATION&labels=documentation&body=Documentation+update+for+enum+SYSTag.REQ_RESTART_APPLICATION:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+SYSTag.RESTART_APPLICATION&labels=documentation&body=Documentation+update+for+enum+SYSTag.RESTART_APPLICATION:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+SYSTag.SCRIPT_FILE&labels=documentation&body=Documentation+update+for+enum+SYSTag.SCRIPT_FILE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+SYSTag.GENERAL_ERROR&labels=documentation&body=Documentation+update+for+enum+SYSTag.GENERAL_ERROR:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x0CFFFFFF", type = DataType.CONTAINER),


}