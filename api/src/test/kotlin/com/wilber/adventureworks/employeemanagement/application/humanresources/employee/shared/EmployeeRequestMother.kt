package com.wilber.adventureworks.employeemanagement.application.humanresources.employee.shared

import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.dto.EmployeeRequest
import com.wilber.adventureworks.employeemanagement.domain.shared.LocalDateMother
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother

object EmployeeRequestMother {
    fun random(): EmployeeRequest {
        return EmployeeRequest(
            businessEntityId = NumberMother.randomInt(),
            jobTitle = StringMother.random(),
            birthDate = LocalDateMother.random()
        )
    }
}
