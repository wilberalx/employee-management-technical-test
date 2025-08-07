package com.wilber.adventureworks.employeemanagement.application.humanresources.employee.update

import com.wilber.adventureworks.employeemanagement.application.exceptions.EntityNotFoundException
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.shared.EmployeeBaseTest
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.shared.EmployeeMother
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.shared.EmployeeRequestMother
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import java.util.*

internal class EmployeeUpdaterTest : EmployeeBaseTest() {

    @Test
    fun shouldThrowExceptionWhenEmployeeNotFound() {
        val request = EmployeeRequestMother.random()

        every { employeeRepository.findById(any()) } returns Optional.empty()

        Assertions.assertThrows(
            EntityNotFoundException::class.java, {
                employeeUpdater.update(request)
            },
            "Must throw EntityNotFoundException when employee not found"
        )
    }

    @Test
    fun shouldUpdateExistingEmployee() {
        val employee = EmployeeMother.random()
        val request = EmployeeRequestMother.random()
        request.businessEntityId = employee.businessEntityId
        val businessEntityId = employee.businessEntityId

        every { employeeRepository.findById(any()) } returns Optional.of(employee)
        every { employeeRepository.save(any()) } returns employee

        assertDoesNotThrow("Updating employee should not throw") {
            employeeUpdater.update(request)
        }

        verify(exactly = 1) {
            employeeRepository.findById(businessEntityId)
            employeeRepository.save(withArg {
                Assertions.assertEquals(businessEntityId, it.businessEntityId)
            })
        }
    }

}
