package com.wilber.adventureworks.employeemanagement.application.person.stateprovince.shared

import com.wilber.adventureworks.employeemanagement.application.person.stateprovince.find.StateProvinceFindByCountryFinder
import com.wilber.adventureworks.employeemanagement.domain.repository.person.StateProvinceRepository
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

open class StateProvinceBaseTest {
    protected lateinit var stateProvinceRepository: StateProvinceRepository

    protected lateinit var stateProvinceFindByCountryFinder: StateProvinceFindByCountryFinder

    @BeforeEach
    protected fun setUp() {
        stateProvinceRepository = mockk()

        stateProvinceFindByCountryFinder = StateProvinceFindByCountryFinder(stateProvinceRepository)
    }

}
