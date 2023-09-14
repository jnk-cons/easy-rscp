package de.jnkconsulting.e3dc.easyrscp.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable

class DefaultLiveDataServiceTest: IntegrationTestBase() {

    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `read current power state`() {
        val toTest = DefaultLiveDataService(connectionPool)
        val result = toTest.readPowerState()
        println(result)
    }
}
