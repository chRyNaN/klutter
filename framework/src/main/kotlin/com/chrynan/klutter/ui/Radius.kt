@file:Suppress("unused")

package com.chrynan.klutter.ui

data class Radius(
    val x: Double,
    val y: Double
) {

    companion object {

        val ZERO = Radius(x = 0.0, y = 0.0)

        fun circular(radius: Double) = Radius(x = radius, y = radius)

        fun elliptical(x: Double, y: Double) = Radius(x = x, y = y)
    }

    operator fun rem(operand: Double) = Radius(x = x % operand, y = y % operand)

    operator fun rem(other: Radius) =
        Radius(x = x % other.x, y = y % other.y)

    operator fun times(operand: Double) = Radius(x = x * operand, y = y * operand)

    operator fun times(other: Radius) =
        Radius(x = x * other.x, y = y * other.y)

    operator fun plus(value: Double) = Radius(x = x + value, y = y + value)

    operator fun plus(other: Radius) =
        Radius(x = x + other.x, y = y + other.y)

    operator fun minus(value: Double) = Radius(x = x - value, y = y - value)

    operator fun minus(other: Radius) =
        Radius(x = x - other.x, y = y - other.y)

    operator fun div(operand: Double) = Radius(x = x / operand, y = y / operand)

    operator fun div(other: Radius) =
        Radius(x = x / other.x, y = y / other.y)

    operator fun unaryMinus() = Radius(x = -x, y = -y)

    operator fun unaryPlus() = Radius(x = +x, y = +y)
}