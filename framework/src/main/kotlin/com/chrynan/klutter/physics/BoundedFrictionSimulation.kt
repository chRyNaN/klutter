package com.chrynan.klutter.physics

import kotlin.math.absoluteValue

class BoundedFrictionSimulation(
    override val drag: Double,
    override val position: Double,
    override val velocity: Double,
    val minX: Double,
    val maxX: Double
) : FrictionSimulation(
    drag = drag,
    position = position,
    velocity = velocity
) {

    override fun x(time: Double) = super.x(time).coerceIn(minX, maxX)

    override fun isDone(time: Double) =
        super.isDone(time) or
                ((x(time) - minX).absoluteValue < tolerance.distance) or
                ((x(time) - maxX).absoluteValue < tolerance.distance)
}