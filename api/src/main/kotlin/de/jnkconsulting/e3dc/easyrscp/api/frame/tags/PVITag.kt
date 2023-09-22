package de.jnkconsulting.e3dc.easyrscp.api.frame.tags

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Namespace
import de.jnkconsulting.e3dc.easyrscp.api.frame.Tag

/**
 * Contains tags for controlling and reading the photovoltaic inverter
 *
 * @param namespace Der Namespace des Tags für die Abbildung des jeweiligen Bereichs
 * @param hex Code of the tag in HexString format (0x0304001)
 * @param type Tag data type [DataType]
 *
 * @since 2.0
 */
enum class PVITag(
    override val namespace: Namespace = Namespace.PVI,
    override val hex: String,
    override val type: DataType
) : Tag {

    /**
     * hex = "0x02840000", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.DATA&labels=documentation&body=Documentation+update+for+enum+PVITag.DATA:).
     *
     * Original E3DC Documentation:
     *
     * en: TAG_PVI_INDEX & TAG_PVI_... Response with all data of the REQ_DATA request
     *
     * de: TAG_PVI_INDEX & TAG_PVI_... Antwort mit allen Daten der REQ_DATA Anfrage
     *
     */
    DATA(hex = "0x02840000", type = DataType.CONTAINER),

    /**
     * hex = "0x02040000", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_DATA&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_DATA:).
     *
     * Original E3DC Documentation:
     *
     * en: TAG_PVI_INDEX & TAG_PVI_REQ...  Contains all request TAGs, the container MUST contain an index
     *
     * de: TAG_PVI_INDEX & TAG_PVI_REQ...  Beinhaltet alle Anfrage-TAGs, der Container MUSS einen Index enthalten
     *
     */
    REQ_DATA(hex = "0x02040000", type = DataType.CONTAINER),

    /**
     * hex = "0x02040001", type = DataType.UINT16
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.INDEX&labels=documentation&body=Documentation+update+for+enum+PVITag.INDEX:).
     *
     * Original E3DC Documentation:
     *
     * en: Index of the requested device (0?x), Must occur in the request and response to the DATA tag.
     *
     * de: Index des angefragten Gerätes (0?x), Muss in Anfrage und Antwort zum DATA-Tag vorkommen
     *
     */
    INDEX(hex = "0x02040001", type = DataType.UINT16),

    /**
     * hex = "0x02040005", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.VALUE&labels=documentation&body=Documentation+update+for+enum+PVITag.VALUE:).
     *
     * Original E3DC Documentation:
     *
     * en: dataType returns the respective data type!
     *
     * de: dataType gibt den jeweiligen Daten Typ zurück!
     *
     */
    VALUE(hex = "0x02040005", type = DataType.NONE),

    /**
     * hex = "0x02FFFFFF", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.GENERAL_ERROR&labels=documentation&body=Documentation+update+for+enum+PVITag.GENERAL_ERROR:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x02FFFFFF", type = DataType.CONTAINER),

    /**
     * hex = "0x02800001", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.ON_GRID&labels=documentation&body=Documentation+update+for+enum+PVITag.ON_GRID:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    ON_GRID(hex = "0x02800001", type = DataType.BOOL),

    /**
     * hex = "0x02000001", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_ON_GRID&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_ON_GRID:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_ON_GRID(hex = "0x02000001", type = DataType.NONE),

    /**
     * hex = "0x02800002", type = DataType.STRING
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.STATE&labels=documentation&body=Documentation+update+for+enum+PVITag.STATE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    STATE(hex = "0x02800002", type = DataType.STRING),

    /**
     * hex = "0x02000002", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_STATE&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_STATE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_STATE(hex = "0x02000002", type = DataType.NONE),

    /**
     * hex = "0x02800003", type = DataType.STRING
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.LAST_ERROR&labels=documentation&body=Documentation+update+for+enum+PVITag.LAST_ERROR:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    LAST_ERROR(hex = "0x02800003", type = DataType.STRING),

    /**
     * hex = "0x02000003", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_LAST_ERROR&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_LAST_ERROR:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_LAST_ERROR(hex = "0x02000003", type = DataType.NONE),

    /**
     * hex = "0x02800007", type = DataType.STRING
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.FLASH_FILE&labels=documentation&body=Documentation+update+for+enum+PVITag.FLASH_FILE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    FLASH_FILE(hex = "0x02800007", type = DataType.STRING),

    /**
     * hex = "0x02060000", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_DEVICE_STATE&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_DEVICE_STATE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DEVICE_STATE(hex = "0x02060000", type = DataType.NONE),

    /**
     * hex = "0x02860000", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.DEVICE_STATE&labels=documentation&body=Documentation+update+for+enum+PVITag.DEVICE_STATE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: DEVICE_CONNECTED & DEVICE_WORKING & DEVICE_IN_SERVICE
     *
     */
    DEVICE_STATE(hex = "0x02860000", type = DataType.CONTAINER),

    /**
     * hex = "0x02860001", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.DEVICE_CONNECTED&labels=documentation&body=Documentation+update+for+enum+PVITag.DEVICE_CONNECTED:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DEVICE_CONNECTED(hex = "0x02860001", type = DataType.BOOL),

    /**
     * hex = "0x02860002", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.DEVICE_WORKING&labels=documentation&body=Documentation+update+for+enum+PVITag.DEVICE_WORKING:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DEVICE_WORKING(hex = "0x02860002", type = DataType.BOOL),

    /**
     * hex = "0x02860003", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.DEVICE_IN_SERVICE&labels=documentation&body=Documentation+update+for+enum+PVITag.DEVICE_IN_SERVICE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DEVICE_IN_SERVICE(hex = "0x02860003", type = DataType.BOOL),

    /**
     * hex = "0x02000009", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_TYPE&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_TYPE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_TYPE(hex = "0x02000009", type = DataType.NONE),

    /**
     * hex = "0x02800009", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.TYPE&labels=documentation&body=Documentation+update+for+enum+PVITag.TYPE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     *
     * de:
     * 1=SOLU
     * 2=KACO
     * 3=E3DC_E
     *
     */
    TYPE(hex = "0x02800009", type = DataType.UCHAR8),

    /**
     * hex = "0x02800060", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.COS_PHI&labels=documentation&body=Documentation+update+for+enum+PVITag.COS_PHI:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_COS_PHI_VALUE & TAG_PVI_COS_PHI_IS_AKTIV & TAG_PVI_COS_PHI_EXCITED
     *
     */
    COS_PHI(hex = "0x02800060", type = DataType.CONTAINER),

    /**
     * hex = "0x02000060", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_COS_PHI&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_COS_PHI:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_COS_PHI(hex = "0x02000060", type = DataType.NONE),

    /**
     * hex = "0x02000061", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_SET_COS_PHI&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_SET_COS_PHI:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_COS_PHI_VALUE & TAG_PVI_COS_PHI_IS_AKTIV & TAG_PVI_COS_PHI_EXCITED
     *
     */
    REQ_SET_COS_PHI(hex = "0x02000061", type = DataType.CONTAINER),

    /**
     * hex = "0x02000062", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.COS_PHI_VALUE&labels=documentation&body=Documentation+update+for+enum+PVITag.COS_PHI_VALUE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    COS_PHI_VALUE(hex = "0x02000062", type = DataType.FLOAT32),

    /**
     * hex = "0x02000063", type = DataType.BOOL
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.COS_PHI_IS_AKTIV&labels=documentation&body=Documentation+update+for+enum+PVITag.COS_PHI_IS_AKTIV:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    COS_PHI_IS_AKTIV(hex = "0x02000063", type = DataType.BOOL),

    /**
     * hex = "0x02000064", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.COS_PHI_EXCITED&labels=documentation&body=Documentation+update+for+enum+PVITag.COS_PHI_EXCITED:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    COS_PHI_EXCITED(hex = "0x02000064", type = DataType.UCHAR8),

    /**
     * hex = "0x02800070", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.VOLTAGE_MONITORING&labels=documentation&body=Documentation+update+for+enum+PVITag.VOLTAGE_MONITORING:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_VOLTAGE_MONITORING_THRESHOLD_TOP & TAG_PVI_VOLTAGE_MONITORING_THRESHOLD_BOTTOM & TAG_PVI_VOLTAGE_MONITORING_SLOPE_UP & TAG_PVI_VOLTAGE_MONITORING_SLOPE_DOWN
     *
     */
    VOLTAGE_MONITORING(hex = "0x02800070", type = DataType.CONTAINER),

    /**
     * hex = "0x02000070", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_VOLTAGE_MONITORING&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_VOLTAGE_MONITORING:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_VOLTAGE_MONITORING(hex = "0x02000070", type = DataType.NONE),

    /**
     * hex = "0x02000072", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.VOLTAGE_MONITORING_THRESHOLD_TOP&labels=documentation&body=Documentation+update+for+enum+PVITag.VOLTAGE_MONITORING_THRESHOLD_TOP:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    VOLTAGE_MONITORING_THRESHOLD_TOP(hex = "0x02000072", type = DataType.FLOAT32),

    /**
     * hex = "0x02000073", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.VOLTAGE_MONITORING_THRESHOLD_BOTTOM&labels=documentation&body=Documentation+update+for+enum+PVITag.VOLTAGE_MONITORING_THRESHOLD_BOTTOM:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    VOLTAGE_MONITORING_THRESHOLD_BOTTOM(hex = "0x02000073", type = DataType.FLOAT32),

    /**
     * hex = "0x02000074", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.VOLTAGE_MONITORING_SLOPE_UP&labels=documentation&body=Documentation+update+for+enum+PVITag.VOLTAGE_MONITORING_SLOPE_UP:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    VOLTAGE_MONITORING_SLOPE_UP(hex = "0x02000074", type = DataType.FLOAT32),

    /**
     * hex = "0x02000075", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.VOLTAGE_MONITORING_SLOPE_DOWN&labels=documentation&body=Documentation+update+for+enum+PVITag.VOLTAGE_MONITORING_SLOPE_DOWN:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    VOLTAGE_MONITORING_SLOPE_DOWN(hex = "0x02000075", type = DataType.FLOAT32),

    /**
     * hex = "0x02800080", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.FREQUENCY_UNDER_OVER&labels=documentation&body=Documentation+update+for+enum+PVITag.FREQUENCY_UNDER_OVER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_FREQUENCY_UNDER & TAG_PVI_FREQUENCY_OVER
     *
     */
    FREQUENCY_UNDER_OVER(hex = "0x02800080", type = DataType.CONTAINER),

    /**
     * hex = "0x02000080", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_FREQUENCY_UNDER_OVER&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_FREQUENCY_UNDER_OVER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_FREQUENCY_UNDER_OVER(hex = "0x02000080", type = DataType.NONE),

    /**
     * hex = "0x02000082", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.FREQUENCY_UNDER&labels=documentation&body=Documentation+update+for+enum+PVITag.FREQUENCY_UNDER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    FREQUENCY_UNDER(hex = "0x02000082", type = DataType.FLOAT32),

    /**
     * hex = "0x02000083", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.FREQUENCY_OVER&labels=documentation&body=Documentation+update+for+enum+PVITag.FREQUENCY_OVER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    FREQUENCY_OVER(hex = "0x02000083", type = DataType.FLOAT32),

    /**
     * hex = "0x02800085", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.SYSTEM_MODE&labels=documentation&body=Documentation+update+for+enum+PVITag.SYSTEM_MODE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     *
     * 0=IdleMode
     * 1=NormalMode
     * 2=GridChargeMode
     * 3=BackupPowerMode
     *
     */
    SYSTEM_MODE(hex = "0x02800085", type = DataType.UCHAR8),

    /**
     * hex = "0x02000085", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_SYSTEM_MODE&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_SYSTEM_MODE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SYSTEM_MODE(hex = "0x02000085", type = DataType.NONE),

    /**
     * hex = "0x02800087", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.POWER_MODE&labels=documentation&body=Documentation+update+for+enum+PVITag.POWER_MODE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     *
     * 1=PVI ON
     * 0=PVI OFF
     * 101=PVI ON_FORCE
     * 100=PVI OFF_FORCE
     *
     */
    POWER_MODE(hex = "0x02800087", type = DataType.UCHAR8),

    /**
     * hex = "0x02000087", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_POWER_MODE&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_POWER_MODE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_POWER_MODE(hex = "0x02000087", type = DataType.NONE),

    /**
     * hex = "0x02800100", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+PVITag.TEMPERATURE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    TEMPERATURE(hex = "0x02800100", type = DataType.CONTAINER),

    /**
     * hex = "0x02000100", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_TEMPERATURE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_TEMPERATURE(hex = "0x02000100", type = DataType.UCHAR8),

    /**
     * hex = "0x02800101", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.TEMPERATURE_COUNT&labels=documentation&body=Documentation+update+for+enum+PVITag.TEMPERATURE_COUNT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    TEMPERATURE_COUNT(hex = "0x02800101", type = DataType.NONE),

    /**
     * hex = "0x02000101", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_TEMPERATURE_COUNT&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_TEMPERATURE_COUNT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_TEMPERATURE_COUNT(hex = "0x02000101", type = DataType.UCHAR8),

    /**
     * hex = "0x02800102", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.MAX_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+PVITag.MAX_TEMPERATURE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MAX_TEMPERATURE(hex = "0x02800102", type = DataType.FLOAT32),

    /**
     * hex = "0x02000102", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_MAX_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_MAX_TEMPERATURE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_MAX_TEMPERATURE(hex = "0x02000102", type = DataType.UCHAR8),

    /**
     * hex = "0x02800103", type = DataType.FLOAT32
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.MIN_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+PVITag.MIN_TEMPERATURE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MIN_TEMPERATURE(hex = "0x02800103", type = DataType.FLOAT32),

    /**
     * hex = "0x02000103", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_MIN_TEMPERATURE&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_MIN_TEMPERATURE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_MIN_TEMPERATURE(hex = "0x02000103", type = DataType.UCHAR8),

    /**
     * hex = "0x028ABC01", type = DataType.STRING
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.SERIAL_NUMBER&labels=documentation&body=Documentation+update+for+enum+PVITag.SERIAL_NUMBER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SERIAL_NUMBER(hex = "0x028ABC01", type = DataType.STRING),

    /**
     * hex = "0x020ABC01", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_SERIAL_NUMBER&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_SERIAL_NUMBER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SERIAL_NUMBER(hex = "0x020ABC01", type = DataType.NONE),

    /**
     * hex = "0x028ABC02", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.VERSION&labels=documentation&body=Documentation+update+for+enum+PVITag.VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_VERSION_MAIN |& TAG_PVI_VERSION_PIC |& ?.
     *
     */
    VERSION(hex = "0x028ABC02", type = DataType.CONTAINER),

    /**
     * hex = "0x020ABC02", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_VERSION&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_VERSION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_VERSION(hex = "0x020ABC02", type = DataType.NONE),

    /**
     * hex = "0x020ABC03", type = DataType.STRING
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.VERSION_MAIN&labels=documentation&body=Documentation+update+for+enum+PVITag.VERSION_MAIN:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    VERSION_MAIN(hex = "0x020ABC03", type = DataType.STRING),

    /**
     * hex = "0x020ABC04", type = DataType.STRING
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.VERSION_PIC&labels=documentation&body=Documentation+update+for+enum+PVITag.VERSION_PIC:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    VERSION_PIC(hex = "0x020ABC04", type = DataType.STRING),

    /**
     * hex = "0x028AC000", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.AC_MAX_PHASE_COUNT&labels=documentation&body=Documentation+update+for+enum+PVITag.AC_MAX_PHASE_COUNT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    AC_MAX_PHASE_COUNT(hex = "0x028AC000", type = DataType.UCHAR8),

    /**
     * hex = "0x028AC001", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.AC_POWER&labels=documentation&body=Documentation+update+for+enum+PVITag.AC_POWER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    AC_POWER(hex = "0x028AC001", type = DataType.CONTAINER),

    /**
     * hex = "0x028AC002", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.AC_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+PVITag.AC_VOLTAGE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    AC_VOLTAGE(hex = "0x028AC002", type = DataType.CONTAINER),

    /**
     * hex = "0x028AC003", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.AC_CURRENT&labels=documentation&body=Documentation+update+for+enum+PVITag.AC_CURRENT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    AC_CURRENT(hex = "0x028AC003", type = DataType.CONTAINER),

    /**
     * hex = "0x028AC004", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.AC_APPARENTPOWER&labels=documentation&body=Documentation+update+for+enum+PVITag.AC_APPARENTPOWER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    AC_APPARENTPOWER(hex = "0x028AC004", type = DataType.CONTAINER),

    /**
     * hex = "0x028AC005", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.AC_REACTIVEPOWER&labels=documentation&body=Documentation+update+for+enum+PVITag.AC_REACTIVEPOWER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    AC_REACTIVEPOWER(hex = "0x028AC005", type = DataType.CONTAINER),

    /**
     * hex = "0x028AC006", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.AC_ENERGY_ALL&labels=documentation&body=Documentation+update+for+enum+PVITag.AC_ENERGY_ALL:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    AC_ENERGY_ALL(hex = "0x028AC006", type = DataType.CONTAINER),

    /**
     * hex = "0x028AC007", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.AC_MAX_APPARENTPOWER&labels=documentation&body=Documentation+update+for+enum+PVITag.AC_MAX_APPARENTPOWER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    AC_MAX_APPARENTPOWER(hex = "0x028AC007", type = DataType.CONTAINER),

    /**
     * hex = "0x028AC008", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.AC_ENERGY_DAY&labels=documentation&body=Documentation+update+for+enum+PVITag.AC_ENERGY_DAY:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    AC_ENERGY_DAY(hex = "0x028AC008", type = DataType.CONTAINER),

    /**
     * hex = "0x028AC009", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.AC_ENERGY_GRID_CONSUMPTION&labels=documentation&body=Documentation+update+for+enum+PVITag.AC_ENERGY_GRID_CONSUMPTION:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    AC_ENERGY_GRID_CONSUMPTION(hex = "0x028AC009", type = DataType.CONTAINER),

    /**
     * hex = "0x020AC000", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_AC_MAX_PHASE_COUNT&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_AC_MAX_PHASE_COUNT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     *
     */
    REQ_AC_MAX_PHASE_COUNT(hex = "0x020AC000", type = DataType.NONE),

    /**
     * hex = "0x020AC001", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_AC_POWER&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_AC_POWER:).
     *
     * Original E3DC Documentation:
     *
     * en: Value of the request includes the requested phase
     *
     * de: Value der Anfrage beinhaltet die angefragte Phase
     *
     */
    REQ_AC_POWER(hex = "0x020AC001", type = DataType.UCHAR8),

    /**
     * hex = "0x020AC002", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_AC_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_AC_VOLTAGE:).
     *
     * Original E3DC Documentation:
     *
     * en: Value of the request includes the requested phase
     *
     * de: Value der Anfrage beinhaltet die angefragte Phase
     *
     */
    REQ_AC_VOLTAGE(hex = "0x020AC002", type = DataType.UCHAR8),

    /**
     * hex = "0x020AC003", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_AC_CURRENT&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_AC_CURRENT:).
     *
     * Original E3DC Documentation:
     *
     * en: Value of the request includes the requested phase
     *
     * de: Value der Anfrage beinhaltet die angefragte Phase
     *
     */
    REQ_AC_CURRENT(hex = "0x020AC003", type = DataType.UCHAR8),

    /**
     * hex = "0x020AC004", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_AC_APPARENTPOWER&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_AC_APPARENTPOWER:).
     *
     * Original E3DC Documentation:
     *
     * en: Value of the request includes the requested phase
     *
     * de: Value der Anfrage beinhaltet die angefragte Phase
     *
     */
    REQ_AC_APPARENTPOWER(hex = "0x020AC004", type = DataType.UCHAR8),

    /**
     * hex = "0x020AC005", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_AC_REACTIVEPOWER&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_AC_REACTIVEPOWER:).
     *
     * Original E3DC Documentation:
     *
     * en: Value of the request includes the requested phase
     *
     * de: Value der Anfrage beinhaltet die angefragte Phase
     *
     */
    REQ_AC_REACTIVEPOWER(hex = "0x020AC005", type = DataType.UCHAR8),

    /**
     * hex = "0x020AC006", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_AC_ENERGY_ALL&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_AC_ENERGY_ALL:).
     *
     * Original E3DC Documentation:
     *
     * en: Value of the request includes the requested phase
     *
     * de: Value der Anfrage beinhaltet die angefragte Phase
     *
     */
    REQ_AC_ENERGY_ALL(hex = "0x020AC006", type = DataType.UCHAR8),

    /**
     * hex = "0x020AC007", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_AC_MAX_APPARENTPOWER&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_AC_MAX_APPARENTPOWER:).
     *
     * Original E3DC Documentation:
     *
     * en: Value of the request includes the requested phase
     *
     * de: Value der Anfrage beinhaltet die angefragte Phase
     *
     */
    REQ_AC_MAX_APPARENTPOWER(hex = "0x020AC007", type = DataType.UCHAR8),

    /**
     * hex = "0x020AC008", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_AC_ENERGY_DAY&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_AC_ENERGY_DAY:).
     *
     * Original E3DC Documentation:
     *
     * en: Value of the request includes the requested phase
     *
     * de: Value der Anfrage beinhaltet die angefragte Phase
     *
     */
    REQ_AC_ENERGY_DAY(hex = "0x020AC008", type = DataType.UCHAR8),

    /**
     * hex = "0x020AC009", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_AC_ENERGY_GRID_CONSUMPTION&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_AC_ENERGY_GRID_CONSUMPTION:).
     *
     * Original E3DC Documentation:
     *
     * en: Value of the request includes the requested phase
     *
     * de: Value der Anfrage beinhaltet die angefragte Phase
     *
     */
    REQ_AC_ENERGY_GRID_CONSUMPTION(hex = "0x020AC009", type = DataType.UCHAR8),

    /**
     * hex = "0x028DC000", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.DC_MAX_STRING_COUNT&labels=documentation&body=Documentation+update+for+enum+PVITag.DC_MAX_STRING_COUNT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DC_MAX_STRING_COUNT(hex = "0x028DC000", type = DataType.UCHAR8),

    /**
     * hex = "0x028DC001", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.DC_POWER&labels=documentation&body=Documentation+update+for+enum+PVITag.DC_POWER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    DC_POWER(hex = "0x028DC001", type = DataType.CONTAINER),

    /**
     * hex = "0x028DC002", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.DC_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+PVITag.DC_VOLTAGE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    DC_VOLTAGE(hex = "0x028DC002", type = DataType.CONTAINER),

    /**
     * hex = "0x028DC003", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.DC_CURRENT&labels=documentation&body=Documentation+update+for+enum+PVITag.DC_CURRENT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    DC_CURRENT(hex = "0x028DC003", type = DataType.CONTAINER),

    /**
     * hex = "0x028DC004", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.DC_MAX_POWER&labels=documentation&body=Documentation+update+for+enum+PVITag.DC_MAX_POWER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    DC_MAX_POWER(hex = "0x028DC004", type = DataType.CONTAINER),

    /**
     * hex = "0x028DC005", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.DC_MAX_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+PVITag.DC_MAX_VOLTAGE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    DC_MAX_VOLTAGE(hex = "0x028DC005", type = DataType.CONTAINER),

    /**
     * hex = "0x028DC006", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.DC_MIN_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+PVITag.DC_MIN_VOLTAGE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    DC_MIN_VOLTAGE(hex = "0x028DC006", type = DataType.CONTAINER),

    /**
     * hex = "0x028DC007", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.DC_MAX_CURRENT&labels=documentation&body=Documentation+update+for+enum+PVITag.DC_MAX_CURRENT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    DC_MAX_CURRENT(hex = "0x028DC007", type = DataType.CONTAINER),

    /**
     * hex = "0x028DC008", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.DC_MIN_CURRENT&labels=documentation&body=Documentation+update+for+enum+PVITag.DC_MIN_CURRENT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    DC_MIN_CURRENT(hex = "0x028DC008", type = DataType.CONTAINER),

    /**
     * hex = "0x028DC009", type = DataType.CONTAINER
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.DC_STRING_ENERGY_ALL&labels=documentation&body=Documentation+update+for+enum+PVITag.DC_STRING_ENERGY_ALL:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: TAG_PVI_INDEX & TAG_PVI_VALUE
     *
     */
    DC_STRING_ENERGY_ALL(hex = "0x028DC009", type = DataType.CONTAINER),

    /**
     * hex = "0x020DC000", type = DataType.NONE
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_DC_MAX_STRING_COUNT&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_DC_MAX_STRING_COUNT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DC_MAX_STRING_COUNT(hex = "0x020DC000", type = DataType.NONE),

    /**
     * hex = "0x020DC001", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_DC_POWER&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_DC_POWER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DC_POWER(hex = "0x020DC001", type = DataType.UCHAR8),

    /**
     * hex = "0x020DC002", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_DC_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_DC_VOLTAGE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DC_VOLTAGE(hex = "0x020DC002", type = DataType.UCHAR8),

    /**
     * hex = "0x020DC003", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_DC_CURRENT&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_DC_CURRENT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DC_CURRENT(hex = "0x020DC003", type = DataType.UCHAR8),

    /**
     * hex = "0x020DC004", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_DC_MAX_POWER&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_DC_MAX_POWER:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DC_MAX_POWER(hex = "0x020DC004", type = DataType.UCHAR8),

    /**
     * hex = "0x020DC005", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_DC_MAX_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_DC_MAX_VOLTAGE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DC_MAX_VOLTAGE(hex = "0x020DC005", type = DataType.UCHAR8),

    /**
     * hex = "0x020DC006", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_DC_MIN_VOLTAGE&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_DC_MIN_VOLTAGE:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DC_MIN_VOLTAGE(hex = "0x020DC006", type = DataType.UCHAR8),

    /**
     * hex = "0x020DC007", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_DC_MAX_CURRENT&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_DC_MAX_CURRENT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DC_MAX_CURRENT(hex = "0x020DC007", type = DataType.UCHAR8),

    /**
     * hex = "0x020DC008", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_DC_MIN_CURRENT&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_DC_MIN_CURRENT:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DC_MIN_CURRENT(hex = "0x020DC008", type = DataType.UCHAR8),

    /**
     * hex = "0x020DC009", type = DataType.UCHAR8
	 *
	 * You know what the tag means or want to improve the tag description? Create a [Ticket](https://github.com/jnk-cons/easy-rscp/issues/new?title='Documentation+improvement+for+PVITag.REQ_DC_STRING_ENERGY_ALL&labels=documentation&body=Documentation+update+for+enum+PVITag.REQ_DC_STRING_ENERGY_ALL:).
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DC_STRING_ENERGY_ALL(hex = "0x020DC009", type = DataType.UCHAR8),


}