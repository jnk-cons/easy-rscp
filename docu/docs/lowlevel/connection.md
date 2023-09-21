The `connection` package contains all classes that are needed to establish a connection to the home power plant.
The class `DefaultHomePowerPlantConnection` serves as connection point. Here frames are sent to the home power plant and the answers are parsed.

To create a connection the class `DefaultHomePowerPlantConectionFactory` is available.

As `ConnectionPool` the implementation `SingleInstanceConnectionPool` is available, which keeps Thread Save open a connection to the home power plant.

To simplify the creation and dependencies, there is the `ConnectionBuilder` which can create the instances with little configuration effort.

## ConnectionBuilder usage

In the following example we create a ConnectionBuilder instance, get a ConnectionPool and request the current live production data.
To be able to read the answer we use the `StringFrameConverter` to output the answer frame:

=== "Kotlin"
    ```kotlin
    import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
    import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
    import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
    import de.jnkconsulting.e3dc.easyrscp.connection.ConnectionBuilder
    import de.jnkconsulting.e3dc.easyrscp.service.converter.StringFrameConverter

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
    
        val connectionPool = connectionBuilder.buildConnectionPool()
        val answer = connectionPool.executeAndRelease {
            it.send(FrameBuilder()
                        .addData(
                            DataBuilder().tag(EMSTag.REQ_POWER_PV).none().build(),
                            DataBuilder().tag(EMSTag.REQ_POWER_BAT).none().build(),
                            DataBuilder().tag(EMSTag.REQ_POWER_GRID).none().build(),
                            DataBuilder().tag(EMSTag.REQ_POWER_HOME).none().build(),
                            DataBuilder().tag(EMSTag.REQ_BAT_SOC).none().build(),
                        ).build()
            )
        }
        println(StringFrameConverter().invoke(answer))
    }
    ```
=== "Java"
    ```java
    import de.jnkconsulting.e3dc.easyrscp.api.connection.ConnectionPool;
    import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame;
    import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag;
    import de.jnkconsulting.e3dc.easyrscp.connection.ConnectionBuilder;
    import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder;
    import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder;
    import de.jnkconsulting.e3dc.easyrscp.service.converter.StringFrameConverter;
    
    public class ConnectionBuilderExample {
    
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
    
            ConnectionPool connectionPool = connectionBuilder.buildConnectionPool();
            Frame answer = connectionPool.executeAndRelease(connection -> {
                Frame requestFrame = new FrameBuilder()
                    .addData(
                        new DataBuilder().tag(EMSTag.REQ_POWER_PV).none().build(),
                        new DataBuilder().tag(EMSTag.REQ_POWER_BAT).none().build(),
                        new DataBuilder().tag(EMSTag.REQ_POWER_GRID).none().build(),
                        new DataBuilder().tag(EMSTag.REQ_POWER_HOME).none().build(),
                        new DataBuilder().tag(EMSTag.REQ_BAT_SOC).none().build()
                        ).build();
                return connection.send(requestFrame);
            });
            System.out.println(new StringFrameConverter().invoke(answer));
        }
    }
    ```

The output should look something like this:
```text
Timestamp:	2023-09-19T19:08:44.664348Z
WithChecksum:	true
	Tag:	EMS.POWER_PV - 01800001
	Type:	INT32 - 06
	Value:	0 - 00000000
	Tag:	EMS.POWER_BAT - 01800002
	Type:	INT32 - 06
	Value:	-639 - 81fdffff
	Tag:	EMS.POWER_GRID - 01800004
	Type:	INT32 - 06
	Value:	23 - 17000000
	Tag:	EMS.POWER_HOME - 01800003
	Type:	INT32 - 06
	Value:	662 - 96020000
	Tag:	EMS.BAT_SOC - 01800008
	Type:	UCHAR8 - 03
	Value:	86 - 56
```
