package com.wilber.adventureworks.employeemanagement.application.humanresources.shift.shared

import com.wilber.adventureworks.employeemanagement.application.humanresources.shift.find.ShiftFindAllFinder
import com.wilber.adventureworks.employeemanagement.domain.repository.humanresources.ShiftRepository
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

open class ShiftBaseTest {
    protected lateinit var shiftRepository: ShiftRepository

    protected lateinit var shiftFindAllFinder: ShiftFindAllFinder

    @BeforeEach
    protected fun setUp() {
        shiftRepository = mockk()

        shiftFindAllFinder = ShiftFindAllFinder(shiftRepository)
    }
}
