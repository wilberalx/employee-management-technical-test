package com.wilber.adventureworks.employeemanagement.api.controller.health

import com.wilber.adventureworks.employeemanagement.api.controller.shared.SpringIntegrationTest
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.get

class VersionControllerIT : SpringIntegrationTest() {

    @Test
    fun getVersionShouldReturnConfiguredAppVersion() {
        mockMvc.get("/api/version") {
            accept = MediaType.APPLICATION_JSON
        }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$.version") { value(equalTo("0.0.1-SNAPSHOT")) }
            }
    }

}
