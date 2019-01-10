package com.chrynan.klutter.physics

open class SpringSimulation(
    val spring: SpringDescription,
    val start: Double,
    val end: Double,
    val velocity: Double
) : Simulation() {

    val type: SpringType
        get() = springSolution.type

    private val springSolution =
        SpringSolution.from(spring = spring, initialPosition = start, initialVelocity = velocity)

    override fun x(time: Double) = end + springSolution.x(time)

    override fun dx(time: Double) = springSolution.dx(time)

    override fun isDone(time: Double): Boolean {
        return nearZero(springSolution.x(time), tolerance.distance) and
                nearZero(springSolution.dx(time), tolerance.velocity)
    }

    private fun nearZero(a: Double, epsilon: Double) = nearEqual(a, 0.0, epsilon)

    private fun nearEqual(a: Double, b: Double, epsilon: Double) =
        ((a > (b - epsilon)) and (a < (b + epsilon))) or (a == b)
}