package com.wilber.adventureworks.employeemanagement.domain.entities.person

import java.io.Serializable

data class PersonPhoneId(
    var businessEntityId: Int = 0,
    var phoneNumber: String = "",
    var phoneNumberTypeId: Int = 0
) : Serializable
