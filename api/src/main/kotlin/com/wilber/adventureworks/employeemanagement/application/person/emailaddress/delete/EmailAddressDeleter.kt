package com.wilber.adventureworks.employeemanagement.application.person.emailaddress.delete

import com.wilber.adventureworks.employeemanagement.application.exceptions.EntityNotFoundException
import com.wilber.adventureworks.employeemanagement.domain.repository.person.EmailAddressRepository
import org.springframework.stereotype.Component

@Component
class EmailAddressDeleter(
    private val emailAddressRepository: EmailAddressRepository
) {

    fun delete(emailAddressId: Int) {
        val emailAddress = emailAddressRepository.findById(emailAddressId)
            .orElseThrow { throw EntityNotFoundException("EmailAddress") }
        emailAddressRepository.delete(emailAddress)
    }

}
