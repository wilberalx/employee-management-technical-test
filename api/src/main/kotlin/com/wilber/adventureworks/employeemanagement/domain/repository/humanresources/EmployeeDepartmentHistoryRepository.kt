package com.wilber.adventureworks.employeemanagement.domain.repository.humanresources

import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.EmployeeDepartmentHistory
import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.EmployeeDepartmentHistoryId
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface EmployeeDepartmentHistoryRepository : JpaRepository<EmployeeDepartmentHistory, EmployeeDepartmentHistoryId> {

    @Query(
        """
            from EmployeeDepartmentHistory edh
            where edh.businessEntityId = :businessEntityId
              and edh.endDate is null
        """
    )
    fun findByBusinessEntityIdAndEndDateIsNull(
        @Param("businessEntityId") businessEntityId: Int
    ): EmployeeDepartmentHistory?

}


