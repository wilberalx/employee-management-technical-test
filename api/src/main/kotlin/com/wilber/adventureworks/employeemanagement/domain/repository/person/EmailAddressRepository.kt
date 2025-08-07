package com.wilber.adventureworks.employeemanagement.domain.repository.person

import com.wilber.adventureworks.employeemanagement.domain.entities.person.EmailAddress
import org.springframework.data.jpa.repository.JpaRepository

interface EmailAddressRepository : JpaRepository<EmailAddress, Int>
