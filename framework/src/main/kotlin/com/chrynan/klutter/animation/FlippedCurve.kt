package com.chrynan.klutter.animation

class FlippedCurve(val curve: Curve) : Curve() {

    override fun transform(t: Double) = 1.0 - curve.transform(1.0 - t)
}