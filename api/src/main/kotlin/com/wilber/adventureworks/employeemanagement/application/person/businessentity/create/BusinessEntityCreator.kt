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

//        val entity = BusinessEntity()
//        val person = Person().apply {
//            this.businessEntity = entity
//            this.personType = ApplicationConstant.personTypeEmployee
//            this.firstName = "Nombre"
//            this.middleName = null
//            this.lastName = "Apellido"
//        }
//        entity.person = person // 🔥 ¡Importante para evitar fetch cíclico o null!
//        return BusinessEntity()
    }

}
