package com.wilber.adventureworks.employeemanagement.application.person.personphone.create

import com.wilber.adventureworks.employeemanagement.application.shared.ApplicationConstant
import com.wilber.adventureworks.employeemanagement.domain.entities.person.PersonPhone
import com.wilber.adventureworks.employeemanagement.domain.repository.person.PersonPhoneRepository
import org.springframework.stereotype.Component

@Component
class PersonPhoneCreator(
    private val personPhoneRepository: PersonPhoneRepository
) {

    fun create(businessEntityId: Int, phoneNumber: String) {
        val personPhone = PersonPhone().apply {
                this.businessEntityId = businessEntityId
                this.phoneNumber = phoneNumber
                this.phoneNumberTypeId = ApplicationConstant.phoneNumberTypeCellId
            }
        personPhoneRepository.save(personPhone)
    }

}
