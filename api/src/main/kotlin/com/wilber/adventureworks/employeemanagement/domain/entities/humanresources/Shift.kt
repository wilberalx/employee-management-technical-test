package com.wilber.adventureworks.employeemanagement.domain.entities.humanresources

import com.wilber.adventureworks.employeemanagement.domain.entities.shared.BaseEntityModifiedDateField
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.time.LocalTime

@Entity
@Table(name = "Shift", schema = "HumanResources")
class Shift : BaseEntityModifiedDateField() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ShiftID", nullable = false)
    var shiftId: Byte? = null

    @Column(name = "Name", length = 50)
    var name: String = ""

    @Column(name = "StartTime")
    var startTime: LocalTime = LocalTime.MIN

    @Column(name = "EndTime")
    var endTime: LocalTime = LocalTime.MIN

}
