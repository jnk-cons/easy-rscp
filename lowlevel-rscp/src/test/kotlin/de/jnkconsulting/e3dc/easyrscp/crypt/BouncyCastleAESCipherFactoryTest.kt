package de.jnkconsulting.e3dc.easyrscp.crypt

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class BouncyCastleAESCipherFactoryTest {

    private val factoryToTest = BouncyCastleAESCipherFactory("test")

    @Test
    fun buildCipher() {
        Assertions.assertNotNull(factoryToTest.buildCipher())
    }
}
