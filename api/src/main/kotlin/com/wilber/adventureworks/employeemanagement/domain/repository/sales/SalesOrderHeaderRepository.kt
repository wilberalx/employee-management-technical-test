package com.wilber.adventureworks.employeemanagement.domain.repository.sales

import com.wilber.adventureworks.employeemanagement.domain.dto.sales.SalesOrderHeaderSummary
import com.wilber.adventureworks.employeemanagement.domain.entities.sales.SalesOrderHeader
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import java.time.LocalDateTime

interface SalesOrderHeaderRepository : JpaRepository<SalesOrderHeader, Int> {

    @Query(
        """
        select new com.wilber.adventureworks.employeemanagement.domain.dto.sales.SalesOrderHeaderSummary(
              soh.salesOrderId
            , soh.orderDate
            , soh.status
            , soh.accountNumber
            , ad.addressLine1
            , soh.subTotal
            , soh.taxAmt
            , soh.freight
            , soh.totalDue
            , per.firstName
            , per.lastName
        )
          from SalesOrderHeader soh
          join SalesTerritory st on st.territoryId = soh.territoryId
                                and st.countryRegionCode = 'US'
                                and soh.salesPersonId = :salesPersonId
                                and orderDate >= :startDate
                                and orderDate <= :endDate
          join Address ad on ad.addressId = soh.billToAddressId
          join Person per on per.businessEntityId = :salesPersonId
    """
    )
    fun finSummaryByEmployeeAndDates(
        @Param("salesPersonId") salesPersonId: Int,
        @Param("startDate") startDate: LocalDateTime,
        @Param("endDate") endDate: LocalDateTime
    ): List<SalesOrderHeaderSummary>

    fun findTop1BySalesPersonIdOrderByOrderDateDesc(@Param("salesPersonId") salesPersonId: Int): SalesOrderHeader?

}

