# Release Notes

## Version 2.1.0 (2023-XX-YY)

- [#2](https://github.com/jnk-cons/easy-rscp/issues/2)) DataBuilder().none() is optional, now
  - It To create a data block of data type `NONE`, the function `none()` must no longer be called explicitly. This behavior is now default.
  - The examples in the documentation have been adjusted.
- [#13](https://github.com/jnk-cons/easy-rscp/issues/13)) BatteryService and more BatteryTags
  - A whole host of new tags for the BAT namespace have now been added
  - A new service for reading out battery information is available
- [#14](https://github.com/jnk-cons/easy-rscp/issues/14)) Dependency updates
  - slf4j: from 2.0.9 to 2.0.11
  - BouncyCastle: from 1.76 to 1.77
  - JUnit: from 5.10.0 to 5.10.1
  - Mockk: from 1.13.7 to 1.13.9
- [#15](https://github.com/jnk-cons/easy-rscp/issues/15)) TypeScript added to the documentation
  - To avoid duplication, this documentation also contains the TypeScript examples for the sister project [easy-rscp-js](https://github.com/jnk-cons/easy-rscp-js)
- New API functions:
  - Class Frame
    - isDataBlockInError()
    - errorCodeByTag()
  - Class Data
    - valueAsErrorCode
  - New enum ErrorCode

## Version 2.0.0 (2023-09-22)

- Initial Public release
