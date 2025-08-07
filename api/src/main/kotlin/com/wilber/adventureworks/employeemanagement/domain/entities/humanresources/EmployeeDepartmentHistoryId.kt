package com.wilber.adventureworks.employeemanagement.domain.entities.humanresources

import java.io.Serializable
import java.time.LocalDate

data class EmployeeDepartmentHistoryId(
    var businessEntityId: Int = 0,
    var startDate: LocalDate = LocalDate.now(),
    var departmentId: Short = 0,
    var shiftId: Byte = 0
) : Serializable
