package com.wilber.adventureworks.employeemanagement.domain.entities.shared

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime

@MappedSuperclass
abstract class BaseEntityModifiedDateField {

    @Column(name = "ModifiedDate", nullable = false, insertable = false)
    var modifiedDate: LocalDateTime? = null

}
