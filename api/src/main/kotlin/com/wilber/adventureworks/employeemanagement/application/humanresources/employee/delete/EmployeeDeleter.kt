package com.wilber.adventureworks.employeemanagement.application.humanresources.employee.delete

import com.wilber.adventureworks.employeemanagement.application.exceptions.EntityNotFoundException
import com.wilber.adventureworks.employeemanagement.domain.repository.humanresources.EmployeeRepository
import org.springframework.stereotype.Component

@Component
class EmployeeDeleter(
    private val employeeRepository: EmployeeRepository
) {

    fun delete(businessEntityId: Int) {
        val employee = employeeRepository.findById(businessEntityId)
            .orElseThrow { throw EntityNotFoundException("Employee") }

        employee.currentFlag = false
        employeeRepository.save(employee)
    }

}
