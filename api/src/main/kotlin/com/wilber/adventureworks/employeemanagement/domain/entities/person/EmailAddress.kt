package com.wilber.adventureworks.employeemanagement.domain.entities.person

import com.wilber.adventureworks.employeemanagement.domain.entities.shared.BaseEntityFields
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "EmailAddress", schema = "Person")
class EmailAddress : BaseEntityFields() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EmailAddressID", nullable = false)
    var emailAddressId: Int? = null

    @Column(name = "BusinessEntityID")
    var businessEntityId: Int = 0

    @Column(name = "EmailAddress", length = 50)
    var emailAddress: String = ""

}
