package com.wilber.adventureworks.employeemanagement.application.humanresources.department.shared

import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.Department
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother

object DepartmentMother {

    fun random(): Department {
        return Department().apply {
            this.departmentId = NumberMother.randomShort()
            this.name = StringMother.random()
        }
    }
}
