package com.wilber.adventureworks.employeemanagement.application.humanresources.employee.create

import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.shared.EmployeeBaseTest
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.shared.EmployeeMother
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.shared.EmployeeRequestMother
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class EmployeeCreatorTest : EmployeeBaseTest() {

    @Test
    fun shouldCreateAndReturnEmployeeBusinessEntityId() {
        val employee = EmployeeMother.random()
        val request = EmployeeRequestMother.random()

        every { employeeRepository.save(any()) } returns employee

        val result = employeeCreator.create(request)

        Assertions.assertEquals(employee.businessEntityId, result, "Returned businessEntityId must match")
    }
}
