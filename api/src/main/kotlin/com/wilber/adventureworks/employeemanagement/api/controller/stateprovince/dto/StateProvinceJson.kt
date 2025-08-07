package com.wilber.adventureworks.employeemanagement.api.controller.stateprovince.dto

import com.wilber.adventureworks.employeemanagement.domain.entities.person.StateProvince

class StateProvinceJson {

    var stateProvinceId: Int = 0
    var name: String = ""

    constructor()

    constructor(stateProvince: StateProvince) {
        this.stateProvinceId = stateProvince.stateProvinceId!!
        this.name = stateProvince.name
    }

}
