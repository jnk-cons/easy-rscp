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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.REQ_IS_READY_FOR_SWITCH&labels=documentation&body=Documentation+update+for+enum+EPTag.REQ_IS_READY_FOR_SWITCH:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.REQ_IS_GRID_CONNECTED&labels=documentation&body=Documentation+update+for+enum+EPTag.REQ_IS_GRID_CONNECTED:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.REQ_IS_ISLAND_GRID&labels=documentation&body=Documentation+update+for+enum+EPTag.REQ_IS_ISLAND_GRID:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.REQ_IS_INVALID_STATE&labels=documentation&body=Documentation+update+for+enum+EPTag.REQ_IS_INVALID_STATE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.REQ_IS_POSSIBLE&labels=documentation&body=Documentation+update+for+enum+EPTag.REQ_IS_POSSIBLE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.IS_READY_FOR_SWITCH&labels=documentation&body=Documentation+update+for+enum+EPTag.IS_READY_FOR_SWITCH:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.IS_GRID_CONNECTED&labels=documentation&body=Documentation+update+for+enum+EPTag.IS_GRID_CONNECTED:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.IS_ISLAND_GRID&labels=documentation&body=Documentation+update+for+enum+EPTag.IS_ISLAND_GRID:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.IS_INVALID_STATE&labels=documentation&body=Documentation+update+for+enum+EPTag.IS_INVALID_STATE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.IS_POSSIBLE&labels=documentation&body=Documentation+update+for+enum+EPTag.IS_POSSIBLE:).
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
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.GENERAL_ERROR&labels=documentation&body=Documentation+update+for+enum+EPTag.GENERAL_ERROR:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x0BFFFFFF", type = DataType.CONTAINER),


    /**
     * hex = "0x0B000001", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.REQ_SWITCH_TO_GRID&labels=documentation&body=Documentation+update+for+enum+EPTag.REQ_SWITCH_TO_GRID:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SWITCH_TO_GRID(hex = "0x0B000001", type = DataType.NONE),

    /**
     * hex = "0x0B000002", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.REQ_SWITCH_TO_ISLAND&labels=documentation&body=Documentation+update+for+enum+EPTag.REQ_SWITCH_TO_ISLAND:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SWITCH_TO_ISLAND(hex = "0x0B000002", type = DataType.NONE),

    /**
     * hex = "0x0B000008", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.REQ_LEAVE_INVALID_STATE_TO_ISLAND&labels=documentation&body=Documentation+update+for+enum+EPTag.REQ_LEAVE_INVALID_STATE_TO_ISLAND:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_LEAVE_INVALID_STATE_TO_ISLAND(hex = "0x0B000008", type = DataType.NONE),

    /**
     * hex = "0x0B000009", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.REQ_LEAVE_INVALID_STATE_TO_GRID&labels=documentation&body=Documentation+update+for+enum+EPTag.REQ_LEAVE_INVALID_STATE_TO_GRID:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_LEAVE_INVALID_STATE_TO_GRID(hex = "0x0B000009", type = DataType.NONE),

    /**
     * hex = "0x0B800001", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.SWITCH_TO_GRID&labels=documentation&body=Documentation+update+for+enum+EPTag.SWITCH_TO_GRID:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SWITCH_TO_GRID(hex = "0x0B800001", type = DataType.NONE),

    /**
     * hex = "0x0B000009", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.SWITCH_TO_ISLAND&labels=documentation&body=Documentation+update+for+enum+EPTag.SWITCH_TO_ISLAND:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SWITCH_TO_ISLAND(hex = "0x0B000009", type = DataType.NONE),

    /**
     * hex = "0x0B800008", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.LEAVE_INVALID_STATE_TO_ISLAND&labels=documentation&body=Documentation+update+for+enum+EPTag.LEAVE_INVALID_STATE_TO_ISLAND:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    LEAVE_INVALID_STATE_TO_ISLAND(hex = "0x0B800008", type = DataType.NONE),

    /**
     * hex = "0x0B800009", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.LEAVE_INVALID_STATE_TO_GRID&labels=documentation&body=Documentation+update+for+enum+EPTag.LEAVE_INVALID_STATE_TO_GRID:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    LEAVE_INVALID_STATE_TO_GRID(hex = "0x0B800009", type = DataType.NONE),

    /**
     * hex = "0x1B000009", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.REQ_EP_RESERVE&labels=documentation&body=Documentation+update+for+enum+EPTag.REQ_EP_RESERVE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_EP_RESERVE(hex = "0x1B000009", type = DataType.NONE),

    /**
     * hex = "0x1B040000", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.PARAM_INDEX&labels=documentation&body=Documentation+update+for+enum+EPTag.PARAM_INDEX:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PARAM_INDEX(hex = "0x1B040000", type = DataType.UCHAR8),

    /**
     * hex = "0x1B040011", type = DataType.NONE
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.PARAM_INT&labels=documentation&body=Documentation+update+for+enum+EPTag.PARAM_INT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PARAM_INT(hex = "0x1B040011", type = DataType.UCHAR8),

    /**
     * hex = "0x1B040023", type = DataType.FLOAT32
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.PARAM_EP_RESERVE&labels=documentation&body=Documentation+update+for+enum+EPTag.PARAM_EP_RESERVE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PARAM_EP_RESERVE(hex = "0x1B040023", type = DataType.FLOAT32),

    /**
     * hex = "0x1B040024", type = DataType.FLOAT32
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.PARAM_TIME_LAST_FULL&labels=documentation&body=Documentation+update+for+enum+EPTag.PARAM_TIME_LAST_FULL:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PARAM_TIME_LAST_FULL(hex = "0x1B040024", type = DataType.UINT64),

    /**
     * hex = "0x1B040025", type = DataType.FLOAT32
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.PARAM_TIME_LAST_EMPTY&labels=documentation&body=Documentation+update+for+enum+EPTag.PARAM_TIME_LAST_EMPTY:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PARAM_TIME_LAST_EMPTY(hex = "0x1B040025", type = DataType.UINT64),

    /**
     * hex = "0x1B040026", type = DataType.FLOAT32
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.PARAM_LAST_SOC&labels=documentation&body=Documentation+update+for+enum+EPTag.PARAM_LAST_SOC:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PARAM_LAST_SOC(hex = "0x1B040026", type = DataType.FLOAT32),

    /**
     * hex = "0x1B040033", type = DataType.FLOAT32
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.PARAM_EP_RESERVE_ENERGY&labels=documentation&body=Documentation+update+for+enum+EPTag.PARAM_EP_RESERVE_ENERGY:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PARAM_EP_RESERVE_ENERGY(hex = "0x1B040033", type = DataType.FLOAT32),

    /**
     * hex = "0x1B040034", type = DataType.FLOAT32
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.PARAM_EP_RESERVE_MAX_ENERGY&labels=documentation&body=Documentation+update+for+enum+EPTag.PARAM_EP_RESERVE_MAX_ENERGY:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PARAM_EP_RESERVE_MAX_ENERGY(hex = "0x1B040034", type = DataType.FLOAT32),

    /**
     * hex = "0x1B800009", type = DataType.CONTAINER
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.EP_RESERVE&labels=documentation&body=Documentation+update+for+enum+EPTag.EP_RESERVE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    EP_RESERVE(hex = "0x1B800009", type = DataType.CONTAINER),


    /**
     * hex = "0x1B000010", type = DataType.CONTAINER
     *
     * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title=Documentation+improvement+for+EPTag.REQ_SET_EP_RESERVE&labels=documentation&body=Documentation+update+for+enum+EPTag.REQ_SET_EP_RESERVE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_EP_RESERVE(hex = "0x1B000010", type = DataType.CONTAINER),

}
