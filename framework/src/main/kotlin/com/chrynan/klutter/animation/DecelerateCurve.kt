package com.chrynan.klutter.animation

class DecelerateCurve : Curve() {

    override fun transform(t: Double): Double {
        val newT = 1.0 - t
        return 1.0 - newT * newT
    }
}