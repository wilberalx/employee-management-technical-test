package com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.create

import com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.dto.EmployeeDepartmentHistoryRequest
import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.EmployeeDepartmentHistory
import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.EmployeeDepartmentHistoryId
import com.wilber.adventureworks.employeemanagement.domain.repository.humanresources.EmployeeDepartmentHistoryRepository
import org.springframework.stereotype.Component

@Component
class EmployeeDepartmentHistoryCreator(
    private val employeeDepartmentHistoryRepository: EmployeeDepartmentHistoryRepository
) {

    fun create(employeeDepartmentRequest: EmployeeDepartmentHistoryRequest) {
        val id = EmployeeDepartmentHistoryId(
            employeeDepartmentRequest.businessEntityId,
            employeeDepartmentRequest.startDate,
            employeeDepartmentRequest.departmentId,
            employeeDepartmentRequest.shiftId
        )

        employeeDepartmentHistoryRepository.findById(id).orElse(null)?.let {
            it.endDate = null
            employeeDepartmentHistoryRepository.save(it)
            return
        }

        val employeeDepartment = EmployeeDepartmentHistory().apply {
            this.businessEntityId = employeeDepartmentRequest.businessEntityId
            this.startDate = employeeDepartmentRequest.startDate
            this.departmentId = employeeDepartmentRequest.departmentId
            this.shiftId = employeeDepartmentRequest.shiftId
        }
        employeeDepartmentHistoryRepository.save(employeeDepartment)
    }

}
