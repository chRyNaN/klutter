package com.chrynan.klutter.animation

class ThresholdCurve(val threshold: Double) : Curve() {

    override fun transform(t: Double): Double {
        if ((t == 0.0) or (t == 1.0)) return t

        return if (t < threshold) 0.0 else 1.0
    }
}