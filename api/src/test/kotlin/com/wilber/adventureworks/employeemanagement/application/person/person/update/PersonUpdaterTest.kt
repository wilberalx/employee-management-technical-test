package com.wilber.adventureworks.employeemanagement.application.person.person.update

import com.wilber.adventureworks.employeemanagement.application.exceptions.EntityNotFoundException
import com.wilber.adventureworks.employeemanagement.application.person.person.dto.PersonRequest
import com.wilber.adventureworks.employeemanagement.application.person.person.shared.PersonBaseTest
import com.wilber.adventureworks.employeemanagement.application.person.person.shared.PersonMother
import com.wilber.adventureworks.employeemanagement.application.person.person.shared.PersonRequestMother
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import java.util.*


internal class PersonUpdaterTest : PersonBaseTest() {

    @Test
    fun shouldThrowExceptionWhenNotFoundPersonById() {
        val request = PersonRequestMother.random()

        every { personRepository.findById(any()) } returns Optional.empty()

        Assertions.assertThrows(
            EntityNotFoundException::class.java, {
                personUpdater.update(NumberMother.randomInt(), request)
            },
            "Must throw EntityNotFoundException when person not found"
        )

        verify(exactly = 1) {
            personRepository.findById(any())
        }
    }

    @Test
    fun shouldUpdateExistingPerson() {
        val person = PersonMother.random()
        val request = PersonRequest(
            firstName = StringMother.random(),
            middleName = StringMother.random(),
            lastName = StringMother.random()
        )
        val personId = person.businessEntityId!!

        every { personRepository.findById(any()) } returns Optional.of(person)
        every { personRepository.save(any()) } returns person

        assertDoesNotThrow("Updating a person should not throw") {
            personUpdater.update(person.businessEntityId!!, request)
        }

        verify(exactly = 1) {
            personRepository.findById(personId)
            personRepository.save(withArg {
                Assertions.assertEquals(personId, it.businessEntityId)
            })
        }
    }
}
