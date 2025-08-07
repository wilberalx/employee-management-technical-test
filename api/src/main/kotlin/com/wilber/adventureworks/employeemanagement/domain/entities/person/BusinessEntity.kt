package com.wilber.adventureworks.employeemanagement.domain.entities.person

import com.wilber.adventureworks.employeemanagement.domain.entities.shared.BaseEntityFields
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Inheritance
import jakarta.persistence.InheritanceType
import jakarta.persistence.Table

@Entity
@Table(name = "BusinessEntity", schema = "Person")
@Inheritance(strategy = InheritanceType.JOINED)
class BusinessEntity : BaseEntityFields() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BusinessEntityID")
    var businessEntityId: Int? = null

}

//@Entity
//@Table(name = "BusinessEntity", schema = "Person")
//@Inheritance(strategy = InheritanceType.JOINED)
//open class BusinessEntity(
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "BusinessEntityID")
//    var businessEntityId: Int? = null,
//
//    @Column(name = "rowguid")
//    var rowguid: UUID? = UUID.randomUUID(),
//
//    @Column(name = "ModifiedDate")
//    var modifiedDate: LocalDateTime? = LocalDateTime.now()
//)