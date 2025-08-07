package com.wilber.adventureworks.employeemanagement.api.controller.shift.find

import com.wilber.adventureworks.employeemanagement.api.controller.shared.SpringIntegrationTest
import org.hamcrest.Matchers.greaterThanOrEqualTo
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.get

class ShiftAllGetControllerIT : SpringIntegrationTest() {

    @Sql(
        scripts = ["/sql/test-shift.sql"],
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Rollback
    @Test
    fun getAllShiftsShouldReturnListOfShifts() {
        mockMvc.get("/api/shift") {
            accept = MediaType.APPLICATION_JSON
        }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$") { isArray() }
                jsonPath("$.length()") { greaterThanOrEqualTo(1) }
                jsonPath("$[0].shiftId") { exists() }
                jsonPath("$[0].name") { exists() }
            }
    }

}
