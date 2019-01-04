package com.chrynan.klutter.ui

import kotlin.math.atan2
import kotlin.math.cos
import kotlin.math.sin

data class Tangent(
    val position: Offset,
    val vector: Offset
) {

    companion object {

        fun fromAngle(position: Offset, angle: Double) =
            Tangent(position = position, vector = Offset(dx = cos(angle), dy = sin(angle)))
    }

    val angle: Double
        get() = atan2(vector.dy, vector.dx)
}