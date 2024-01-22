The `crypt` package contains the AES implementations. Each request and response frame must be AES encrypted. Here E3DC has made some specifications which are mapped in the class `BouncyCastleAESCipher`.

???+ danger "Uses the class only and exclusively to communicate with the home power plant"

    E3DC requires some peculiarities that make the AES algrithm used here insecure. 

    1. A password is not well suited as an AES key. Actually, a password derivation algorithm should be used. This is not the case here. Simply the bytes from the string are used and converted into a 32Byte long key. If the password is too short, the key is padded, if the passowrt is too long, it is truncated.
    2. The IV for the first request is always empty.

    None of this can be changed, the home power plant requires exactly this algorithm. Therefore use this class only here and otherwise please not!

## Usage

???+ info "TypeScript"

    If you want to intervene in the encryption, you can implement your own AesCipherFactory and make this known to the DefaultHomePowerPlantConnectionFactory in the structure.

The classes are not used directly, but created automatically by the `ConnectionBuilder`. Only if you want to exchange the supplied implementation, you can set your factory at the builder:

=== "Kotlin"
    ```kotlin
    val connectionBuilder = ConnectionBuilder()
            .withAddress(host)
            .withPortalUser(portalUser)
            .withPortalPassword(portalPassword)
            .withRSCPPassword(rscpPassword)
            .withCipherFactory(myCustomCipherFactory)
    ```
=== "Java"
    ```java
    ConnectionBuilder connectionBuilder = new ConnectionBuilder()
            .withAddress(host)
            .withPortalUser(portalUser)
            .withPortalPassword(portalPassword)
            .withRSCPPassword(rscpPassword)
            .withCipherFactory(myCustomCipherFactory);
    ```
=== "TypeScript"
    ```typescript
    const factory = new DefaultHomePowerPlantConnectionFactory(
            connectionData,
            myCustomAESImplementation);
    ```
