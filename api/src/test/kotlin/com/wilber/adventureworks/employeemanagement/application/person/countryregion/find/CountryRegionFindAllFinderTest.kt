package com.wilber.adventureworks.employeemanagement.application.person.countryregion.find

import com.wilber.adventureworks.employeemanagement.application.person.countryregion.shared.CountryRegionBaseTest
import com.wilber.adventureworks.employeemanagement.application.person.countryregion.shared.CountryRegionMother
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class CountryRegionFindAllFinderTest : CountryRegionBaseTest() {

    @Test
    fun shouldFindAllCountries() {
        val countries = listOf(CountryRegionMother.random(), CountryRegionMother.random())

        every { countryRegionRepository.findAll() } returns countries

        val result = countryRegionFindAllFinder.find()

        Assertions.assertEquals(countries.size, result.size, "Country list size must match the expected size")
    }
}
