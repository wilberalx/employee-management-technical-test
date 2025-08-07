package com.wilber.adventureworks.employeemanagement.domain.entities.person

import com.wilber.adventureworks.employeemanagement.domain.entities.shared.BaseEntityModifiedDateField
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "CountryRegion", schema = "Person")
class CountryRegion : BaseEntityModifiedDateField() {

    @Id
    @Column(name = "CountryRegionCode", length = 3, nullable = false)
    var countryRegionCode: String = ""

    @Column(name = "Name", nullable = false)
    var name: String = ""

}
