package com.wilber.adventureworks.employeemanagement.application.person.emailaddress.shared

import com.wilber.adventureworks.employeemanagement.application.person.emailaddress.create.EmailAddressCreator
import com.wilber.adventureworks.employeemanagement.application.person.emailaddress.delete.EmailAddressDeleter
import com.wilber.adventureworks.employeemanagement.application.person.emailaddress.update.EmailAddressUpdater
import com.wilber.adventureworks.employeemanagement.domain.repository.person.EmailAddressRepository
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

open class EmailAddressBaseTest {
    protected lateinit var emailAddressRepository: EmailAddressRepository

    protected lateinit var emailAddressCreator: EmailAddressCreator
    protected lateinit var emailAddressUpdater: EmailAddressUpdater
    protected lateinit var emailAddressDeleter: EmailAddressDeleter

    @BeforeEach
    protected fun setUp() {
        emailAddressRepository = mockk()

        emailAddressCreator = EmailAddressCreator(emailAddressRepository)
        emailAddressUpdater = EmailAddressUpdater(emailAddressRepository)
        emailAddressDeleter = EmailAddressDeleter(emailAddressRepository)
    }
}
