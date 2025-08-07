package com.wilber.adventureworks.employeemanagement.api.controller.employee.create

import com.wilber.adventureworks.employeemanagement.api.controller.employee.dto.EmployeeSummaryJson
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.create.EmployeeCreator
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.dto.EmployeeRequest
import com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.create.EmployeeDepartmentHistoryCreator
import com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.dto.EmployeeDepartmentHistoryRequest
import com.wilber.adventureworks.employeemanagement.application.person.address.create.AddressCreator
import com.wilber.adventureworks.employeemanagement.application.person.address.dto.AddressRequest
import com.wilber.adventureworks.employeemanagement.application.person.businessentityaddress.create.BusinessEntityAddressCreator
import com.wilber.adventureworks.employeemanagement.application.person.emailaddress.create.EmailAddressCreator
import com.wilber.adventureworks.employeemanagement.application.person.person.create.PersonCreator
import com.wilber.adventureworks.employeemanagement.application.person.person.dto.PersonRequest
import com.wilber.adventureworks.employeemanagement.application.person.personphone.create.PersonPhoneCreator
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@Tag(name = "Employee Management", description = "Endpoints for managing employees")
@RestController
@RequestMapping(
    value = ["/api/employee"],
    produces = [MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE]
)
class EmployeeCreatePostController(
    private val personCreator: PersonCreator,
    private val addressCreator: AddressCreator,
    private val businessEntityAddressCreator: BusinessEntityAddressCreator,
    private val emailAddressCreator: EmailAddressCreator,
    private val personPhoneCreator: PersonPhoneCreator,
    private val employeeCreator: EmployeeCreator,
    private val employeeDepartmentHistoryCreator: EmployeeDepartmentHistoryCreator
) {

    @Operation(summary = "Create a new Employee")
    @ApiResponses(
        value = [
            ApiResponse(responseCode = "201", description = "Employee created businessEntityId"),
            ApiResponse(responseCode = "500", description = "Server error")
        ]
    )
    @PostMapping(value = ["/", ""])
    @Transactional(rollbackFor = [RuntimeException::class])
    fun index(
        @RequestBody(required = true) employeeSummaryJson: EmployeeSummaryJson
    ): ResponseEntity<Int> {

        employeeSummaryJson.businessEntityId = addPerson(employeeSummaryJson)
        addAddress(employeeSummaryJson)
        emailAddressCreator.create(employeeSummaryJson.businessEntityId, employeeSummaryJson.emailAddress)
        personPhoneCreator.create(employeeSummaryJson.businessEntityId, employeeSummaryJson.phoneNumber)
        addEmployee(employeeSummaryJson)
        addEmployeeDepartment(employeeSummaryJson)

        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(1)
    }

    private fun addPerson(employee: EmployeeSummaryJson): Int {
        val personRequest = PersonRequest(
            employee.firstName,
            employee.middleName,
            employee.lastName
        )
        return personCreator.create(personRequest)
    }

    private fun addAddress(employee: EmployeeSummaryJson) {
        val addressRequest = AddressRequest(
            employee.addressLine1,
            employee.addressLine2,
            employee.city,
            employee.stateProvinceId,
            employee.postalCode
        )
        val addressId = addressCreator.create(addressRequest)
        businessEntityAddressCreator.create(employee.businessEntityId, addressId)
    }

    private fun addEmployee(employee: EmployeeSummaryJson) {
        val employeeRequest = EmployeeRequest(
            employee.businessEntityId,
            employee.jobTitle,
            employee.birthDate
        )
        employeeCreator.create(employeeRequest)
    }

    private fun addEmployeeDepartment(employee: EmployeeSummaryJson) {
        val employeeRequest = EmployeeDepartmentHistoryRequest(
            employee.businessEntityId,
            employee.departmentStartDate,
            employee.departmentId,
            employee.shiftId
        )
        employeeDepartmentHistoryCreator.create(employeeRequest)
    }

}
