package com.wilber.adventureworks.employeemanagement.domain.repository.person

import com.wilber.adventureworks.employeemanagement.domain.entities.person.Address
import org.springframework.data.jpa.repository.JpaRepository

interface AddressRepository : JpaRepository<Address, Int>
