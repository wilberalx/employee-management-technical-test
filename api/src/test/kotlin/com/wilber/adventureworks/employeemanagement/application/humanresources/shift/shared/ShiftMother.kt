package com.wilber.adventureworks.employeemanagement.application.humanresources.shift.shared

import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.Shift
import com.wilber.adventureworks.employeemanagement.domain.shared.NumberMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother
import java.time.LocalTime

object ShiftMother {

    fun random(): Shift {
        return Shift().apply {
            this.shiftId = NumberMother.randomByte()
            this.name = StringMother.random()
            this.startTime = LocalTime.MIN
            this.endTime = LocalTime.MAX
        }
    }

}
