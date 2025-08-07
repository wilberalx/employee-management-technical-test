package com.wilber.adventureworks.employeemanagement.domain.entities.person

import com.wilber.adventureworks.employeemanagement.domain.entities.shared.BaseEntityFields
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table

//@Entity
//@Table(name = "Person", schema = "Person")
//class Person : BaseEntityFields() {
//
//    @Id
//    @Column(name = "BusinessEntityID")
//    var businessEntityId: Int = 0
//
//    @Column(name = "PersonType", nullable = false, length = 2)
//    var personType: String = ""
//
//    @Column(name = "FirstName", nullable = false)
//    var firstName: String = ""
//
//    @Column(name = "MiddleName")
//    var middleName: String? = null
//
//    @Column(name = "LastName", nullable = false)
//    var lastName: String = ""
//
//}


@Entity
@Table(name = "Person", schema = "Person")
class Person(

    @Column(name = "PersonType", nullable = false, length = 2)
    var personType: String = "",

    @Column(name = "FirstName", nullable = false)
    var firstName: String = "",

    @Column(name = "MiddleName")
    var middleName: String? = null,

    @Column(name = "LastName", nullable = false)
    var lastName: String
) : BusinessEntity()


//@Entity
//@Table(name = "BusinessEntity", schema = "Person") // Asegúrate que el schema sea correcto
//@Inheritance(strategy = InheritanceType.JOINED)
//open class BusinessEntity2(
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "BusinessEntityID")
//    var id: Int? = null,
//
//    @Column(name = "rowguid")
//    var rowguid: UUID? = null,
//
//    @Column(name = "ModifiedDate")
//    var modifiedDate: LocalDateTime? = null
//)
//
//@Entity
//@Table(name = "Person", schema = "Person")
//class Person2(
//
//    @Column(name = "FirstName")
//    var firstName: String? = null,
//
//    @Column(name = "LastName")
//    var lastName: String? = null,
//
//    @Column(name = "PersonType", nullable = false, length = 2)
//    var personType: String = "EM"
//
//) : BusinessEntity2()