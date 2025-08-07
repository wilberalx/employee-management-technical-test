package com.wilber.adventureworks.employeemanagement.application.person.businessentity.shared

import com.wilber.adventureworks.employeemanagement.domain.entities.person.BusinessEntity
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother

object BusinessEntityMother {

    fun random(): BusinessEntity {
        return BusinessEntity().apply {
            this.businessEntityId = NumberMother.randomInt()
        }
    }

}
