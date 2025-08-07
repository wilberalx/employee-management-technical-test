package com.wilber.adventureworks.employeemanagement.api.controller.health

import com.wilber.adventureworks.employeemanagement.api.controller.config.AppVersionProperties
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/version")
@Tag(name = "Version", description = "API version information")
class VersionController(
    private val appVersionProperties: AppVersionProperties
) {

    @GetMapping
    @Operation(summary = "Get API version", description = "Returns the current version of the API")
    fun getVersion(): Map<String, String> {
        return mapOf("version" to appVersionProperties.version)
    }
}