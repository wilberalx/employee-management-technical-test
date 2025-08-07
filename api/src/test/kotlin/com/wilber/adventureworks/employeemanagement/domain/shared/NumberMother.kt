package com.wilber.adventureworks.employeemanagement.domain.shared

import java.math.BigDecimal
import java.math.RoundingMode
import kotlin.random.Random

object NumberMother {

    fun randomInt(): Int = Random.nextInt()

    fun randomShort(): Short = Random.nextInt(Short.MIN_VALUE.toInt(), Short.MAX_VALUE.toInt()).toShort()

    fun randomByte(): Byte = Random.nextInt(Byte.MIN_VALUE.toInt(), Byte.MAX_VALUE.toInt()).toByte()

    private fun randomDoubleBetween(min: Double = 0.0, max: Double = 10000.0): Double = Random.nextDouble(min, max)

    fun randomBigDecimal(scale: Int = 2): BigDecimal {
        val randomDouble = randomDoubleBetween()
        return BigDecimal.valueOf(randomDouble).setScale(scale, RoundingMode.HALF_UP)
    }

}