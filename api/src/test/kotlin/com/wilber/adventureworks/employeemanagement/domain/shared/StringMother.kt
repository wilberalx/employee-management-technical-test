package com.wilber.adventureworks.employeemanagement.domain.shared

object StringMother {
    private const val CHAR_POOL = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

    fun random(length: Int = 10): String =
        (1..length)
            .map { CHAR_POOL.random() }
            .joinToString("")
}
