package com.wilber.adventureworks.employeemanagement.api.controller.countryregion.find

import com.wilber.adventureworks.employeemanagement.api.controller.countryregion.dto.CountryRegionJson
import com.wilber.adventureworks.employeemanagement.application.person.countryregion.find.CountryRegionFindAllFinder
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

@Tag(name = "Country Management", description = "Endpoints for managing country")
@RestController
@RequestMapping(
    value = ["/api/country-region"],
    produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
)
class CountryRegionAllGetController(
    private val countryRegionFindAllFinder: CountryRegionFindAllFinder
) {

    @Operation(summary = "Get all countries")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Countries list"),
            ApiResponse(responseCode = "500", description = "Server error")
        ]
    )
    @GetMapping(value = ["/", ""])
    @Transactional(readOnly = true)
    fun index(): ResponseEntity<List<CountryRegionJson>> {

        val countries = countryRegionFindAllFinder.find().map { CountryRegionJson(it) }

        return ResponseEntity.ok(countries)
    }

}
