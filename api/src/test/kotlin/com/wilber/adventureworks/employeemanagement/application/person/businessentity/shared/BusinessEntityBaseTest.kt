package com.wilber.adventureworks.employeemanagement.application.person.businessentity.shared

import com.wilber.adventureworks.employeemanagement.application.person.businessentity.create.BusinessEntityCreator
import com.wilber.adventureworks.employeemanagement.domain.repository.person.BusinessEntityRepository
import io.mockk.mockk
import org.junit.jupiter.api.BeforeEach

open class BusinessEntityBaseTest {
    protected lateinit var businessEntityRepository: BusinessEntityRepository

    protected lateinit var businessEntityCreator: BusinessEntityCreator

    @BeforeEach
    protected fun setUp() {
        businessEntityRepository = mockk()

        businessEntityCreator = BusinessEntityCreator(businessEntityRepository)
    }
}
