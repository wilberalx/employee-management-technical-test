package com.wilber.adventureworks.employeemanagement.api.controller.employee.delete

import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.delete.EmployeeDeleter
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Employee Management", description = "Endpoints for managing employees")
@RestController
@RequestMapping(
    value = ["/api/employee"],
    produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
)
class EmployeeDeleteController(
    private val warehouseDeleter: EmployeeDeleter
) {

    @Operation(summary = "Delete an existing employee")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Employee deleted id"),
            ApiResponse(responseCode = "404", description = "Employee not found"),
            ApiResponse(responseCode = "500", description = "Server error")
        ]
    )
    @DeleteMapping(value = ["/{businessEntityId}"])
    @Transactional(rollbackFor = [RuntimeException::class])
    fun index(
        @Parameter(description = "BusinessEntity ID", required = true, `in` = ParameterIn.PATH)
        @PathVariable businessEntityId: Int
    ): ResponseEntity<Int> {

        warehouseDeleter.delete(businessEntityId)

        return ResponseEntity.ok(businessEntityId)
    }

}
