There are currently three ways to interfere with the operation of the service or lowlevel API.

Listener --> Are called at specific points in the request/response lifecycle

FrameConverter --> Read data from a response frame from the home power plant and convert the data into an object

FrameCreator --> Generates request frames to the home power plant

### Listener
For instances of type `ConnectionBuilder` any number of `RSCPRequestResponseListener` can be registered. These listeners are called at different points in the request-response cycle.

=== "Kotlin"
    ```kotlin
    val connectionBuilder = ConnectionBuilder()
            .withAddress(host)
            .withPortalUser(portalUser)
            .withPortalPassword(portalPassword)
            .withRSCPPassword(rscpPassword)
            .addRequestResponseListener(listener1, listener2)
    ```
=== "Java"
    ```java
    ConnectionBuilder connectionBuilder = new ConnectionBuilder()
            .withAddress(host)
            .withPortalUser(portalUser)
            .withPortalPassword(portalPassword)
            .withRSCPPassword(rscpPassword)
            .addRequestResponseListener(listener1, listener2);
    ```

???+ warning "Please note"
    The listeners are only used if NO own instance of type `HomePowerPlantConnectionFactory` or `ConnectionPool` is configured at the Builder!

#### Request-/Response Lifecycle
``` mermaid
sequenceDiagram
  autonumber
  DefaultHomePowerPlantConnection->>Listener: onBeforeRequestFrameEncryption(event)
  DefaultHomePowerPlantConnection->>AESCipher: encrypt(frameBytes)
  DefaultHomePowerPlantConnection->>Listener: onBeforeRequestSend(event)
  DefaultHomePowerPlantConnection->>HomePowerPlant: send(encryptedFrameBytes)
  DefaultHomePowerPlantConnection->>Listener: onAfterRequestSend(event)
  HomePowerPlant->>DefaultHomePowerPlantConnection: sendAnswer(encryptedAnswerFrameBytes)
  DefaultHomePowerPlantConnection->>Listener: onAnswerReceived(event)
  DefaultHomePowerPlantConnection->>AESCipher: decrypt(encryptedAnswerFrameBytes)
  DefaultHomePowerPlantConnection->>Listener: onAnswerDecrypted(event)
  DefaultHomePowerPlantConnection->>FrameParser: parseRSCPFrame(decryptedAnswerBytes)
  DefaultHomePowerPlantConnection->>Listener: onAnswerParsed(event)
```

### FrameConverter

Each service offers the possibility to set its own `FrameConverter` instances. The builders offer corresponding functions here.

A `FrameConverter` reads a response frame from the home power plant and converts it into a corresponding logical object. The service API already provides corresponding converters.
Normally you don't need to do anything here. But if you want to influence the conversion process, you can create your own converter and set it as constructor parameter or via one of the builders.

Here is an example how to set your own converter at the `InfoService`:

=== "Kotlin"
    ```kotlin
    import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
    import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.InfoTag
    import de.jnkconsulting.e3dc.easyrscp.api.service.model.ProductionDate
    import de.jnkconsulting.e3dc.easyrscp.api.service.model.SystemInfo
    import de.jnkconsulting.e3dc.easyrscp.service.builder.ConnectionBuilder
    import de.jnkconsulting.e3dc.easyrscp.service.builder.InfoServiceBuilder
    import de.jnkconsulting.e3dc.easyrscp.service.converter.FrameConverter
    
    class CustomConverter: FrameConverter<SystemInfo> {
        override fun invoke(frame: Frame) =
            SystemInfo(
                serialNumber = frame.stringByTag(InfoTag.SERIAL_NUMBER),
                softwareVersion = frame.stringByTag(InfoTag.SW_RELEASE),
                productionDate = ProductionDate(frame.stringByTag(InfoTag.PRODUCTION_DATE)),
        )
    }
    
    fun main() {
        val connectionBuilder = ConnectionBuilder()
            .withAddress(host)
            .withPortalUser(portalUser)
            .withPortalPassword(portalPassword)
            .withRSCPPassword(rscpPassword)
        
        val builder = InfoServiceBuilder()
            .withConnectionBuilder(connectionBuilder)
            .withSystemInfoFrameConverter(CustomConverter())
    }
    ```
=== "Java"
    ```java
    import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame;
    import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.InfoTag;
    import de.jnkconsulting.e3dc.easyrscp.api.service.InfoService;
    import de.jnkconsulting.e3dc.easyrscp.api.service.model.ProductionDate;
    import de.jnkconsulting.e3dc.easyrscp.api.service.model.SystemInfo;
    import de.jnkconsulting.e3dc.easyrscp.service.builder.ConnectionBuilder;
    import de.jnkconsulting.e3dc.easyrscp.service.builder.InfoServiceBuilder;
    import de.jnkconsulting.e3dc.easyrscp.service.converter.FrameConverter;
    
    public class CustomConverter implements FrameConverter<SystemInfo> {
    
        @Override
        public SystemInfo invoke(Frame frame) {
            String serialNumber = frame.stringByTag(InfoTag.SERIAL_NUMBER);
            String softwareVersion = frame.stringByTag(InfoTag.SW_RELEASE);
            ProductionDate productionDate = new ProductionDate(frame.stringByTag(InfoTag.PRODUCTION_DATE));
            return new SystemInfo(serialNumber, softwareVersion, productionDate);
        }
    
        private static String host = ...;
        private static String portalUser = ...;
        private static String portalPassword = ...;
        private static String rscpPassword = ...;
    
        public static void main(String[] args) {
            ConnectionBuilder connectionBuilder = new ConnectionBuilder()
                .withAddress(host)
                .withPortalUser(portalUser)
                .withPortalPassword(portalPassword)
                .withRSCPPassword(rscpPassword);
    
            InfoServiceBuilder infoServiceBuilder = new InfoServiceBuilder()
                .withConnectionBuilder(connectionBuilder)
                .withSystemInfoFrameConverter(new CustomConverter());    
        }
    }    
    ```

### FrameCreator

Each service offers the possibility to set its own `FrameCreator` instances. The builders offer corresponding functions here.

A `FrameCreator` creates request frames that are sent to the home power plant. The service API already provides corresponding creators.
Normally you don't need to do anything here. But if you want to influence the creation process, you can create your own creator and set it as constructor parameter or via one of the builders.

Here is an example of how to set your own creator on the `InfoService`:

=== "Kotlin"
    ```kotlin
    import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.InfoTag
    import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
    import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
    import de.jnkconsulting.e3dc.easyrscp.service.builder.ConnectionBuilder
    import de.jnkconsulting.e3dc.easyrscp.service.builder.InfoServiceBuilder
    import de.jnkconsulting.e3dc.easyrscp.service.creator.FrameCreator
    
    class CustomCreator: FrameCreator<Nothing?> {
        override fun invoke(param: Nothing?) =
            FrameBuilder()
                .addData(
                    DataBuilder().tag(InfoTag.REQ_MAC_ADDRESS).none().build(),
                    DataBuilder().tag(InfoTag.REQ_PRODUCTION_DATE).none().build(),
                    DataBuilder().tag(InfoTag.REQ_SERIAL_NUMBER).none().build(),
                    DataBuilder().tag(InfoTag.REQ_SW_RELEASE).none().build()
                )
                .build()
    }
    
    fun main() {
        val connectionBuilder = ConnectionBuilder()
            .withAddress(host)
            .withPortalUser(portalUser)
            .withPortalPassword(portalPassword)
            .withRSCPPassword(rscpPassword)
    
        val builder = InfoServiceBuilder()
            .withConnectionBuilder(connectionBuilder)
            .withRequestReadSystemInfoCreator(CustomCreator())
    }
    ```
=== "Java"
    ```java
    import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame;
    import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.InfoTag;
    import de.jnkconsulting.e3dc.easyrscp.api.service.InfoService;
    import de.jnkconsulting.e3dc.easyrscp.api.service.model.SystemInfo;
    import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder;
    import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder;
    import de.jnkconsulting.e3dc.easyrscp.service.builder.ConnectionBuilder;
    import de.jnkconsulting.e3dc.easyrscp.service.builder.InfoServiceBuilder;
    import de.jnkconsulting.e3dc.easyrscp.service.creator.FrameCreator;
    
    public class CustomCreator implements FrameCreator<Void> {
    
        @Override
        public Frame invoke(Void unused) {
            return new FrameBuilder()
                .addData(
                    new DataBuilder().tag(InfoTag.REQ_MAC_ADDRESS).none().build(),
                    new DataBuilder().tag(InfoTag.REQ_PRODUCTION_DATE).none().build(),
                    new DataBuilder().tag(InfoTag.REQ_SERIAL_NUMBER).none().build(),
                    new DataBuilder().tag(InfoTag.REQ_SW_RELEASE).none().build()
                )
                .build();
        }
    
        private static String host = ...;
        private static String portalUser = ...;
        private static String portalPassword = ...;
        private static String rscpPassword = ...;
    
        public static void main(String[] args) {
            ConnectionBuilder connectionBuilder = new ConnectionBuilder()
                .withAddress(host)
                .withPortalUser(portalUser)
                .withPortalPassword(portalPassword)
                .withRSCPPassword(rscpPassword);
    
            InfoServiceBuilder infoServiceBuilder = new InfoServiceBuilder()
                .withConnectionBuilder(connectionBuilder)
                .withRequestReadSystemInfoCreator(new CustomCreator());
        }
    }    
    ```
