package com.wilber.adventureworks.employeemanagement.application.person.emailaddress.create

import com.wilber.adventureworks.employeemanagement.application.person.emailaddress.shared.EmailAddressBaseTest
import com.wilber.adventureworks.employeemanagement.application.person.emailaddress.shared.EmailAddressMother
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class EmailAddressCreatorTest : EmailAddressBaseTest() {

    @Test
    fun shouldCreateEmailAddress() {
        val emailAddress = EmailAddressMother.random()
        val businessEntityId = NumberMother.randomInt()
        val email = StringMother.random()

        every { emailAddressRepository.save(any()) } returns emailAddress

        assertDoesNotThrow("Creating an email address should not throw") {
            emailAddressCreator.create(businessEntityId, email)
        }

        verify(exactly = 1) {
            emailAddressRepository.save(withArg {
                Assertions.assertEquals(businessEntityId, it.businessEntityId)
                Assertions.assertEquals(email, it.emailAddress)
            })
        }
    }
}