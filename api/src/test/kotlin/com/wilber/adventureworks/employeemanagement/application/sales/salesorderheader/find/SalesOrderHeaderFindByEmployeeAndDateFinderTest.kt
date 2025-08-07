package com.wilber.adventureworks.employeemanagement.application.sales.salesorderheader.find

import com.wilber.adventureworks.employeemanagement.application.sales.salesorderheader.shared.SalesOrderHeaderBaseTest
import com.wilber.adventureworks.employeemanagement.application.sales.salesorderheader.shared.SalesOrderHeaderSummaryMother
import com.wilber.adventureworks.employeemanagement.domain.shared.LocalDateMother
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class SalesOrderHeaderFindByEmployeeAndDateFinderTest : SalesOrderHeaderBaseTest() {

    @Test
    fun shouldFindSalesOrdersByEmployeeAndDateRange() {
        val employeeId = NumberMother.randomInt()
        val startDate = LocalDateMother.random().atStartOfDay()
        val endDate = startDate.plusDays(1)
        val orders = listOf(SalesOrderHeaderSummaryMother.random(), SalesOrderHeaderSummaryMother.random())

        every {
            salesOrderHeaderRepository.finSummaryByEmployeeAndDates(employeeId, startDate, endDate)
        } returns orders

        val result = salesOrderHeaderFindByEmployeeAndDateFinder.find(employeeId, startDate, endDate)

        Assertions.assertEquals(
            orders.size,
            result.size,
            "Must return the same number of orders in date range for employee"
        )
    }

}
