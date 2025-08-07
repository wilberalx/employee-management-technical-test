package com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.shared

import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.EmployeeDepartmentHistory
import com.wilber.adventureworks.employeemanagement.domain.shared.LocalDateMother
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother

object EmployeeDepartmentHistoryMother {
    fun random(): EmployeeDepartmentHistory {
        val entity = EmployeeDepartmentHistory()
        entity.businessEntityId = NumberMother.randomInt()
        entity.startDate = LocalDateMother.random()
        entity.departmentId = NumberMother.randomShort()
        entity.shiftId = NumberMother.randomByte()
        return entity
    }
}
