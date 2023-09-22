package de.jnkconsulting.e3dc.easyrscp.api.frame.tags

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Namespace
import de.jnkconsulting.e3dc.easyrscp.api.frame.Tag

/**
 * Defines tags that affect the server of the home power plant. Currently only status queries and user management
 *
 * @param namespace Der Namespace des Tags für die Abbildung des jeweiligen Bereichs
 * @param hex Code of the tag in HexString format (0x0304001)
 * @param type Tag data type [DataType]
 *
 * @since 2.0
 */
enum class SRVTag(
    override val namespace: Namespace = Namespace.SRV,
    override val hex: String,
    override val type: DataType
) : Tag {

    /**
     * hex = "0x08000001", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+SRVTag.REQ_IS_ONLINE&labels=documentation&body=Documentation+update+for+enum+SRVTag.REQ_IS_ONLINE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_IS_ONLINE(hex = "0x08000001", type = DataType.NONE),

    /**
     * hex = "0x08800001", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+SRVTag.IS_ONLINE&labels=documentation&body=Documentation+update+for+enum+SRVTag.IS_ONLINE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IS_ONLINE(hex = "0x08800001", type = DataType.BOOL),

    /**
     * hex = "0x08000002", type = DataType.STRING
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+SRVTag.REQ_ADD_USER&labels=documentation&body=Documentation+update+for+enum+SRVTag.REQ_ADD_USER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_ADD_USER(hex = "0x08000002", type = DataType.STRING),

    /**
     * hex = "0x08800002", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+SRVTag.ADD_USER&labels=documentation&body=Documentation+update+for+enum+SRVTag.ADD_USER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    ADD_USER(hex = "0x08800002", type = DataType.BOOL),

    /**
     * hex = "0x08FFFFFF", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+SRVTag.GENERAL_ERROR&labels=documentation&body=Documentation+update+for+enum+SRVTag.GENERAL_ERROR:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x08FFFFFF", type = DataType.CONTAINER),


}