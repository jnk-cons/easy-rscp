package de.jnkconsulting.e3dc.easyrscp.api.frame.tags

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Namespace
import de.jnkconsulting.e3dc.easyrscp.api.frame.Tag

/**
 * Defines tags related to the RSCP protocol itself. Mostly acts
 * these are the tags for authentication and encryption
 *
 * @param namespace Der Namespace des Tags für die Abbildung des jeweiligen Bereichs
 * @param hex Code of the tag in HexString format (0x0304001)
 * @param type Tag data type [DataType]
 *
 * @since 2.0
 */
enum class RSCPTag(
    override val namespace: Namespace = Namespace.RSCP,
    override val hex: String,
    override val type: DataType
) : Tag {

    /**
     * hex = "0x00000001", type = DataType.CONTAINER
     *
     * Original E3DC Documentation:
     *
     * en: This TAG encapsulates an authorization request to the S10. It therefore contains the data tags AUTHENTICATION_USER and AUTHENTICATION_PASSWORD
     *
     * de: Dieser TAG kapselt eine Authorisierungsanfrage an das S10. Er enthält daher die Daten-Tags AUTHENTICATION_USER und AUTHENTICATION_PASSWORD
     */
    REQ_AUTHENTICATION(hex = "0x00000001", type = DataType.CONTAINER),

    /**
     * hex = "0x00000002", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: Benutzername innerhalb eines REQ_AUTHENTICATION
     */
    AUTHENTICATION_USER(hex = "0x00000002", type = DataType.STRING),

    /**
     * hex = "0x00000003", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de: Passwort innerhalb eines REQ_AUTHENTICATION
     */
    AUTHENTICATION_PASSWORD(hex = "0x00000003", type = DataType.STRING),

    /**
     * hex = "0x00800001", type = DataType.UCHAR8
     *
     * Original E3DC Documentation:
     *
     * en: The response to a REQ_AUTHENTICATION containing the level obtained.
     *   /  authorization failed.
     *
     * de: Die Antwort auf einen REQ_AUTHENTICATION die den erhaltenen Level enthällt.
     *  / ist die Authorisierung fehlgeschlagen.
     *
     *  NO_AUTH          -  0
     *  USER             -  10
     *  INSTALLER        -  20
     *  PARTNER          -  30
     *  E3DC             -  40
     *  E3DC_ADMIN       -  50
     *  E3DC_ROOT        -  60
     */
    AUTHENTICATION(hex = "0x00800001", type = DataType.UCHAR8),

    /**
     * hex = "0x00000004", type = DataType.NONE
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    REQ_USER_LEVEL(hex = "0x00000004", type = DataType.NONE),

    /**
     * hex = "0x00800004", type = DataType.UCHAR8
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    USER_LEVEL(hex = "0x00800004", type = DataType.UCHAR8),

    /**
     * hex = "0x00000005", type = DataType.STRING
     *
     * Original E3DC Documentation:
     *
     * en: Set a Network Encryption passphrase
     *
     * de: Setze einen Netzwerk Encryption-Passphrase
     */
    REQ_SET_ENCRYPTION_PASSPHRASE(hex = "0x00000005", type = DataType.STRING),

    /**
     * hex = "0x00800005", type = DataType.BOOL
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    SET_ENCRYPTION_PASSPHRASE(hex = "0x00800005", type = DataType.BOOL),

    /**
     * hex = "0x00FFFFFF", type = DataType.ERROR
     *
     * Original E3DC Documentation:
     *
     * en:
     *
     * de:
     */
    GENERAL_ERROR(hex = "0x00FFFFFF", type = DataType.ERROR)

}
