package com.wilber.adventureworks.employeemanagement.application.humanresources.employee.shared

import com.wilber.adventureworks.employeemanagement.domain.dto.humanresources.EmployeeSummary
import com.wilber.adventureworks.employeemanagement.domain.shared.LocalDateMother
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother

object EmployeeSummaryMother {
    fun random(): EmployeeSummary {
        return EmployeeSummary(
            businessEntityId = NumberMother.randomInt(),
            firstName = StringMother.random(),
            middleName = StringMother.random(),
            lastName = StringMother.random(),
            jobTitle = StringMother.random(),
            birthDate = LocalDateMother.random(),
            shiftId = NumberMother.randomByte(),
            departmentId = NumberMother.randomShort(),
            departmentName = StringMother.random(),
            departmentStartDate = LocalDateMother.random(),
            phoneNumber = StringMother.random(),
            phoneNumberTypeId = NumberMother.randomInt(),
            emailAddressId = NumberMother.randomInt(),
            emailAddress = StringMother.random(),
            addressId = NumberMother.randomInt(),
            addressLine1 = StringMother.random(),
            addressLine2 = StringMother.random(),
            city = StringMother.random(),
            postalCode = StringMother.random(),
            stateProvinceId = NumberMother.randomInt(),
            stateProvinceName = StringMother.random(),
            countryRegionCode = StringMother.random(3),
            countryRegionName = StringMother.random()
        )
    }
}
