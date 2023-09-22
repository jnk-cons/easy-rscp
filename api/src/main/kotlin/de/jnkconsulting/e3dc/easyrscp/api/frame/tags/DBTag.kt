package de.jnkconsulting.e3dc.easyrscp.api.frame.tags

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Namespace
import de.jnkconsulting.e3dc.easyrscp.api.frame.Tag

/**
 * Contains tags to query the internal database of the domestic power plant. This can be used to obtain historical data.
 *
 * @param namespace Der Namespace des Tags für die Abbildung des jeweiligen Bereichs
 * @param hex Code of the tag in HexString format (0x0304001)
 * @param type Tag data type [DataType]
 *
 * @since 2.0
 */
enum class DBTag(
    override val namespace: Namespace = Namespace.DB,
    override val hex: String,
    override val type: DataType
) : Tag {

    /**
     * hex = "0x06000100", type = DataType.CONTAINER
     *
     * Request parameter for production and consumption data from the home power plant database for a specific day. Returns a data block of the type [DBTag.HISTORY_DATA_DAY] as response.
     *
     * Each request container must contain the following blocks:
     * - [DBTag.REQ_HISTORY_TIME_START]
     * - [DBTag.REQ_HISTORY_TIME_INTERVAL]
     * - [DBTag.REQ_HISTORY_TIME_SPAN]
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.REQ_HISTORY_DATA_DAY&labels=documentation&body=Documentation+update+for+enum+DBTag.REQ_HISTORY_DATA_DAY:).
     *
     * Original E3DC Documentation:
     *
     * en: Must contain the TAGs DB_REQ_HISTORY_TIME_START, DB_REQ_HISTORY_TIME_INTERVAL, DB_REQ_HISTORY_TIME_SPAN
     *
     * de: Muss die TAGs DB_REQ_HISTORY_TIME_START, DB_REQ_HISTORY_TIME_INTERVAL, DB_REQ_HISTORY_TIME_SPAN enthalten
     *
     */
    REQ_HISTORY_DATA_DAY(hex = "0x06000100", type = DataType.CONTAINER),

    /**
     * hex = "0x06000101", type = DataType.TIMESTAMP
     *
     * Query parameter used within a data container of type [DBTag.REQ_HISTORY_DATA_DAY], [DBTag.REQ_HISTORY_DATA_WEEK], [DBTag.REQ_HISTORY_DATA_MONTH] or [DBTag.REQ_HISTORY_DATA_YEAR] to control the start time of the data query.
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.REQ_HISTORY_TIME_START&labels=documentation&body=Documentation+update+for+enum+DBTag.REQ_HISTORY_TIME_START:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_HISTORY_TIME_START(hex = "0x06000101", type = DataType.TIMESTAMP),

    /**
     * hex = "0x06000102", type = DataType.TIMESTAMP
     *
     * Query parameter used within a data container of type [DBTag.REQ_HISTORY_DATA_DAY], [DBTag.REQ_HISTORY_DATA_WEEK], [DBTag.REQ_HISTORY_DATA_MONTH] or [DBTag.REQ_HISTORY_DATA_YEAR] to determine the distances of the individual data points.
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.REQ_HISTORY_TIME_INTERVAL&labels=documentation&body=Documentation+update+for+enum+DBTag.REQ_HISTORY_TIME_INTERVAL:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_HISTORY_TIME_INTERVAL(hex = "0x06000102", type = DataType.TIMESTAMP),

    /**
     * hex = "0x06000103", type = DataType.TIMESTAMP
     *
     * Query parameter used within a data container of type [DBTag.REQ_HISTORY_DATA_DAY], [DBTag.REQ_HISTORY_DATA_WEEK], [DBTag.REQ_HISTORY_DATA_MONTH] or [DBTag.REQ_HISTORY_DATA_YEAR] to determine the end time of the request.
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.REQ_HISTORY_TIME_SPAN&labels=documentation&body=Documentation+update+for+enum+DBTag.REQ_HISTORY_TIME_SPAN:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_HISTORY_TIME_SPAN(hex = "0x06000103", type = DataType.TIMESTAMP),

    /**
     * hex = "0x06000200", type = DataType.CONTAINER
     *
     * Request parameter for production and consumption data from the home power plant database for a specific month. Returns a data block of the type [DBTag.HISTORY_DATA_WEEK] as response.
     *
     * Each request container must contain the following blocks:
     * - [DBTag.REQ_HISTORY_TIME_START]
     * - [DBTag.REQ_HISTORY_TIME_INTERVAL]
     * - [DBTag.REQ_HISTORY_TIME_SPAN]
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.REQ_HISTORY_DATA_WEEK&labels=documentation&body=Documentation+update+for+enum+DBTag.REQ_HISTORY_DATA_WEEK:).
     *
     * Original E3DC Documentation:
     *
     * en: Must contain the TAGs DB_REQ_HISTORY_TIME_START, DB_REQ_HISTORY_TIME_INTERVAL, DB_REQ_HISTORY_TIME_SPAN
     *
     * de: Muss die TAGs DB_REQ_HISTORY_TIME_START, DB_REQ_HISTORY_TIME_INTERVAL, DB_REQ_HISTORY_TIME_SPAN enthalten
     *
     */
    REQ_HISTORY_DATA_WEEK(hex = "0x06000200", type = DataType.CONTAINER),

    /**
     * hex = "0x06000300", type = DataType.CONTAINER
     *
     * Request parameter for production and consumption data from the home power plant database for a specific month. Returns a data block of the type [DBTag.HISTORY_DATA_MONTH] as response.
     *
     * Each request container must contain the following blocks:
     * - [DBTag.REQ_HISTORY_TIME_START]
     * - [DBTag.REQ_HISTORY_TIME_INTERVAL]
     * - [DBTag.REQ_HISTORY_TIME_SPAN]
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.REQ_HISTORY_DATA_MONTH&labels=documentation&body=Documentation+update+for+enum+DBTag.REQ_HISTORY_DATA_MONTH:).
     *
     * Original E3DC Documentation:
     *
     * en: Must contain the TAGs DB_REQ_HISTORY_TIME_START, DB_REQ_HISTORY_TIME_INTERVAL, DB_REQ_HISTORY_TIME_SPAN
     *
     * de: Muss die TAGs DB_REQ_HISTORY_TIME_START, DB_REQ_HISTORY_TIME_INTERVAL, DB_REQ_HISTORY_TIME_SPAN enthalten
     *
     */
    REQ_HISTORY_DATA_MONTH(hex = "0x06000300", type = DataType.CONTAINER),

    /**
     * hex = "0x06000400", type = DataType.CONTAINER
     *
     * Request parameter for production and consumption data from the home power plant database for a specific year. Returns a data block of the type [DBTag.HISTORY_DATA_YEAR] as response.
     *
     * Each request container must contain the following blocks:
     * - [DBTag.REQ_HISTORY_TIME_START]
     * - [DBTag.REQ_HISTORY_TIME_INTERVAL]
     * - [DBTag.REQ_HISTORY_TIME_SPAN]
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.REQ_HISTORY_DATA_YEAR&labels=documentation&body=Documentation+update+for+enum+DBTag.REQ_HISTORY_DATA_YEAR:).
     *
     * Original E3DC Documentation:
     *
     * en: Must contain the TAGs DB_REQ_HISTORY_TIME_START, DB_REQ_HISTORY_TIME_INTERVAL, DB_REQ_HISTORY_TIME_SPAN
     *
     * de: Muss die TAGs DB_REQ_HISTORY_TIME_START, DB_REQ_HISTORY_TIME_INTERVAL, DB_REQ_HISTORY_TIME_SPAN enthalten
     *
     */
    REQ_HISTORY_DATA_YEAR(hex = "0x06000400", type = DataType.CONTAINER),

    /**
     * hex = "0x06800010", type = DataType.CONTAINER
     *
     * Container within a [DBTag.HISTORY_DATA_DAY], [DBTag.HISTORY_DATA_WEEK], [DBTag.HISTORY_DATA_MONTH] or [DBTag.HISTORY_DATA_YEAR] response.
     *
     * The cotainer contains Miscellaneous data blocks that contain the summed data over the entire requested time period. The following blocks can be included
     * - [DBTag.GRAPH_INDEX] - Always valu -1
     * - [DBTag.BAT_POWER_IN]
     * - [DBTag.BAT_POWER_OUT]
     * - [DBTag.DC_POWER]
     * - [DBTag.GRID_POWER_IN]
     * - [DBTag.GRID_POWER_OUT]
     * - [DBTag.CONSUMPTION]
     * - [DBTag.PM_0_POWER]
     * - [DBTag.PM_1_POWER]
     * - [DBTag.BAT_CHARGE_LEVEL]
     * - [DBTag.BAT_CYCLE_COUNT]
     * - [DBTag.CONSUMED_PRODUCTION]
     * - [DBTag.AUTARKY]
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.SUM_CONTAINER&labels=documentation&body=Documentation+update+for+enum+DBTag.SUM_CONTAINER:).
     *
     * Original E3DC Documentation:
     *
     * en: The sum between the energies over the period
     *
     * de: Die Summe zwischen der Energien über den Zeitraum
     *
     */
    SUM_CONTAINER(hex = "0x06800010", type = DataType.CONTAINER),

    /**
     * hex = "0x06800020", type = DataType.CONTAINER
     *
     * Container within a [DBTag.HISTORY_DATA_DAY], [DBTag.HISTORY_DATA_WEEK], [DBTag.HISTORY_DATA_MONTH] or [DBTag.HISTORY_DATA_YEAR] response.
     *
     * The container contains various data blocks that specify the value at the respective time within the queried time span. The time is determined by means of [DBTag.GRAPH_INDEX].
     * - [DBTag.GRAPH_INDEX] - Percentage value to determine the time span on the query span timeline
     * - [DBTag.BAT_POWER_IN]
     * - [DBTag.BAT_POWER_OUT]
     * - [DBTag.DC_POWER]
     * - [DBTag.GRID_POWER_IN]
     * - [DBTag.GRID_POWER_OUT]
     * - [DBTag.CONSUMPTION]
     * - [DBTag.PM_0_POWER]
     * - [DBTag.PM_1_POWER]
     * - [DBTag.BAT_CHARGE_LEVEL]
     * - [DBTag.BAT_CYCLE_COUNT]
     * - [DBTag.CONSUMED_PRODUCTION]
     * - [DBTag.AUTARKY]
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.VALUE_CONTAINER&labels=documentation&body=Documentation+update+for+enum+DBTag.VALUE_CONTAINER:).
     *
     * Original E3DC Documentation:
     *
     * en: Usually more than one of these containers in a HISTORY_DATA container
     *
     * de: Meist mehr als einer von diesen Containern in einem HISTORY_DATA Container
     *
     */
    VALUE_CONTAINER(hex = "0x06800020", type = DataType.CONTAINER),

    /**
     * hex = "0x06800001", type = DataType.FLOAT32
     *
     * Response parameter that occurs within a data block of the type [DBTag.SUM_CONTAINER] or [DBTag.VALUE_CONTAINER].
     *
     * The value is always -1 if the parameter occurs within a [DBTag.SUM_CONTAINER].
     *
     * Within a [DBTag.VALUE_CONTAINER], it is a percentage value from 0 - 1. If you imagine a graph that starts at
     * time point [DBTag.REQ_HISTORY_TIME_START] and ends at time point [DBTag.REQ_HISTORY_TIME_START] + [DBTag.REQ_HISTORY_TIME_SPAN],
     * the percentage value indicates the data point on the time axis.
     *
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.GRAPH_INDEX&labels=documentation&body=Documentation+update+for+enum+DBTag.GRAPH_INDEX:).
     *
     * Original E3DC Documentation:
     *
     * en: Diagram position in percent
     *
     * de: Diagrammposition in Prozent
     *
     */
    GRAPH_INDEX(hex = "0x06800001", type = DataType.FLOAT32),

    /**
     * hex = "0x06800002", type = DataType.FLOAT32
     *
     * Response parameter that occurs within a data block of the type [DBTag.SUM_CONTAINER] or [DBTag.VALUE_CONTAINER].
     *
     * Indicates the total amount of energy in Wh that has been charged into the battery.
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.BAT_POWER_IN&labels=documentation&body=Documentation+update+for+enum+DBTag.BAT_POWER_IN:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    BAT_POWER_IN(hex = "0x06800002", type = DataType.FLOAT32),

    /**
     * hex = "0x06800003", type = DataType.FLOAT32
     *
     * Response parameter that occurs within a data block of the type [DBTag.SUM_CONTAINER] or [DBTag.VALUE_CONTAINER].
     *
     * Indicates the total amount of energy in Wh that has received from the battery
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.BAT_POWER_OUT&labels=documentation&body=Documentation+update+for+enum+DBTag.BAT_POWER_OUT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    BAT_POWER_OUT(hex = "0x06800003", type = DataType.FLOAT32),

    /**
     * hex = "0x06800004", type = DataType.FLOAT32
     *
     * Response parameter that occurs within a data block of the type [DBTag.SUM_CONTAINER] or [DBTag.VALUE_CONTAINER].
     *
     * Indicates the amount of solar energy produced in Wh.
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.DC_POWER&labels=documentation&body=Documentation+update+for+enum+DBTag.DC_POWER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DC_POWER(hex = "0x06800004", type = DataType.FLOAT32),

    /**
     * hex = "0x06800005", type = DataType.FLOAT32
     *
     * Response parameter that occurs within a data block of the type [DBTag.SUM_CONTAINER] or [DBTag.VALUE_CONTAINER].
     *
     * Indicates the amount of energy fed into the grid. The unit is Wh.
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.GRID_POWER_IN&labels=documentation&body=Documentation+update+for+enum+DBTag.GRID_POWER_IN:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GRID_POWER_IN(hex = "0x06800005", type = DataType.FLOAT32),

    /**
     * hex = "0x06800006", type = DataType.FLOAT32
     *
     * Response parameter that occurs within a data block of the type [DBTag.SUM_CONTAINER] or [DBTag.VALUE_CONTAINER].
     *
     * Indicates the energy drawn from the grid in Wh.
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.GRID_POWER_OUT&labels=documentation&body=Documentation+update+for+enum+DBTag.GRID_POWER_OUT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GRID_POWER_OUT(hex = "0x06800006", type = DataType.FLOAT32),

    /**
     * hex = "0x06800007", type = DataType.FLOAT32
     *
     * Response parameter that occurs within a data block of the type [DBTag.SUM_CONTAINER] or [DBTag.VALUE_CONTAINER].
     *
     * Indicates the consumed energy in Wh.
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.CONSUMPTION&labels=documentation&body=Documentation+update+for+enum+DBTag.CONSUMPTION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    CONSUMPTION(hex = "0x06800007", type = DataType.FLOAT32),

    /**
     * hex = "0x06800008", type = DataType.FLOAT32
     *
     * Response parameter that occurs within a data block of the type [DBTag.SUM_CONTAINER] or [DBTag.VALUE_CONTAINER].
     *
     * Unclear, alsways 0 on my system
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.PM_0_POWER&labels=documentation&body=Documentation+update+for+enum+DBTag.PM_0_POWER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PM_0_POWER(hex = "0x06800008", type = DataType.FLOAT32),

    /**
     * hex = "0x06800009", type = DataType.FLOAT32
     *
     * Response parameter that occurs within a data block of the type [DBTag.SUM_CONTAINER] or [DBTag.VALUE_CONTAINER].
     *
     * Unclear, alsways 0 on my system
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.PM_1_POWER&labels=documentation&body=Documentation+update+for+enum+DBTag.PM_1_POWER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PM_1_POWER(hex = "0x06800009", type = DataType.FLOAT32),

    /**
     * hex = "0x0680000A", type = DataType.FLOAT32
     *
     * Response parameter that occurs within a data block of the type [DBTag.SUM_CONTAINER] or [DBTag.VALUE_CONTAINER].
     *
     * Battery level in percent (0 - 100). It is unclear what the number means, since the query asks for a time period. Average charge level? Charge level at the end?
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.BAT_CHARGE_LEVEL&labels=documentation&body=Documentation+update+for+enum+DBTag.BAT_CHARGE_LEVEL:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    BAT_CHARGE_LEVEL(hex = "0x0680000A", type = DataType.FLOAT32),

    /**
     * hex = "0x0680000B", type = DataType.FLOAT32
     *
     * Response parameter that occurs within a data block of the type [DBTag.SUM_CONTAINER] or [DBTag.VALUE_CONTAINER].
     *
     * Indicates the number of charging cycles of the battery. CAUTION! It depends on the installed battery type if the value is correct.
     * It is known that some (all?) Samsung batteries do not count cycles. In this case the parameter is always 0
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.BAT_CYCLE_COUNT&labels=documentation&body=Documentation+update+for+enum+DBTag.BAT_CYCLE_COUNT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    BAT_CYCLE_COUNT(hex = "0x0680000B", type = DataType.FLOAT32),

    /**
     * hex = "0x0680000C", type = DataType.FLOAT32
     *
     * Response parameter that occurs within a data block of the type [DBTag.SUM_CONTAINER] or [DBTag.VALUE_CONTAINER].
     *
     * Percentage value (0-100), how much of the produced electricity was used in the time frame itself.
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.CONSUMED_PRODUCTION&labels=documentation&body=Documentation+update+for+enum+DBTag.CONSUMED_PRODUCTION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    CONSUMED_PRODUCTION(hex = "0x0680000C", type = DataType.FLOAT32),

    /**
     * hex = "0x0680000D", type = DataType.FLOAT32
     *
     * Response parameter that occurs within a data block of the type [DBTag.SUM_CONTAINER] or [DBTag.VALUE_CONTAINER].
     *
     * Percentage value (0-100), How high the independence from grid supply was in the queried period.
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.AUTARKY&labels=documentation&body=Documentation+update+for+enum+DBTag.AUTARKY:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    AUTARKY(hex = "0x0680000D", type = DataType.FLOAT32),

    /**
     * hex = "0x06800100", type = DataType.CONTAINER
     *
     * Response container to a [DBTag.REQ_HISTORY_DATA_DAY] request.
     *
     * Contains one container of type [DBTag.SUM_CONTAINER] and 1-n containers of type [DBTag.VALUE_CONTAINER].
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.HISTORY_DATA_DAY&labels=documentation&body=Documentation+update+for+enum+DBTag.HISTORY_DATA_DAY:).
     *
     * Original E3DC Documentation:
     *
     * en: Contains the containers DB_SUM_CONTAINER, VALUE_CONTAINER
     *
     * de: Beinhaltet die Container DB_SUM_CONTAINER, VALUE_CONTAINER
     *
     */
    HISTORY_DATA_DAY(hex = "0x06800100", type = DataType.CONTAINER),

    /**
     * hex = "0x06800200", type = DataType.CONTAINER
     *
     * Response container to a [DBTag.REQ_HISTORY_DATA_WEEK] request.
     *
     * Contains one container of type [DBTag.SUM_CONTAINER] and 1-n containers of type [DBTag.VALUE_CONTAINER].
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.HISTORY_DATA_WEEK&labels=documentation&body=Documentation+update+for+enum+DBTag.HISTORY_DATA_WEEK:).
     *
     * Original E3DC Documentation:
     *
     * en: Contains the containers DB_SUM_CONTAINER, VALUE_CONTAINER
     *
     * de: Beinhaltet die Container DB_SUM_CONTAINER, VALUE_CONTAINER
     *
     */
    HISTORY_DATA_WEEK(hex = "0x06800200", type = DataType.CONTAINER),

    /**
     * hex = "0x06800300", type = DataType.CONTAINER
     *
     * Response container to a [DBTag.REQ_HISTORY_DATA_MONTH] request.
     *
     * Contains one container of type [DBTag.SUM_CONTAINER] and 1-n containers of type [DBTag.VALUE_CONTAINER].
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.HISTORY_DATA_MONTH&labels=documentation&body=Documentation+update+for+enum+DBTag.HISTORY_DATA_MONTH:).
     *
     * Original E3DC Documentation:
     *
     * en: Contains the containers DB_SUM_CONTAINER, VALUE_CONTAINER
     *
     * de: Beinhaltet die Container DB_SUM_CONTAINER, VALUE_CONTAINER
     *
     */
    HISTORY_DATA_MONTH(hex = "0x06800300", type = DataType.CONTAINER),

    /**
     * hex = "0x06800400", type = DataType.CONTAINER
     *
     * Response container to a [DBTag.REQ_HISTORY_DATA_YEAR] request.
     *
     * Contains one container of type [DBTag.SUM_CONTAINER] and 1-n containers of type [DBTag.VALUE_CONTAINER].
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.HISTORY_DATA_YEAR&labels=documentation&body=Documentation+update+for+enum+DBTag.HISTORY_DATA_YEAR:).
     *
     * Original E3DC Documentation:
     *
     * en: Contains the containers DB_SUM_CONTAINER, VALUE_CONTAINER
     *
     * de: Beinhaltet die Container DB_SUM_CONTAINER, VALUE_CONTAINER
     *
     */
    HISTORY_DATA_YEAR(hex = "0x06800400", type = DataType.CONTAINER),

    /**
     * hex = "0x06B00000", type = DataType.UINT64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.PAR_TIME_MIN&labels=documentation&body=Documentation+update+for+enum+DBTag.PAR_TIME_MIN:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PAR_TIME_MIN(hex = "0x06B00000", type = DataType.UINT64),

    /**
     * hex = "0x06B00001", type = DataType.UINT64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.PAR_TIME_MAX&labels=documentation&body=Documentation+update+for+enum+DBTag.PAR_TIME_MAX:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PAR_TIME_MAX(hex = "0x06B00001", type = DataType.UINT64),

    /**
     * hex = "0x06B00002", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.PARAM_ROW&labels=documentation&body=Documentation+update+for+enum+DBTag.PARAM_ROW:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PARAM_ROW(hex = "0x06B00002", type = DataType.CONTAINER),

    /**
     * hex = "0x06B00003", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.PARAM_COLUMN&labels=documentation&body=Documentation+update+for+enum+DBTag.PARAM_COLUMN:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PARAM_COLUMN(hex = "0x06B00003", type = DataType.CONTAINER),

    /**
     * hex = "0x06B00004", type = DataType.UINT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.PARAM_INDEX&labels=documentation&body=Documentation+update+for+enum+DBTag.PARAM_INDEX:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PARAM_INDEX(hex = "0x06B00004", type = DataType.UINT32),

    /**
     * hex = "0x06B00005", type = DataType.STRING
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.PARAM_VALUE&labels=documentation&body=Documentation+update+for+enum+DBTag.PARAM_VALUE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PARAM_VALUE(hex = "0x06B00005", type = DataType.STRING),

    /**
     * hex = "0x06B00006", type = DataType.UINT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.PARAM_MAX_ROWS&labels=documentation&body=Documentation+update+for+enum+DBTag.PARAM_MAX_ROWS:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PARAM_MAX_ROWS(hex = "0x06B00006", type = DataType.UINT32),

    /**
     * hex = "0x06B00007", type = DataType.UINT64
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.PARAM_TIME&labels=documentation&body=Documentation+update+for+enum+DBTag.PARAM_TIME:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PARAM_TIME(hex = "0x06B00007", type = DataType.UINT64),

    /**
     * hex = "0x06B00008", type = DataType.STRING
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.PARAM_VERSION&labels=documentation&body=Documentation+update+for+enum+DBTag.PARAM_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PARAM_VERSION(hex = "0x06B00008", type = DataType.STRING),

    /**
     * hex = "0x06B00009", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+DBTag.PARAM_HEADER&labels=documentation&body=Documentation+update+for+enum+DBTag.PARAM_HEADER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PARAM_HEADER(hex = "0x06B00009", type = DataType.CONTAINER),

}