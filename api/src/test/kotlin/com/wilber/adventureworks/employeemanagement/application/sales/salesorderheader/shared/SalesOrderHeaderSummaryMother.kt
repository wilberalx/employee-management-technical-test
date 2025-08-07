package com.wilber.adventureworks.employeemanagement.application.sales.salesorderheader.shared

import com.wilber.adventureworks.employeemanagement.domain.dto.sales.SalesOrderHeaderSummary
import com.wilber.adventureworks.employeemanagement.domain.shared.LocalDateMother
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother

object SalesOrderHeaderSummaryMother {

    fun random(): SalesOrderHeaderSummary {
        return SalesOrderHeaderSummary(
            salesOrderId = NumberMother.randomInt(),
            orderDate = LocalDateMother.random().atStartOfDay(),
            status = NumberMother.randomInt(),
            accountNumber = StringMother.random(),
            address = StringMother.random(),
            subTotal = NumberMother.randomBigDecimal(),
            taxAmt = NumberMother.randomBigDecimal(),
            freight = NumberMother.randomBigDecimal(),
            totalDue = NumberMother.randomBigDecimal(),
            personFirsName = StringMother.random(),
            personLastName = StringMother.random()
        )
    }
}
