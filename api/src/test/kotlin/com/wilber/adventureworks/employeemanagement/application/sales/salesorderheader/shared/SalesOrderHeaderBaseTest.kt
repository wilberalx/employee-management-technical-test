package com.wilber.adventureworks.employeemanagement.application.sales.salesorderheader.shared

import com.wilber.adventureworks.employeemanagement.application.sales.salesorderheader.find.SalesOrderHeaderFindByEmployeeAndDateFinder
import com.wilber.adventureworks.employeemanagement.application.sales.salesorderheader.find.SalesOrderHeaderFindLastSaleDateByEmployeeFinder
import com.wilber.adventureworks.employeemanagement.domain.repository.sales.SalesOrderHeaderRepository
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

open class SalesOrderHeaderBaseTest {
    protected lateinit var salesOrderHeaderRepository: SalesOrderHeaderRepository

    protected lateinit var salesOrderHeaderFindByEmployeeAndDateFinder: SalesOrderHeaderFindByEmployeeAndDateFinder
    protected lateinit var salesOrderHeaderFindLastSaleDateByEmployeeFinder: SalesOrderHeaderFindLastSaleDateByEmployeeFinder

    @BeforeEach
    protected fun setUp() {
        salesOrderHeaderRepository = mockk()
        salesOrderHeaderFindByEmployeeAndDateFinder =
            SalesOrderHeaderFindByEmployeeAndDateFinder(salesOrderHeaderRepository)
        salesOrderHeaderFindLastSaleDateByEmployeeFinder =
            SalesOrderHeaderFindLastSaleDateByEmployeeFinder(salesOrderHeaderRepository)
    }

}
