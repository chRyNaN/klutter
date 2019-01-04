@file:Suppress("unused")

package com.chrynan.klutter.ui

class RelativeRect(
    val left: Double,
    val top: Double,
    val right: Double,
    val bottom: Double
) {

    companion object {

        val ZERO = RelativeRect(left = 0.0, top = 0.0, right = 0.0, bottom = 0.0)

        fun fromCircle(center: Offset, radius: Double) =
            RelativeRect(
                left = center.dx - radius,
                top = center.dy - radius,
                right = center.dx + radius,
                bottom = center.dy + radius
            )

        fun fromRadius(center: Offset, radius: Radius) =
            RelativeRect(
                left = center.dx - radius.x,
                top = center.dy - radius.y,
                right = center.dx + radius.x,
                bottom = center.dy + radius.y
            )


        fun fromRect(rect: Rect, container: Rect) =
            RelativeRect(
                left = rect.left - container.left,
                top = rect.top - container.top,
                right = rect.right - container.right,
                bottom = rect.bottom - container.bottom
            )
    }

    val hasInsets: Boolean
        get() = (left > 0.0) or (top > 0.0) or (right > 0.0) or (bottom > 0.0)

    fun deflate(delta: Double) =
        Rect(
            left = left - delta,
            top = top - delta,
            right = right - delta,
            bottom = bottom - delta
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

    fun toRect(container: Rect) =
        Rect(
            left = left,
            top = top,
            right = container.width - right,
            bottom = container.height - bottom
        )

    fun toSize(container: Size) =
        Size(
            width = container.width - left - right,
            height = container.height - top - bottom
        )

    operator fun contains(offset: Offset) = (offset.dx >= left) and
            (offset.dx < right) and
            (offset.dy >= top) and
            (offset.dy < bottom)

    operator fun rem(operand: Double) =
        RelativeRect(
            left = left % operand,
            top = top % operand,
            right = right % operand,
            bottom = bottom % operand
        )

    operator fun rem(other: RelativeRect) =
        RelativeRect(
            left = left % other.left,
            top = top % other.top,
            right = right % other.right,
            bottom = bottom % other.bottom
        )

    operator fun times(operand: Double) =
        RelativeRect(
            left = left * operand,
            top = top * operand,
            right = right * operand,
            bottom = bottom * operand
        )

    operator fun times(other: RelativeRect) =
        RelativeRect(
            left = left * other.left,
            top = top * other.top,
            right = right * other.right,
            bottom = bottom * other.bottom
        )

    operator fun plus(value: Double) =
        RelativeRect(
            left = left + value,
            top = top + value,
            right = right + value,
            bottom = bottom + value
        )

    operator fun plus(other: RelativeRect) =
        RelativeRect(
            left = left + other.left,
            top = top + other.top,
            right = right + other.right,
            bottom = bottom + other.bottom
        )

    operator fun minus(value: Double) =
        RelativeRect(
            left = left - value,
            top = top - value,
            right = right - value,
            bottom = bottom - value
        )

    operator fun minus(other: RelativeRect) =
        RelativeRect(
            left = left - other.left,
            top = top - other.top,
            right = right - other.right,
            bottom = bottom - other.bottom
        )

    operator fun div(operand: Double) =
        RelativeRect(
            left = left / operand,
            top = top / operand,
            right = right / operand,
            bottom = bottom / operand
        )

    operator fun div(other: RelativeRect) =
        RelativeRect(
            left = left / other.left,
            top = top / other.top,
            right = right / other.right,
            bottom = bottom / other.bottom
        )

    operator fun unaryMinus() =
        RelativeRect(left = -left, top = -top, right = -right, bottom = -bottom)

    operator fun unaryPlus() =
        RelativeRect(left = +left, top = +top, right = +right, bottom = +bottom)
}