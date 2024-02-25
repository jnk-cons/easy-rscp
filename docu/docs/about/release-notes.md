# Release Notes

## Version 2.3.1 (2024-02-25)
- [#38](https://github.com/jnk-cons/easy-rscp/issues/38)) Omit credentials during string convertion
  - Added option to the StringFrameConverter to omit credentials

## Version 2.3.0 (2024-02-18)
- [#32](https://github.com/jnk-cons/easy-rscp/issues/32)) Add missing WallBox Tags
  - Added a bunch of Tags to WB and EMS Namespace
- [#34](https://github.com/jnk-cons/easy-rscp/issues/34)) Extend services with wallbox live data
  - DefaultLiveDataService returns the complete wallbox consumption and the solar share
  - New DefaultWallboxService to query the connected wallboxes and read the live data for each

## Version 2.2.2 (2024-02-07)
- [#30](https://github.com/jnk-cons/easy-rscp/issues/30)) Battery status contains the incorrect volt and temperature values per cell

## Version 2.2.1 (2024-02-06)
- [#23](https://github.com/jnk-cons/easy-rscp/issues/23)) ASOC/SOH interchange

## Version 2.2.0 (2024-02-01)
- Fixed wrong return code if a data block is in error
- [#21](https://github.com/jnk-cons/easy-rscp/issues/21)) Service to control the manual charging system
  - The ChargingService has been expanded to include the following functions
    - readManualChargeState() -> Reading out the current status of a manual storage tank charge
    - setManualCharge(amountWh) -> Starting a manual storage tank charge
    - stopManualCharge() -> Stopping a manual storage tank charge
  - BatTag and EMSTag enums have been expanded to include a number of tags relating to the battery system 
- [#23](https://github.com/jnk-cons/easy-rscp/issues/23)) Fixed Training Mode
  - The status of the battery training mode was interpreted as a Boolean in version 2.1.0. However, it is actually an enum. This has been fixed
  - The boolean value trainingModeActive is now deprecated and scheduled for removal in 2.4.0
- [#22](https://github.com/jnk-cons/easy-rscp/issues/22)) Add emergency power related Tags and a new service for controlling the emergency power system
  - BatTag and EMSTag enums have been expanded to include a number of tags relating to emergency power system
  - A new service EmergencyPowerService has been created
    - readState() -> Reads out the status of the emergency power function
    - setReserveWH(reserve) -> Configuring the emergency power reserve in watt hours
    - setReservePercentage(reserve) -> Configuring the emergency power reserve as a percentage relative to the battery capacity
    - removeReserve() -> Removes a configured emergency power reserve

## Version 2.1.0 (2024-01-22)

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
