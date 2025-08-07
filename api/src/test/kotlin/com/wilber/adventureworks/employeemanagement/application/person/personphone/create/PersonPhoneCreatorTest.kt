package com.wilber.adventureworks.employeemanagement.application.person.personphone.create

import com.wilber.adventureworks.employeemanagement.application.person.personphone.shared.PersonPhoneBaseTest
import com.wilber.adventureworks.employeemanagement.application.person.personphone.shared.PersonPhoneMother
import io.mockk.every
import io.mockk.just
import io.mockk.runs
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class PersonPhoneCreatorTest : PersonPhoneBaseTest() {

    @Test
    fun shouldCreatePersonPhone() {
        val personPhone = PersonPhoneMother.random()

        every { personPhoneRepository.save(any()) } returns personPhone

        personPhoneCreator.create(personPhone.businessEntityId, personPhone.phoneNumber)

        verify(exactly = 1) {
            personPhoneRepository.save(withArg {
                assert(it.businessEntityId == personPhone.businessEntityId)
                assert(it.phoneNumber == personPhone.phoneNumber)
                assert(it.phoneNumberTypeId == personPhone.phoneNumberTypeId)
            })
        }
    }

}
