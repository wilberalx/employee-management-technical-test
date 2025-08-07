package com.wilber.adventureworks.employeemanagement.application.person.address.shared

import com.wilber.adventureworks.employeemanagement.application.person.address.dto.AddressRequest
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother

object AddressRequestMother {

    fun random(): AddressRequest {
        return AddressRequest(
            StringMother.random(),
            StringMother.random(),
            StringMother.random(),
            NumberMother.randomInt(),
            StringMother.random()
        )
    }

}
