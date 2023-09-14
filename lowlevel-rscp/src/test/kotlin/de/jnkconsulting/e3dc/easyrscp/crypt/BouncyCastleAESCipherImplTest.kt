package de.jnkconsulting.e3dc.easyrscp.crypt

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class BouncyCastleAESCipherImplTest {
    private val toTest = BouncyCastleAESCipher("junit-test")

    @Test
    fun `test that an the encryption result is equal to the input after decryption`() {
        val input = "this is my cipher text".toByteArray()
        val encrypted = toTest.encrypt(input)
        val decrypted = toTest.decrypt(encrypted)

        assertEquals("this is my cipher text", String(decrypted))
    }
}
