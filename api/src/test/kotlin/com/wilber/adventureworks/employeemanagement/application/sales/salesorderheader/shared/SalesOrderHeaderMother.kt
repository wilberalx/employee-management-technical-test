package com.wilber.adventureworks.employeemanagement.application.sales.salesorderheader.shared

import com.wilber.adventureworks.employeemanagement.domain.entities.sales.SalesOrderHeader
import com.wilber.adventureworks.employeemanagement.domain.shared.LocalDateMother
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother

object SalesOrderHeaderMother {

    fun random(): SalesOrderHeader {
        return SalesOrderHeader().apply {
            this.salesOrderId = NumberMother.randomInt()
            this.orderDate = LocalDateMother.random().atStartOfDay()
            this.status = NumberMother.randomInt()
            this.accountNumber = StringMother.random()
            this.billToAddressId = NumberMother.randomInt()
            this.subTotal = NumberMother.randomBigDecimal()
            this.taxAmt = NumberMother.randomBigDecimal()
            this.totalDue = NumberMother.randomBigDecimal()
            this.salesPersonId = NumberMother.randomInt()
            this.territoryId = NumberMother.randomInt()
        }
    }
}
