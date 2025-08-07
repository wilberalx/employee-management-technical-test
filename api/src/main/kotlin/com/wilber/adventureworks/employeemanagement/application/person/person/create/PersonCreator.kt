package com.wilber.adventureworks.employeemanagement.application.person.person.create

import com.wilber.adventureworks.employeemanagement.application.person.person.dto.PersonRequest
import com.wilber.adventureworks.employeemanagement.application.shared.ApplicationConstant
import com.wilber.adventureworks.employeemanagement.domain.entities.person.Person
import com.wilber.adventureworks.employeemanagement.domain.repository.person.PersonRepository
import org.springframework.stereotype.Component

@Component
class PersonCreator(
    private val personRepository: PersonRepository
) {

    fun create(request: PersonRequest): Int {
        val person = Person(
            personType = ApplicationConstant.personTypeEmployee,
            firstName = request.firstName,
            middleName = request.middleName,
            lastName = request.lastName,
        )

        return personRepository.save(person).businessEntityId!!
    }

}