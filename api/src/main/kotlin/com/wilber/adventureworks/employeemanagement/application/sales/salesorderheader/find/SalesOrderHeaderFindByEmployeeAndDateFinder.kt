package com.wilber.adventureworks.employeemanagement.application.sales.salesorderheader.find

import com.wilber.adventureworks.employeemanagement.domain.dto.sales.SalesOrderHeaderSummary
import com.wilber.adventureworks.employeemanagement.domain.repository.sales.SalesOrderHeaderRepository
import org.springframework.stereotype.Component
import java.time.LocalDateTime

@Component
class SalesOrderHeaderFindByEmployeeAndDateFinder(
    private val salesOrderHeaderRepository: SalesOrderHeaderRepository
) {

    fun find(salesPersonId: Int, startDate: LocalDateTime, endDate: LocalDateTime): List<SalesOrderHeaderSummary> {
        return salesOrderHeaderRepository.finSummaryByEmployeeAndDates(
            salesPersonId,
            startDate,
            endDate
        )
    }

}
