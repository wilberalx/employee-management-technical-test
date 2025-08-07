package com.wilber.adventureworks.employeemanagement.domain.repository.humanresources

import com.wilber.adventureworks.employeemanagement.domain.dto.humanresources.EmployeeSummary
import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.Employee
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface EmployeeRepository : JpaRepository<Employee, Int> {

    @Query(
        """
        select new com.wilber.adventureworks.employeemanagement.domain.dto.humanresources.EmployeeSummary(
              emp.businessEntityId
            , per.firstName
            , per.middleName
            , per.lastName
            , emp.jobTitle
            , emp.birthDate
            , edh.shiftId
            , dep.departmentId
            , dep.name
            , edh.startDate
            , pp.phoneNumber
            , pp.phoneNumberTypeId
            , ea.emailAddressId
            , ea.emailAddress
            , ad.addressId
            , ad.addressLine1
            , ad.addressLine2
            , ad.city
            , ad.postalCode
            , sp.stateProvinceId
            , sp.name
            , cr.countryRegionCode
            , cr.name
        )
          from Employee emp
          join Person per on per.businessEntityId = emp.businessEntityId
          join EmployeeDepartmentHistory edh on edh.businessEntityId = emp.businessEntityId
                                            and edh.endDate is null
                                            and emp.currentFlag = true
          join Department dep on dep.departmentId = edh.departmentId
          join PersonPhone pp on pp.businessEntityId = emp.businessEntityId
                                  and pp.phoneNumberTypeId = 1
          join EmailAddress ea on ea.businessEntityId = emp.businessEntityId          
          join BusinessEntityAddress bad on bad.businessEntityId = emp.businessEntityId 
                                             and bad.addressTypeId = 2
          join Address ad on ad.addressId = bad.addressId
          join StateProvince sp on sp.stateProvinceId = ad.stateProvinceId
          join CountryRegion cr on cr.countryRegionCode = sp.countryRegionCode
          order by emp.businessEntityId
    """
    )
    fun findSummaryActive(): List<EmployeeSummary>

    @Query(
        """
        select new com.wilber.adventureworks.employeemanagement.domain.dto.humanresources.EmployeeSummary(
              emp.businessEntityId
            , per.firstName
            , per.middleName
            , per.lastName
            , emp.jobTitle
            , emp.birthDate
            , edh.shiftId
            , dep.departmentId
            , dep.name
            , edh.startDate
            , pp.phoneNumber
            , pp.phoneNumberTypeId
            , ea.emailAddressId
            , ea.emailAddress
            , ad.addressId
            , ad.addressLine1
            , ad.addressLine2
            , ad.city
            , ad.postalCode
            , sp.stateProvinceId
            , sp.name
            , cr.countryRegionCode
            , cr.name
        )
          from Employee emp
          join Person per on per.businessEntityId = emp.businessEntityId
          join EmployeeDepartmentHistory edh on edh.businessEntityId = emp.businessEntityId
                                            and edh.endDate is null
                                            and emp.currentFlag = true
                                            and emp.businessEntityId = :businessEntityId
          join Department dep on dep.departmentId = edh.departmentId
          join PersonPhone pp on pp.businessEntityId = emp.businessEntityId
                                  and pp.phoneNumberTypeId = 1
          join EmailAddress ea on ea.businessEntityId = emp.businessEntityId          
          join BusinessEntityAddress bad on bad.businessEntityId = emp.businessEntityId 
                                             and bad.addressTypeId = 2
          join Address ad on ad.addressId = bad.addressId
          join StateProvince sp on sp.stateProvinceId = ad.stateProvinceId
          join CountryRegion cr on cr.countryRegionCode = sp.countryRegionCode
          order by emp.businessEntityId
    """
    )
    fun findSummaryById(@Param("businessEntityId") businessEntityId: Int): EmployeeSummary?

}
