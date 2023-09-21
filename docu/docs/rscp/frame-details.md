
## The big picture

??? note "Please Zoom"

    To visualize the frame structure I used Gantt charts here. They are actually meant for something else, but they serve their purpose and can be easily generated with [mermaid.js](https://mermaid.js.org/). Unfortunately the diagrams don't offer a zoom function, so use the browser zoom!

The following diagrams show the structure of a frame. And this byte by byte. Please note that the bytes are transmitted in little endian order.

### Frame
``` mermaid
gantt
    title Structure of a frame
    dateFormat YYYY-MM-DD
    axisFormat %d
    tickInterval 1day
    section Frame
        Whole frame          : frame, 2014-01-01, 30d         
    section Header        
        Magic bytes          : mb, 2014-01-01, 2d
        CTRL                 : ctrl, after mb, 2d
        Timestamp            : ts, after ctrl, 12d
        length               : dlength, after ts, 2d
    section Data        
        Data                 : crit, data, after dlength, 8d
    section Checksum
        CRC32                : active, crc, after data, 4d
```

In the diagram above the structure of a frame is shown. Please note that the length of the data block is variable and is only shown here as an example of 8 bytes. In reality a data block is significantly longer.

#### Magic Bytes
Each frame starts with a 2 byte MagicByte block. This always contains the values E3DC (Hexcode ...)

``` mermaid
gantt
    title Magic Bytes
    dateFormat YYYY-MM-DD
    axisFormat %d
    tickInterval 1day
    section Magic Bytes
        0xE3                : e3, 2014-01-01, 1d
        0xDC                : dc, after e3, 1d
```

#### Control Bytes
The control bytes currently contain 2 pieces of information.

1. Does the frame contain a checksum at the end (the checksum is optional)?
2. Which protocol version is used? To my knowledge this is always 0x01 so far

Both information are placed in the first byte. The second byte is intended for future use is currently always 0.

``` mermaid
gantt
    title Control Bytes
    dateFormat YYYY-MM-DD
    axisFormat %d
    tickInterval 1day
    section CRC true
        0x00                : b1, 2014-01-01, 1d
        0x11                : b2, after b1, 1d
    section CRC false
        0x00                : b1, 2014-01-01, 1d
        0x01                : b2, after b1, 1d
```

#### Timestamp

The timestamp area indicates the creation time of the frame. In seconds and nanoseconds since 01/01/1970 00:00. As I understand it in UTC.

The first 8 bytes indicate the seconds value and the next 4 bytes the nanoseconds.

The following timestamp block, represents the timestamp 2023-09-20T07:57:05.362489Z.

Since the 01.01.1970 00:00 o'clock up to this Timestamp 1,695,196,625 seconds and 362,489,000 nanoseconds have passed.

``` mermaid
gantt
    title Timestamp
    dateFormat YYYY-MM-DD
    axisFormat %d
    tickInterval 1day
    section Timestamp
        0xd1a50a6500000000  : seconds, 2014-01-01, 8d
        0xa8249b15          : nanos, after seconds, 4d
```

#### Length

In the length field the length of the following data block is indicated in bytes. Since a frame can consist of several data blocks, the sum of all data block lengths is specified here.

In the example 28bytes (0x1c00 in hexcode Little Endian)

``` mermaid
gantt
    title Length
    dateFormat YYYY-MM-DD
    axisFormat %d
    tickInterval 1day
    section Timestamp
        0x1c00  : length, 2014-01-01, 2d
```

#### Data block

One or more data blocks follow. The length is determined by the previous length field. The structure is described in detail in the data block area.


#### Checksum

If the frame uses a checksum, it is specified here, with a length of 4 bytes. The standard algorithm CRC32 is used.

``` mermaid
gantt
    title CRC32
    dateFormat YYYY-MM-DD
    axisFormat %d
    tickInterval 1day
    section Timestamp
        0xe2a60c5d  : crc, 2014-01-01, 4d
```

### Datenblock
A data block represents a concrete value in a frame. Exception: A data block is of the type 'container'. Then it contains further data blocks

``` mermaid
gantt
    title Structure of a Data Block
    dateFormat YYYY-MM-DD
    axisFormat %d
    tickInterval 1day
    section Data
        Whole Block          : block, 2014-01-01, 15d         
    section Header        
        Tag                  : tag, 2014-01-01, 4d
        Type                 : type, after tag, 1d
        Length               : length, after type, 2d        
    section Value        
        Value                : crit, value, after length, 8d
```

#### Tag

The tag gives a meaning to the content. It describes which area of the home power plant it is (namespace), whether it is a request or response block, and which field from the respective namespace is meant.

For example the tag `MAC_ADDRESS` from the namespace `INFO`. This has the value `0a80000a`.

``` mermaid
gantt
    title The Tag INFO.MAC_ADDRESS
    dateFormat YYYY-MM-DD
    axisFormat %d
    tickInterval 1day
    section Namespace
        0x0a                : ns, 2014-01-01, 1d         
    section Tag        
        0x00800a            : tag, after ns, 3d
```

???+ info

    Whether it is a request or response block can be seen by the first bit(!) of the tag area. 0=request, 1=response

#### Type

In the next byte the data type is specified. That is, how the value area in the block is to be interpreted (number, string, etc.).

``` mermaid
gantt
    title Datatype String
    dateFormat YYYY-MM-DD
    axisFormat %d
    tickInterval 1day
    section String
        0x0d                : type, 2014-01-01, 1d
```

#### Length

This area is 2 bytes long and specifies the length in bytes of the following value area.

``` mermaid
gantt
    title Lengthj
    dateFormat YYYY-MM-DD
    axisFormat %d
    tickInterval 1day
    section String
        0x1100               : length, 2014-01-01, 2d
```

#### Value

Here hides the actual value, which can be interpreted depending on length and type. Here is an example for the software release number `H20_2023_024` (tag `INFO.SW_RELEASE`)

``` mermaid
gantt
    title Example String
    dateFormat YYYY-MM-DD
    axisFormat %d
    tickInterval 1day
    section String
        0x4832305f323032335f303234               : value, 2014-01-01, 2d
```

???+ note "Blocks as values"
If the data type is `container`, the value area contains a complete further data block(s)!

### Example

To make things a little clearer, let's take a look at a request frame and its corresponding response frame.

We want to query the live data of the current PV production and the battery. For this purpose, we first assemble the query frame.

In human readable form:
```text
Timestamp:	2023-09-20T08:42:32.818989Z
WithChecksum:	true
	Tag:	EMS.REQ_POWER_PV - 01000001
	Type:	NONE - 00
	Value:	[NONE] - 
	Tag:	EMS.REQ_POWER_BAT - 01000002
	Type:	NONE - 00
	Value:	[NONE] - 
```

In home power plant readable form:
```text
e3dc001178b00a6500000000c8c7d0300e0001000001000000020000010000004c769f09
```

And once disassembled:

| Bytes   |             Value | Description                                                    |
|---------|-----------------:|----------------------------------------------------------------|
| 1 - 2   |             e3dc | Magic Bytes                                                    |
| 3 - 4   |             0011 | Controlbytes -> protocol version 1 and checksum is enabled     |
| 5 - 12  | 78b00a6500000000 | Timestamp, seconds since 01.01.1970 00:00 UTC -> 1,695,199,352 |
| 13 - 16 |         c8c7d030 | Timestamp, Nanoseconds -> 818,989,000                          |
| 17 - 18 |             0e00 | Length of the data block area in bytes -> 14 bytes             |
| 18 - 21 |         01000001 | Namespace + Tag -> EMS.REQ_POWER_PV                            |
| 22      |               00 | Data type -> None                                               |
| 23 - 24 |             0000 | Length of the data block -> Data type is `none`, therefore 0          |
| 25 - 28 |         02000001 | Namespace + Tag -> EMS.REQ_POWER_BAT                           |
| 29      |               00 | Data type -> None                                               |
| 31-32   |             0000 | Length of the data block -> data type is `none`, therefore 0          |
| 33-36   |             4c769f09 | CRC32 checksum                                                |

As a response we get the following frame:

In human readable form:
```text
Timestamp:	2023-09-20T08:42:35.019685Z
WithChecksum:	true
	Tag:	EMS.POWER_PV - 01800001
	Type:	INT32 - 06
	Value:	4687 - 4f120000
	Tag:	EMS.POWER_BAT - 01800002
	Type:	INT32 - 06
	Value:	2139 - 5b080000
```

In home power plant readable form:
```text
e3dc00117bb00a6500000000885e2c011600010080010604004f120000020080010604005b08000058156e18
```

And once disassembled:

| Bytes   |             Value | Description                                                         |
|---------|-----------------:|---------------------------------------------------------------------|
| 1 - 2   |             e3dc | Magic Bytes                                                         |
| 3 - 4   |             0011 | Kontrolbytes -> Protocol version 1 and checksum is activated        |
| 5 - 12  | 7bb00a6500000000 | Timestamp, seconds since 01.01.1970 00:00 UTC -> 1,695,199,355      |
| 13 - 16 |         885e2c01 | Timestamp, Nanoseconds -> 19,685,000                                |
| 17 - 18 |             1600 | Length of the data block area in bytes -> 22 bytes                  |
| 18 - 21 |         01008001 | Namespace + Tag -> EMS.POWER_PV                                     |
| 22      |               06 | Data type -> INT32                                                  |
| 23 - 24 |             0400 | Length of the data block -> data type is `INT32`, therefore 4 bytes |
| 25 - 28 | 4f120000 | Actual value -> data type is `INT32`, therefore 4,687               |
| 29 - 32 |         02008001 | Namespace + Tag -> EMS.POWER_BAT                                    |
| 33      |               06 | Data type -> INT32                                                  |
| 34 - 35 |             0400 | Length of the data block -> data type is `INT32`, therefore 4 bytes |
| 36 - 39 | 5b080000 | Actual value -> data type is `INT32`, therefore 2,139               |
| 40 - 43 |             58156e18 | CRC32 checksume                                                     |

## Namespaces

E3DC has split all tags into different namespaces to create some overview. All namespaces known to me are documented in kdoc in the enum class [`de.jnkconsulting.e3dc.easyrscp.api.frame.Namespace`](../kdoc/easy-rscp/de.jnkconsulting.e3dc.easyrscp.api.frame/-namespace/index.html).

## Tags

The multitude of tags is also documented in kdoc. Each namespace has its own enum class to ensure at least some overview.

If I know anything about the structure and meaning of the tag, it is stored in kdoc. Partly E3DC has documented a little bit. If available, I have included the original E3DC documentation in kdoc and marked it with `Original E3DC Documentation:`. Once translated in English and once in German, as supplied by E3DC. 

Here you can find the tags [TAG API](../kdoc/easy-rscp/de.jnkconsulting.e3dc.easyrscp.api.frame.tags/index.html).


## Data types
The protocol defines a set of data types. These are documented in the enum class [`de.jnkconsulting.e3dc.easyrscp.api.frame.DataType`](../kdoc/easy-rscp/de.jnkconsulting.e3dc.easyrscp.api.frame/-data-type/index.html).
