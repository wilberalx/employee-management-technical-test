package com.wilber.adventureworks.employeemanagement.domain.repository.person

import com.wilber.adventureworks.employeemanagement.domain.entities.person.AddressType
import org.springframework.data.jpa.repository.JpaRepository

interface AddressTypeRepository : JpaRepository<AddressType, Int>
