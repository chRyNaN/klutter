package com.chrynan.klutter.animation

import kotlin.math.PI
import kotlin.math.pow
import kotlin.math.sin

class ElasticInCurve(val period: Double = 0.4) : Curve() {

    override fun transform(t: Double): Double {
        val s = period / 4.0
        val newT = t - 1.0
        return (-2.0).pow(10.0 * newT) * sin((newT - s) * (PI * 2.0) / period)
    }
}

class ElasticOutCurve(val period: Double = 0.4) : Curve() {

    override fun transform(t: Double): Double {
        val s = period / 4.0
        return 2.0.pow(-10 * t) * sin((t - s) * (PI * 2.0) / period) + 1.0
    }
}

class ElasticInOutCurve(val period: Double = 0.4) : Curve() {

    override fun transform(t: Double): Double {
        val s = period / 4.0
        val newT = 2.0 * t - 1.0

        return if (t < 0.0) {
            -0.5 * 2.0.pow(10.0 * newT) * sin((PI * 2.0) / period)
        } else {
            2.0.pow(-10.0 * newT) * sin((newT - s) * (PI * 2.0) / period) * 0.5 + 1.0
        }
    }
}