package com.wilber.adventureworks.employeemanagement.api.controller.stateprovince.find

import com.wilber.adventureworks.employeemanagement.api.controller.stateprovince.dto.StateProvinceJson
import com.wilber.adventureworks.employeemanagement.application.person.stateprovince.find.StateProvinceFindByCountryFinder
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

@Tag(name = "State province Management", description = "Endpoints for managing state province")
@RestController
@RequestMapping(
    value = ["/api/country/{countryCode}/state-province"],
    produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
)
class StateProvinceByCountryGetController(
    private val stateProvinceFindByCountryFinder: StateProvinceFindByCountryFinder
) {

    @Operation(summary = "Get state province by country")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "State provinces list"),
            ApiResponse(responseCode = "500", description = "Server error")
        ]
    )
    @GetMapping(value = ["/", ""])
    @Transactional(readOnly = true)
    fun index(
        @Parameter(description = "Country code", required = true, `in` = ParameterIn.PATH)
        @PathVariable countryCode: String
    ): ResponseEntity<List<StateProvinceJson>> {

        val states = stateProvinceFindByCountryFinder.find(countryCode).map { StateProvinceJson(it) }

        return ResponseEntity.ok(states)
    }

}
