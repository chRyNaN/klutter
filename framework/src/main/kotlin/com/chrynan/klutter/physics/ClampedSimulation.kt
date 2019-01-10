package com.chrynan.klutter.physics

class ClampedSimulation(
    val simulation: Simulation,
    val xMin: Double = Double.NEGATIVE_INFINITY,
    val xMax: Double = Double.POSITIVE_INFINITY,
    val dxMin: Double = Double.NEGATIVE_INFINITY,
    val dxMax: Double = Double.POSITIVE_INFINITY
) : Simulation() {

    override fun x(time: Double) = simulation.x(time).coerceIn(xMin, xMax)

    override fun dx(time: Double) = simulation.dx(time).coerceIn(dxMin, dxMax)

    override fun isDone(time: Double) = simulation.isDone(time)
}