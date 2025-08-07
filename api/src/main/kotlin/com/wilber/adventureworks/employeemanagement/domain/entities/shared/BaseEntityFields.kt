package com.wilber.adventureworks.employeemanagement.domain.entities.shared

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import java.time.LocalDateTime
import java.util.UUID

@MappedSuperclass
abstract class BaseEntityFields {

    @Column(name = "rowguid", nullable = false, insertable = false)
    protected var rowguid: UUID? = null

    @Column(name = "ModifiedDate", nullable = false, insertable = false)
    var modifiedDate: LocalDateTime? = null

}
