package com.wilber.adventureworks.employeemanagement.application.humanresources.employee.find

import com.wilber.adventureworks.employeemanagement.application.exceptions.EntityNotFoundException
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.shared.EmployeeBaseTest
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.shared.EmployeeSummaryMother
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class EmployeeFindByIdFinderTest : EmployeeBaseTest() {

    @Test
    fun shouldReturnEmployeeSummaryWhenExists() {
        val summary = EmployeeSummaryMother.random()
        val id = summary.businessEntityId

        every { employeeRepository.findSummaryById(id) } returns summary

        val result = employeeFindByIdFinder.find(id)

        Assertions.assertEquals(summary, result, "Must return matching summary when employee is found")
    }

    @Test
    fun shouldThrowExceptionWhenEmployeeNotFound() {
        val id = NumberMother.randomInt()

        every { employeeRepository.findSummaryById(id) } returns null

        Assertions.assertThrows(
            EntityNotFoundException::class.java,
            { employeeFindByIdFinder.find(id) },
            "Must throw EntityNotFoundException when employee is not found"
        )

        verify(exactly = 1) {
            employeeRepository.findSummaryById(id)
        }
    }
}
