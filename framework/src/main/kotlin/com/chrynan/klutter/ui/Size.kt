@file:Suppress("unused")

package com.chrynan.klutter.ui

import kotlin.math.max
import kotlin.math.min

data class Size(
    val width: Double,
    val height: Double
) : OffsetBase(
    dx = width,
    dy = height
) {

    companion object {

        val INFINITE = Size(width = Double.POSITIVE_INFINITY, height = Double.POSITIVE_INFINITY)

        val ZERO = Size(width = 0.0, height = 0.0)

        fun fromHeight(height: Double) = Size(width = Double.POSITIVE_INFINITY, height = height)

        fun fromWidth(width: Double) = Size(width = width, height = Double.POSITIVE_INFINITY)

        fun fromRadius(radius: Double) = Size(width = 2 * radius, height = 2 * radius)

        fun square(dimension: Double) = Size(width = dimension, height = dimension)
    }

    val isEmpty: Boolean
        get() = (width <= 0) or (height <= 0)

    val longestSide: Double
        get() = max(width, height)

    val shortestSide: Double
        get() = min(width, height)

    val flipped: Size
        get() = Size(width = height, height = width)

    fun bottomCenter(origin: Offset) =
        Offset(dx = origin.dx + width / 2, dy = origin.dy + height)

    fun bottomLeft(origin: Offset) =
        Offset(dx = origin.dx, dy = origin.dy + height)

    fun bottomRight(origin: Offset) =
        Offset(dx = origin.dx + width, dy = origin.dy + height)

    fun center(origin: Offset) =
        Offset(dx = origin.dx + width / 2, dy = origin.dy + height / 2)

    fun centerLeft(origin: Offset) =
        Offset(dx = origin.dx, dy = origin.dy + height / 2)

    fun centerRight(origin: Offset) =
        Offset(dx = origin.dx + width, dy = origin.dy + height / 2)

    fun topCenter(origin: Offset) =
        Offset(dx = origin.dx + width / 2, dy = origin.dy)

    fun topLeft(origin: Offset) =
        Offset(dx = origin.dx, dy = origin.dy)

    fun topRight(origin: Offset) =
        Offset(dx = origin.dx + width, dy = origin.dy)

    operator fun contains(offset: Offset) = (offset.dx >= 0.0) and
            (offset.dx < width) and
            (offset.dy >= 0.0) and
            (offset.dy < height)

    operator fun rem(operand: Double) = Size(width = width % operand, height = width % operand)

    operator fun rem(other: Size) =
        Size(width = width % other.width, height = height % other.height)

    operator fun times(operand: Double) =
        Size(width = width * operand, height = height * operand)

    operator fun times(other: Size) =
        Size(width = width * other.width, height = height * other.height)

    operator fun plus(value: Double) = Size(width = width + value, height = height + value)

    operator fun plus(other: Size) =
        Size(width = width + other.width, height = height + other.height)

    operator fun minus(value: Double) = Size(width = width - value, height = height - value)

    operator fun minus(other: Size) =
        Size(width = width - other.width, height = height - other.height)

    operator fun div(operand: Double) = Size(width = width / operand, height = height / operand)

    operator fun div(other: Size) =
        Size(width = width / other.width, height = height / other.height)

    operator fun unaryMinus() = Size(width = -width, height = -height)

    operator fun unaryPlus() = Size(width = +width, height = +height)
}