package de.jnkconsulting.e3dc.easyrscp.api.crypt

/**
 * Service to encrypt or decrypt a given byte message using AES.
 *
 * The service is stateful and designed for E3DC home power plants and follows the algorithm required there.
 * For example, the last block of the last encrypted message is used as IV for the next one.
 *
 * @since 2.0
 */
interface AESCipher {

    /**
     * Encrypts the given message using AES
     *
     * @param message Unencrypted message to be encrypted
     * @return Encrypted message
     *
     * @since 2.0
     */
    fun encrypt(message: ByteArray): ByteArray

    /**
     * Decrypts the given message using AES
     *
     * @param message Encrypted message to be decrypted
     * @return Decrypted message
     *
     * @since 2.0
     */
    fun decrypt(message: ByteArray): ByteArray
}
