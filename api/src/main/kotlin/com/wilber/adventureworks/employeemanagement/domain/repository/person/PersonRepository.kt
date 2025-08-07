package com.wilber.adventureworks.employeemanagement.domain.repository.person

import com.wilber.adventureworks.employeemanagement.domain.entities.person.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : JpaRepository<Person, Int>
