package de.jnkconsulting.e3dc.easyrscp.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable

class DefaultBatteryServiceTest: IntegrationTestBase() {

    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `read battery spec`() {
        val toTest = DefaultBatteryService(connectionPool)
        val result = toTest.readSpecification()
        println(result)
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `read battery status`() {
        val toTest = DefaultBatteryService(connectionPool)
        val result = toTest.readMonitoringData()
        println(result)
    }
}
