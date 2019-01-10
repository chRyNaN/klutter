package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.TextDirection

abstract class AlignmentGeometry {

    abstract val x: Double

    abstract val y: Double

    abstract val start: Double

    abstract fun resolve(direction: TextDirection): AlignmentGeometry

    open fun add(other: AlignmentGeometry): AlignmentGeometry =
        Alignment(
            x = x + other.x,
            start = start + other.start,
            y = y + other.y
        )

    // TODO add operators
}