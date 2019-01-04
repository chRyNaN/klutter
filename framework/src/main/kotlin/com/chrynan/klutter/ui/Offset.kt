@file:Suppress("unused")

package com.chrynan.klutter.ui

import kotlin.math.atan2
import kotlin.math.sqrt

data class Offset(
    public override val dx: Double,
    public override val dy: Double
) : OffsetBase(
    dx = dx,
    dy = dy
), Comparable<Offset> {

    companion object {

        val INFINITE = Offset(dx = Double.POSITIVE_INFINITY, dy = Double.POSITIVE_INFINITY)

        val ZERO = Offset(dx = 0.0, dy = 0.0)
    }

    val direction: Double
        get() = atan2(y = dy, x = dx)

    val distance: Double
        get() = sqrt(dx * dx + dy * dy)

    val distanceSquared: Double
        get() = dx * dx + dy * dy

    override fun compareTo(other: Offset) = compareValuesBy(this, other, { it.dx }, { it.dy })

    fun scale(scaleX: Double, scaleY: Double) = Offset(dx = dx * scaleX, dy = dy * scaleY)

    fun translate(translateX: Double, translateY: Double) =
        Offset(dx = dx + translateX, dy = dy + translateY)

    operator fun rem(operand: Double) = Offset(dx = dx % operand, dy = dy % operand)

    operator fun rem(other: Offset) =
        Offset(dx = dx % other.dx, dy = dy % other.dy)

    operator fun times(operand: Double) = Offset(dx = dx * operand, dy = dy * operand)

    operator fun times(other: Offset) =
        Offset(dx = dx * other.dx, dy = dy * other.dy)

    operator fun plus(value: Double) = Offset(dx = dx + value, dy = dy + value)

    operator fun plus(other: Offset) =
        Offset(dx = dx + other.dx, dy = dy + other.dy)

    operator fun minus(value: Double) = Offset(dx = dx - value, dy = dy - value)

    operator fun minus(other: Offset) =
        Offset(dx = dx - other.dx, dy = dy - other.dy)

    operator fun div(operand: Double) = Offset(dx = dx / operand, dy = dy / operand)

    operator fun div(other: Offset) =
        Offset(dx = dx / other.dx, dy = dy / other.dy)

    operator fun unaryMinus() = Offset(dx = -dx, dy = -dy)

    operator fun unaryPlus() = Offset(dx = +dx, dy = +dy)
}