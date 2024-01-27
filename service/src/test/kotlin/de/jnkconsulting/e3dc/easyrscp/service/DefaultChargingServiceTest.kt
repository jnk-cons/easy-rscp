package de.jnkconsulting.e3dc.easyrscp.service

import de.jnkconsulting.e3dc.easyrscp.api.service.model.ChargingLimits
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable

class DefaultChargingServiceTest: IntegrationTestBase() {

//    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `read charging config`() {
        val toTest = DefaultChargingService(connectionPool)
        val result = toTest.readConfiguration()
        println(result)
    }

//     @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `write charging config`() {
        val toTest = DefaultChargingService(connectionPool)
        val limits = ChargingLimits(
            maxCurrentChargingPower = 2000,
            maxCurrentDischargingPower = 3000,
            dischargeStartPower = 70,
            chargingLimitationsEnabled = true,
        )
        val result = toTest.writeLimits(limits)
        println(result)
    }

//    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `read manual charging state`() {
        val toTest = DefaultChargingService(connectionPool)
        val result = toTest.readManualChargeState()
        println(result)
    }

//    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `start manual charging`() {
        val toTest = DefaultChargingService(connectionPool)
        val result = toTest.startManualCharge(0)
        println(result)
    }

    //    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `stop manual charging`() {
        val toTest = DefaultChargingService(connectionPool)
        val result = toTest.stopManualCharge()
        println(result)
    }
}
