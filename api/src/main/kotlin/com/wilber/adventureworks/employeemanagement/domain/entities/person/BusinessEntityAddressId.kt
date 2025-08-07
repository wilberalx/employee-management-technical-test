package com.wilber.adventureworks.employeemanagement.domain.entities.person

import java.io.Serializable

data class BusinessEntityAddressId(
    var businessEntityId: Int = 0,
    var addressId: Int = 0,
    var addressTypeId: Int = 0
) : Serializable