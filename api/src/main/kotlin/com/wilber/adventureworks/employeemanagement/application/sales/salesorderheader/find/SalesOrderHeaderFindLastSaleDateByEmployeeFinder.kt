package com.wilber.adventureworks.employeemanagement.application.sales.salesorderheader.find

import com.wilber.adventureworks.employeemanagement.domain.repository.sales.SalesOrderHeaderRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class SalesOrderHeaderFindLastSaleDateByEmployeeFinder(
    private val salesOrderHeaderRepository: SalesOrderHeaderRepository
) {

    fun find(salesPersonId: Int): LocalDateTime? {
        return salesOrderHeaderRepository.findTop1BySalesPersonIdOrderByOrderDateDesc(
            salesPersonId
        )?.orderDate
    }

}
