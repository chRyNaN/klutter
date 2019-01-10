package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.Radius
import com.chrynan.klutter.ui.TextDirection

class BorderRadiusDirectional(
    override val topStart: Radius,
    override val topEnd: Radius,
    override val bottomStart: Radius,
    override val bottomEnd: Radius
) : BorderRadiusGeometry() {

    companion object {

        val ZERO = all(Radius.ZERO)

        fun all(radius: Radius) =
            BorderRadiusDirectional(
                topStart = radius,
                topEnd = radius,
                bottomStart = radius,
                bottomEnd = radius
            )

        fun circular(radius: Double) =
            all(Radius.circular(radius))

        fun vertical(top: Radius, bottom: Radius) =
            BorderRadiusDirectional(
                topStart = top,
                topEnd = top,
                bottomStart = bottom,
                bottomEnd = bottom
            )

        fun horizontal(start: Radius = Radius.ZERO, end: Radius = Radius.ZERO) =
            BorderRadiusDirectional(
                topStart = start,
                topEnd = end,
                bottomStart = start,
                bottomEnd = end
            )

        fun only(
            topStart: Radius = Radius.ZERO,
            topEnd: Radius = Radius.ZERO,
            bottomStart: Radius = Radius.ZERO,
            bottomEnd: Radius = Radius.ZERO
        ) =
            BorderRadiusDirectional(
                topStart = topStart,
                topEnd = topEnd,
                bottomStart = bottomStart,
                bottomEnd = bottomEnd
            )
    }

    override val topLeft = Radius.ZERO
    override val topRight = Radius.ZERO
    override val bottomLeft = Radius.ZERO
    override val bottomRight = Radius.ZERO

    override fun resolve(direction: TextDirection) =
        if (direction == TextDirection.LTR) {
            BorderRadius(
                topLeft = topStart,
                topRight = topEnd,
                bottomLeft = bottomStart,
                bottomRight = bottomEnd
            )
        } else {
            BorderRadius(
                topLeft = topEnd,
                topRight = topStart,
                bottomLeft = bottomEnd,
                bottomRight = bottomStart
            )
        }
}