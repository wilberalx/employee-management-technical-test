package com.wilber.adventureworks.employeemanagement.application.humanresources.department.shared

import com.wilber.adventureworks.employeemanagement.application.humanresources.department.find.DepartmentFindAllFinder
import com.wilber.adventureworks.employeemanagement.domain.repository.humanresources.DepartmentRepository
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

open class DepartmentBaseTest {
    protected lateinit var departmentRepository: DepartmentRepository

    protected lateinit var departmentFindAllFinder: DepartmentFindAllFinder

    @BeforeEach
    protected fun setUp() {
        departmentRepository = mockk()

        departmentFindAllFinder = DepartmentFindAllFinder(departmentRepository)
    }
}
