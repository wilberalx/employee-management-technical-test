package com.wilber.adventureworks.employeemanagement.domain.dto.humanresources

import java.time.LocalDate

class EmployeeSummary(
    var businessEntityId: Int,
    var firstName: String,
    var middleName: String?,
    var lastName: String,
    var jobTitle: String,
    var birthDate: LocalDate,

    var shiftId: Byte,
    var departmentId: Short,
    var departmentName: String,
    var departmentStartDate: LocalDate,

    var phoneNumber: String,
    var phoneNumberTypeId: Int,

    var emailAddressId: Int,
    var emailAddress: String,

    var addressId: Int,
    var addressLine1: String,
    var addressLine2: String?,
    var city: String,
    var postalCode: String,

    var stateProvinceId: Int,
    var stateProvinceName: String,

    var countryRegionCode: String,
    var countryRegionName: String
)
