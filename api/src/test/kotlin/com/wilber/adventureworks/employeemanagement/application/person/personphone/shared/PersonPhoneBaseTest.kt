package com.wilber.adventureworks.employeemanagement.application.person.personphone.shared

import com.wilber.adventureworks.employeemanagement.application.person.personphone.create.PersonPhoneCreator
import com.wilber.adventureworks.employeemanagement.application.person.personphone.delete.PersonPhoneDeleter
import com.wilber.adventureworks.employeemanagement.application.person.personphone.update.PersonPhoneUpdater
import com.wilber.adventureworks.employeemanagement.domain.repository.person.PersonPhoneRepository
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

open class PersonPhoneBaseTest {

    protected lateinit var personPhoneRepository: PersonPhoneRepository

    protected lateinit var personPhoneCreator: PersonPhoneCreator
    protected lateinit var personPhoneDeleter: PersonPhoneDeleter
    protected lateinit var personPhoneUpdater: PersonPhoneUpdater

    @BeforeEach
    protected fun setUp() {
        personPhoneRepository = mockk()
        personPhoneCreator = PersonPhoneCreator(personPhoneRepository)
        personPhoneDeleter = PersonPhoneDeleter(personPhoneRepository)
        personPhoneUpdater = PersonPhoneUpdater(personPhoneRepository, personPhoneCreator)
    }
}
