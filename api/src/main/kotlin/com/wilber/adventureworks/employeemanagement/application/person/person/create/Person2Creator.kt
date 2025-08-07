package com.wilber.adventureworks.employeemanagement.application.person.person.create

//import com.wilber.adventureworks.employeemanagement.application.person.person.dto.PersonRequest
//import com.wilber.adventureworks.employeemanagement.domain.repository.person.Person2Repository
//import org.springframework.stereotype.Component
//
////@Component
////class Person2Creator(
////    private val personRepository: Person2Repository
////) {
////
////
////    fun create2(request: PersonRequest): Int {
//////        val person = Person2(
//////            firstName = request.firstName,
//////            lastName = request.lastName
//////        ).apply {
//////            this.rowguid = UUID.randomUUID()
//////            this.modifiedDate = LocalDateTime.now()
//////        }
////        return 0
//////        return personRepository.save(person).id!!
////    }
////}