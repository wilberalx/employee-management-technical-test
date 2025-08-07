package com.wilber.adventureworks.employeemanagement.api.controller.countryregion.dto

import com.wilber.adventureworks.employeemanagement.domain.entities.person.CountryRegion

class CountryRegionJson {

    var countryRegionCode: String = ""
    var name: String = ""

    constructor()

    constructor(countryRegion: CountryRegion) {
        this.countryRegionCode = countryRegion.countryRegionCode
        this.name = countryRegion.name
    }

}
