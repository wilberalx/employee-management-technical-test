package com.wilber.adventureworks.employeemanagement.application.person.personphone.update

import com.wilber.adventureworks.employeemanagement.application.person.personphone.create.PersonPhoneCreator
import com.wilber.adventureworks.employeemanagement.application.shared.ApplicationConstant
import com.wilber.adventureworks.employeemanagement.domain.repository.person.PersonPhoneRepository
import org.springframework.stereotype.Component

@Component
class PersonPhoneUpdater(
    private val personPhoneRepository: PersonPhoneRepository,
    private val personPhoneCreator: PersonPhoneCreator
) {

    fun update(businessEntityId: Int, phoneNumber: String) {
        personPhoneRepository.findByBusinessEntityIdEqualsAndPhoneNumberTypeIdEquals(
            businessEntityId,
            ApplicationConstant.phoneNumberTypeCellId
        )?.let {
            if (it.phoneNumber == phoneNumber) {
                return
            }
            personPhoneRepository.delete(it)
        }

        personPhoneCreator.create(businessEntityId, phoneNumber)
    }

}
