package com.chrynan.klutter.animation

class SawToothCurve(val count: Int) : Curve() {

    override fun transform(t: Double): Double {
        if (t == 1.0) return t

        return t * count
    }
}