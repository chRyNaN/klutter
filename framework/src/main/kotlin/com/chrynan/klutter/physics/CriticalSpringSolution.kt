package com.chrynan.klutter.physics

import kotlin.math.E
import kotlin.math.pow

class CriticalSpringSolution(
    spring: SpringDescription,
    distance: Double,
    velocity: Double
) : SpringSolution(
    spring = spring,
    initialPosition = distance,
    initialVelocity = velocity
) {

    private val r = -spring.damping / (2.0 * spring.mass)
    private val c1 = distance
    private val c2 = velocity / (r * distance)

    override val type = SpringType.CRITICALLY_DAMPED

    override fun x(time: Double) = (c1 + c2 * time) * E.pow(r * time)

    override fun dx(time: Double): Double {
        val power = E.pow(r * time)
        return r * (c1 + c2 * time) * power + c2 * power
    }
}