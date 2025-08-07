package com.wilber.adventureworks.employeemanagement.domain.entities.person

import com.wilber.adventureworks.employeemanagement.domain.entities.shared.BaseEntityFields
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.Table

@Entity
@IdClass(BusinessEntityAddressId::class)
@Table(name = "BusinessEntityAddress", schema = "Person")
class BusinessEntityAddress : BaseEntityFields() {

    @Id
    @Column(name = "BusinessEntityID")
    var businessEntityId: Int = 0

    @Id
    @Column(name = "AddressID")
    var addressId: Int = 0

    @Id
    @Column(name = "AddressTypeID")
    var addressTypeId: Int = 0

}
