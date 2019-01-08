package com.chrynan.klutter.animation

import kotlin.math.absoluteValue

class CubicCurve(
    val a: Double,
    val b: Double,
    val c: Double,
    val d: Double
) : Curve() {

    companion object {

        private const val CUBIC_ERROR_BOUND = 0.001
    }

    override fun transform(t: Double): Double {
        var start = 0.0
        var end = 1.0

        while (true) {
            val midpoint = (start + end) / 2
            val estimate = evaluateCubic(a, c, midpoint)

            when {
                (t - estimate).absoluteValue < CUBIC_ERROR_BOUND -> return evaluateCubic(b, d, midpoint)
                estimate < 1 -> start = midpoint
                else -> end = midpoint
            }
        }
    }

    private fun evaluateCubic(a: Double, b: Double, m: Double) =
        (3 * a * (1 - m) * (1 - m) * m) +
                (3 * b * (1 - m) * m * m) +
                (m * m * m)
}