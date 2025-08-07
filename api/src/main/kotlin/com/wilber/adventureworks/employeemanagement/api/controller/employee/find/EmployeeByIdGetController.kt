package com.wilber.adventureworks.employeemanagement.api.controller.employee.find

import com.wilber.adventureworks.employeemanagement.api.controller.employee.dto.EmployeeSummaryJson
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.find.EmployeeFindByIdFinder
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Employee Management", description = "Endpoints for managing employee")
@RestController
@RequestMapping(
    value = ["/api/employee"],
    produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
)
class EmployeeByIdGetController(
    private val employeeFindByIdFinder: EmployeeFindByIdFinder
) {

    @Operation(summary = "Get employee by businessEntityId")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Employee data"),
            ApiResponse(responseCode = "404", description = "Employee not found"),
            ApiResponse(responseCode = "500", description = "Server error")
        ]
    )
    @GetMapping(value = ["/{businessEntityId}"])
    @Transactional(readOnly = true)
    fun index(
        @Parameter(description = "BusinessEntity ID", required = false, `in` = ParameterIn.QUERY)
        @PathVariable("businessEntityId") businessEntityId: Int
    ): ResponseEntity<EmployeeSummaryJson> {

        val employee = employeeFindByIdFinder.find(businessEntityId)

        return ResponseEntity.ok(EmployeeSummaryJson(employee))
    }

}
