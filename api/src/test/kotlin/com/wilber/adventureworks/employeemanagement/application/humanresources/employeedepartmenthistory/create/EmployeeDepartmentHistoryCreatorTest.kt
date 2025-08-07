package com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.create

import com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.shared.EmployeeDepartmentHistoryBaseTest
import com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.shared.EmployeeDepartmentHistoryMother
import com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.shared.EmployeeDepartmentHistoryRequestMother
import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.EmployeeDepartmentHistoryId
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import java.time.LocalDate
import java.util.Optional

internal class EmployeeDepartmentHistoryCreatorTest : EmployeeDepartmentHistoryBaseTest() {

    @Test
    fun shouldCreateWhenNotExists() {
        val request = EmployeeDepartmentHistoryRequestMother.random()
        val id = EmployeeDepartmentHistoryId(
            request.businessEntityId,
            request.startDate,
            request.departmentId,
            request.shiftId
        )

        every { employeeDepartmentHistoryRepository.findById(id) } returns Optional.empty()
        every { employeeDepartmentHistoryRepository.save(any()) } returns EmployeeDepartmentHistoryMother.random()

        assertDoesNotThrow {
            employeeDepartmentHistoryCreator.create(request)
        }

        verify(exactly = 1) {
            employeeDepartmentHistoryRepository.findById(id)
            employeeDepartmentHistoryRepository.save(any())
        }
    }

    @Test
    fun shouldUpdateEndDateWhenExists() {
        val request = EmployeeDepartmentHistoryRequestMother.random()
        val id = EmployeeDepartmentHistoryId(
            request.businessEntityId,
            request.startDate,
            request.departmentId,
            request.shiftId
        )
        val existing = EmployeeDepartmentHistoryMother.random().apply {
            endDate = LocalDate.of(2023, 1, 1)
        }

        every { employeeDepartmentHistoryRepository.findById(id) } returns Optional.of(existing)
        every { employeeDepartmentHistoryRepository.save(existing) } returns existing

        assertDoesNotThrow {
            employeeDepartmentHistoryCreator.create(request)
        }

        verify(exactly = 1) {
            employeeDepartmentHistoryRepository.findById(id)
            employeeDepartmentHistoryRepository.save(existing)
        }
    }
}
