package com.wilber.adventureworks.employeemanagement.application.person.countryregion.shared

import com.wilber.adventureworks.employeemanagement.domain.entities.person.CountryRegion
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother

object CountryRegionMother {

    fun random(): CountryRegion {
        return CountryRegion().apply {
            this.countryRegionCode = StringMother.random()
            this.name = StringMother.random()
        }
    }
}
