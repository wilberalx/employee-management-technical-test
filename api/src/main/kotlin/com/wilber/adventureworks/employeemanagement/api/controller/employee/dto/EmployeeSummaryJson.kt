package com.wilber.adventureworks.employeemanagement.api.controller.employee.dto

import com.wilber.adventureworks.employeemanagement.domain.dto.humanresources.EmployeeSummary
import java.time.LocalDate

class EmployeeSummaryJson {

    var businessEntityId: Int = 0
    var fullName: String = ""
    var fullAddress: String = ""
    var firstName: String = ""
    var middleName: String? = null
    var lastName: String = ""
    var jobTitle: String = ""
    var birthDate: LocalDate = LocalDate.now()
    var shiftId: Byte = 0
    var departmentId: Short = 0
    var departmentName: String = ""
    var departmentStartDate: LocalDate = LocalDate.now()
    var phoneNumber: String = ""
    var phoneNumberTypeId: Int = 0
    var emailAddressId: Int = 0
    var emailAddress: String = ""
    var addressId: Int = 0
    var addressLine1: String = ""
    var addressLine2: String? = null
    var city: String = ""
    var postalCode: String = ""
    var stateProvinceId: Int = 0
    var stateProvinceName: String = ""
    var countryRegionCode: String = ""
    var countryRegionName: String = ""

    constructor()

    constructor(employee: EmployeeSummary) {
        this.businessEntityId = employee.businessEntityId
        this.fullName = "${employee.firstName} ${employee.middleName ?: ""} ${employee.lastName}"
        this.fullAddress = "${employee.addressLine1} ${employee.stateProvinceName} ${employee.countryRegionName}"
        this.firstName = employee.firstName
        this.middleName = employee.middleName
        this.lastName = employee.lastName
        this.jobTitle = employee.jobTitle
        this.birthDate = employee.birthDate
        this.shiftId = employee.shiftId
        this.departmentId = employee.departmentId
        this.departmentName = employee.departmentName
        this.departmentStartDate = employee.departmentStartDate
        this.phoneNumber = employee.phoneNumber
        this.phoneNumberTypeId = employee.phoneNumberTypeId
        this.emailAddressId = employee.emailAddressId
        this.emailAddress = employee.emailAddress
        this.addressId = employee.addressId
        this.addressLine1 = employee.addressLine1
        this.addressLine2 = employee.addressLine2
        this.city = employee.city
        this.postalCode = employee.postalCode
        this.stateProvinceId = employee.stateProvinceId
        this.stateProvinceName = employee.stateProvinceName
        this.countryRegionCode = employee.countryRegionCode
        this.countryRegionName = employee.countryRegionName
    }

}
