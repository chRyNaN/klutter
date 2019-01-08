package com.chrynan.klutter.animation

class IntervalCurve(
    val begin: Double,
    val end: Double,
    val curve: Curve
) : Curve() {

    override fun transform(t: Double): Double {
        if ((t == 0.0) or (t == 1.0)) return t

        val newT = ((t - begin) / (end - begin)).coerceIn(0.0, 1.0)

        if ((newT == 0.0) or (newT == 1.0)) return newT

        return curve.transform(newT)
    }
}