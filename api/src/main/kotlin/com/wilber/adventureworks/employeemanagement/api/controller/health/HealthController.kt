package com.wilber.adventureworks.employeemanagement.api.controller.health

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/health")
@Tag(name = "Health", description = "API status check")
class HealthController {

    @GetMapping
    @Operation(summary = "Health check", description = "Returns the status of the API")
    fun checkHealth(): Map<String, String> {
        return mapOf("status" to "UP")
    }

}
