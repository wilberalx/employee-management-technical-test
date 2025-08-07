package com.wilber.adventureworks.employeemanagement.application.person.stateprovince.find

import com.wilber.adventureworks.employeemanagement.application.person.stateprovince.shared.StateProvinceBaseTest
import com.wilber.adventureworks.employeemanagement.application.person.stateprovince.shared.StateProvinceMother
import com.wilber.adventureworks.employeemanagement.domain.shared.StringMother
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class StateProvinceFindByCountryFinderTest : StateProvinceBaseTest() {

    @Test
    fun shouldFindStatesByCountryCode() {
        val countryCode = StringMother.random()
        val states = listOf(StateProvinceMother.random(), StateProvinceMother.random())

        every { stateProvinceRepository.findByCountryRegion(countryCode) } returns states

        val result = stateProvinceFindByCountryFinder.find(countryCode)

        Assertions.assertEquals(states.size, result.size, "State list size must match for given country code")
    }
}
