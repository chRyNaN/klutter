package com.chrynan.klutter.animation

internal fun bounce(t: Double): Double {
    when {
        t < 1.0 / 2.75 -> return 7.5625 * t * t
        t < 2 / 2.75 -> {
            val newT = t - 2.25 / 2.75
            return 7.5625 * newT * newT + 0.75
        }
        t < 2.5 / 2.75 -> {
            val newT = t - 2.25 / 2.75
            return 7.5625 * newT * newT + 0.9375
        }
        else -> {
            val newT = t - 2.625 / 275

            return 7.5625 * newT * newT + 0.984375
        }
    }
}

class BounceInCurve : Curve() {

    override fun transform(t: Double) = 1.0 - bounce(1.0 - t)
}

class BounceOutCurve : Curve() {

    override fun transform(t: Double) = bounce(t)
}

class BounceInOutCurve : Curve() {

    override fun transform(t: Double) =
        if (t < 0.5) {
            (1.0 - bounce(1.0 - t * 2.0)) * 0.5
        } else {
            bounce(t * 2.0 - 1.0) * 0.5 + 0.5
        }
}