package com.wilber.adventureworks.employeemanagement.application.humanresources.employee.udpate

import com.wilber.adventureworks.employeemanagement.application.exceptions.EntityNotFoundException
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.dto.EmployeeRequest
import com.wilber.adventureworks.employeemanagement.domain.repository.humanresources.EmployeeRepository
import org.springframework.stereotype.Component

@Component
class EmployeeUpdater(
    private val employeeRepository: EmployeeRepository
) {

    fun update(employeeRequest: EmployeeRequest) {
        val employee = employeeRepository.findById(employeeRequest.businessEntityId)
            .orElseThrow { throw EntityNotFoundException("Employee") }

        employee.businessEntityId = employeeRequest.businessEntityId
        employee.jobTitle = employeeRequest.jobTitle
        employee.birthDate = employeeRequest.birthDate
        employeeRepository.save(employee)
    }

}
