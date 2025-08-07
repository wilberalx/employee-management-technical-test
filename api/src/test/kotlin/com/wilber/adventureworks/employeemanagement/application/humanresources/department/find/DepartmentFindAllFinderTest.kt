package com.wilber.adventureworks.employeemanagement.application.humanresources.department.find

import com.wilber.adventureworks.employeemanagement.application.humanresources.department.shared.DepartmentBaseTest
import com.wilber.adventureworks.employeemanagement.application.humanresources.department.shared.DepartmentMother
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class DepartmentFindAllFinderTest : DepartmentBaseTest() {

    @Test
    fun shouldReturnAllDepartments() {
        val departments = listOf(
            DepartmentMother.random(),
            DepartmentMother.random()
        )

        every { departmentRepository.findAll() } returns departments

        val result = departmentFindAllFinder.find()

        Assertions.assertEquals(departments.size, result.size, "Must return all departments from repository")
    }
}
