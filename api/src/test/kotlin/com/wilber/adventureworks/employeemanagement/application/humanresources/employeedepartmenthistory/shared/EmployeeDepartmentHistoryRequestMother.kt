package com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.shared

import com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.dto.EmployeeDepartmentHistoryRequest
import com.wilber.adventureworks.employeemanagement.domain.shared.LocalDateMother
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother

object EmployeeDepartmentHistoryRequestMother {
    fun random(): EmployeeDepartmentHistoryRequest {
        return EmployeeDepartmentHistoryRequest(
            businessEntityId = NumberMother.randomInt(),
            startDate = LocalDateMother.random(),
            departmentId = NumberMother.randomShort(),
            shiftId = NumberMother.randomByte()
        )
    }
}
