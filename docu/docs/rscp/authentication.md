After a TCP/IP connection to the home power plant has been established, an authentication frame must first be sent.

This consists of a data block `RSCP.REQ_AUTHENTICATION` of type `container`. This contains two data blocks. Once `RSCP.AUTHENTICATION_USER` and `RSCP.AUTHENTICATION_PASSWORD`. Each of the type string.
The access data to the E3DC portal are set as values.

## Example authentication frame

In the example, the username `TEST` and the password `123` were used:

=== "Human readable"
    ```text
    Timestamp:	2023-09-20T14:22:25.542694Z
    WithChecksum:	true
        Tag:	RSCP.REQ_AUTHENTICATION - 00000001
        Type:	CONTAINER - 0e
            Tag:	RSCP.AUTHENTICATION_USER - 00000002
            Type:	STRING - 0d
            Value:	TEST - 54455354
    
            Tag:	RSCP.AUTHENTICATION_PASSWORD - 00000003
            Type:	STRING - 0d
            Value:	123 - 313233
    ```
=== "As hex code"
    ```text
    e3dc001121000b650000000070da58201c00010000000e1500020000000d040054455354030000000d030031323378babe16
    ```

## Response frame on successful authentication

=== "Human readable"
    ```text
    Timestamp:	2023-09-20T14:26:14.787390Z
    WithChecksum:	true
        Tag:	RSCP.AUTHENTICATION - 00800001
        Type:	UCHAR8 - 03
        Value:	10 - 0a
    ```
=== "As hex code"
    ```text
    e3dc001106010b6500000000309eee2e0800010080000301000ad4e6f5cf
    ```

The response frame contains the value `10`. This specifies some kind of authorization. The following values are known (Even though we usually always have to make do with the USER level):


| Wert |           E3DC Name | 
|------|-----------------:|
| 0    |             NO_AUTH |
| 10   |             USER |
| 20   | INSTALLER |
| 30   |         PARTNER |
| 40   |             E3DC |
| 50   |         E3DC_ADMIN |
| 60   |         E3DC_ROOT |



## Response frame if authentication is NOT successful

=== "Human readable"
    ```text
    Timestamp:	2023-09-20T14:27:42.534655Z
    WithChecksum:	true
        Tag:	RSCP.AUTHENTICATION - 00800001
        Type:	INT32 - 06
        Value:	0 - 00000000
    ```
=== "As hex code"
    ```text
    e3dc00115e010b65000000001830de1f0b00010080000604000000000003120cf6
    ```
