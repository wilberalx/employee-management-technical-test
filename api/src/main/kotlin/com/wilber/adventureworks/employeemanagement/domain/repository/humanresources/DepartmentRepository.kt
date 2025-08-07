package com.wilber.adventureworks.employeemanagement.domain.repository.humanresources

import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.Department
import org.springframework.data.jpa.repository.JpaRepository

interface DepartmentRepository : JpaRepository<Department, Short>
