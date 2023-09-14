package de.jnkconsulting.e3dc.easyrscp.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable
import java.time.LocalDate
import java.time.Year
import java.time.YearMonth

class DefaultDBServiceTest: IntegrationTestBase() {

    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `read daily summary`() {
        val toTest = DefaultDBSummaryService(connectionPool)
        val result = toTest.readDailySummary(LocalDate.now().minusDays(1))
        println(result)
    }

//    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `read monthly summary`() {
        val toTest = DefaultDBSummaryService(connectionPool)
        val result = toTest.readMonthlySummary(YearMonth.now().minusMonths(1))
        println(result)
    }

//    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `read yearly summary`() {
        val toTest = DefaultDBSummaryService(connectionPool)
        val result = toTest.readYearlySummary(Year.now().minusYears(1))
        println(result)
    }
}
