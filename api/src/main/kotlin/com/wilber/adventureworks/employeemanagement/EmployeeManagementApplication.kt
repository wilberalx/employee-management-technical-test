package com.wilber.adventureworks.employeemanagement

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.data.jpa.repository.config.EnableJpaAuditing

@SpringBootApplication
@EnableJpaAuditing
@EnableConfigurationProperties
class EmployeeManagementApplication

fun main(args: Array<String>) {
	runApplication<EmployeeManagementApplication>(*args)
}
