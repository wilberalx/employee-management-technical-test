package com.wilber.adventureworks.employeemanagement.application.person.address.update

import com.wilber.adventureworks.employeemanagement.application.person.address.dto.AddressRequest
import com.wilber.adventureworks.employeemanagement.application.exceptions.EntityNotFoundException
import com.wilber.adventureworks.employeemanagement.domain.repository.person.AddressRepository
import org.springframework.stereotype.Component

@Component
class AddressUpdater(
    private val addressRepository: AddressRepository
) {

    fun update(addressId: Int, addressRequest: AddressRequest) {
        val address = addressRepository.findById(addressId).orElseThrow { throw EntityNotFoundException("Address") }

        address.addressLine1 = addressRequest.addressLine1
        address.addressLine2 = addressRequest.addressLine2
        address.city = addressRequest.city
        address.stateProvinceId = addressRequest.stateProvinceId
        address.postalCode = addressRequest.postalCode

        addressRepository.save(address)
    }

}
