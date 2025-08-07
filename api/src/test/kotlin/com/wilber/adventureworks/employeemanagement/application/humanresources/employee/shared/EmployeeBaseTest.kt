package com.wilber.adventureworks.employeemanagement.application.humanresources.employee.shared

import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.create.EmployeeCreator
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.delete.EmployeeDeleter
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.find.EmployeeFindAllActiveFinder
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.find.EmployeeFindByIdFinder
import com.wilber.adventureworks.employeemanagement.application.humanresources.employee.udpate.EmployeeUpdater
import com.wilber.adventureworks.employeemanagement.domain.repository.humanresources.EmployeeRepository
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

open class EmployeeBaseTest {

    protected lateinit var employeeRepository: EmployeeRepository

    protected lateinit var employeeCreator: EmployeeCreator
    protected lateinit var employeeDeleter: EmployeeDeleter
    protected lateinit var employeeUpdater: EmployeeUpdater
    protected lateinit var employeeFindAllActiveFinder: EmployeeFindAllActiveFinder
    protected lateinit var employeeFindByIdFinder: EmployeeFindByIdFinder

    @BeforeEach
    protected fun setUp() {
        employeeRepository = mockk()

        employeeCreator = EmployeeCreator(employeeRepository)
        employeeDeleter = EmployeeDeleter(employeeRepository)
        employeeUpdater = EmployeeUpdater(employeeRepository)
        employeeFindAllActiveFinder = EmployeeFindAllActiveFinder(employeeRepository)
        employeeFindByIdFinder = EmployeeFindByIdFinder(employeeRepository)
    }

}
