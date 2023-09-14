package de.jnkconsulting.e3dc.easyrscp.api.frame.tags

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Namespace
import de.jnkconsulting.e3dc.easyrscp.api.frame.Tag

/**
 * Contains tags for the home automation sector
 *
 * @param namespace Der Namespace des Tags für die Abbildung des jeweiligen Bereichs
 * @param hex Code of the tag in HexString format (0x0304001)
 * @param type Tag data type [DataType]
 *
 * @since 2.0
 */
enum class HATag(
    override val namespace: Namespace = Namespace.HA,
    override val hex: String,
    override val type: DataType
) : Tag {
    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DATAPOINT_LIST(hex = "0x09000001", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_ACTUATOR_STATES(hex = "0x09000010", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en: Contains DATAPOINT_INDEX, DATAPOINT_TYPE, DATAPOINT_NAME, DATAPOINT_NAME, DATAPOINT_DESCRIPTIONS, DATAPOINT_DESCRIPTION_VALUE, DATAPOINT_DESCRIPTION_VALUE
     *
     * de: Beinhaltet DATAPOINT_INDEX, DATAPOINT_TYPE, DATAPOINT_NAME, DATAPOINT_NAME, DATAPOINT_DESCRIPTIONS, DATAPOINT_DESCRIPTION_VALUE, DATAPOINT_DESCRIPTION_VALUE
     *
     */
    REQ_ADD_ACTUATOR(hex = "0x09000020", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_REMOVE_ACTUATOR(hex = "0x09000030", type = DataType.UINT16),

    /**
     * Original E3DC Documentation:
     *
     * en: Contains DATAPOINT_INDEX, DATAPOINT_DESCRIPTIONS
     *
     * de: Beinhaltet DATAPOINT_INDEX, REQ_COMMAND
     *
     */
    REQ_COMMAND_ACTUATOR(hex = "0x09000040", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_COMMAND(hex = "0x09000041", type = DataType.STRING),

    /**
     * Original E3DC Documentation:
     *
     * en: Contains DATAPOINT_INDEX, DATAPOINT_DESCRIPTIONS
     *
     * de: Beinhaltet DATAPOINT_INDEX, DATAPOINT_DESCRIPTIONS
     *
     */
    REQ_DESCRIPTIONS_CHANGE(hex = "0x09000050", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_CONFIGURATION_CHANGE_COUNTER(hex = "0x09000060", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    CONFIGURATION_CHANGE_COUNTER(hex = "0x09800060", type = DataType.UINT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DATAPOINT_LIST(hex = "0x09800001", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en: Contains DATAPOINT_INDEX, DATAPOINT_TYPE, DATAPOINT_NAME, DATAPOINT_DESCRIPTIONS
     *
     * de: Beinhaltet DATAPOINT_INDEX, DATAPOINT_TYPE, DATAPOINT_NAME, DATAPOINT_DESCRIPTIONS
     *
     */
    DATAPOINT(hex = "0x09800002", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DATAPOINT_INDEX(hex = "0x09800003", type = DataType.UINT16),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DATAPOINT_TYPE(hex = "0x09800004", type = DataType.UINT32),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DATAPOINT_NAME(hex = "0x09800005", type = DataType.STRING),

    /**
     * Original E3DC Documentation:
     *
     * en: '1' - ON / '2' - OFF / '?' - Unknown / 'G' - Group
     *
     * de: '1' - ON / '2' - OFF / '?' - Unknown / 'G' - Group
     *
     */
    DATAPOINT_STATE(hex = "0x09800011", type = DataType.CHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en: Timestamp of the last state message
     *
     * de: Zeitstempel der letzten Statenachricht
     *
     */
    DATAPOINT_STATE_TIMESTAMP(hex = "0x09800013", type = DataType.UINT64),

    /**
     * Original E3DC Documentation:
     *
     * en: Different meanings depending on DATAPOINTTYPE (e.g.:dimmer percentages )
     *
     * de: Verschiedene Bedeutungen je nach DATAPOINTTYPE (z.B:Dimmer Prozente )
     *
     */
    DATAPOINT_STATE_VALUE(hex = "0x09800014", type = DataType.CHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     * 0x00|0xFF = Not Available, no information
     * 0x01 = Empty
     * 0x02 = Change it
     * 0x03 = Medium
     * 0x04 = Good
     * 0x05 = New
     * 0x10 = mains-powered
     *
     *
     *
     * de:
     * 0x00|0xFF = Nicht verfügbar, keine Informationen
     * 0x01 = Leer
     * 0x02 = Ändern Sie es
     * 0x03 = Mittel
     * 0x04 = Gut
     * 0x05 = Neu
     * 0x10 = netzgespeist
     */
    DATAPOINT_SUPPLY_QUALITY(hex = "0x09800015", type = DataType.CHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en:
     * 0xFF = Not available, no information
     * 0x00 - 0x64 = value in percent
     *
     *
     *
     * de:
     * 0xFF = Nicht verfügbar, keine Information
     * 0x00 - 0x64 = Wert in Prozent
     */
    DATAPOINT_SIGNAL_QUALITY(hex = "0x09800016", type = DataType.CHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en: 'A' - Automatic / 'M' - Manual
     *
     *
     * de: 'A' - Automatik / 'M' - Manuell
     */
    DATAPOINT_MODE(hex = "0x09800012", type = DataType.CHAR8),

    /**
     * Original E3DC Documentation:
     *
     * en: Contains multiple TAG_HA_DATAPOINT_DESCRIPTION
     *
     * de: Beinhaltet mehrere TAG_HA_DATAPOINT_DESCRIPTION
     *
     */
    DATAPOINT_DESCRIPTIONS(hex = "0x09800006", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DATAPOINT_DESCRIPTION(hex = "0x09800007", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DATAPOINT_DESCRIPTION_NAME(hex = "0x09800008", type = DataType.STRING),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DATAPOINT_DESCRIPTION_VALUE(hex = "0x09800009", type = DataType.INT32),

    /**
     * Original E3DC Documentation:
     *
     * en: Contains a list of DATAPOINT containers
     *
     * de: Beinhaltet eine Liste mit DATAPOINT Container
     *
     */
    ACTUATOR_STATES(hex = "0x09800010", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    ADD_ACTUATOR(hex = "0x09800020", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REMOVE_ACTUATOR(hex = "0x09800030", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    COMMAND_ACTUATOR(hex = "0x09800040", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DESCRIPTIONS_CHANGE(hex = "0x09800050", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DEVICE_STATE(hex = "0x09060000", type = DataType.NONE),

    /**
     * Original E3DC Documentation:
     *
     * en: DEVICE_CONNECTED & DEVICE_WORKING & DEVICE_IN_SERVICE
     *
     *
     * de: DEVICE_CONNECTED & DEVICE_WORKING & DEVICE_IN_SERVICE
     *
     */
    DEVICE_STATE(hex = "0x09860000", type = DataType.CONTAINER),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DEVICE_CONNECTED(hex = "0x09860001", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DEVICE_WORKING(hex = "0x09860002", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DEVICE_IN_SERVICE(hex = "0x09860003", type = DataType.BOOL),

    /**
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x09FFFFFF", type = DataType.ERROR),


}
