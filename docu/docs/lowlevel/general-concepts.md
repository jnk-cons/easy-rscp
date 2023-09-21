???+ note "RSCP Knowledge"

    If you want to work with the lowlevel API, you must be familiar with the RSCP protocol, at least in its basic features. I therefore recommend to also read the [RSCP](../rscp/basic-rscp.md) section.

The API of easy-rscp consists of three areas, which are separated by the packages `connection`, `crypt` and `frame`.

## connection
Here are all the classes that are needed to establish a connection to the home power plant.

To create and correctly connect the different objects, a `ConnectionBuilder` is available. More info in the [Connection setup](connection.md) section.

## crypt
Here are the implementations of `AESCipher` and `AESCipherFactory`. easy-rscp uses the Java Crypto Framework [BouncyCastle](https://www.bouncycastle.org/) for the implementations.

If you want to work without BouncyCastle dependency, you can implement the two interfaces yourself and set them accordingly in the `ConnectionBuilder`.

## frame
Everything that has to do with frames and data blocks, parsing etc. is located here.
