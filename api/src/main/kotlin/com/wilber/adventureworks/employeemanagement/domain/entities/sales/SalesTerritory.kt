package com.wilber.adventureworks.employeemanagement.domain.entities.sales

import com.wilber.adventureworks.employeemanagement.domain.entities.shared.BaseEntityFields
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "SalesTerritory", schema = "Sales")
class SalesTerritory: BaseEntityFields() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TerritoryID", nullable = false)
    var territoryId: Int? = null

    @Column(name = "CountryRegionCode", length = 3, nullable = false)
    var countryRegionCode: String = ""

}