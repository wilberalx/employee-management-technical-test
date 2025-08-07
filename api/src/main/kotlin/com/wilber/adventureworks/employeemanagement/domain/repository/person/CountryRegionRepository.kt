package com.wilber.adventureworks.employeemanagement.domain.repository.person

import com.wilber.adventureworks.employeemanagement.domain.entities.person.CountryRegion
import org.springframework.data.jpa.repository.JpaRepository

interface CountryRegionRepository : JpaRepository<CountryRegion, String>
