package com.chrynan.klutter.rendering

import com.chrynan.klutter.ui.TextDirection

data class EdgeInsetsDirectional(
    override val top: Double,
    override val bottom: Double,
    override val start: Double,
    override val end: Double
) : EdgeInsetsGeometry() {

    companion object {

        val ZERO = EdgeInsetsDirectional.only()

        fun all(value: Double) = EdgeInsetsDirectional(start = value, end = value, top = value, bottom = value)

        fun only(start: Double = 0.0, end: Double = 0.0, top: Double = 0.0, bottom: Double = 0.0) =
            EdgeInsetsDirectional(start = start, end = end, top = top, bottom = bottom)

        fun symmetric(horizontal: Double = 0.0, vertical: Double = 0.0) =
            EdgeInsetsDirectional(start = horizontal, end = horizontal, top = vertical, bottom = vertical)
    }

    override val left: Double = 0.0

    override val right: Double = 0.0

    override val flipped =
        EdgeInsetsDirectional(top = bottom, bottom = top, start = end, end = start)

    override fun resolve(direction: TextDirection) =
        if (direction == TextDirection.LTR) {
            EdgeInsets(left = start, right = end, top = top, bottom = bottom)
        } else {
            EdgeInsets(left = end, right = start, top = top, bottom = bottom)
        }

    // TODO add operators
}