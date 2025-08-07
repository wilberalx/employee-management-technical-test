package com.wilber.adventureworks.employeemanagement.domain.entities.person

import com.wilber.adventureworks.employeemanagement.domain.entities.shared.BaseEntityFields
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "Address", schema = "Person")
class Address : BaseEntityFields() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID", nullable = false)
    var addressId: Int? = null

    @Column(name = "AddressLine1", length = 60, nullable = false)
    var addressLine1: String = ""

    @Column(name = "AddressLine2", length = 60)
    var addressLine2: String? = null

    @Column(name = "City", length = 30, nullable = false)
    var city: String = ""

    @Column(name = "StateProvinceID", nullable = false)
    var stateProvinceId: Int = 0

    @Column(name = "PostalCode", length = 15, nullable = false)
    var postalCode: String = ""

}
