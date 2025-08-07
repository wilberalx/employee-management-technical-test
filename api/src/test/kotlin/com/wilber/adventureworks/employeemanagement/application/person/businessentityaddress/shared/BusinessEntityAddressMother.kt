package com.wilber.adventureworks.employeemanagement.application.person.businessentityaddress.shared

import com.wilber.adventureworks.employeemanagement.application.shared.ApplicationConstant
import com.wilber.adventureworks.employeemanagement.domain.entities.person.BusinessEntityAddress
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother

object BusinessEntityAddressMother {

    fun random(): BusinessEntityAddress {
        return BusinessEntityAddress().apply {
            this.businessEntityId = NumberMother.randomInt()
            this.addressId = NumberMother.randomInt()
            this.addressTypeId = ApplicationConstant.addressTypeHomeId
        }
    }

}
