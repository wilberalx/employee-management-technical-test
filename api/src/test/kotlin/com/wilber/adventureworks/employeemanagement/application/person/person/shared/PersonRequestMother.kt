package com.wilber.adventureworks.employeemanagement.application.person.person.shared

import com.wilber.adventureworks.employeemanagement.application.person.person.dto.PersonRequest
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother

object PersonRequestMother {

    fun random(): PersonRequest {
        return PersonRequest(
            firstName = StringMother.random(),
            middleName = StringMother.random(),
            lastName = StringMother.random()
        )
    }
}
