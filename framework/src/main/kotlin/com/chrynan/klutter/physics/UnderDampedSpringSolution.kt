package com.chrynan.klutter.physics

import kotlin.math.*

class UnderDampedSpringSolution(
    spring: SpringDescription,
    distance: Double,
    velocity: Double
) : SpringSolution(
    spring = spring,
    initialPosition = distance,
    initialVelocity = velocity
) {

    private val w = sqrt(4.0 * spring.mass * spring.stiffness - spring.damping * spring.damping) / (2.0 * spring.mass)
    private val r = -(spring.damping / 2.0 * spring.mass)
    private val c1 = distance
    private val c2 = (velocity - r * distance) / w

    override val type = SpringType.UNDER_DAMPED

    override fun x(time: Double) = E.pow(r * time) * (c1 * cos(w * time) + c2 * sin(w * time))

    override fun dx(time: Double): Double {
        val power = E.pow(r * time)
        val cosine = cos(w * time)
        val sine = sin(w * time)

        return power * (c2 * w * cosine - c1 * w * sine) + r * power * (c2 * sine + c1 * cosine)
    }
}