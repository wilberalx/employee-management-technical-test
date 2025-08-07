package com.wilber.adventureworks.employeemanagement.domain.shared

import java.time.LocalDate
import kotlin.random.Random

object LocalDateMother {
    fun random(): LocalDate {
        val startEpochDay = LocalDate.of(1970, 1, 1).toEpochDay()
        val endEpochDay = LocalDate.of(2100, 12, 31).toEpochDay()
        val randomDay = Random.nextLong(startEpochDay, endEpochDay)
        return LocalDate.ofEpochDay(randomDay)
    }
}
