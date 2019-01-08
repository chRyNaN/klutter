package com.chrynan.klutter.animation

object Curves {

    val LINEAR = LinearCurve()

    val DECELERATE = DecelerateCurve()

    val EASE = CubicCurve(a = 0.25, b = 0.1, c = 0.25, d = 1.0)

    val EASE_IN = CubicCurve(a = 0.42, b = 0.0, c = 1.0, d = 1.0)

    val EASE_IN_SINE = CubicCurve(a = 0.47, b = 0.0, c = 0.745, d = 0.715)

    val EASE_IN_QUAD = CubicCurve(a = 0.55, b = 0.085, c = 0.68, d = 0.53)

    val EASE_IN_CUBIC = CubicCurve(a = 0.55, b = 0.055, c = 0.675, d = 0.19)

    val EASE_IN_QUART = CubicCurve(a = 0.895, b = 0.03, c = 0.685, d = 0.22)

    val EASE_IN_QUINT = CubicCurve(a = 0.755, b = 0.05, c = 0.855, d = 0.06)

    val EASE_IN_EXPO = CubicCurve(a = 0.95, b = 0.05, c = 0.795, d = 0.035)

    val EASE_IN_CIRC = CubicCurve(a = 0.6, b = 0.04, c = 0.98, d = 0.335)

    val EASE_IN_BACK = CubicCurve(a = 0.6, b = -0.28, c = 0.735, d = 0.045)

    val EASE_OUT = CubicCurve(a = 0.0, b = 0.0, c = 0.58, d = 1.0)

    val EASE_OUT_SINE = CubicCurve(a = 0.39, b = 0.575, c = 0.565, d = 1.0)

    val EASE_OUT_QUAD = CubicCurve(a = 0.25, b = 0.46, c = 0.45, d = 0.94)

    val EASE_OUT_CUBIC = CubicCurve(a = 0.215, b = 0.61, c = 0.355, d = 1.0)

    val EASE_OUT_QUART = CubicCurve(a = 0.165, b = 0.84, c = 0.44, d = 1.0)

    val EASE_OUT_QUINT = CubicCurve(a = 0.23, b = 1.0, c = 0.32, d = 1.0)

    val EASE_OUT_EXPO = CubicCurve(a = 0.19, b = 1.0, c = 0.22, d = 1.0)

    val EASE_OUT_CIRC = CubicCurve(a = 0.075, b = 0.82, c = 0.165, d = 1.0)

    val EASE_OUT_BACK = CubicCurve(a = 0.175, b = 0.885, c = 0.32, d = 1.275)

    val EASE_IN_OUT = CubicCurve(a = 0.42, b = 0.0, c = 0.58, d = 1.0)

    val EASE_IN_OUT_SINE = CubicCurve(a = 0.445, b = 0.05, c = 0.55, d = 0.95)

    val EASE_IN_OUT_QUAD = CubicCurve(a = 0.455, b = 0.03, c = 0.515, d = 0.955)

    val EASE_IN_OUT_CUBIC = CubicCurve(a = 0.645, b = 0.045, c = 0.355, d = 1.0)

    val EASE_IN_OUT_QUART = CubicCurve(a = 0.77, b = 0.0, c = 0.175, d = 1.0)

    val EASE_IN_OUT_QUINT = CubicCurve(a = 0.86, b = 0.0, c = 0.07, d = 1.0)

    val EASE_IN_OUT_EXPO = CubicCurve(a = 1.0, b = 0.0, c = 0.0, d = 1.0)

    val EASE_IN_OUT_CIRC = CubicCurve(a = 0.785, b = 0.135, c = 0.15, d = 0.86)

    val EASE_IN_OUT_BACK = CubicCurve(a = 0.68, b = -0.55, c = 0.265, d = 1.55)

    val FAST_OUT_SLOW_IN = CubicCurve(a = 0.4, b = 0.0, c = 0.2, d = 1.0)

    val BOUNCE_IN = BounceInCurve()

    val BOUNCE_OUT = BounceOutCurve()

    val BOUNCE_IN_OUT = BounceInOutCurve()

    val ELASTIC_IN = ElasticInCurve()

    val ELASTIC_OUT = ElasticOutCurve()

    val ELASTIC_IN_OUT_CURVE = ElasticInOutCurve()
}