package com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.update

import com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.shared.EmployeeDepartmentHistoryBaseTest
import com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.shared.EmployeeDepartmentHistoryMother
import com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.shared.EmployeeDepartmentHistoryRequestMother
import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.EmployeeDepartmentHistory
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class EmployeeDepartmentHistoryCloseCurrentUpdaterTest : EmployeeDepartmentHistoryBaseTest() {

    @Test
    fun shouldDoNothingIfNoCurrentDepartment() {
        val request = EmployeeDepartmentHistoryRequestMother.random()

        every {
            employeeDepartmentHistoryRepository.findByBusinessEntityIdAndEndDateIsNull(request.businessEntityId)
        } returns null

        val result = employeeDepartmentHistoryUpdater.update(request)
        Assertions.assertTrue(result, "The update employee department must response true")
    }

    @Test
    fun shouldReturnFalseIfSameAssignment() {
        val request = EmployeeDepartmentHistoryRequestMother.random()
        val current = EmployeeDepartmentHistory().apply {
            businessEntityId = request.businessEntityId
            departmentId = request.departmentId
            startDate = request.startDate
            shiftId = request.shiftId
        }

        every { employeeDepartmentHistoryRepository.findByBusinessEntityIdAndEndDateIsNull(request.businessEntityId) } returns current

        val result = employeeDepartmentHistoryUpdater.update(request)
        Assertions.assertFalse(result, "The update employee department must response faalse")

    }

    @Test
    fun shouldUpdateEndDateIfDifferentAssignment() {
        val request = EmployeeDepartmentHistoryRequestMother.random()
        val current = EmployeeDepartmentHistoryMother.random().apply {
            businessEntityId = request.businessEntityId
            endDate = null
        }

        every { employeeDepartmentHistoryRepository.findByBusinessEntityIdAndEndDateIsNull(request.businessEntityId) } returns current
        every { employeeDepartmentHistoryRepository.save(current) } returns current

        val result = employeeDepartmentHistoryUpdater.update(request)
        Assertions.assertTrue(result, "The update employee department must response true")

    }

}
