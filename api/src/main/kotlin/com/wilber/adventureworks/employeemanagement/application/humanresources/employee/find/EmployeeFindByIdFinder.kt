package com.wilber.adventureworks.employeemanagement.application.humanresources.employee.find

import com.wilber.adventureworks.employeemanagement.application.exceptions.EntityNotFoundException
import com.wilber.adventureworks.employeemanagement.domain.dto.humanresources.EmployeeSummary
import com.wilber.adventureworks.employeemanagement.domain.repository.humanresources.EmployeeRepository
import org.springframework.stereotype.Component

@Component
class EmployeeFindByIdFinder(
    private val employeeRepository: EmployeeRepository
) {

    fun find(businessEntityId: Int): EmployeeSummary {
        return employeeRepository.findSummaryById(businessEntityId) ?: throw EntityNotFoundException("Employee")
    }

}
