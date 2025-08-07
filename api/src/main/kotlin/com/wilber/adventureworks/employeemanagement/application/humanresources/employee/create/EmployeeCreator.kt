package com.wilber.adventureworks.employeemanagement.application.humanresources.employee.create

import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.dto.EmployeeRequest
import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.Employee
import com.wilber.adventureworks.employeemanagement.domain.repository.humanresources.EmployeeRepository
import org.springframework.stereotype.Component

@Component
class EmployeeCreator(
    private val employeeRepository: EmployeeRepository
) {

    fun create(employeeRequest: EmployeeRequest): Int {
        val employee = Employee().apply {
            this.businessEntityId = employeeRequest.businessEntityId
            this.jobTitle = employeeRequest.jobTitle
            this.birthDate = employeeRequest.birthDate
        }
        val entity = employeeRepository.save(employee)
        return entity.businessEntityId
    }

}
