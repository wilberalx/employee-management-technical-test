package com.wilber.adventureworks.employeemanagement.application.person.address.create

import com.wilber.adventureworks.employeemanagement.application.person.address.dto.AddressRequest
import com.wilber.adventureworks.employeemanagement.domain.entities.person.Address
import com.wilber.adventureworks.employeemanagement.domain.repository.person.AddressRepository
import org.springframework.stereotype.Component

@Component
class AddressCreator(
    private val addressRepository: AddressRepository
) {

    fun create(addressRequest: AddressRequest): Int {
        val address = Address().apply {
            this.addressLine1 = addressRequest.addressLine1
            this.addressLine2 = addressRequest.addressLine2
            this.city = addressRequest.city
            this.stateProvinceId = addressRequest.stateProvinceId
            this.postalCode = addressRequest.postalCode
            }
        val addressCreated = addressRepository.save(address)
        return addressCreated.addressId!!
    }

}
