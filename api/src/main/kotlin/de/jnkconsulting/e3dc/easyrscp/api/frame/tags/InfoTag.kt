package de.jnkconsulting.e3dc.easyrscp.api.frame.tags

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Namespace
import de.jnkconsulting.e3dc.easyrscp.api.frame.Tag

/**
 * Mainly contains tags to query system information. Some values can also be written (time, IP etc.)
 *
 * @param namespace Der Namespace des Tags für die Abbildung des jeweiligen Bereichs
 * @param hex Code of the tag in HexString format (0x0304001)
 * @param type Tag data type [DataType]
 *
 * @since 2.0
 */
enum class InfoTag(
    override val namespace: Namespace = Namespace.INFO,
    override val hex: String,
    override val type: DataType
) : Tag {

    /**
     * hex = "0x0A000001", type = DataType.NONE
     *
     * Request tag to get the serial number of the home power plant. As a response a tag of the type [SERIAL_NUMBER] is delivered.
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SERIAL_NUMBER(hex = "0x0A000001", type = DataType.NONE),

    /**
     * hex = "0x0A000002", type = DataType.NONE
     *
     * Request tag to query the production date of the home power plant. A tag of the type [PRODUCTION_DATE] is supplied as a response.
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_PRODUCTION_DATE(hex = "0x0A000002", type = DataType.NONE),

    /**
     * hex = "0x0A000003", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_MODULES_SW_VERSIONS(hex = "0x0A000003", type = DataType.NONE),

    /**
     * hex = "0x0A000007", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_A35_SERIAL_NUMBER(hex = "0x0A000007", type = DataType.NONE),

    /**
     * hex = "0x0A000008", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_IP_ADDRESS(hex = "0x0A000008", type = DataType.NONE),

    /**
     * hex = "0x0A000009", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SUBNET_MASK(hex = "0x0A000009", type = DataType.NONE),

    /**
     * hex = "0x0A00000A", type = DataType.NONE
     *
     * Request tag to get the Mac address of the home power plant. A [MAC_ADDRESS] tag is supplied as the response.
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_MAC_ADDRESS(hex = "0x0A00000A", type = DataType.NONE),

    /**
     * hex = "0x0A00000B", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_GATEWAY(hex = "0x0A00000B", type = DataType.NONE),

    /**
     * hex = "0x0A00000C", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DNS(hex = "0x0A00000C", type = DataType.NONE),

    /**
     * hex = "0x0A00000D", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_DHCP_STATUS(hex = "0x0A00000D", type = DataType.NONE),

    /**
     * hex = "0x0A00000E", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_TIME(hex = "0x0A00000E", type = DataType.NONE),

    /**
     * hex = "0x0A00000F", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_UTC_TIME(hex = "0x0A00000F", type = DataType.NONE),

    /**
     * hex = "0x0A000010", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_TIME_ZONE(hex = "0x0A000010", type = DataType.NONE),

    /**
     * hex = "0x0A000011", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_INFO(hex = "0x0A000011", type = DataType.NONE),

    /**
     * hex = "0x0A000012", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_IP_ADDRESS(hex = "0x0A000012", type = DataType.STRING),

    /**
     * hex = "0x0A000013", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_SUBNET_MASK(hex = "0x0A000013", type = DataType.STRING),

    /**
     * hex = "0x0A000014", type = DataType.BOOL
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_DHCP_STATUS(hex = "0x0A000014", type = DataType.BOOL),

    /**
     * hex = "0x0A000015", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_GATEWAY(hex = "0x0A000015", type = DataType.STRING),

    /**
     * hex = "0x0A000016", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_DNS(hex = "0x0A000016", type = DataType.STRING),

    /**
     * hex = "0x0A000018", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SET_TIME_ZONE(hex = "0x0A000018", type = DataType.STRING),

    /**
     * hex = "0x0A000019", type = DataType.NONE
     *
     * request tag in order to get the version number of the software installed on the home power plant. A tag of the type [SW_RELEASE] is supplied as a response
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_SW_RELEASE(hex = "0x0A000019", type = DataType.NONE),

    /**
     * hex = "0x0A800001", type = DataType.STRING
     *
     * Response Tag containing the serial number of the home power plant as a string.
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SERIAL_NUMBER(hex = "0x0A800001", type = DataType.STRING),

    /**
     * hex = "0x0A800002", type = DataType.STRING
     *
     * Response day to a [REQ_PRODUCTION_DATE] request. Production date of the home power plant. The information is given in calendar week and year: For example: KW21 2021
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    PRODUCTION_DATE(hex = "0x0A800002", type = DataType.STRING),

    /**
     * hex = "0x0A800003", type = DataType.CONTAINER
     *
     * Original E3DC Documentation:
     *
     * en: Contains a list of INFO_MODULE_SW_VERSION containers.
     *
     * de: Beinhaltet eine Liste mit INFO_MODULE_SW_VERSION Containern
     */
    MODULES_SW_VERSIONS(hex = "0x0A800003", type = DataType.CONTAINER),

    /**
     * hex = "0x0A800004", type = DataType.CONTAINER
     *
     * Original E3DC Documentation:
     *
     * en: Contains the TAGs INFO_MODULE and INFO_VERSION
     *
     * de: Beinhaltet die TAGs INFO_MODULE und INFO_VERSION
     */
    MODULE_SW_VERSION(hex = "0x0A800004", type = DataType.CONTAINER),

    /**
     * hex = "0x0A800005", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MODULE(hex = "0x0A800005", type = DataType.STRING),

    /**
     * hex = "0x0A800006", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    VERSION(hex = "0x0A800006", type = DataType.STRING),

    /**
     * hex = "0x0A800007", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    A35_SERIAL_NUMBER(hex = "0x0A800007", type = DataType.STRING),

    /**
     * hex = "0x0A800008", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    IP_ADDRESS(hex = "0x0A800008", type = DataType.STRING),

    /**
     * hex = "0x0A800009", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SUBNET_MASK(hex = "0x0A800009", type = DataType.STRING),

    /**
     * hex = "0x0A80000A", type = DataType.STRING
     *
     * Reply tag to a request of type [REQ_MAC_ADDRESS]. Contains the Mac address of the home power plant.
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    MAC_ADDRESS(hex = "0x0A80000A", type = DataType.STRING),

    /**
     * hex = "0x0A80000B", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GATEWAY(hex = "0x0A80000B", type = DataType.STRING),

    /**
     * hex = "0x0A80000C", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DNS(hex = "0x0A80000C", type = DataType.STRING),

    /**
     * hex = "0x0A80000D", type = DataType.BOOL
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    DHCP_STATUS(hex = "0x0A80000D", type = DataType.BOOL),

    /**
     * hex = "0x0A80000E", type = DataType.TIMESTAMP
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    TIME(hex = "0x0A80000E", type = DataType.TIMESTAMP),

    /**
     * hex = "0x0A80000F", type = DataType.TIMESTAMP
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    UTC_TIME(hex = "0x0A80000F", type = DataType.TIMESTAMP),

    /**
     * hex = "0x0A800010", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    TIME_ZONE(hex = "0x0A800010", type = DataType.STRING),

    /**
     * hex = "0x0A800011", type = DataType.CONTAINER
     *
     * Original E3DC Documentation:
     *
     * en: Contains the TAGs INFO_SERIAL_NUMBER, INFO_PRODUCTION_DATE, INFO_MAC_ADDRESS
     *
     * de: Beinhaltet die TAGs INFO_SERIAL_NUMBER, INFO_PRODUCTION_DATE, INFO_MAC_ADDRESS
     *
     */
    INFO(hex = "0x0A800011", type = DataType.CONTAINER),

    /**
     * hex = "0x0A800012", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_IP_ADDRESS(hex = "0x0A800012", type = DataType.STRING),

    /**
     * hex = "0x0A800013", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_SUBNET_MASK(hex = "0x0A800013", type = DataType.STRING),

    /**
     * hex = "0x0A800014", type = DataType.BOOL
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_DHCP_STATUS(hex = "0x0A800014", type = DataType.BOOL),

    /**
     * hex = "0x0A800015", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_GATEWAY(hex = "0x0A800015", type = DataType.STRING),

    /**
     * hex = "0x0A800016", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_DNS(hex = "0x0A800016", type = DataType.STRING),

    /**
     * hex = "0x0A800017", type = DataType.TIMESTAMP
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_TIME(hex = "0x0A800017", type = DataType.TIMESTAMP),

    /**
     * hex = "0x0A800018", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_TIME_ZONE(hex = "0x0A800018", type = DataType.STRING),

    /**
     * hex = "0x0A800019", type = DataType.STRING
     *
     * Response tag to a [REQ_SW_RELEASE] request. Contains the version number of the software installed on the home power plant.
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SW_RELEASE(hex = "0x0A800019", type = DataType.STRING),

    /**
     * hex = "0x0AFFFFFF", type = DataType.ERROR
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x0AFFFFFF", type = DataType.ERROR),


}
