package com.wilber.adventureworks.employeemanagement.application.person.person.shared

import com.wilber.adventureworks.employeemanagement.application.person.person.create.PersonCreator
import com.wilber.adventureworks.employeemanagement.application.person.person.update.PersonUpdater
import com.wilber.adventureworks.employeemanagement.domain.repository.person.PersonRepository
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

open class PersonBaseTest {
    protected lateinit var personRepository: PersonRepository

    protected lateinit var personCreator: PersonCreator
    protected lateinit var personUpdater: PersonUpdater

    @BeforeEach
    protected fun setUp() {
        personRepository = mockk()

        personCreator = PersonCreator(personRepository)
        personUpdater = PersonUpdater(personRepository)
    }
}
