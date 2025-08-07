package com.wilber.adventureworks.employeemanagement.application.humanresources.employee.find

import com.wilber.adventureworks.employeemanagement.domain.dto.humanresources.EmployeeSummary
import com.wilber.adventureworks.employeemanagement.domain.repository.humanresources.EmployeeRepository
import org.springframework.stereotype.Component

@Component
class EmployeeFindAllActiveFinder(
    private val employeeRepository: EmployeeRepository
) {

    fun find(): List<EmployeeSummary> {
        return employeeRepository.findSummaryActive()
    }

}
