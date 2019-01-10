package com.chrynan.klutter.painting

import com.chrynan.klutter.painting.Alignment
import com.chrynan.klutter.painting.AlignmentGeometry
import com.chrynan.klutter.ui.TextDirection

data class AlignmentDirectional(
    override val start: Double,
    override val y: Double
) : AlignmentGeometry() {

    override val x = 0.0

    override fun resolve(direction: TextDirection) =
        Alignment(x = if (direction == TextDirection.RTL) -start else start, y = y)
}