package com.wilber.adventureworks.employeemanagement.application.person.countryregion.find

import com.wilber.adventureworks.employeemanagement.domain.entities.person.CountryRegion
import com.wilber.adventureworks.employeemanagement.domain.repository.person.CountryRegionRepository
import org.springframework.stereotype.Component

@Component
class CountryRegionFindAllFinder(
    private val countryRegionRepository: CountryRegionRepository
) {

    fun find(): List<CountryRegion> {
        return countryRegionRepository.findAll()
    }

}
