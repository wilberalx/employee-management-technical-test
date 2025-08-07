package com.wilber.adventureworks.employeemanagement.api.controller.salesorderheader.find

import com.wilber.adventureworks.employeemanagement.api.controller.employee.dto.EmployeeSummaryJson
import com.wilber.adventureworks.employeemanagement.api.controller.salesorderheader.dto.SalesOrderHeaderSummaryJson
import com.wilber.adventureworks.employeemanagement.application.sales.salesorderheader.find.SalesOrderHeaderFindByEmployeeAndDateFinder
import com.wilber.adventureworks.employeemanagement.application.sales.salesorderheader.find.SalesOrderHeaderFindLastSaleDateByEmployeeFinder
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
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

@Tag(name = "SalesOrderHeader Management", description = "Endpoints for managing salesOrderHeader")
@RestController
@RequestMapping(
    value = ["/api/sales-order-header"],
    produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
)
class SalesOrderHeaderByEmployeeAndDateGetController(
    private val salesOrderHeaderFindLastSaleDateByEmployeeFinder: SalesOrderHeaderFindLastSaleDateByEmployeeFinder,
    private val salesOrderHeaderFindByEmployeeAndDateFinder: SalesOrderHeaderFindByEmployeeAndDateFinder
) {

    @Operation(summary = "Get an employee's sales by dates")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Employee's sales list"),
            ApiResponse(responseCode = "500", description = "Server error")
        ]
    )
    @PostMapping(value = ["/sales-person/{salesPersonId}"])
    @Transactional(readOnly = true)
    fun index(
        @Parameter(description = "SalesPerson ID", required = true, `in` = ParameterIn.PATH)
        @PathVariable("salesPersonId") salesPersonId: Int,
        @RequestBody(required = true) filterData: SalesOrderHeaderSummaryJson
    ): ResponseEntity<List<SalesOrderHeaderSummaryJson>> {

        val (startDateTime, endDateTime) = if (filterData.loadLastSales) {
            val lastSaleDate = salesOrderHeaderFindLastSaleDateByEmployeeFinder.find(salesPersonId)
                ?: return ResponseEntity.ok(arrayListOf())

            val startDateTime = lastSaleDate.withDayOfMonth(1).toLocalDate().atStartOfDay()
            val endDateTime =
                lastSaleDate.withDayOfMonth(lastSaleDate.toLocalDate().lengthOfMonth()).with(LocalTime.MAX)

            startDateTime to endDateTime
        } else {
            val startDateTime = LocalDateTime.of(filterData.startDate, LocalTime.MIN)
            val endDateTime = LocalDateTime.of(filterData.endDate, LocalTime.MAX)

            startDateTime to endDateTime
        }

        val salesOrderHeader = salesOrderHeaderFindByEmployeeAndDateFinder.find(
            salesPersonId,
            startDateTime,
            endDateTime
        ).map { SalesOrderHeaderSummaryJson(it) }

        return ResponseEntity.ok(salesOrderHeader)
    }

}
