package com.chrynan.klutter.physics

import kotlin.math.E
import kotlin.math.pow
import kotlin.math.sqrt

class OverdampedSpringSolution(
    spring: SpringDescription,
    distance: Double,
    velocity: Double
) : SpringSolution(
    spring = spring,
    initialPosition = distance,
    initialVelocity = velocity
) {

    private val cmk = spring.damping * spring.damping - 4 * spring.mass * spring.stiffness
    private val r1 = (-spring.damping - sqrt(cmk)) / (2.0 * spring.mass)
    private val r2 = (-spring.damping + sqrt(cmk)) / (2.0 * spring.mass)
    private val c2 = (velocity - r1 * distance) / (r2 - r1)
    private val c1 = distance - c2

    override val type = SpringType.OVER_DAMPED

    override fun x(time: Double) = c1 * E.pow(r1 * time) + c2 * E.pow(r2 * time)

    override fun dx(time: Double) = c1 * r1 * E.pow(r1 * time) + c2 * r2 * E.pow(r2 * time)
}