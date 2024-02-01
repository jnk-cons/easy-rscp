package de.jnkconsulting.e3dc.easyrscp.service

import de.jnkconsulting.e3dc.easyrscp.api.frame.tags.EPTag
import de.jnkconsulting.e3dc.easyrscp.frame.DataBuilder
import de.jnkconsulting.e3dc.easyrscp.frame.FrameBuilder
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable

class DefaultEmergencyPowerServiceTest: IntegrationTestBase() {

//    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `request read state`() {
        val service = DefaultEmergencyPowerService(connectionPool)
        val result = service.readState()
        println(result)
    }

//    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `set power reserve percentage`() {
        val service = DefaultEmergencyPowerService(connectionPool)
        val result = service.setReservePercentage(0.1f)
        println(result)
    }

    //    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `remove power reserve`() {
        val service = DefaultEmergencyPowerService(connectionPool)
        val result = service.removeReserve()
        println(result)
    }

//    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `set power reserve wh`() {
        val service = DefaultEmergencyPowerService(connectionPool)
        val result = service.setReserveWH(900f)
        println(result)
    }

//    @Test
    @EnabledIfEnvironmentVariable(named = "E3DC_HOST", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_USER", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "RSCP_PASSWORD", matches = ".*\\S+.*")
    @EnabledIfEnvironmentVariable(named = "E3DC_PORTAL_PASSWORD", matches = ".*\\S+.*")
    fun `request tester`() {
        connectionPool.executeAndRelease {
            val request = FrameBuilder()
                .addData(
                    DataBuilder().tag(EPTag.REQ_SET_EP_RESERVE).container(
                        DataBuilder().tag(EPTag.PARAM_INDEX).uint32(0).build(),
                        DataBuilder().tag(EPTag.PARAM_EP_RESERVE).float32(10f).build()
                    ).build()
                ).build()
            it.send(request)
        }
    }
}
