package com.wilber.adventureworks.employeemanagement.api.controller.employee.create

import com.wilber.adventureworks.employeemanagement.api.controller.shared.SpringIntegrationTest
import com.fasterxml.jackson.databind.ObjectMapper
import com.wilber.adventureworks.employeemanagement.api.controller.employee.dto.EmployeeSummaryJson
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.test.annotation.Rollback
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.web.servlet.post
import java.time.LocalDate

class EmployeeCreatePostControllerIT : SpringIntegrationTest() {

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Sql(
        scripts = ["/sql/test-employee.sql"],
        executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD
    )
    @Rollback
    @Test
    fun createEmployeeShouldReturnBusinessEntityId() {
        val employeeJson = EmployeeSummaryJson().apply {
            firstName = "John"
            middleName = "Q"
            lastName = "Public"
            jobTitle = "Software Engineer"
            birthDate = LocalDate.of(1990, 1, 1)
            shiftId = 99
            departmentId = 999
            departmentName = "Test Department"
            departmentStartDate = LocalDate.now()
            phoneNumber = "555-1234"
            phoneNumberTypeId = 1  // asume válido
            emailAddress = "john.public@test.com"
            addressLine1 = "123 Test St"
            addressLine2 = "Apt 456"
            city = "Testville"
            postalCode = "12345"
            stateProvinceId = 9999
            stateProvinceName = "Test State"
            countryRegionCode = "TT"
            countryRegionName = "Test Country"
        }

        mockMvc.post("/api/employee") {
            contentType = MediaType.APPLICATION_JSON
            accept = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(employeeJson)
        }
            .andExpect {
                status { isCreated() }
                content { contentType(MediaType.APPLICATION_JSON) }
                jsonPath("$") { isNumber() }
            }
    }

}
