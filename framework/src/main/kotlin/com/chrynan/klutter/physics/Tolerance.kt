package com.chrynan.klutter.physics

class Tolerance(
    val distance: Double = EPSILON_DEFAULT,
    val time: Double = EPSILON_DEFAULT,
    val velocity: Double = EPSILON_DEFAULT
) {

    companion object {

        private const val EPSILON_DEFAULT = 1e-3
    }
}