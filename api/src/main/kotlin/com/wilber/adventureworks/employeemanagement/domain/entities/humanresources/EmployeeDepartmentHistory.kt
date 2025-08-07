package com.wilber.adventureworks.employeemanagement.domain.entities.humanresources

import com.wilber.adventureworks.employeemanagement.domain.entities.shared.BaseEntityModifiedDateField
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.IdClass
import jakarta.persistence.Table
import java.time.LocalDate

@Entity
@IdClass(EmployeeDepartmentHistoryId::class)
@Table(name = "EmployeeDepartmentHistory", schema = "HumanResources")
class EmployeeDepartmentHistory : BaseEntityModifiedDateField() {

    @Id
    @Column(name = "BusinessEntityID")
    var businessEntityId: Int = 0

    @Id
    @Column(name = "StartDate")
    var startDate: LocalDate = LocalDate.now()

    @Id
    @Column(name = "DepartmentID")
    var departmentId: Short = 0

    @Id
    @Column(name = "ShiftID")
    var shiftId: Byte = 0

    @Column(name = "EndDate")
    var endDate: LocalDate? = null

}
