package com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.shared

import com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.create.EmployeeDepartmentHistoryCreator
import com.wilber.adventureworks.employeemanagement.application.humanresources.employeedepartmenthistory.update.EmployeeDepartmentHistoryCloseCurrentUpdater
import com.wilber.adventureworks.employeemanagement.domain.repository.humanresources.EmployeeDepartmentHistoryRepository
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

open class EmployeeDepartmentHistoryBaseTest {

    protected lateinit var employeeDepartmentHistoryRepository: EmployeeDepartmentHistoryRepository

    protected lateinit var employeeDepartmentHistoryCreator: EmployeeDepartmentHistoryCreator
    protected lateinit var employeeDepartmentHistoryUpdater: EmployeeDepartmentHistoryCloseCurrentUpdater

    @BeforeEach
    protected fun setUp() {
        employeeDepartmentHistoryRepository = mockk()
        employeeDepartmentHistoryCreator = EmployeeDepartmentHistoryCreator(employeeDepartmentHistoryRepository)
        employeeDepartmentHistoryUpdater = EmployeeDepartmentHistoryCloseCurrentUpdater(employeeDepartmentHistoryRepository)
    }
}
