package de.jnkconsulting.e3dc.easyrscp.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable
import java.time.LocalDate
import java.time.Year
import java.time.YearMonth

class DefaultInfoServiceTest: IntegrationTestBase() {

    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `read system informations`() {
        val toTest = DefaultInfoService(connectionPool)
        val result = toTest.readSystemInfo()
        println(result)
    }

}
