package com.chrynan.klutter.animation

abstract class Curve {

    val flipped: Curve
        get() = FlippedCurve(this)

    abstract fun transform(t: Double): Double
}