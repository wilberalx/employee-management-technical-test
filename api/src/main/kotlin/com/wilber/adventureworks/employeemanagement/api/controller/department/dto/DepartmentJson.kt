package com.wilber.adventureworks.employeemanagement.api.controller.department.dto

import com.wilber.adventureworks.employeemanagement.domain.entities.humanresources.Department

class DepartmentJson {

    var departmentId: Short = 0
    var name: String = ""

    constructor()

    constructor(department: Department) {
        this.departmentId = department.departmentId!!
        this.name = department.name
    }

}
