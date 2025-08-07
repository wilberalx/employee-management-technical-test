package com.wilber.adventureworks.employeemanagement.application.person.countryregion.shared

import com.wilber.adventureworks.employeemanagement.application.person.countryregion.find.CountryRegionFindAllFinder
import com.wilber.adventureworks.employeemanagement.domain.repository.person.CountryRegionRepository
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

open class CountryRegionBaseTest {
    protected lateinit var countryRegionRepository: CountryRegionRepository

    protected lateinit var countryRegionFindAllFinder: CountryRegionFindAllFinder

    @BeforeEach
    protected fun setUp() {
        countryRegionRepository = mockk()

        countryRegionFindAllFinder = CountryRegionFindAllFinder(countryRegionRepository)
    }

}
