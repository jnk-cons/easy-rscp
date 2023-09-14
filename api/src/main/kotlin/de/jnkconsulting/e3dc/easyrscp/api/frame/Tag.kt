package de.jnkconsulting.e3dc.easyrscp.api.frame

import de.jnkconsulting.e3dc.easyrscp.api.bytes.fromHexString

/**
 * Definition of a tag to use it in a [Data] block
 *
 * @since 2.0
 */
interface Tag {
    /**
     * Namespace defined by E3DC in which this tag is used.
     */
    val namespace: Namespace

    /**
     * Encoding of the tag in hex string format with 0x as prefix. For example 0x03040000
     */
    val hex: String

    /**
     * Data type used in the context of this tag in a [Data] block.
     */
    val type: DataType

    /**
     * Human-readable name of the tag. Defined by E3DC.
     *
     * The name corresponds to the E3DC definition WITHOUT the prefix TAG_ and WITHOUT the namespace abbreviation,
     * since these two pieces of information are already apparent from the context
     */
    val name: String
}

/**
 * Auxiliary class to represent unknown [Tag]s that were not known at compile time but can still be sent and received
 *
 * The [namespace] is tried to be determined. If this is also unknown, [Namespace.UNKNOWN] is always returned for the [namespace] property.
 * For the [type] property, [DataType.UNKNOWN] is always supplied.
 * The fixed string UNKNWON is supplied as [name].
 *
 * @since 2.0
 */
data class UnknownTag(override val hex: String) : Tag {

    override val namespace: Namespace
        get() = hex
            .fromHexString()[0]
            .let { Namespace.byCode(it) }

    override val type: DataType
        get() = DataType.UNKNOWN

    override val name: String
        get() = "UNKNOWN"

}

