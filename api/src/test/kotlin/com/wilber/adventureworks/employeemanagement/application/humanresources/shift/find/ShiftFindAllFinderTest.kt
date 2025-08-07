package com.wilber.adventureworks.employeemanagement.application.humanresources.shift.find

import com.wilber.adventureworks.employeemanagement.application.humanresources.shift.shared.ShiftBaseTest
import com.wilber.adventureworks.employeemanagement.application.humanresources.shift.shared.ShiftMother
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ShiftFindAllFinderTest : ShiftBaseTest() {

    @Test
    fun shouldReturnAllShifts() {
        val shifts = listOf(
            ShiftMother.random(),
            ShiftMother.random()
        )

        every { shiftRepository.findAll() } returns shifts

        val result = shiftFindAllFinder.find()

        Assertions.assertEquals(shifts.size, result.size, "Must return all shifts from repository")
    }
}
