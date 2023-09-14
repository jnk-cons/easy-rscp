package de.jnkconsulting.e3dc.easyrscp.api.frame

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EMSTag

/**
 * Helper class to read your data block with the tag [EMSTag.GET_SYS_SPECS].
 *
 * @param rawData Data block. Must use the [EMSTag.GET_SYS_SPECS] tag. Otherwise an [IllegalArgumentException] will occur.
 * @param parser Parser to use
 *
 *
 * @since 2.0
 *
 * @see [EMSSysSpecName]
 */
data class SysSpecData(val rawData: Data, val parser: DataParser) {

    init {
        if (rawData.tagObject() != EMSTag.GET_SYS_SPECS) throw IllegalArgumentException("Given frame is not of tag ${EMSTag.GET_SYS_SPECS}")
    }

    /**
     * Returns an Int value to the specified specification block
     *
     * @param spec Specification block
     *
     * @return Int value or null if no value of type Int is found
     *
     * @since 2.0
     */
    fun intValue(spec: EMSSysSpecName) =
        intValue(specName = spec.rscpName)

    /**
     * Returns a String value to the specified specification block
     *
     * @param spec Specification block
     *
     * @return String value or null if no value of type string is found
     *
     * @since 2.0
     */
    fun stringValue(spec: EMSSysSpecName) =
        stringValue(specName = spec.rscpName)

    /**
     * Returns an Int value to the specified specification block
     *
     * @param specName Specification block name
     *
     * @return Int value or null if no value of type Int is found
     *
     * @since 2.0
     */
    fun intValue(specName: String): Int? {
        rawData
            .valueAsContainer(parser)
            .forEach {specContainer ->
                if (specContainer.tagObject() == EMSTag.SYS_SPEC) {
                    var valueData: Data? = null
                    var found = false
                    specContainer.valueAsContainer(parser).forEach { specContainerEntry ->
                        if (specContainerEntry.tagObject() == EMSTag.SYS_SPEC_VALUE_INT) valueData = specContainerEntry
                        if (specContainerEntry.tagObject() == EMSTag.SYS_SPEC_NAME && specName == specContainerEntry.valueAsString()) {
                            found = true
                        }
                    }
                    if (found) return valueData?.valueAsInt()
                }
            }
        return null
    }

    /**
     * Returns a String value to the specified specification block
     *
     * @param specName Specification block name
     *
     * @return String value or null if no value of type string is found
     *
     * @since 2.0
     */
    fun stringValue(specName: String): String? {
        rawData
            .valueAsContainer(parser)
            .forEach {specContainer ->
                if (specContainer.tagObject() == EMSTag.SYS_SPEC) {
                    var valueData: Data? = null
                    var found = false
                    specContainer.valueAsContainer(parser).forEach { specContainerEntry ->
                        if (specContainerEntry.tagObject() == EMSTag.SYS_SPEC_VALUE_STRING) valueData = specContainerEntry
                        if (specContainerEntry.tagObject() == EMSTag.SYS_SPEC_NAME && specName == specContainerEntry.valueAsString()) {
                            found = true
                        }
                    }
                    if (found) return valueData?.valueAsString()
                }
            }
        return null
    }
}
