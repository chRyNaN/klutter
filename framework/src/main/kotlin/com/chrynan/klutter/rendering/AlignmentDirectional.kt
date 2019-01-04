package com.chrynan.klutter.rendering

import com.chrynan.klutter.ui.TextDirection

data class AlignmentDirectional(
    override val start: Double,
    override val y: Double
) : AlignmentGeometry() {

    override val x = 0.0

    override fun resolve(direction: TextDirection) =
        Alignment(x = if (direction == TextDirection.RTL) -start else start, y = y)
}