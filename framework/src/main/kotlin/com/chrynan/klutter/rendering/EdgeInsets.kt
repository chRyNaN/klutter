package com.chrynan.klutter.rendering

import com.chrynan.klutter.ui.Offset
import com.chrynan.klutter.ui.Rect
import com.chrynan.klutter.ui.TextDirection

data class EdgeInsets(
    override val left: Double,
    override val right: Double,
    override val top: Double,
    override val bottom: Double
) : EdgeInsetsGeometry() {

    companion object {

        val ZERO = EdgeInsets.only()

        fun all(value: Double) = EdgeInsets(left = value, right = value, top = value, bottom = value)

        fun only(left: Double = 0.0, right: Double = 0.0, top: Double = 0.0, bottom: Double = 0.0) =
            EdgeInsets(left = left, right = right, top = top, bottom = bottom)

        fun symmetric(horizontal: Double = 0.0, vertical: Double = 0.0) =
            EdgeInsets(left = horizontal, right = horizontal, top = vertical, bottom = vertical)
    }

    override val start: Double = 0.0

    override val end: Double = 0.0

    val topLeft: Offset
        get() = Offset(dx = left, dy = top)

    val topRight: Offset
        get() = Offset(dx = -right, dy = top)

    val bottomLeft: Offset
        get() = Offset(dx = left, dy = -bottom)

    val bottomRight: Offset
        get() = Offset(dx = -right, dy = -bottom)

    override val flipped = EdgeInsets(left = right, right = left, top = bottom, bottom = top)

    override fun resolve(direction: TextDirection) = this

    fun inflateRect(rect: Rect) =
        Rect(
            left = rect.left - left,
            top = rect.top - top,
            right = rect.right + right,
            bottom = rect.bottom + bottom
        )

    fun deflateRect(rect: Rect) =
        Rect(
            left = rect.left + left,
            top = rect.top + top,
            right = rect.right - right,
            bottom = rect.bottom - bottom
        )

    // TODO add operators
}