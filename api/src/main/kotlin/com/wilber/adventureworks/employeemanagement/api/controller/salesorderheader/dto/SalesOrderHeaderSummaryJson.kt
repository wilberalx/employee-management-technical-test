package com.wilber.adventureworks.employeemanagement.api.controller.salesorderheader.dto

import com.wilber.adventureworks.employeemanagement.domain.dto.sales.SalesOrderHeaderSummary
import com.wilber.adventureworks.employeemanagement.domain.entities.sales.OrderStatus
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime

class SalesOrderHeaderSummaryJson {

    var salesOrderId: Int = 0
    var orderDate: LocalDateTime = LocalDateTime.now()
    var status: Int = 0
    var statusDescription: String = ""
    var accountNumber: String = ""
    var address: String = ""
    var subTotal: BigDecimal = BigDecimal.ZERO
    var taxAmt: BigDecimal = BigDecimal.ZERO
    var freight: BigDecimal = BigDecimal.ZERO
    var totalDue: BigDecimal = BigDecimal.ZERO
    var empployeeFullName: String = ""

    var loadLastSales: Boolean = false
    var startDate: LocalDate = LocalDate.now()
    var endDate: LocalDate = LocalDate.now()

    constructor()

    constructor(salesOrderHeader: SalesOrderHeaderSummary) {
        this.salesOrderId = salesOrderHeader.salesOrderId
        this.orderDate = salesOrderHeader.orderDate
        this.statusDescription = OrderStatus.fromId(salesOrderHeader.status)?.description ?: ""
        this.status = salesOrderHeader.status
        this.accountNumber = salesOrderHeader.accountNumber ?: ""
        this.address = salesOrderHeader.address
        this.subTotal = salesOrderHeader.subTotal
        this.taxAmt = salesOrderHeader.taxAmt
        this.freight = salesOrderHeader.freight
        this.totalDue = salesOrderHeader.totalDue
        this.empployeeFullName = "${salesOrderHeader.personFirsName} ${salesOrderHeader.personLastName}"
    }

}
