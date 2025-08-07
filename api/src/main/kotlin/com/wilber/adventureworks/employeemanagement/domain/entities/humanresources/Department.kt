package com.wilber.adventureworks.employeemanagement.domain.entities.humanresources

import com.wilber.adventureworks.employeemanagement.domain.entities.shared.BaseEntityModifiedDateField
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "Department", schema = "HumanResources")
class Department : BaseEntityModifiedDateField() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DepartmentID", nullable = false)
    var departmentId: Short? = null

    @Column(name = "Name", length = 50)
    var name: String = ""

}
