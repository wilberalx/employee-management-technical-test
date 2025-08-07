package com.wilber.adventureworks.employeemanagement.application.person.businessentity.create

import com.wilber.adventureworks.employeemanagement.domain.entities.person.BusinessEntity
import com.wilber.adventureworks.employeemanagement.domain.repository.person.BusinessEntityRepository
import org.springframework.stereotype.Component

@Component
class BusinessEntityCreator(
    private val businessEntityRepository: BusinessEntityRepository
) {

    fun create(): Int {
        return businessEntityRepository.save(BusinessEntity()).businessEntityId!!
    }

}
