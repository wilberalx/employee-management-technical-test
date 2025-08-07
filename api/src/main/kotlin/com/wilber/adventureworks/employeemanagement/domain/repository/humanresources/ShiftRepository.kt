package com.wilber.adventureworks.employeemanagement.domain.repository.humanresources

import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.Shift
import org.springframework.data.jpa.repository.JpaRepository

interface ShiftRepository : JpaRepository<Shift, Short>
