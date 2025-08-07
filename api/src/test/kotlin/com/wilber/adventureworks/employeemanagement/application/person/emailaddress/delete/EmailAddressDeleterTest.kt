package com.wilber.adventureworks.employeemanagement.application.person.emailaddress.delete

import com.wilber.adventureworks.employeemanagement.application.exceptions.EntityNotFoundException
import com.wilber.adventureworks.employeemanagement.application.person.emailaddress.shared.EmailAddressBaseTest
import com.wilber.adventureworks.employeemanagement.application.person.emailaddress.shared.EmailAddressMother
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import io.mockk.Runs
import io.mockk.every
import io.mockk.just
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import java.util.*

internal class EmailAddressDeleterTest : EmailAddressBaseTest() {

    @Test
    fun shouldThrowExceptionWhenNotFoundEmailAddressById() {
        val emailAddressId = NumberMother.randomInt()

        every { emailAddressRepository.findById(emailAddressId) } returns Optional.empty()

        Assertions.assertThrows(
            EntityNotFoundException::class.java,
            {
                emailAddressDeleter.delete(emailAddressId)
            },
            "Must throw EntityNotFoundException when email address not found"
        )

        verify(exactly = 1) {
            emailAddressRepository.findById(emailAddressId)
        }
    }

    @Test
    fun shouldDeleteExistingEmailAddress() {
        val emailAddress = EmailAddressMother.random()
        val emailAddressId = emailAddress.emailAddressId!!

        every { emailAddressRepository.findById(emailAddressId) } returns Optional.of(emailAddress)
        every { emailAddressRepository.delete(any()) } just Runs

        assertDoesNotThrow("Deleting an email address should not throw") {
            emailAddressDeleter.delete(emailAddressId)
        }

        verify(exactly = 1) {
            emailAddressRepository.findById(emailAddressId)
            emailAddressRepository.delete(emailAddress)
        }
    }
}
