@file:Suppress("unused")

package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.Rect
import com.chrynan.klutter.ui.Size
import com.chrynan.klutter.ui.TextDirection

data class Alignment(
    override val x: Double,
    override val y: Double,
    override val start: Double = 0.0
) : AlignmentGeometry() {

    companion object {

        val BOTTOM_CENTER = Alignment(x = 0.0, y = 1.0)

        val BOTTOM_LEFT = Alignment(x = -1.0, y = 1.0)

        val BOTTOM_RIGHT = Alignment(x = 1.0, y = 1.0)

        val CENTER = Alignment(x = 0.0, y = 0.0)

        val CENTER_LEFT = Alignment(x = -1.0, y = 0.0)

        val CENTER_RIGHT = Alignment(x = 1.0, y = 0.0)

        val TOP_CENTER = Alignment(x = 0.0, y = -1.0)

        val TOP_LEFT = Alignment(x = -1.0, y = -1.0)

        val TOP_RIGHT = Alignment(x = 1.0, y = -1.0)
    }

    override fun resolve(direction: TextDirection) = this

    fun inscribe(size: Size, rect: Rect): Rect {
        val halfWidthDelta = (rect.width - size.width) / 2.0
        val halfHeightDelta = (rect.height - size.height) / 2.0

        return Rect.fromLTWH(
            left = rect.left + halfWidthDelta + x * halfWidthDelta,
            top = rect.top + halfHeightDelta + y * halfHeightDelta,
            width = size.width,
            height = size.height
        )
    }

    // Add additional functions and operator functions
}