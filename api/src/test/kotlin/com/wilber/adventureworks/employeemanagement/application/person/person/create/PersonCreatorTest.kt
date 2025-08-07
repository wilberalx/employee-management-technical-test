package com.wilber.adventureworks.employeemanagement.application.person.person.create

import com.wilber.adventureworks.employeemanagement.application.person.person.shared.PersonBaseTest
import com.wilber.adventureworks.employeemanagement.application.person.person.shared.PersonMother
import com.wilber.adventureworks.employeemanagement.application.person.person.shared.PersonRequestMother
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class PersonCreatorTest : PersonBaseTest() {

    @Test
    fun shouldCreatePerson() {
        val request = PersonRequestMother.random()
        val person = PersonMother.random()

        every { personRepository.save(any()) } returns person

        assertDoesNotThrow("Creating a person should not throw") {
            personCreator.create(request)
        }

        verify(exactly = 1) {
            personRepository.save(withArg {
                Assertions.assertEquals(request.firstName, it.firstName)
                Assertions.assertEquals(request.middleName, it.middleName)
                Assertions.assertEquals(request.lastName, it.lastName)
                Assertions.assertEquals("EM", it.personType)
            })
        }
    }
}
