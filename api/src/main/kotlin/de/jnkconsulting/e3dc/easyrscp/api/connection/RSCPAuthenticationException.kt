package de.jnkconsulting.e3dc.easyrscp.api.connection


/**
 * Exception indicating that authentication has failed.
 *
 * @since 2.0
 */
class RSCPAuthenticationException: RuntimeException("RSCP authentication has failed. Check your username and password. You must use the credentials from the E3DC portal.")
