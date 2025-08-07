package com.wilber.adventureworks.employeemanagement.domain.entities.person

import com.wilber.adventureworks.employeemanagement.domain.entities.shared.BaseEntityFields
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "StateProvince", schema = "Person")
class StateProvince : BaseEntityFields() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "StateProvinceID", nullable = false)
    var stateProvinceId: Int? = null

    @Column(name = "StateProvinceCode", length = 3, nullable = false)
    var stateProvinceCode: String = ""

    @Column(name = "CountryRegionCode", length = 3, nullable = false)
    var countryRegionCode: String = ""

    @Column(name = "Name", nullable = false)
    var name: String = ""

}
