package com.wilber.adventureworks.employeemanagement.api.controller.department.find

import com.wilber.adventureworks.employeemanagement.api.controller.department.dto.DepartmentJson
import com.wilber.adventureworks.employeemanagement.application.humanresources.department.find.DepartmentFindAllFinder
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

@Tag(name = "Department Management", description = "Endpoints for managing department")
@RestController
@RequestMapping(
    value = ["/api/department"],
    produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
)
class DepartmentAllGetController(
    private val departmentFindAllFinder: DepartmentFindAllFinder
) {

    @Operation(summary = "Get all departments")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Departments list"),
            ApiResponse(responseCode = "500", description = "Server error")
        ]
    )
    @GetMapping(value = ["/", ""])
    @Transactional(readOnly = true)
    fun index(): ResponseEntity<List<DepartmentJson>> {

        val departments = departmentFindAllFinder.find().map { DepartmentJson(it) }

        return ResponseEntity.ok(departments)
    }

}
