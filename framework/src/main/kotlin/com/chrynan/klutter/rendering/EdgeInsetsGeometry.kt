package com.chrynan.klutter.rendering

import com.chrynan.klutter.painting.Axis
import com.chrynan.klutter.ui.Size
import com.chrynan.klutter.ui.TextDirection

abstract class EdgeInsetsGeometry {

    abstract val bottom: Double

    abstract val top: Double

    abstract val left: Double

    abstract val right: Double

    abstract val start: Double

    abstract val end: Double

    abstract val flipped: EdgeInsetsGeometry

    val isNegative: Boolean
        get() = !isNonNegative

    val isNonNegative: Boolean
        get() = (left >= 0.0) and
                (right >= 0.0) and
                (start >= 0.0) and
                (end >= 0.0) and
                (top >= 0.0) and
                (bottom >= 0.0)

    val horizontal: Double
        get() = left + right + start + end

    val vertical: Double
        get() = top + bottom

    val collapsedSize: Size
        get() = Size(width = horizontal, height = vertical)

    abstract fun resolve(direction: TextDirection): EdgeInsets

    fun along(axis: Axis) = if (axis == Axis.HORIZONTAL) horizontal else vertical

    fun inflateSize(size: Size) =
        Size(width = size.width + horizontal, height = size.height + vertical)

    fun deflateSize(size: Size) =
        Size(width = size.width - horizontal, height = size.height - vertical)

    // TODO add operators
}