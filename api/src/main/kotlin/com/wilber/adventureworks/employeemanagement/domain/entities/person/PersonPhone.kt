package com.wilber.adventureworks.employeemanagement.domain.entities.person

import com.wilber.adventureworks.employeemanagement.domain.entities.shared.BaseEntityModifiedDateField
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.Table

@Entity
@IdClass(PersonPhoneId::class)
@Table(name = "PersonPhone", schema = "Person")
class PersonPhone : BaseEntityModifiedDateField() {

    @Id
    @Column(name = "BusinessEntityID")
    var businessEntityId: Int = 0

    @Id
    @Column(name = "PhoneNumber", length = 25)
    var phoneNumber: String = ""

    @Id
    @Column(name = "PhoneNumberTypeID")
    var phoneNumberTypeId: Int = 0

}
