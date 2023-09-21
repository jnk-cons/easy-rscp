This section describes how to encrypt (or decrypt) a frame. It is assumed that some terms are already known. AES, IV, etc. are not described in detail because they are part of the standard AES algorithm.

## The basics

Each frame must be AES-256 encrypted. The response frames must be decrypted accordingly. The RSCP password configured on the home power plant is used as the key (see [Setup](../getting-started/setup.md)).

Note the handling of the IV. Initially, an IV completely filled with the values 0xFF is used. Afterwards the last encrypted block is always used as IV for the next one (AES standard). This also applies across frames.
So when you send the authentication frame, you have to remember the last block, because it is needed as IV for the next frame.

On the decryption side it is the same. The initial IV is filled with 0xFF. When decrypting you have to remember the last block again, because it is needed for the next response frame.

???+ danger "Do not use this algorithm anywhere else!"
    The algorithm given by E3DC is not completely secure. Therefore, do not use the algorithm or the encryption implementation in any other project. Three problems make the algorithm insecure:

    1. Empty IV: Actually, a random (or at least secret) value should be used. Since a symmetrical procedure is used here, it is not possible to transmit such a secret securely. The value was therefore chosen empty by E3DC. The first block of the encryption is therefore less strongly encrypted than the others.
    2. No `password derivation function`: AES is byte based. Here AES-256 -> A 32Byte long key consisting of binary data is used. Now it is quite inconvenient for humans to remember binary data, so E3DC decided to use a text as key. This can be done, but then you should use a `password derivation function` (PBKDF2, Argon2, etc). Otherwise the key space is limited to the printable characters, and thus the security is reduced considerably. E3DC does not do this!
    3. Pseudo security by key generation: E3DC pretends that the 32byte long key is generated directly from the bytes of the text password. If the password is too short, the key is padded with 0xFF values. If the password is too long, the key is truncated.

???+ danger "The transferred data is not secure"
    In addition to pointing out that please do not use the algorithm anywhere else, it is also worth mentioning that the data transmitted in the frames cannot be considered completely safe either. Be aware of this. Among other things, your E3DC Portal username and E3DC Portal password will be transmitted! 

    Usually the transmission is done in your private network, but I don't want to leave it unmentioned. When you log in to the E3DC portal with your data, these are SSL encrypted and therefore not readable in your private network. When communicating with the home power plant you have to rely on the poorly implemented AES algorithm.

???+ note "Good AES vs Bad AES"
    Just to clarify: AES itself is not considered insecure as of today (end of 2023) and is a very good symmetric algorithm. However, if you choose the parameters incorrectly, the security is unfortunately gone.

## AES Parameter

To use your AES algorithm correctly, you need to consider the following parameters:

1. Key length 32Byte (AES-256)
2. CBC Mode (Cipher Block Chaining)
3. ZeroBytePadding
