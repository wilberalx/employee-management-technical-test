package com.wilber.adventureworks.employeemanagement.domain.entities.sales

import com.wilber.adventureworks.employeemanagement.domain.entities.shared.BaseEntityFields
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "SalesOrderHeader", schema = "Sales")
class SalesOrderHeader : BaseEntityFields() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SalesOrderID", nullable = false)
    var salesOrderId: Int = 0

    @Column(name = "OrderDate")
    var orderDate: LocalDateTime = LocalDateTime.now()

    @Column(name = "Status")
    var status: Int = 0

    @Column(name = "AccountNumber")
    var accountNumber: String? = null

    @Column(name = "BillToAddressID")
    var billToAddressId: Int = 0

    @Column(name = "SubTotal")
    var subTotal: BigDecimal = BigDecimal.ZERO

    @Column(name = "TaxAmt")
    var taxAmt: BigDecimal = BigDecimal.ZERO

    @Column(name = "Freight")
    var freight: BigDecimal = BigDecimal.ZERO

    @Column(name = "TotalDue")
    var totalDue: BigDecimal = BigDecimal.ZERO

    @Column(name = "SalesPersonID")
    var salesPersonId: Int? = null

    @Column(name = "TerritoryID")
    var territoryId: Int? = null

}
