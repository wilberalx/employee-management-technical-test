package com.wilber.adventureworks.employeemanagement.domain.repository.person

import com.wilber.adventureworks.employeemanagement.domain.entities.person.PersonPhone
import com.wilber.adventureworks.employeemanagement.domain.entities.person.PersonPhoneId
import org.springframework.data.jpa.repository.JpaRepository

interface PersonPhoneRepository : JpaRepository<PersonPhone, PersonPhoneId> {

    fun findByBusinessEntityIdEqualsAndPhoneNumberTypeIdEquals(
        businessEntityId: Int,
        phoneNumberTypeId: Int
    ): PersonPhone?

}
