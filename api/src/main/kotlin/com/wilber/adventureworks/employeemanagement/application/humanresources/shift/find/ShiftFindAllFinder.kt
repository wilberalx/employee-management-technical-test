package com.wilber.adventureworks.employeemanagement.application.humanresources.shift.find

import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.Shift
import com.wilber.adventureworks.employeemanagement.domain.repository.humanresources.ShiftRepository
import org.springframework.stereotype.Component

@Component
class ShiftFindAllFinder(
    private val shiftRepository: ShiftRepository
) {

    fun find(): List<Shift> {
        return shiftRepository.findAll()
    }

}
