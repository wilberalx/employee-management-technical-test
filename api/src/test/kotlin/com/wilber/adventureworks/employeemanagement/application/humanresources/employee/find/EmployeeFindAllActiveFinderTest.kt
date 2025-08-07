package com.wilber.adventureworks.employeemanagement.application.humanresources.employee.find

import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.shared.EmployeeBaseTest
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.shared.EmployeeSummaryMother
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class EmployeeFindAllActiveFinderTest : EmployeeBaseTest() {

    @Test
    fun shouldReturnAllActiveEmployeesWhenSearchIsEmpty() {
        val summaries = listOf(
            EmployeeSummaryMother.random(),
            EmployeeSummaryMother.random()
        )

        every { employeeRepository.findSummaryActive() } returns summaries

        val result = employeeFindAllActiveFinder.find()

        Assertions.assertEquals(summaries.size, result.size, "Must return all summaries")
    }

}
