package com.wilber.adventureworks.employeemanagement.domain.repository.person

import com.wilber.adventureworks.employeemanagement.domain.entities.person.StateProvince
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param

interface StateProvinceRepository : JpaRepository<StateProvince, Int> {

    @Query(
        """
         FROM StateProvince sp 
        WHERE sp.countryRegionCode = :countryRegionCode
    """
    )
    fun findByCountryRegion(@Param("countryRegionCode") countryRegionCode: String): List<StateProvince>

}
