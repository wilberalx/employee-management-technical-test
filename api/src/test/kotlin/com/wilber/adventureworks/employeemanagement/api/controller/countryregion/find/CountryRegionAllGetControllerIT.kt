package com.wilber.adventureworks.employeemanagement.api.controller.countryregion.find

import com.wilber.adventureworks.employeemanagement.api.controller.shared.SpringIntegrationTest
import org.hamcrest.Matchers.greaterThanOrEqualTo
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.get

class CountryRegionAllGetControllerIT : SpringIntegrationTest() {

    @Sql(
        scripts = ["/sql/test-country-region.sql"],
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Rollback
    @Test
    fun getAllCountryRegionsShouldReturnListOfCountryRegions() {
        mockMvc.get("/api/country-region") {
            accept = MediaType.APPLICATION_JSON
        }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$") { isArray() }
                jsonPath("$.length()") { greaterThanOrEqualTo(0) }
                jsonPath("$[0].countryRegionCode") { exists() }
                jsonPath("$[0].name") { exists() }
            }
    }

}
