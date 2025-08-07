package com.wilber.adventureworks.employeemanagement.application.person.address.dto

class AddressRequest (
    var addressLine1: String,
    var addressLine2: String?,
    var city: String,
    var stateProvinceId: Int,
    var postalCode: String
)
