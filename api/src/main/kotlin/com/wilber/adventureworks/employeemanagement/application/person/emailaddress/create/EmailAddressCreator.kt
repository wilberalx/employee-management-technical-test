package com.wilber.adventureworks.employeemanagement.application.person.emailaddress.create

import com.wilber.adventureworks.employeemanagement.domain.entities.person.EmailAddress
import com.wilber.adventureworks.employeemanagement.domain.repository.person.EmailAddressRepository
import org.springframework.stereotype.Component

@Component
class EmailAddressCreator(
    private val emailAddressRepository: EmailAddressRepository
) {

    fun create(businessEntityId: Int, email: String) {
        val emailAddress = EmailAddress().apply {
                this.businessEntityId = businessEntityId
                this.emailAddress = email
            }
        emailAddressRepository.save(emailAddress)
    }

}
