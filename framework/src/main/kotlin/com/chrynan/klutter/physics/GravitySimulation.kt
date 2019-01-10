package com.chrynan.klutter.physics

import kotlin.math.absoluteValue

class GravitySimulation(
    val acceleration: Double,
    val distance: Double,
    val endDistance: Double,
    val velocity: Double
) : Simulation() {

    override fun x(time: Double) = distance + velocity * time + 0.5 * acceleration * time * time

    override fun dx(time: Double) = velocity + time * acceleration

    override fun isDone(time: Double) = x(time).absoluteValue >= endDistance
}