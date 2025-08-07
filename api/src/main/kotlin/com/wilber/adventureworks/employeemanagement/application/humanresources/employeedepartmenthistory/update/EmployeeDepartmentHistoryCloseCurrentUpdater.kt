package com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.update

import com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.dto.EmployeeDepartmentHistoryRequest
import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.EmployeeDepartmentHistory
import com.wilber.adventureworks.employeemanagement.domain.repository.humanresources.EmployeeDepartmentHistoryRepository
import org.springframework.stereotype.Component

@Component
class EmployeeDepartmentHistoryCloseCurrentUpdater(
    private val employeeDepartmentHistoryRepository: EmployeeDepartmentHistoryRepository
) {

    fun update(employeeDepartmentRequest: EmployeeDepartmentHistoryRequest): Boolean {
        val current = employeeDepartmentHistoryRepository.findByBusinessEntityIdAndEndDateIsNull(
            employeeDepartmentRequest.businessEntityId
        ) ?: return true

        val isSame = isSameAssignment(current, employeeDepartmentRequest)
        if (isSame) {
            return false
        }

        current.endDate = if (employeeDepartmentRequest.startDate > current.startDate) {
            employeeDepartmentRequest.startDate
        } else {
            current.startDate
        }

        employeeDepartmentHistoryRepository.save(current)
        return true
    }

    private fun isSameAssignment(
        current: EmployeeDepartmentHistory,
        request: EmployeeDepartmentHistoryRequest
    ): Boolean {
        return current.departmentId == request.departmentId &&
                current.startDate == request.startDate &&
                current.shiftId == request.shiftId
    }

}
