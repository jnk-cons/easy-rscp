package de.jnkconsulting.e3dc.easyrscp.service.converter

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.RSCPTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.Instant

class StringFrameConverterTest {
    private val timestamp = Instant.parse("2024-02-25T15:30:00.00Z")

    @Test
    fun `test conversion with omited values`() {
        val frame = FrameBuilder()
            .timestamp(timestamp)
            .addData(
                DataBuilder().tag(RSCPTag.AUTHENTICATION).container(
                    DataBuilder().tag(RSCPTag.AUTHENTICATION_USER).string("user").build(),
                    DataBuilder().tag(RSCPTag.REQ_SET_ENCRYPTION_PASSPHRASE).string("password").build()
                ).build(),
            )
            .build()

        val toTest = StringFrameConverter(omitAuthenticationCredentials = true)
        val result = toTest.invoke(frame)

        assertEquals("Timestamp:\t2024-02-25T15:30:00Z\n" +
                "WithChecksum:\ttrue\n" +
                "\tTag:\tRSCP.AUTHENTICATION - 00800001\n" +
                "\tType:\tCONTAINER - 0e\n" +
                "\t\tTag:\tRSCP.AUTHENTICATION_USER - 00000002\n" +
                "\t\tType:\tSTRING - 0d\n" +
                "\t\tValue:\t*** - ***\n\n" +
                "\t\tTag:\tRSCP.REQ_SET_ENCRYPTION_PASSPHRASE - 00000005\n" +
                "\t\tType:\tSTRING - 0d\n" +
                "\t\tValue:\t*** - ***\n\n", result)
    }

    @Test
    fun `test conversion with clear text values`() {
        val frame = FrameBuilder()
            .timestamp(timestamp)
            .addData(
                DataBuilder().tag(RSCPTag.AUTHENTICATION).container(
                    DataBuilder().tag(RSCPTag.AUTHENTICATION_USER).string("user").build(),
                    DataBuilder().tag(RSCPTag.REQ_SET_ENCRYPTION_PASSPHRASE).string("password").build()
                ).build(),
            )
            .build()

        val toTest = StringFrameConverter(omitAuthenticationCredentials = false)
        val result = toTest.invoke(frame)

        assertEquals("Timestamp:\t2024-02-25T15:30:00Z\n" +
                "WithChecksum:\ttrue\n" +
                "\tTag:\tRSCP.AUTHENTICATION - 00800001\n" +
                "\tType:\tCONTAINER - 0e\n" +
                "\t\tTag:\tRSCP.AUTHENTICATION_USER - 00000002\n" +
                "\t\tType:\tSTRING - 0d\n" +
                "\t\tValue:\tuser - 75736572\n\n" +
                "\t\tTag:\tRSCP.REQ_SET_ENCRYPTION_PASSPHRASE - 00000005\n" +
                "\t\tType:\tSTRING - 0d\n" +
                "\t\tValue:\tpassword - 70617373776f7264\n\n", result)
    }
}
