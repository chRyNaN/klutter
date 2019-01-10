package com.chrynan.klutter.physics

import kotlin.math.E
import kotlin.math.absoluteValue
import kotlin.math.log10
import kotlin.math.pow

open class FrictionSimulation(
    override val tolerance: Tolerance = Tolerance(),
    open val drag: Double,
    open val position: Double,
    open val velocity: Double
) : Simulation() {

    companion object {

        fun through(startPosition: Double, endPosition: Double, startVelocity: Double, endVelocity: Double) =
            FrictionSimulation(
                drag = dragFor(startPosition, endPosition, startVelocity, endVelocity),
                position = startPosition,
                velocity = startVelocity,
                tolerance = Tolerance(velocity = endVelocity.absoluteValue)
            )

        private fun dragFor(startPosition: Double, endPosition: Double, startVelocity: Double, endVelocity: Double) =
            E.pow((startVelocity - endVelocity) / (startPosition - endPosition))
    }

    val dragLog: Double
        get() = log10(drag)

    val finalX: Double
        get() = position - velocity / dragLog

    override fun x(time: Double) = position + velocity * drag.pow(time) / dragLog - velocity / dragLog

    override fun dx(time: Double) = velocity * drag.pow(time)

    override fun isDone(time: Double) = dx(time).absoluteValue < tolerance.velocity
}