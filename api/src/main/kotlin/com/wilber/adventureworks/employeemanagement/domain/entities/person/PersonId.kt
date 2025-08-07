package com.wilber.adventureworks.employeemanagement.domain.entities.person

import java.io.Serializable

data class PersonId(
    var businessEntityId: Int = 0
) : Serializable