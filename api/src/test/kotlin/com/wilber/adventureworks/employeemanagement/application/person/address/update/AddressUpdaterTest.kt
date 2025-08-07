package com.wilber.adventureworks.employeemanagement.application.person.address.update

import com.wilber.adventureworks.employeemanagement.application.exceptions.EntityNotFoundException
import com.wilber.adventureworks.employeemanagement.application.person.address.shared.AddressBaseTest
import com.wilber.adventureworks.employeemanagement.application.person.address.shared.AddressMother
import com.wilber.adventureworks.employeemanagement.application.person.address.shared.AddressRequestMother
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import io.mockk.every
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import java.util.*

internal class AddressUpdaterTest : AddressBaseTest() {

    @Test
    fun shouldThrowExceptionWhenNotFoundAddressById() {
        val addressId = NumberMother.randomInt()
        val request = AddressRequestMother.random()

        every { addressRepository.findById(addressId) } returns Optional.empty()

        Assertions.assertThrows(
            EntityNotFoundException::class.java, {
                addressUpdater.update(addressId, request)
            },
            "Must throw EntityNotFoundException when address not found"
        )

        verify(exactly = 1) {
            addressRepository.findById(addressId)
        }
    }

    @Test
    fun shouldUpdateExistingAddress() {
        val address = AddressMother.random()
        val request = AddressRequestMother.random()
        val addressId = address.addressId!!

        every { addressRepository.findById(any()) } returns Optional.of(address)
        every { addressRepository.save(any()) } returns address

        assertDoesNotThrow("Updating an address should not throw") {
            addressUpdater.update(addressId, request)
        }

        verify(exactly = 1) {
            addressRepository.findById(addressId)
            addressRepository.save(withArg {
                Assertions.assertEquals(addressId, it.addressId)
            })
        }
    }

}
