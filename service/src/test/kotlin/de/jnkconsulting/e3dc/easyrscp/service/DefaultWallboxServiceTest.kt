package de.jnkconsulting.e3dc.easyrscp.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable

class DefaultWallboxServiceTest: IntegrationTestBase() {


//    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `read connected wallboxes`() {
        val toTest = DefaultWallboxService(connectionPool)
        val result = toTest.readConnectedWallboxes()
        println(result)
    }

//    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `read live data`() {
        val toTest = DefaultWallboxService(connectionPool)
        val result = toTest.readPowerState(0)
        println(result)
    }
}
