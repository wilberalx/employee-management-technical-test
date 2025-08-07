package com.wilber.adventureworks.employeemanagement.application.humanresources.employee.dto

import java.time.LocalDate

class EmployeeRequest(
    var businessEntityId: Int,
    var jobTitle: String,
    var birthDate: LocalDate
)
