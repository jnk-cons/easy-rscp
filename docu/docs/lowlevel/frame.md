Frames are used to send requests to the home power plant. The home power plant also responds in frames. 
Each frame consists of a series (at least one) of data blocks. The type of a block is determined by so-called tags.

## Tags
Tags describe the type of a data block. They tell whether the contained value is a number or a text, and whether it is, for example, the current PV prodction or a load limit.

The tags I know are located as enum classes in the package [`de.jnkconsulting.e3dc.easyrscp.api.frame.tags`](../kdoc/easy-rscp/de.jnkconsulting.e3dc.easyrscp.api.frame.tags/index.html). 
For each namespace defined by E3DC there is a separate enum class.

What exactly the namespaces mean is described in the [RSCP](../rscp/basic-rscp.md) section.

If a tag is needed, either as a request or as a response, which are not defined here in enum classes, an instance of `UnknownTag` can be used. 
The original byte value remains here and can be used accordingly.

## Building frames
The easiest way to create frames is to use the `FrameBuilder` and the `DataBuilder` classes.

???+ warning "Know what you do"

    You must know what you are doing. Neither the `FrameBuilder` nor the `DataBuilder` check if the combination makes any sense!

Here is an example of how to put together a query frame that asks for some live data:

=== "Kotlin"
    ```kotlin
    import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag
    import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
    import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
    import de.jnkconsulting.e3dc.easyrscp.service.converter.StringFrameConverter
    
    fun main() {
        val requestFrame = FrameBuilder()
                .addData(
                    DataBuilder().tag(EMSTag.REQ_POWER_PV).build(),
                    DataBuilder().tag(EMSTag.REQ_POWER_BAT).build(),
                    DataBuilder().tag(EMSTag.REQ_POWER_GRID).build(),
                    DataBuilder().tag(EMSTag.REQ_POWER_HOME).build(),
                    DataBuilder().tag(EMSTag.REQ_BAT_SOC).build(),
                ).build()
    
        println(StringFrameConverter().invoke(requestFrame))
    }
    ```
=== "Java"
    ```java
    import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame;
    import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag;
    import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder;
    import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder;
    import de.jnkconsulting.e3dc.easyrscp.service.converter.StringFrameConverter;
    
    public class FrameExamples {
        public static void main(String[] args) {
            Frame requestFrame =  new FrameBuilder()
                .addData(
                    new DataBuilder().tag(EMSTag.REQ_POWER_PV).build(),
                    new DataBuilder().tag(EMSTag.REQ_POWER_BAT).build(),
                    new DataBuilder().tag(EMSTag.REQ_POWER_GRID).build(),
                    new DataBuilder().tag(EMSTag.REQ_POWER_HOME).build(),
                    new DataBuilder().tag(EMSTag.REQ_BAT_SOC).build()
                ).build();
    
            System.out.println(new StringFrameConverter().invoke(requestFrame));
        }
    }
    ```
=== "TypeScript"
    ```java
    import {FrameBuilder, DataBuilder, StringFrameConverter, EMSTag} from 'easy-rscp';
    
    const request = new FrameBuilder()
        .addData(
            new DataBuilder().tag(EMSTag.REQ_POWER_PV).build(),
            new DataBuilder().tag(EMSTag.REQ_POWER_BAT).build(),
            new DataBuilder().tag(EMSTag.REQ_POWER_GRID).build(),
            new DataBuilder().tag(EMSTag.REQ_POWER_HOME).build(),
            new DataBuilder().tag(EMSTag.REQ_BAT_SOC).build()
        ).build();
    console.log(new StringFrameConverter().convert(requestFrame));
    ```

The output should look something like this:

```text
Timestamp:	2023-09-19T20:32:43.305569Z
WithChecksum:	true
	Tag:	EMS.REQ_POWER_PV - 01000001
	Type:	NONE - 00
	Value:	[NONE] - 
	Tag:	EMS.REQ_POWER_BAT - 01000002
	Type:	NONE - 00
	Value:	[NONE] - 
	Tag:	EMS.REQ_POWER_GRID - 01000004
	Type:	NONE - 00
	Value:	[NONE] - 
	Tag:	EMS.REQ_POWER_HOME - 01000003
	Type:	NONE - 00
	Value:	[NONE] - 
	Tag:	EMS.REQ_BAT_SOC - 01000008
	Type:	NONE - 00
	Value:	[NONE] - 
```

## Reading frames
Reading data from a frame can be complex. Theoretically, a frame can contain data blocks of type `container`. So, blocks that contain other blocks.
To make it as comfortable as possible to access the individual values, the frame class provides various functions to access the contents in any depth.
For this purpose different `xxxByTag` functions are available. The functions search for a specific data block with the given tag. There is an additional vararg parameter,
which maps the path through possibly existing containers.

Here is an example to read the house consumption of a certain day. For this, a request was made to the home power plant database.
In response, a frame with a nested structure is provided. The searched value is in the following structure:

```text
DBTag.HISTORY_DATA_DAY -> DBTag.SUM_CONTAINER -> DBTag.CONSUMPTION
```
`DBTag.HISTORY_DATA_DAY` and `DBTag.SUM_CONTAINER` are data blocks of type `container`. `DBTag.CONSUMPTION` contains a float value indicating the total house consumption of the day.

This value can be accessed as follows:

=== "Kotlin"
    ```kotlin
    val answerFrame: Frame = ...
    val consumption = answerFrame.floatByTag(
            DBTag.CONSUMPTION, 
            DBTag.HISTORY_DATA_DAY, DBTag.SUM_CONTAINER)
    ```
=== "Java"
    ```java
    Frame answerFrame = ...;
    float consumption = amswerFrame.floatByTag(
            DBTag.CONSUMPTION, 
            DBTag.HISTORY_DATA_DAY, DBTag.SUM_CONTAINER);
    ```
=== "TypeScript"
    ```typescript
    import {Frame, DBTag} from 'easy-rscp';

    const answerFrame: Frame = ...
    const consumption = answerFrame.floatByTag(
        DBTag.CONSUMPTION, 
        DBTag.HISTORY_DATA_DAY, DBTag.SUM_CONTAINER)
    ```

The various `xxxByTag` usually always return a value. If the corresponding tag is not found, a default value is returned (For numeric values 0, for string "" etc.).

The `xxxByTag` methods have their limit when a container contains several data blocks of the same type. This happens quite rarely (in database queries for example). But if it does, then you have to access manually according to the content.
