package com.chrynan.klutter.physics

abstract class SpringSolution(
    val spring: SpringDescription,
    val initialPosition: Double,
    val initialVelocity: Double
) {

    companion object {

        fun from(spring: SpringDescription, initialPosition: Double, initialVelocity: Double): SpringSolution {
            val cmk = spring.damping * spring.damping - 4 * spring.mass * spring.stiffness

            return when {
                cmk == 0.0 -> CriticalSpringSolution(
                    spring = spring,
                    distance = initialPosition,
                    velocity = initialVelocity
                )
                cmk > 0.0 -> OverdampedSpringSolution(
                    spring = spring,
                    distance = initialPosition,
                    velocity = initialVelocity
                )
                else -> UnderDampedSpringSolution(
                    spring = spring,
                    distance = initialPosition,
                    velocity = initialVelocity
                )
            }
        }
    }

    abstract val type: SpringType

    abstract fun x(time: Double): Double

    abstract fun dx(time: Double): Double
}