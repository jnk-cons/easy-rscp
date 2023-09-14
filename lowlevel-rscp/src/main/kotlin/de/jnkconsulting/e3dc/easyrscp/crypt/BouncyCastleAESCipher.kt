package de.jnkconsulting.e3dc.easyrscp.crypt

import de.jnkconsulting.e3dc.easyrscp.api.crypt.AESCipher
import org.bouncycastle.crypto.engines.RijndaelEngine
import org.bouncycastle.crypto.modes.CBCBlockCipher
import org.bouncycastle.crypto.paddings.PaddedBufferedBlockCipher
import org.bouncycastle.crypto.paddings.ZeroBytePadding
import org.bouncycastle.crypto.params.KeyParameter
import org.bouncycastle.crypto.params.ParametersWithIV
import java.util.*

/**
 * Instance of [AESCipher] that uses [BouncyCastle](https://www.bouncycastle.org/) for implementation.
 *
 * @since 2.0
 */
class BouncyCastleAESCipher(rscpPassword: String): AESCipher {

    private val blockSize = 256
    private val ivEncryption = ByteArray(32).apply {
        Arrays.fill(this, 0xFF.toByte())
    }
    private val ivDecryption = ByteArray(32).apply {
        Arrays.fill(this, 0xFF.toByte())
    }
    private val key = ByteArray(32).apply {
        val passwordBytes = rscpPassword.toByteArray()
        forEachIndexed { index, _ ->
            if (index < passwordBytes.size) this[index] = passwordBytes[index]
            else this[index] = 0xFF.toByte()
        }
    }

    override fun encrypt(message: ByteArray) =
        createCipher(true, ivEncryption).let {
            ByteArray(it.getOutputSize(message.size)).apply {
                val len = it.processBytes(message, 0, message.size, this, 0)
                it.doFinal(this, len)
                updateIv(this, ivEncryption)
            }
        }

    override fun decrypt(message: ByteArray): ByteArray =
        createCipher(false, ivDecryption).let { paddedBuffer ->
            ByteArray(paddedBuffer.getOutputSize(message.size)).apply {
                val len = paddedBuffer.processBytes(message, 0, message.size, this, 0)
                paddedBuffer.doFinal(this, len)
                updateIv(message, ivDecryption)
            }.let {
                var lastZeroIdx: Int = it.size - 1
                while (lastZeroIdx >= 0 && it.get(lastZeroIdx).toInt() == 0) {
                    --lastZeroIdx
                }
                it.copyOf(lastZeroIdx + 1)
            }
        }

    private fun updateIv(source: ByteArray, iv: ByteArray) {
        System.arraycopy(
            source,
            source.size - iv.size,
            iv,
            0,
            iv.size
        )
    }

    private fun createCipher(forEncryption: Boolean, iv: ByteArray) =
        PaddedBufferedBlockCipher(
            CBCBlockCipher(RijndaelEngine(blockSize)),
            ZeroBytePadding()
        ).also {
            val keySize = blockSize / 8
            it.init(
                forEncryption,
                ParametersWithIV(
                    KeyParameter(key, 0, keySize),
                    iv,
                    0,
                    keySize
                )
            )
        }
}
