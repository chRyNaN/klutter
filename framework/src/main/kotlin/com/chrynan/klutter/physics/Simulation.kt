package com.chrynan.klutter.physics

abstract class Simulation(open val tolerance: Tolerance = Tolerance()) {

    abstract fun x(time: Double): Double

    abstract fun dx(time: Double): Double

    abstract fun isDone(time: Double): Boolean
}