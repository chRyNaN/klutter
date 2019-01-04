@file:Suppress("unused")

package com.chrynan.klutter.ui

import kotlin.math.max
import kotlin.math.min

data class Rect(
    val left: Double,
    val top: Double,
    val right: Double,
    val bottom: Double
) {

    companion object {

        val ZERO = Rect(left = 0.0, top = 0.0, right = 0.0, bottom = 0.0)

        fun fromCircle(center: Offset, radius: Double) =
            Rect(
                left = center.dx - radius,
                top = center.dy - radius,
                right = center.dx + radius,
                bottom = center.dy + radius
            )

        fun fromRadius(center: Offset, radius: Radius) =
            Rect(
                left = center.dx - radius.x,
                top = center.dy - radius.y,
                right = center.dx + radius.x,
                bottom = center.dy + radius.y
            )

        fun fromLTWH(left: Double, top: Double, width: Double, height: Double) =
            Rect(
                left = left,
                top = top,
                right = left + width,
                bottom = top + height
            )
    }

    val width: Double
        get() = right - left

    val height: Double
        get() = bottom - top

    val shortestSide: Double
        get() = min(width, height)

    val longestSide: Double
        get() = max(width, height)

    val isFinite: Boolean
        get() = left.isFinite() and right.isFinite() and top.isFinite() and bottom.isFinite()

    val isInfinite: Boolean
        get() = left.isInfinite() or right.isInfinite() or top.isInfinite() or bottom.isInfinite()

    val isEmpty: Boolean
        get() = (width <= 0) or (height <= 0)

    val bottomCenter = Offset(dx = left + width / 2, dy = bottom)

    val bottomLeft = Offset(dx = left, dy = bottom)

    val bottomRight = Offset(dx = right, dy = bottom)

    val center = Offset(dx = left + width / 2, dy = top + height / 2)

    val centerLeft = Offset(dx = left, dy = top + height / 2)

    val centerRight = Offset(dx = right, dy = top + height / 2)

    val topCenter = Offset(dx = left + width / 2, dy = top)

    val topLeft = Offset(dx = left, dy = top)

    val topRight = Offset(dx = right, dy = top)

    fun deflate(delta: Double) =
        Rect(
            left = left - delta,
            top = top - delta,
            right = right - delta,
            bottom = bottom - delta
        )

    fun expandToInclude(other: Rect) =
        Rect(
            left = min(left, other.left),
            top = min(top, other.top),
            right = max(right, other.right),
            bottom = max(bottom, other.bottom)
        )

    fun inflate(delta: Double) =
        Rect(
            left = left + delta,
            top = top + delta,
            right = right + delta,
            bottom = bottom + delta
        )

    fun shift(offset: Offset) =
        Rect(
            left = left + offset.dx,
            top = top + offset.dy,
            right = right + offset.dx,
            bottom = bottom + offset.dy
        )

    fun overlaps(other: Rect): Boolean {
        if (right < other.left) return false
        if (bottom < other.top) return false
        return (left < other.right) and (top < other.bottom)
    }

    operator fun contains(offset: Offset) = (offset.dx >= left) and
            (offset.dx < right) and
            (offset.dy >= top) and
            (offset.dy < bottom)

    operator fun rem(operand: Double) =
        Rect(
            left = left % operand,
            top = top % operand,
            right = right % operand,
            bottom = bottom % operand
        )

    operator fun rem(other: Rect) =
        Rect(
            left = left % other.left,
            top = top % other.top,
            right = right % other.right,
            bottom = bottom % other.bottom
        )

    operator fun times(operand: Double) =
        Rect(
            left = left * operand,
            top = top * operand,
            right = right * operand,
            bottom = bottom * operand
        )

    operator fun times(other: Rect) =
        Rect(
            left = left * other.left,
            top = top * other.top,
            right = right * other.right,
            bottom = bottom * other.bottom
        )

    operator fun plus(value: Double) =
        Rect(
            left = left + value,
            top = top + value,
            right = right + value,
            bottom = bottom + value
        )

    operator fun plus(other: Rect) =
        Rect(
            left = left + other.left,
            top = top + other.top,
            right = right + other.right,
            bottom = bottom + other.bottom
        )

    operator fun minus(value: Double) =
        Rect(
            left = left - value,
            top = top - value,
            right = right - value,
            bottom = bottom - value
        )

    operator fun minus(other: Rect) =
        Rect(
            left = left - other.left,
            top = top - other.top,
            right = right - other.right,
            bottom = bottom - other.bottom
        )

    operator fun div(operand: Double) =
        Rect(
            left = left / operand,
            top = top / operand,
            right = right / operand,
            bottom = bottom / operand
        )

    operator fun div(other: Rect) =
        Rect(
            left = left / other.left,
            top = top / other.top,
            right = right / other.right,
            bottom = bottom / other.bottom
        )

    operator fun unaryMinus() =
        Rect(left = -left, top = -top, right = -right, bottom = -bottom)

    operator fun unaryPlus() =
        Rect(left = +left, top = +top, right = +right, bottom = +bottom)
}