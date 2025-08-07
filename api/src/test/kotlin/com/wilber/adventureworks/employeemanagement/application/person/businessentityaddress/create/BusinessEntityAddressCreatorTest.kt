package com.wilber.adventureworks.employeemanagement.application.person.businessentityaddress.create

import com.wilber.adventureworks.employeemanagement.application.person.businessentityaddress.shared.BusinessEntityAddressBaseTest
import com.wilber.adventureworks.employeemanagement.application.person.businessentityaddress.shared.BusinessEntityAddressMother
import io.mockk.every
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow

internal class BusinessEntityAddressCreatorTest : BusinessEntityAddressBaseTest() {

    @Test
    fun shouldCreateBusinessEntityAddress() {
        val businessEntityAddress = BusinessEntityAddressMother.random()

        every { businessEntityAddressRepository.save(any()) } returns businessEntityAddress

        assertDoesNotThrow("Creating a business entity address should not throw") {
            businessEntityAddressCreator.create(
                businessEntityAddress.businessEntityId,
                businessEntityAddress.addressId
            )
        }
    }
}
