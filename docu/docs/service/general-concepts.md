The service API is based on the lowlevel API. Its goal is to hide all details of the RSCP interface behind service facades and to make working with the home power plant more logical.

???+ info "You want more?"

    It should be noted that the RSCP interface is incredibly complex and only a very small part is currently used here. The expansion of the service API is planned and will be developed further.
    If you want to contribute here, have developed your own useful services, etc.: just create a PR or create a ticket with the title 'Maintainer'!

    Until then, the [low-level API](../lowlevel/general-concepts.md) can be used. Here all RSCP possibilities are open to you.

## Service creation

Generally, each service can be created simply with the constructor. Each service has exactly one mandatory parameter: The ConnectionPool. All other parameters are optional and have default values.
Especially for the Java developers among you, the default parameters will not work because they are a Kotlin construct. Therefore, the use of the Builder API is recommended.

For each service there is an own builder, which can create the service and if necessary allows to set the optional extension points. Each builder has a mandatory parameter. Namely an instance of the type `ConnectionBuilder` is needed. This creates the instances for encryption, connection setup etc.
Don't worry, with the ConnectionBuilder it is sufficient to specify only the connection data. Everything else is optional. Here is an example:

=== "Kotlin"
    ```kotlin
    val connectionBuilder = ConnectionBuilder()
        .withAddress(host)
        .withPortalUser(portalUser)
        .withPortalPassword(portalPassword)
        .withRSCPPassword(rscpPassword)
    ```
=== "Java"
    ```java
    ConnectionBuilder connectionBuilder = new ConnectionBuilder()
        .withAddress(host)
        .withPortalUser(portalUser)
        .withPortalPassword(portalPassword)
        .withRSCPPassword(rscpPassword);
    ```

| Parameter      | Description                                                                                                                             | 
|----------------|-----------------------------------------------------------------------------------------------------------------------------------------| 
|                |                                                                                                                                         | 
| address        | IP address or DNS name of the home power plant                                                                                          | 
| portalUser     | Username. Corresponds to the username from the E3DC portal                 | 
| portalPassword | Password. Corresponds to the password on the E3DC portal | 
| rscpPassword   | Encryption password. This value is configured directly at the home power plant and must be identical here |

With this instance you can configure all other ServiceBuilders. This is the only mandatory information that is required.

=== "Kotlin"
    ```kotlin
    val serviceBuilder = InfoServiceBuilder()
            .withConnectionBuilder(connectionBuilder)
    val service = serviceBuilder.buildService()
    val systemInfos = service.readSystemInfo()
    println(systemInfos)
    ```
=== "Java"
    ```java
    InfoServiceBuilder infoServiceBuilder = new InfoServiceBuilder()
            .withConnectionBuilder(connectionBuilder);
    InfoService service = infoServiceBuilder.buildService();
    SystemInfo infos = service.readSystemInfo();
    System.out.println(infos);
    ```

## Extension points

The service API provides several points where you can intervene in the way it works. The details are described in the section [Extension points](extension-points.md).


## Logging

easy-rscp uses internally [SLF4J](https://www.slf4j.org/) as logging framework. You may have already noticed that you get the following warning when running the examples:

```text
SLF4J: No SLF4J providers were found.
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See https://www.slf4j.org/codes.html#noProviders for further details.
```

This is because easy-rscp does not provide a logging provider. Depending on which logging framework you use (Log4j, java logging, or whatever), you have to declare the corresponding provider implementation as a dependency.
SLF4J provides instructions on what to do at the link [https://www.slf4j.org/codes.html#noProviders](https://www.slf4j.org/codes.html#noProviders).

???+ info "Why another dependency?"
    Normally you will not need the log messages from easy-rscp. But it can be helpful for debugging. easy-rscp logs only on debug, 
    trace or error level to avoid too much noise. We don't want to impose a logging framework on you, so we use SLF4J to abstract the framework. You have the choice!



