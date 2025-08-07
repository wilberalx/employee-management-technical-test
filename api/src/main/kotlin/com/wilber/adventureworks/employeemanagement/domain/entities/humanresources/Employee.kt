package com.wilber.adventureworks.employeemanagement.domain.entities.humanresources

import com.wilber.adventureworks.employeemanagement.domain.entities.shared.BaseEntityFields
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalDate
import java.util.UUID

@Entity
@Table(name = "Employee", schema = "HumanResources")
class Employee : BaseEntityFields() {

    @Id
    @Column(name = "BusinessEntityID")
    var businessEntityId: Int = 0

    @Column(name = "CurrentFlag")
    var currentFlag: Boolean = true

    @Column(name = "NationalIDNumber", length = 15)
    var nationalIdNumber: String = UUID.randomUUID().toString().take(10)

    @Column(name = "LoginID", length = 256)
    var loginId: String = "TEMP-${UUID.randomUUID()}"

    @Column(name = "JobTitle", length = 50)
    var jobTitle: String = ""

    @Column(name = "BirthDate")
    var birthDate: LocalDate = LocalDate.now()

    @Column(name = "MaritalStatus", length = 1)
    var maritalStatus: String = "S"

    @Column(name = "Gender", length = 1)
    var gender: String = "M"

    @Column(name = "HireDate")
    var hireDate: LocalDate = LocalDate.now()

}
