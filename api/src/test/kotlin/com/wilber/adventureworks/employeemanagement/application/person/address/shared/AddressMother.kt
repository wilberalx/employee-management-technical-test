package com.wilber.adventureworks.employeemanagement.application.person.address.shared

import com.wilber.adventureworks.employeemanagement.domain.entities.person.Address
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother

object AddressMother {

    fun random(): Address {
        return Address().apply {
            this.addressId = NumberMother.randomInt()
            this.addressLine1 = StringMother.random()
            this.addressLine2 = StringMother.random()
            this.city = StringMother.random()
            this.stateProvinceId = NumberMother.randomInt()
            this.postalCode = StringMother.random()
        }
    }

}
