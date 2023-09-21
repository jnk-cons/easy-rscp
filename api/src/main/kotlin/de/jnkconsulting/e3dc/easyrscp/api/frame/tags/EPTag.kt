package de.jnkconsulting.e3dc.easyrscp.api.frame.tags

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Namespace
import de.jnkconsulting.e3dc.easyrscp.api.frame.Tag

/**
 * Contains tags to control and query the emergency power mode
 *
 * @param namespace Der Namespace des Tags für die Abbildung des jeweiligen Bereichs
 * @param hex Code of the tag in HexString format (0x0304001)
 * @param type Tag data type [DataType]
 *
 * @since 2.0
 */
enum class EPTag(
    override val namespace: Namespace = Namespace.EP,
    override val hex: String,
    override val type: DataType
) : Tag {

    /**
     * hex = "0x0B000003", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_IS_READY_FOR_SWITCH(hex = "0x0B000003", type = DataType.NONE),

    /**
     * hex = "0x0B000004", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_IS_GRID_CONNECTED(hex = "0x0B000004", type = DataType.NONE),

    /**
     * hex = "0x0B000005", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_IS_ISLAND_GRID(hex = "0x0B000005", type = DataType.NONE),

    /**
     * hex = "0x0B000006", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_IS_INVALID_STATE(hex = "0x0B000006", type = DataType.NONE),

    /**
     * hex = "0x0B000007", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_IS_POSSIBLE(hex = "0x0B000007", type = DataType.NONE),

    /**
     * hex = "0x0B800003", type = DataType.BOOL
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IS_READY_FOR_SWITCH(hex = "0x0B800003", type = DataType.BOOL),

    /**
     * hex = "0x0B800004", type = DataType.BOOL
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IS_GRID_CONNECTED(hex = "0x0B800004", type = DataType.BOOL),

    /**
     * hex = "0x0B800005", type = DataType.BOOL
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IS_ISLAND_GRID(hex = "0x0B800005", type = DataType.BOOL),

    /**
     * hex = "0x0B800006", type = DataType.BOOL
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IS_INVALID_STATE(hex = "0x0B800006", type = DataType.BOOL),

    /**
     * hex = "0x0B800007", type = DataType.BOOL
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IS_POSSIBLE(hex = "0x0B800007", type = DataType.BOOL),

    /**
     * hex = "0x0BFFFFFF", type = DataType.CONTAINER
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x0BFFFFFF", type = DataType.CONTAINER),


}
