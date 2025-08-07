package com.wilber.adventureworks.employeemanagement.application.person.person.shared

import com.wilber.adventureworks.employeemanagement.domain.entities.person.Person
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother

object PersonMother {

    fun random(): Person {
        return Person(
            personType = StringMother.random(),
            firstName = StringMother.random(),
            middleName = StringMother.random(),
            lastName = StringMother.random()
        ).apply {
            this.businessEntityId = NumberMother.randomInt()
        }
    }
}
