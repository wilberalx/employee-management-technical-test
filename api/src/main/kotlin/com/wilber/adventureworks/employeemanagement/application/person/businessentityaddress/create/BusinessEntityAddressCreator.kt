package com.wilber.adventureworks.employeemanagement.application.person.businessentityaddress.create

import com.wilber.adventureworks.employeemanagement.application.shared.ApplicationConstant
import com.wilber.adventureworks.employeemanagement.domain.entities.person.BusinessEntityAddress
import com.wilber.adventureworks.employeemanagement.domain.repository.person.BusinessEntityAddressRepository
import org.springframework.stereotype.Component

@Component
class BusinessEntityAddressCreator(
    private val businessEntityAddressRepository: BusinessEntityAddressRepository
) {

    fun create(businessEntityId: Int, addressId: Int) {
        val businessEntityAddress = BusinessEntityAddress().apply {
            this.businessEntityId = businessEntityId
            this.addressId = addressId
            this.addressTypeId = ApplicationConstant.addressTypeHomeId
        }

        businessEntityAddressRepository.save(businessEntityAddress)
    }

}
