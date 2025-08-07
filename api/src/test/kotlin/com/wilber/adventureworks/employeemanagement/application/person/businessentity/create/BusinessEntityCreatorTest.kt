package com.wilber.adventureworks.employeemanagement.application.person.businessentity.create

import com.wilber.adventureworks.employeemanagement.application.person.businessentity.shared.BusinessEntityBaseTest
import com.wilber.adventureworks.employeemanagement.application.person.businessentity.shared.BusinessEntityMother
import io.mockk.every
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class BusinessEntityCreatorTest : BusinessEntityBaseTest() {

    @Test
    fun shouldCreateAndReturnBusinessEntityId() {
        val businessEntity = BusinessEntityMother.random()

        every { businessEntityRepository.save(any()) } returns businessEntity

        val response = businessEntityCreator.create()

        Assertions.assertEquals(
            businessEntity.businessEntityId,
            response,
            "BusinessEntity id must be equals when created"
        )
    }
}
