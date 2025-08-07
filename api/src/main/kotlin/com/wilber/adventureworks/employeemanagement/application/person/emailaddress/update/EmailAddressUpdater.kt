package com.wilber.adventureworks.employeemanagement.application.person.emailaddress.update

import com.wilber.adventureworks.employeemanagement.application.exceptions.EntityNotFoundException
import com.wilber.adventureworks.employeemanagement.domain.repository.person.EmailAddressRepository
import org.springframework.stereotype.Component

@Component
class EmailAddressUpdater(
    private val emailAddressRepository: EmailAddressRepository
) {

    fun update(emailAddressId: Int, email: String) {
        val emailAddress = emailAddressRepository.findById(emailAddressId)
            .orElseThrow { throw EntityNotFoundException("EmailAddress") }

        emailAddress.emailAddress = email
        emailAddressRepository.save(emailAddress)
    }

}
