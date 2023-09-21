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
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x08FFFFFF", type = DataType.CONTAINER),


}
