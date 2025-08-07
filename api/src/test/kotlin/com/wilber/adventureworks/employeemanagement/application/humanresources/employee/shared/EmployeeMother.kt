package com.wilber.adventureworks.employeemanagement.application.humanresources.employee.shared

import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.Employee
import com.wilber.adventureworks.employeemanagement.domain.shared.LocalDateMother
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother

object EmployeeMother {
    fun random(): Employee {
        return Employee().apply {
            this.businessEntityId = NumberMother.randomInt()
            this.currentFlag = true
            this.nationalIdNumber = StringMother.random(15)
            this.loginId = StringMother.random(20)
            this.jobTitle = StringMother.random()
            this.birthDate = LocalDateMother.random()
            this.maritalStatus = listOf("S", "M").random()
            this.gender = listOf("M", "F").random()
            this.hireDate = LocalDateMother.random()
        }
    }
}
