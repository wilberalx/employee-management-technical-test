package com.wilber.adventureworks.employeemanagement.application.person.personphone.update

import com.wilber.adventureworks.employeemanagement.application.person.personphone.shared.PersonPhoneBaseTest
import com.wilber.adventureworks.employeemanagement.application.person.personphone.shared.PersonPhoneMother
import com.wilber.adventureworks.employeemanagement.application.shared.ApplicationConstant
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class PersonPhoneUpdaterTest : PersonPhoneBaseTest() {

    @Test
    fun shouldThrowExceptionWhenPhoneNotExists() {
        val businessEntityId = PersonPhoneMother.random().businessEntityId
        val phoneNumber = StringMother.random()

        every {
            personPhoneRepository.findByBusinessEntityIdEqualsAndPhoneNumberTypeIdEquals(
                businessEntityId,
                ApplicationConstant.phoneNumberTypeCellId
            )
        } returns null

        every { personPhoneRepository.save(any()) } returns PersonPhoneMother.random()

        assertDoesNotThrow("Should not throw if phone does not exist and is being created") {
            personPhoneUpdater.update(businessEntityId, phoneNumber)
        }

        verify(exactly = 1) {
            personPhoneRepository.findByBusinessEntityIdEqualsAndPhoneNumberTypeIdEquals(
                businessEntityId,
                ApplicationConstant.phoneNumberTypeCellId
            )
            personPhoneRepository.save(any())
        }
    }

    @Test
    fun shouldUpdatePhoneNumberIfDifferent() {
        val existing = PersonPhoneMother.random()
        val newPhone = StringMother.random()
        val businessEntityId = existing.businessEntityId

        every {
            personPhoneRepository.findByBusinessEntityIdEqualsAndPhoneNumberTypeIdEquals(
                businessEntityId,
                ApplicationConstant.phoneNumberTypeCellId
            )
        } returns existing

        every { personPhoneRepository.delete(any()) } returns Unit
        every { personPhoneRepository.save(any()) } returns existing

        assertDoesNotThrow("Should update when phone is different") {
            personPhoneUpdater.update(businessEntityId, newPhone)
        }

        verify(exactly = 1) {
            personPhoneRepository.findByBusinessEntityIdEqualsAndPhoneNumberTypeIdEquals(
                businessEntityId,
                ApplicationConstant.phoneNumberTypeCellId
            )
            personPhoneRepository.delete(existing)
            personPhoneRepository.save(any())
        }
    }

    @Test
    fun shouldNotUpdateWhenPhoneIsSame() {
        val existing = PersonPhoneMother.random()
        val samePhone = existing.phoneNumber
        val businessEntityId = existing.businessEntityId

        every {
            personPhoneRepository.findByBusinessEntityIdEqualsAndPhoneNumberTypeIdEquals(
                businessEntityId,
                ApplicationConstant.phoneNumberTypeCellId
            )
        } returns existing

        assertDoesNotThrow("Should not update when phone is same") {
            personPhoneUpdater.update(businessEntityId, samePhone)
        }

        verify(exactly = 1) {
            personPhoneRepository.findByBusinessEntityIdEqualsAndPhoneNumberTypeIdEquals(
                businessEntityId,
                ApplicationConstant.phoneNumberTypeCellId
            )
        }
    }

}
