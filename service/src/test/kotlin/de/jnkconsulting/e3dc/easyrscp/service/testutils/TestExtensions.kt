package de.jnkconsulting.e3dc.easyrscp.service.testutils

import de.jnkconsulting.e3dc.easyrscp.api.frame.DataType
import de.jnkconsulting.e3dc.easyrscp.api.frame.Frame
import de.jnkconsulting.e3dc.easyrscp.api.frame.Tag
import org.junit.jupiter.api.Assertions

fun Frame.assertHasDataWithType(tag: Tag, expectedType: DataType, expectedValue: String? = null, vararg path: Tag) {
    val foundData = dataByTag(tag, *path)
    Assertions.assertNotNull(foundData, "Tag $tag (path=$path) not found")
    Assertions.assertEquals(expectedType, foundData!!.typeObject(), "DataBlock with $tag (path=$path) has a different type. Expected: $expectedType, Found: ${foundData.typeObject()}")
    if (expectedValue != null) {
        Assertions.assertEquals(expectedValue, foundData.valueAsString(), "DataBlock with $tag (path=$path) has a different value. Expected: $expectedValue, Found: ${foundData.valueAsString()}")
    }
}
