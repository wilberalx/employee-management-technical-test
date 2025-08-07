package com.wilber.adventureworks.employeemanagement.api.controller.shift.find

import com.wilber.adventureworks.employeemanagement.api.controller.shift.dto.ShiftJson
import com.wilber.adventureworks.employeemanagement.application.humanresources.shift.find.ShiftFindAllFinder
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

@Tag(name = "Shift Management", description = "Endpoints for managing shift")
@RestController
@RequestMapping(
    value = ["/api/shift"],
    produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
)
class ShiftAllGetController(
    private val shiftFindAllFinder: ShiftFindAllFinder
) {

    @Operation(summary = "Get all shifts")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Shifts list"),
            ApiResponse(responseCode = "500", description = "Server error")
        ]
    )
    @GetMapping(value = ["/", ""])
    @Transactional(readOnly = true)
    fun index(): ResponseEntity<List<ShiftJson>> {

        val shifts = shiftFindAllFinder.find().map { ShiftJson(it) }

        return ResponseEntity.ok(shifts)
    }

}
