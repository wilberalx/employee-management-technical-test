package com.wilber.adventureworks.employeemanagement.application.humanresources.employee.delete

import com.wilber.adventureworks.employeemanagement.application.exceptions.EntityNotFoundException
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.shared.EmployeeBaseTest
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.shared.EmployeeMother
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import java.util.*

internal class EmployeeDeleterTest : EmployeeBaseTest() {

    @Test
    fun shouldThrowExceptionWhenEmployeeNotFound() {
        val businessEntityId = NumberMother.randomInt()

        every { employeeRepository.findById(businessEntityId) } returns Optional.empty()

        Assertions.assertThrows(
            EntityNotFoundException::class.java, {
                employeeDeleter.delete(businessEntityId)
            },
            "Must throw EntityNotFoundException when employee not found"
        )
    }

    @Test
    fun shouldSetCurrentFlagFalseAndSaveEmployee() {
        val employee = EmployeeMother.random()
        val businessEntityId = employee.businessEntityId

        every { employeeRepository.findById(businessEntityId) } returns Optional.of(employee)
        every { employeeRepository.save(any()) } returns employee

        assertDoesNotThrow("Deleting employee should not throw") {
            employeeDeleter.delete(businessEntityId)
        }

        verify(exactly = 1) {
            employeeRepository.findById(businessEntityId)
            employeeRepository.save(withArg {
                Assertions.assertFalse(it.currentFlag, "currentFlag must be false after delete")
            })
        }
    }

}
