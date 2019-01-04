package com.chrynan.klutter.ui

data class Shadow(
    val color: Color,
    val offset: Offset,
    val blurRadius: Double = 0.0
) {

    val blurSigma: Double
        get() = blurRadius * 0.57735 + 0.5

    fun scale(factor: Double) = Shadow(
        color = color,
        offset = offset * factor,
        blurRadius = blurRadius * factor
    )

    // TODO add toPaint() function
}