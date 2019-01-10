package com.chrynan.klutter.physics

class ScrollSpringSimulation(
    spring: SpringDescription,
    start: Double,
    end: Double,
    velocity: Double
) : SpringSimulation(
    spring = spring,
    start = start,
    end = end,
    velocity = velocity
) {

    override fun x(time: Double) = if (isDone(time)) end else super.x(time)
}