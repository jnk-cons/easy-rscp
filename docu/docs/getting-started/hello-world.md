In this example we will establish a connection to the home power plant and read out some system information.

## Provide connection data

For connection building it is easiest to use the `ConnectionBuilder()` class. For TypeScript you can use the factory classes. Here is an example with the minimum necessary configuration:

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
=== "TypeScript"
    ```typescript
    const connectionData: E3dcConnectionData = {
        address: host,
        port: 5033,
        portalUser: portalUser,
        portalPassword: portalPassword,
        rscpPassword: rscpPassword
    }
    const factory = new DefaultHomePowerPlantConnectionFactory(connectionData)
    const connection = await factory.openConnection()
    ```

| Parameter      | Description                                                                                                                             | 
|----------------|-----------------------------------------------------------------------------------------------------------------------------------------| 
|                |                                                                                                                                         | 
| address        | IP address or DNS name of the home power plant                                                                                          | 
| portalUser     | Username. Corresponds to the username from the E3DC portal                 | 
| portalPassword | Password. Corresponds to the password on the E3DC portal | 
| rscpPassword   | Encryption password. This value is configured directly at the home power plant and must be identical here |

## Create Service Builder
The access itself is done via one of the services. Here in the example we use the `InfoService`. The easiest way to create it is to use the `InfoServiceBuilder()` class. In TypeScript you can easily create a service if you have created an RSCP connection:

=== "Kotlin"
    ```kotlin
    val serviceBuilder = InfoServiceBuilder()
        .withConnectionBuilder(connectionBuilder)
    ```
=== "Java"
    ```java
    InfoServiceBuilder infoServiceBuilder = new InfoServiceBuilder()
        .withConnectionBuilder(connectionBuilder);
    ```
=== "TypeScript"
    ```typescript
    const service = new DefaultInfoService(connection)
    ```

## Create and use service
And now ... have fun:

=== "Kotlin"
    ```kotlin
    val service = serviceBuilder.buildService()
    val systemInfos = service.readSystemInfo()
    println(systemInfos)
    ```
=== "Java"
    ```java
    InfoService service = infoServiceBuilder.buildService();
    SystemInfo infos = service.readSystemInfo();
    System.out.println(infos);
    ```
=== "TypeScript"
    ```typescript
    const service = new DefaultInfoService(connection)
    service.readSystemInfo()
        .then(systemInfos => console.log(systemInfos)
    ```

## All together
=== "Kotlin"
    ```kotlin
    import de.jnkconsulting.e3dc.easyrscp.connection.ConnectionBuilder
    import de.jnkconsulting.e3dc.easyrscp.service.builder.InfoServiceBuilder
    
    val host = "192.168.1.2" // IP address of your home power plant
    val portalUser = "my_e3dc_username" // The username you use to log in to the E3DC portal
    val portalPassword = "my_e3dc_password" // The password to your E3DC portal access
    val rscpPassword = "my_rscp_password" // The password you set on your home power plant 
    
    fun main() {
        val connectionBuilder = ConnectionBuilder()
            .withAddress(host)
            .withPortalUser(portalUser)
            .withPortalPassword(portalPassword)
            .withRSCPPassword(rscpPassword)
    
        val serviceBuilder = InfoServiceBuilder()
            .withConnectionBuilder(connectionBuilder)
    
        val service = serviceBuilder.buildService()
    
        val systemInfos = service.readSystemInfo()
        println(systemInfos)
    }
    ```
=== "Java"
    ```java
    import de.jnkconsulting.e3dc.easyrscp.api.service.InfoService;
    import de.jnkconsulting.e3dc.easyrscp.api.service.model.SystemInfo;
    import de.jnkconsulting.e3dc.easyrscp.connection.ConnectionBuilder;
    import de.jnkconsulting.e3dc.easyrscp.service.builder.InfoServiceBuilder;
    
    public class ReadSystemInfos {
    
        private static String host = "192.168.1.2"; // IP address of your home power plant
        private static String portalUser = "my_e3dc_username"; // The username you use to log in to the E3DC portal
        private static String portalPassword = "my_e3dc_password"; // The password to your E3DC portal access
        private static String rscpPassword = "my_rscp_password"; // The password you set on your home power plant
    
        public static void main(String[] args) {
            ConnectionBuilder connectionBuilder = new ConnectionBuilder()
                .withAddress(host)
                .withPortalUser(portalUser)
                .withPortalPassword(portalPassword)
                .withRSCPPassword(rscpPassword);
    
            InfoServiceBuilder infoServiceBuilder = new InfoServiceBuilder()
                .withConnectionBuilder(connectionBuilder);
    
            InfoService service = infoServiceBuilder.buildService();
            SystemInfo infos = service.readSystemInfo();
            System.out.println(infos);
        }
    }
    ```
=== "TypeScript"
    ```typescript
    import {E3dcConnectionData, DefaultHomePowerPlantConnectionFactory, DefaultInfoService} from 'easy-rscp';
    
    const connectionData: E3dcConnectionData = {
        address: host,
        port: 5033,
        portalUser: portalUser,
        portalPassword: portalPassword,
        rscpPassword: rscpPassword
    }
    const factory = new DefaultHomePowerPlantConnectionFactory(connectionData)
    const connection = await factory.openConnection()
    const service = new DefaultInfoService(connection)
    service.readSystemInfo()
        .then(systemInfos => console.log(systemInfos)
    ```

If everything worked, you should see something like the following result (The serialNumber is hidden here):
```text
SystemInfo(serialNumber=***, softwareVersion=H20_2023_024, productionDate=ProductionDate(rscpValue='KW27 2022', calendarWeek=27, year=2022, localDate=2022-07-04))
```

That's it. Your first RSCP request to the home power plant is done!

## What's next?

Either you read the documentation of the [Service API](../service/general-concepts.md) or, if you want to code more, you look at the integration tests in the service module. These are normal unit tests that are only executed when certain environment variables are set. There is one test for each service function.
You can find the tests in the service module under `src/test/kotlin/de/jnkconsulting/e3dc/easyrscp/service`. The variables are visible in the code and correspond to the connection data to the home power plant.
