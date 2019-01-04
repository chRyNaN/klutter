@file:Suppress("unused")

package com.chrynan.klutter.ui

import kotlin.math.max
import kotlin.math.min

data class RRect(
    val left: Double,
    val top: Double,
    val right: Double,
    val bottom: Double,
    val topLeftRadius: Radius,
    val topRightRadius: Radius,
    val bottomLeftRadius: Radius,
    val bottomRightRadius: Radius
) {

    companion object {

        val ZERO = RRect(
            left = 0.0,
            top = 0.0,
            right = 0.0,
            bottom = 0.0,
            topLeftRadius = Radius.ZERO,
            topRightRadius = Radius.ZERO,
            bottomLeftRadius = Radius.ZERO,
            bottomRightRadius = Radius.ZERO
        )

        fun fromLTRBR(left: Double, top: Double, right: Double, bottom: Double, radius: Radius) =
            RRect(
                left = left,
                top = top,
                right = right,
                bottom = bottom,
                topLeftRadius = radius,
                topRightRadius = radius,
                bottomLeftRadius = radius,
                bottomRightRadius = radius
            )

        fun fromLTRBXY(left: Double, top: Double, right: Double, bottom: Double, x: Double, y: Double) =
            fromLTRBR(
                left = left,
                top = top,
                right = right,
                bottom = bottom,
                radius = Radius(x = x, y = y)
            )

        fun fromRectAndCorners(
            rect: Rect, topLeftRadius: Radius = Radius.ZERO, topRightRadius: Radius = Radius.ZERO,
            bottomLeftRadius: Radius = Radius.ZERO, bottomRightRadius: Radius = Radius.ZERO
        ) =
            RRect(
                left = rect.left,
                top = rect.top,
                right = rect.right,
                bottom = rect.bottom,
                topLeftRadius = topLeftRadius,
                topRightRadius = topRightRadius,
                bottomLeftRadius = bottomLeftRadius,
                bottomRightRadius = bottomRightRadius
            )

        fun fromRectAndRadius(rect: Rect, radius: Radius) =
            RRect(
                left = rect.left,
                top = rect.top,
                right = rect.right,
                bottom = rect.bottom,
                topLeftRadius = radius,
                topRightRadius = radius,
                bottomLeftRadius = radius,
                bottomRightRadius = radius
            )

        fun fromRectXY(rect: Rect, x: Double, y: Double) =
            fromRectAndRadius(
                rect = rect,
                radius = Radius(x = x, y = y)
            )
    }

    val topLeftRadiusX: Double
        get() = topLeftRadius.x

    val topLeftRadiusY: Double
        get() = topLeftRadius.y

    val topRightRadiusX: Double
        get() = topRightRadius.x

    val topRightRadiusY: Double
        get() = topRightRadius.y

    val bottomLeftRadiusX: Double
        get() = bottomLeftRadius.x

    val bottomLeftRadiusY: Double
        get() = bottomLeftRadius.y

    val bottomRightRadiusX: Double
        get() = bottomRightRadius.x

    val bottomRightRadiusY: Double
        get() = bottomRightRadius.y

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

    val outerRect: Rect
        get() = Rect(left = left, top = top, right = right, bottom = bottom)

    val safeInnerRect: Rect
        get() {
            val kInsetFactor = 0.29289321881 // 1-cos(pi/4)

            val leftRadius = max(bottomLeftRadiusX, topLeftRadiusX)
            val topRadius = max(topLeftRadiusY, topRightRadiusY)
            val rightRadius = max(topRightRadiusX, bottomRightRadiusX)
            val bottomRadius = max(bottomRightRadiusY, bottomLeftRadiusY)

            return Rect(
                left = left + leftRadius * kInsetFactor,
                top = top + topRadius * kInsetFactor,
                right = right - rightRadius * kInsetFactor,
                bottom = bottom - bottomRadius * kInsetFactor
            )
        }

    val middleRect: Rect
        get() {
            val leftRadius = max(bottomLeftRadiusX, topLeftRadiusX)
            val topRadius = max(topLeftRadiusY, topRightRadiusY)
            val rightRadius = max(topRightRadiusX, bottomRightRadiusX)
            val bottomRadius = max(bottomRightRadiusY, bottomLeftRadiusY)

            return Rect(
                left = left + leftRadius,
                top = top + topRadius,
                right = right - rightRadius,
                bottom = bottom - bottomRadius
            )
        }

    val wideMiddleRect: Rect
        get() {
            val topRadius = max(topLeftRadiusY, topRightRadiusY)
            val bottomRadius = max(bottomRightRadiusY, bottomLeftRadiusY)

            return Rect(
                left = left,
                top = top + topRadius,
                right = right,
                bottom = bottom - bottomRadius
            )
        }

    val tallMiddleRect: Rect
        get() {
            val leftRadius = max(bottomLeftRadiusX, topLeftRadiusX)
            val rightRadius = max(topRightRadiusX, bottomRightRadiusX)

            return Rect(
                left = left + leftRadius,
                top = top,
                right = right - rightRadius,
                bottom = bottom
            )
        }

    val isRect: Boolean
        get() = (topLeftRadiusX == 0.0 || topLeftRadiusY == 0.0) and
                (topRightRadiusX == 0.0 || topRightRadiusY == 0.0) and
                (bottomLeftRadiusX == 0.0 || bottomLeftRadiusY == 0.0) and
                (bottomRightRadiusX == 0.0 || bottomRightRadiusY == 0.0)

    val isStadium: Boolean
        get() = (topLeftRadius == topRightRadius) and
                (topRightRadius == bottomRightRadius) and
                (bottomRightRadius == bottomLeftRadius) and
                (width <= 2.0 * topLeftRadiusX || height <= 2.0 * topLeftRadiusY)

    val isEllipse: Boolean
        get() = (topLeftRadius == topRightRadius) and
                (topRightRadius == bottomRightRadius) and
                (bottomRightRadius == bottomLeftRadius) and
                (width <= 2.0 * topLeftRadiusX) and
                (height <= 2.0 * topLeftRadiusY)

    val isCircle: Boolean
        get() = (width == height) and isEllipse

    fun deflate(delta: Double) =
        RRect(
            left = left - delta,
            top = top - delta,
            right = right - delta,
            bottom = bottom - delta,
            topLeftRadius = topLeftRadius,
            topRightRadius = topRightRadius,
            bottomLeftRadius = bottomLeftRadius,
            bottomRightRadius = bottomRightRadius
        )

    fun expandToInclude(other: Rect) =
        RRect(
            left = min(left, other.left),
            top = min(top, other.top),
            right = max(right, other.right),
            bottom = max(bottom, other.bottom),
            topLeftRadius = topLeftRadius,
            topRightRadius = topRightRadius,
            bottomLeftRadius = bottomLeftRadius,
            bottomRightRadius = bottomRightRadius
        )

    fun inflate(delta: Double) =
        RRect(
            left = left + delta,
            top = top + delta,
            right = right + delta,
            bottom = bottom + delta,
            topLeftRadius = topLeftRadius,
            topRightRadius = topRightRadius,
            bottomLeftRadius = bottomLeftRadius,
            bottomRightRadius = bottomRightRadius
        )

    fun shift(offset: Offset) =
        RRect(
            left = left + offset.dx,
            top = top + offset.dy,
            right = right + offset.dx,
            bottom = bottom + offset.dy,
            topLeftRadius = topLeftRadius,
            topRightRadius = topRightRadius,
            bottomLeftRadius = bottomLeftRadius,
            bottomRightRadius = bottomRightRadius
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
        RRect(
            left = left % operand,
            top = top % operand,
            right = right % operand,
            bottom = bottom % operand,
            topLeftRadius = topLeftRadius,
            topRightRadius = topRightRadius,
            bottomLeftRadius = bottomLeftRadius,
            bottomRightRadius = bottomRightRadius
        )

    operator fun rem(other: RRect) =
        RRect(
            left = left % other.left,
            top = top % other.top,
            right = right % other.right,
            bottom = bottom % other.bottom,
            topLeftRadius = topLeftRadius % other.topLeftRadius,
            topRightRadius = topRightRadius % other.topRightRadius,
            bottomLeftRadius = bottomLeftRadius % other.bottomLeftRadius,
            bottomRightRadius = bottomRightRadius % other.bottomRightRadius
        )

    operator fun times(operand: Double) =
        RRect(
            left = left * operand,
            top = top * operand,
            right = right * operand,
            bottom = bottom * operand,
            topLeftRadius = topLeftRadius,
            topRightRadius = topRightRadius,
            bottomLeftRadius = bottomLeftRadius,
            bottomRightRadius = bottomRightRadius
        )

    operator fun times(other: RRect) =
        RRect(
            left = left * other.left,
            top = top * other.top,
            right = right * other.right,
            bottom = bottom * other.bottom,
            topLeftRadius = topLeftRadius * other.topLeftRadius,
            topRightRadius = topRightRadius * other.topRightRadius,
            bottomLeftRadius = bottomLeftRadius * other.bottomLeftRadius,
            bottomRightRadius = bottomRightRadius * other.bottomRightRadius
        )

    operator fun plus(value: Double) =
        RRect(
            left = left + value,
            top = top + value,
            right = right + value,
            bottom = bottom + value,
            topLeftRadius = topLeftRadius,
            topRightRadius = topRightRadius,
            bottomLeftRadius = bottomLeftRadius,
            bottomRightRadius = bottomRightRadius
        )

    operator fun plus(other: RRect) =
        RRect(
            left = left + other.left,
            top = top + other.top,
            right = right + other.right,
            bottom = bottom + other.bottom,
            topLeftRadius = topLeftRadius + other.topLeftRadius,
            topRightRadius = topRightRadius + other.topRightRadius,
            bottomLeftRadius = bottomLeftRadius + other.bottomLeftRadius,
            bottomRightRadius = bottomRightRadius + other.bottomRightRadius
        )

    operator fun minus(value: Double) =
        RRect(
            left = left - value,
            top = top - value,
            right = right - value,
            bottom = bottom - value,
            topLeftRadius = topLeftRadius,
            topRightRadius = topRightRadius,
            bottomLeftRadius = bottomLeftRadius,
            bottomRightRadius = bottomRightRadius
        )

    operator fun minus(other: RRect) =
        RRect(
            left = left - other.left,
            top = top - other.top,
            right = right - other.right,
            bottom = bottom - other.bottom,
            topLeftRadius = topLeftRadius - other.topLeftRadius,
            topRightRadius = topRightRadius - other.topRightRadius,
            bottomLeftRadius = bottomLeftRadius - other.bottomLeftRadius,
            bottomRightRadius = bottomRightRadius - other.bottomRightRadius
        )

    operator fun div(operand: Double) =
        RRect(
            left = left / operand,
            top = top / operand,
            right = right / operand,
            bottom = bottom / operand,
            topLeftRadius = topLeftRadius,
            topRightRadius = topRightRadius,
            bottomLeftRadius = bottomLeftRadius,
            bottomRightRadius = bottomRightRadius
        )

    operator fun div(other: RRect) =
        RRect(
            left = left / other.left,
            top = top / other.top,
            right = right / other.right,
            bottom = bottom / other.bottom,
            topLeftRadius = topLeftRadius / other.topLeftRadius,
            topRightRadius = topRightRadius / other.topRightRadius,
            bottomLeftRadius = bottomLeftRadius / other.bottomLeftRadius,
            bottomRightRadius = bottomRightRadius / other.bottomRightRadius
        )

    operator fun unaryMinus() =
        RRect(
            left = -left,
            top = -top,
            right = -right,
            bottom = -bottom,
            topLeftRadius = topLeftRadius,
            topRightRadius = topRightRadius,
            bottomLeftRadius = bottomLeftRadius,
            bottomRightRadius = bottomRightRadius
        )

    operator fun unaryPlus() =
        RRect(
            left = +left,
            top = +top,
            right = +right,
            bottom = +bottom,
            topLeftRadius = topLeftRadius,
            topRightRadius = topRightRadius,
            bottomLeftRadius = bottomLeftRadius,
            bottomRightRadius = bottomRightRadius
        )
}