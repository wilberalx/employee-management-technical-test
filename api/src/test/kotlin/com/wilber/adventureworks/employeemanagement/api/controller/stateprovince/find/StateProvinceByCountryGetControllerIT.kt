package com.wilber.adventureworks.employeemanagement.api.controller.stateprovince.find

import com.wilber.adventureworks.employeemanagement.api.controller.shared.SpringIntegrationTest
import org.hamcrest.Matchers.greaterThanOrEqualTo
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.get

class StateProvinceByCountryGetControllerIT : SpringIntegrationTest() {

    @Sql(
        scripts = [
            "/sql/test-country-region.sql",
            "/sql/test-state-province.sql"
        ],
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Rollback
    @Test
    fun getStateProvincesByCountryCodeShouldReturnList() {
        val countryCode = "XX"

        mockMvc.get("/api/country/$countryCode/state-province") {
            accept = MediaType.APPLICATION_JSON
        }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$") { isArray() }
                jsonPath("$.length()") { greaterThanOrEqualTo(1) }
                jsonPath("$[0].stateProvinceId") { exists() }
                jsonPath("$[0].name") { exists() }
            }
    }

}
