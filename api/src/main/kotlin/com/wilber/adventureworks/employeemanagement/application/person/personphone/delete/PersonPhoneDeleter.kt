package com.wilber.adventureworks.employeemanagement.application.person.personphone.delete

import com.wilber.adventureworks.employeemanagement.application.exceptions.EntityNotFoundException
import com.wilber.adventureworks.employeemanagement.application.shared.ApplicationConstant
import com.wilber.adventureworks.employeemanagement.domain.entities.person.PersonPhoneId
import com.wilber.adventureworks.employeemanagement.domain.repository.person.PersonPhoneRepository
import org.springframework.stereotype.Component

@Component
class PersonPhoneDeleter(
    private val personPhoneRepository: PersonPhoneRepository
) {

    fun delete(businessEntityId: Int, phoneNumber: String) {
        val id = PersonPhoneId(businessEntityId, phoneNumber, ApplicationConstant.phoneNumberTypeCellId)
        val personPhone =
            personPhoneRepository.findById(id).orElseThrow { throw EntityNotFoundException("PersonPhone") }
        personPhoneRepository.delete(personPhone)
    }

}
