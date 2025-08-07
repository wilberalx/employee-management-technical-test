package com.wilber.adventureworks.employeemanagement.api.controller.shift.dto

import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.Shift
import java.time.LocalTime

class ShiftJson {

    var shiftId: Byte = 0
    var name: String = ""
    var startTime: LocalTime = LocalTime.MIN
    var endTime: LocalTime = LocalTime.MAX

    constructor()

    constructor(shift: Shift) {
        this.shiftId = shift.shiftId!!
        this.name = shift.name
        this.startTime = shift.startTime
        this.endTime = shift.endTime
    }

}
