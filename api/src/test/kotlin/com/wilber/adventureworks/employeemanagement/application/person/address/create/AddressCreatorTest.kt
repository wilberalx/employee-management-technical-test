package com.wilber.adventureworks.employeemanagement.application.person.address.create

import com.wilber.adventureworks.employeemanagement.application.person.address.shared.AddressBaseTest
import com.wilber.adventureworks.employeemanagement.application.person.address.shared.AddressMother
import com.wilber.adventureworks.employeemanagement.application.person.address.shared.AddressRequestMother
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class AddressCreatorTest : AddressBaseTest() {

    @Test
    fun shouldCreateAndReturnAddress() {
        val address = AddressMother.random()

        every { addressRepository.save(any()) } returns address

        val response = addressCreator.create(AddressRequestMother.random())

        Assertions.assertEquals(address.addressId, response, "Address id must be equals when created by request")
    }

}
