package com.wilber.adventureworks.employeemanagement.application.sales.salesorderheader.find

import com.wilber.adventureworks.employeemanagement.application.sales.salesorderheader.shared.SalesOrderHeaderBaseTest
import com.wilber.adventureworks.employeemanagement.application.sales.salesorderheader.shared.SalesOrderHeaderMother
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class SalesOrderHeaderFindLastSaleDateByEmployeeFinderTest : SalesOrderHeaderBaseTest() {

    @Test
    fun shouldFindLastSaleDateByEmployee() {
        val employeeId = NumberMother.randomInt()
        val lastOrder = SalesOrderHeaderMother.random()

        every {
            salesOrderHeaderRepository.findTop1BySalesPersonIdOrderByOrderDateDesc(employeeId)
        } returns lastOrder

        val result = salesOrderHeaderFindLastSaleDateByEmployeeFinder.find(employeeId)

        Assertions.assertEquals(lastOrder.orderDate, result, "Last sale date must match the order's date")
    }

    @Test
    fun shouldReturnNullWhenEmployeeHasNoSales() {
        val employeeId = NumberMother.randomInt()

        every {
            salesOrderHeaderRepository.findTop1BySalesPersonIdOrderByOrderDateDesc(employeeId)
        } returns null

        val result = salesOrderHeaderFindLastSaleDateByEmployeeFinder.find(employeeId)

        Assertions.assertNull(result, "Result should be null when no sales found for employee")
    }
}
