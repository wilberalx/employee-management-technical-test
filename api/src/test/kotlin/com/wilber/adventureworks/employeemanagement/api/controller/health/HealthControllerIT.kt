package com.wilber.adventureworks.employeemanagement.api.controller.health

import com.wilber.adventureworks.employeemanagement.api.controller.shared.SpringIntegrationTest
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.get

class HealthControllerIT : SpringIntegrationTest() {

    @Test
    fun shouldReturnApiHealthStatusUp() {
        mockMvc.get("/api/health") {
            accept = MediaType.APPLICATION_JSON
        }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.status") { value("UP") }
            }
    }

}
