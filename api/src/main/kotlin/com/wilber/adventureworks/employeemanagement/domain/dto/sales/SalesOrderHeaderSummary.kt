package com.wilber.adventureworks.employeemanagement.domain.dto.sales

import java.math.BigDecimal
import java.time.LocalDateTime

class SalesOrderHeaderSummary(
    var salesOrderId: Int,
    var orderDate: LocalDateTime,
    var status: Int,
    var accountNumber: String?,
    var address: String,
    var subTotal: BigDecimal,
    var taxAmt: BigDecimal,
    var freight: BigDecimal,
    var totalDue: BigDecimal,
    var personFirsName: String,
    var personLastName: String
)
