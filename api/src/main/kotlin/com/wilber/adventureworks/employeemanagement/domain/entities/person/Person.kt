package com.wilber.adventureworks.employeemanagement.domain.entities.person

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "Person", schema = "Person")
class Person(

    @Column(name = "PersonType", nullable = false, length = 2)
    var personType: String = "",

    @Column(name = "FirstName", nullable = false)
    var firstName: String = "",

    @Column(name = "MiddleName")
    var middleName: String? = null,

    @Column(name = "LastName", nullable = false)
    var lastName: String
) : BusinessEntity()
