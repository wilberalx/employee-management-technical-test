package com.wilber.adventureworks.employeemanagement.application.person.businessentityaddress.shared

import com.wilber.adventureworks.employeemanagement.application.person.businessentityaddress.create.BusinessEntityAddressCreator
import com.wilber.adventureworks.employeemanagement.domain.repository.person.BusinessEntityAddressRepository
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

open class BusinessEntityAddressBaseTest {
    protected lateinit var businessEntityAddressRepository: BusinessEntityAddressRepository

    protected lateinit var businessEntityAddressCreator: BusinessEntityAddressCreator

    @BeforeEach
    protected fun setUp() {
        businessEntityAddressRepository = mockk()

        businessEntityAddressCreator = BusinessEntityAddressCreator(businessEntityAddressRepository)
    }

}
