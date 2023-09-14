package de.jnkconsulting.e3dc.easyrscp.crypt

import de.jnkconsulting.e3dc.easyrscp.api.crypt.AESCipher
import de.jnkconsulting.e3dc.easyrscp.api.crypt.AESCipherFactory

/**
 * Simple factory for [BouncyCastleAESCipher] instances.
 *
 * @since 2.0
 */
class BouncyCastleAESCipherFactory(private val rscpPassword: String): AESCipherFactory {
    override fun buildCipher(): AESCipher = BouncyCastleAESCipher(rscpPassword)
}
