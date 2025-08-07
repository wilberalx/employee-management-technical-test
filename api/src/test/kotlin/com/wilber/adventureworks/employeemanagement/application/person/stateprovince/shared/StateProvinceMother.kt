package com.wilber.adventureworks.employeemanagement.application.person.stateprovince.shared

import com.wilber.adventureworks.employeemanagement.domain.entities.person.StateProvince
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother

object StateProvinceMother {

    fun random(): StateProvince {
        return StateProvince().apply {
            this.stateProvinceId = NumberMother.randomInt()
            this.stateProvinceCode = StringMother.random()
            this.countryRegionCode = StringMother.random()
            this.name = StringMother.random()
        }
    }

}
