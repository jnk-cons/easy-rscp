package de.jnkconsulting.e3dc.easyrscp.api.crypt

/**
 * Factory to create [AESCipher] instances
 *
 * @since 2.0
 */
interface AESCipherFactory {

    /**
     * Creates a new instance.
     *
     * According to the E3DC requirements, an array of zeros is (unfortunately) used as IV here.
     *
     * @return New [AESCipher] instance
     */
    fun buildCipher(): AESCipher
}
