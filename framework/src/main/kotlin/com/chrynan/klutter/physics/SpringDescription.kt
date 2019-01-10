package com.chrynan.klutter.physics

import kotlin.math.sqrt

data class SpringDescription(
    val mass: Double,
    val stiffness: Double,
    val damping: Double
) {

    companion object {

        fun withDampingRatio(mass: Double, stiffness: Double, ratio: Double = 1.0) =
            SpringDescription(mass = mass, stiffness = stiffness, damping = ratio * 2.0 * sqrt(mass * stiffness))
    }
}