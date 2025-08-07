package com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.dto

import java.time.LocalDate

class EmployeeDepartmentHistoryRequest(
    var businessEntityId: Int,
    var startDate: LocalDate,
    var departmentId: Short,
    var shiftId: Byte
)
