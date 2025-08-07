package com.wilber.adventureworks.employeemanagement.api.controller.department.find

import com.wilber.adventureworks.employeemanagement.api.controller.shared.SpringIntegrationTest
import org.hamcrest.Matchers.greaterThanOrEqualTo
import org.junit.jupiter.api.Test
import org.springframework.http.MediaType
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.get

class DepartmentAllGetControllerIT : SpringIntegrationTest() {

    @Sql(
        scripts = ["/sql/test-department.sql"],
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Rollback
    @Test
    fun getAllDepartmentsShouldReturnListOfDepartments() {
        mockMvc.get("/api/department") {
            accept = MediaType.APPLICATION_JSON
        }
            .andExpect {
                status { isOk() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$") { isArray() }
                jsonPath("$.length()") { greaterThanOrEqualTo(0) }
                jsonPath("$[0].departmentId") { exists() }
                jsonPath("$[0].name") { exists() }
            }
    }

}
