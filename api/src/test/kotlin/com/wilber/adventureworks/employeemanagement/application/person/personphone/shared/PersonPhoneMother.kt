package com.wilber.adventureworks.employeemanagement.application.person.personphone.shared

import com.wilber.adventureworks.employeemanagement.application.shared.ApplicationConstant
import com.wilber.adventureworks.employeemanagement.domain.entities.person.PersonPhone
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother

object PersonPhoneMother {

    fun random(): PersonPhone {
        return PersonPhone().apply {
            this.businessEntityId = NumberMother.randomInt()
            this.phoneNumber = StringMother.random()
            this.phoneNumberTypeId = ApplicationConstant.phoneNumberTypeCellId
        }
    }
}
