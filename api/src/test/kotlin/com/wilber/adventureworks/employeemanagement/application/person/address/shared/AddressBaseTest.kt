package com.wilber.adventureworks.employeemanagement.application.person.address.shared

import com.wilber.adventureworks.employeemanagement.application.person.address.create.AddressCreator
import com.wilber.adventureworks.employeemanagement.application.person.address.update.AddressUpdater
import com.wilber.adventureworks.employeemanagement.domain.repository.person.AddressRepository
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

open class AddressBaseTest {
    protected lateinit var addressRepository: AddressRepository

    protected lateinit var addressCreator: AddressCreator
    protected lateinit var addressUpdater: AddressUpdater

    @BeforeEach
    protected fun setUp() {
        addressRepository = mockk()

        addressCreator = AddressCreator(addressRepository)
        addressUpdater = AddressUpdater(addressRepository)
    }

}
