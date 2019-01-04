package com.chrynan.klutter.rendering

import com.chrynan.klutter.ui.Radius
import com.chrynan.klutter.ui.TextDirection

class BorderRadius(
    override val topLeft: Radius,
    override val topRight: Radius,
    override val bottomLeft: Radius,
    override val bottomRight: Radius
) : BorderRadiusGeometry() {

    companion object {

        val ZERO = BorderRadius.all(Radius.ZERO)

        fun all(radius: Radius) =
            BorderRadius(
                topLeft = radius,
                topRight = radius,
                bottomLeft = radius,
                bottomRight = radius
            )

        fun circular(radius: Double) = all(Radius.circular(radius))

        fun vertical(top: Radius, bottom: Radius) =
            BorderRadius(
                topLeft = top,
                topRight = top,
                bottomLeft = bottom,
                bottomRight = bottom
            )

        fun horizontal(left: Radius = Radius.ZERO, right: Radius = Radius.ZERO) =
            BorderRadius(
                topLeft = left,
                topRight = right,
                bottomLeft = left,
                bottomRight = right
            )

        fun only(
            topLeft: Radius = Radius.ZERO,
            topRight: Radius = Radius.ZERO,
            bottomLeft: Radius = Radius.ZERO,
            bottomRight: Radius = Radius.ZERO
        ) =
            BorderRadius(
                topLeft = topLeft,
                topRight = topRight,
                bottomLeft = bottomLeft,
                bottomRight = bottomRight
            )
    }

    override val topStart = Radius.ZERO
    override val topEnd = Radius.ZERO
    override val bottomStart = Radius.ZERO
    override val bottomEnd = Radius.ZERO

    override fun resolve(direction: TextDirection) = this
}