package com.wilber.adventureworks.employeemanagement.application.person.stateprovince.find

import com.wilber.adventureworks.employeemanagement.domain.entities.person.StateProvince
import com.wilber.adventureworks.employeemanagement.domain.repository.person.StateProvinceRepository
import org.springframework.stereotype.Component

@Component
class StateProvinceFindByCountryFinder(
    private val stateProvinceRepository: StateProvinceRepository
) {

    fun find(countryRegionCode: String): List<StateProvince> {
        return stateProvinceRepository.findByCountryRegion(countryRegionCode)
    }

}
