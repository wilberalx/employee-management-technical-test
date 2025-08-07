package com.wilber.adventureworks.employeemanagement.application.humanresources.department.find

import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.Department
import com.wilber.adventureworks.employeemanagement.domain.repository.humanresources.DepartmentRepository
import org.springframework.stereotype.Component

@Component
class DepartmentFindAllFinder(
    private val departmentRepository: DepartmentRepository
) {

    fun find(): List<Department> {
        return departmentRepository.findAll()
    }

}
