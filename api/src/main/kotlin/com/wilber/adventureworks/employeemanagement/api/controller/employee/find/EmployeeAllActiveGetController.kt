package com.wilber.adventureworks.employeemanagement.api.controller.employee.find

import com.wilber.adventureworks.employeemanagement.api.controller.employee.dto.EmployeeSummaryJson
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.find.EmployeeFindAllActiveFinder
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Employee Management", description = "Endpoints for managing employee")
@RestController
@RequestMapping(
    value = ["/api/employee"],
    produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
)
class EmployeeAllActiveGetController(
    private val employeeFindAllActiveFinder: EmployeeFindAllActiveFinder
) {

    @Operation(summary = "Get all active employees")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Active employees list"),
            ApiResponse(responseCode = "500", description = "Server error")
        ]
    )
    @GetMapping(value = ["/active"])
    @Transactional(readOnly = true)
    fun index(): ResponseEntity<List<EmployeeSummaryJson>> {

        val employee = employeeFindAllActiveFinder.find().map { EmployeeSummaryJson(it) }

        return ResponseEntity.ok(employee)
    }

}
