package de.jnkconsulting.e3dc.easyrscp.api.connection

/**
 * Simple data class to provide the connection data to the home power plant
 *
 * @param address IP address or DNS name of the home power plant
 * @param port Port on which the power plant listens. Default: 5033 (Info: 5034 for Farming)
 * @param portalUser Username. Corresponds to the username from the E3DC portal
 * @param portalPassword Password. Corresponds to the password on the E3DC portal
 * @param rscpPassword Encryption password. This value is configured directly at the home power plant and must be identical here.
 * @param timeoutMillis Milliseconds for the timeout. Default 10000
 *
 * @since 2.0
 */
data class E3DCConnectionData(
    val address: String,
    val port: Int = 5033,
    val portalUser: String,
    val portalPassword: String,
    val rscpPassword: String,
    val timeoutMillis: Long = 10000
) {

    override fun toString(): String {
        return "E3DCConnectionData(address='$address', port=$port, user='$portalUser', rscpPassword='***', portalPassword='***', timeoutMillis=$timeoutMillis)"
    }
}
