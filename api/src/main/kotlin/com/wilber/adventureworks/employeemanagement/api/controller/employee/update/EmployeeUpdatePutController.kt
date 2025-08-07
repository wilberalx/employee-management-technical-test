package com.wilber.adventureworks.employeemanagement.api.controller.employee.update

import com.wilber.adventureworks.employeemanagement.api.controller.employee.dto.EmployeeSummaryJson
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.dto.EmployeeRequest
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.udpate.EmployeeUpdater
import com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.create.EmployeeDepartmentHistoryCreator
import com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.dto.EmployeeDepartmentHistoryRequest
import com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.update.EmployeeDepartmentHistoryCloseCurrentUpdater
import com.wilber.adventureworks.employeemanagement.application.person.address.dto.AddressRequest
import com.wilber.adventureworks.employeemanagement.application.person.address.update.AddressUpdater
import com.wilber.adventureworks.employeemanagement.application.person.businessentity.create.BusinessEntityCreator
import com.wilber.adventureworks.employeemanagement.application.person.emailaddress.update.EmailAddressUpdater
import com.wilber.adventureworks.employeemanagement.application.person.person.dto.PersonRequest
import com.wilber.adventureworks.employeemanagement.application.person.person.update.PersonUpdater
import com.wilber.adventureworks.employeemanagement.application.person.personphone.update.PersonPhoneUpdater
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.enums.ParameterIn
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Employee Management", description = "Endpoints for managing employees")
@RestController
@RequestMapping(
    value = ["/api/employee"],
    produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
)
class EmployeeUpdatePutController(
    private val businessEntityCreator: BusinessEntityCreator,
    private val personUpdater: PersonUpdater,
    private val addressUpdater: AddressUpdater,
    private val emailAddressUpdater: EmailAddressUpdater,
    private val personPhoneUpdater: PersonPhoneUpdater,
    private val employeeUpdater: EmployeeUpdater,
    private val employeeDepartmentHistoryCloseCurrentUpdater: EmployeeDepartmentHistoryCloseCurrentUpdater,
    private val employeeDepartmentHistoryCreator: EmployeeDepartmentHistoryCreator
) {

    @Operation(summary = "Update data of an existing employee record")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "200", description = "Employee created businessEntityId"),
            ApiResponse(responseCode = "404", description = "Entity not found"),
            ApiResponse(responseCode = "500", description = "Server error")
        ]
    )
    @PutMapping(value = ["/{businessEntityId}"])
    @Transactional(rollbackFor = [RuntimeException::class])
    fun index(
        @Parameter(description = "BusinessEntity ID", required = true, `in` = ParameterIn.PATH)
        @PathVariable businessEntityId: Int,
        @RequestBody(required = true) employeeSummaryJson: EmployeeSummaryJson
    ): ResponseEntity<Int> {

        employeeSummaryJson.businessEntityId = businessEntityId

        updatePerson(employeeSummaryJson)
        updateAddress(employeeSummaryJson)
        emailAddressUpdater.update(employeeSummaryJson.emailAddressId, employeeSummaryJson.emailAddress)
        personPhoneUpdater.update(employeeSummaryJson.businessEntityId, employeeSummaryJson.phoneNumber)
        updateEmployee(employeeSummaryJson)
        updateEmployeeDepartment(employeeSummaryJson)

        return ResponseEntity
            .status(HttpStatus.OK)
            .body(businessEntityId)
    }

    private fun updatePerson(employee: EmployeeSummaryJson) {
        val personRequest = PersonRequest(
            employee.firstName,
            employee.middleName,
            employee.lastName
        )
        personUpdater.update(employee.businessEntityId, personRequest)
    }

    private fun updateAddress(employee: EmployeeSummaryJson) {
        val addressRequest = AddressRequest(
            employee.addressLine1,
            employee.addressLine2,
            employee.city,
            employee.stateProvinceId,
            employee.postalCode
        )
        addressUpdater.update(employee.addressId, addressRequest)
    }

    private fun updateEmployee(employee: EmployeeSummaryJson) {
        val employeeRequest = EmployeeRequest(
            employee.businessEntityId,
            employee.jobTitle,
            employee.birthDate
        )
        employeeUpdater.update(employeeRequest)
    }

    private fun updateEmployeeDepartment(employee: EmployeeSummaryJson) {
        val employeeRequest = EmployeeDepartmentHistoryRequest(
            employee.businessEntityId,
            employee.departmentStartDate,
            employee.departmentId,
            employee.shiftId
        )
        val closedCurrent = employeeDepartmentHistoryCloseCurrentUpdater.update(employeeRequest)
        if (closedCurrent) {
            employeeDepartmentHistoryCreator.create(employeeRequest)
        }
    }

}
