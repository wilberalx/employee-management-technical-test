package com.wilber.adventureworks.employeemanagement.application.person.emailaddress.shared

import com.wilber.adventureworks.employeemanagement.domain.entities.person.EmailAddress
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother

object EmailAddressMother {

    fun random(): EmailAddress {
        return EmailAddress().apply {
            this.emailAddressId = NumberMother.randomInt()
            this.businessEntityId = NumberMother.randomInt()
            this.emailAddress = StringMother.random()
        }
    }
}