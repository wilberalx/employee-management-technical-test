package com.wilber.adventureworks.employeemanagement.application.person.emailaddress.update

import com.wilber.adventureworks.employeemanagement.application.exceptions.EntityNotFoundException
import com.wilber.adventureworks.employeemanagement.application.person.emailaddress.shared.EmailAddressBaseTest
import com.wilber.adventureworks.employeemanagement.application.person.emailaddress.shared.EmailAddressMother
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import java.util.*

internal class EmailAddressUpdaterTest : EmailAddressBaseTest() {

    @Test
    fun shouldThrowExceptionWhenNotFoundEmailAddressById() {
        val emailAddressId = NumberMother.randomInt()
        val email = StringMother.random()

        every { emailAddressRepository.findById(emailAddressId) } returns Optional.empty()

        Assertions.assertThrows(
            EntityNotFoundException::class.java,
            {
                emailAddressUpdater.update(emailAddressId, email)
            },
            "Must throw EntityNotFoundException when email address not found"
        )

        verify(exactly = 1) {
            emailAddressRepository.findById(emailAddressId)
        }
    }

    @Test
    fun shouldUpdateExistingEmailAddress() {
        val emailAddress = EmailAddressMother.random()
        val email = StringMother.random()
        val emailAddressId = emailAddress.emailAddressId!!

        every { emailAddressRepository.findById(emailAddressId) } returns Optional.of(emailAddress)
        every { emailAddressRepository.save(any()) } returns emailAddress

        assertDoesNotThrow("Updating an email address should not throw") {
            emailAddressUpdater.update(emailAddressId, email)
        }

        verify(exactly = 1) {
            emailAddressRepository.findById(emailAddressId)
            emailAddressRepository.save(withArg {
                Assertions.assertEquals(emailAddressId, it.emailAddressId)
                Assertions.assertEquals(email, it.emailAddress)
            })
        }
    }
}
