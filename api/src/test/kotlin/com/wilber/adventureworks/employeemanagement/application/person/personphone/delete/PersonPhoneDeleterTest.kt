package com.wilber.adventureworks.employeemanagement.application.person.personphone.delete

import com.wilber.adventureworks.employeemanagement.application.exceptions.EntityNotFoundException
import com.wilber.adventureworks.employeemanagement.application.person.personphone.shared.PersonPhoneBaseTest
import com.wilber.adventureworks.employeemanagement.application.person.personphone.shared.PersonPhoneMother
import com.wilber.adventureworks.employeemanagement.application.shared.ApplicationConstant
import com.wilber.adventureworks.employeemanagement.domain.entities.person.PersonPhoneId
import io.mockk.every
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import java.util.*

internal class PersonPhoneDeleterTest : PersonPhoneBaseTest() {

    @Test
    fun shouldThrowExceptionWhenNotFoundPersonPhone() {
        val personPhone = PersonPhoneMother.random()
        val id = PersonPhoneId(
            personPhone.businessEntityId,
            personPhone.phoneNumber,
            ApplicationConstant.phoneNumberTypeCellId
        )

        every { personPhoneRepository.findById(id) } returns Optional.empty()

        Assertions.assertThrows(EntityNotFoundException::class.java) {
            personPhoneDeleter.delete(personPhone.businessEntityId, personPhone.phoneNumber)
        }

        verify(exactly = 1) {
            personPhoneRepository.findById(id)
        }
    }

    @Test
    fun shouldDeletePersonPhone() {
        val personPhone = PersonPhoneMother.random()
        val id = PersonPhoneId(
            personPhone.businessEntityId,
            personPhone.phoneNumber,
            ApplicationConstant.phoneNumberTypeCellId
        )

        every { personPhoneRepository.findById(id) } returns Optional.of(personPhone)
        every { personPhoneRepository.delete(any()) } just runs

        personPhoneDeleter.delete(personPhone.businessEntityId, personPhone.phoneNumber)

        verify(exactly = 1) {
            personPhoneRepository.findById(id)
            personPhoneRepository.delete(personPhone)
        }
    }

}
