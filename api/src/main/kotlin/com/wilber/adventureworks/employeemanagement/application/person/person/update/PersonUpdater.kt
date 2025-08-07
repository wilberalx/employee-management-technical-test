package com.wilber.adventureworks.employeemanagement.application.person.person.update

import com.wilber.adventureworks.employeemanagement.application.exceptions.EntityNotFoundException
import com.wilber.adventureworks.employeemanagement.application.person.person.dto.PersonRequest
import com.wilber.adventureworks.employeemanagement.domain.repository.person.PersonRepository
import org.springframework.stereotype.Component

@Component
class PersonUpdater(
    private val personRepository: PersonRepository
) {

    fun update(businessEntityId: Int, personRequest: PersonRequest) {
        val person = personRepository.findById(businessEntityId)
            .orElseThrow { throw EntityNotFoundException("Person") }

        person.firstName = personRequest.firstName
        person.middleName = personRequest.middleName
        person.lastName = personRequest.lastName

        personRepository.save(person)
    }

}
