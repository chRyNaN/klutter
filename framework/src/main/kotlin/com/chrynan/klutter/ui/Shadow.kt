package com.chrynan.klutter.ui

open class Shadow(
    val color: Color = Color(0x00),
    val offset: Offset = Offset.ZERO,
    val blurRadius: Double = 0.0
) {

    val blurSigma: Double
        get() = blurRadius * 0.57735 + 0.5

    open fun scale(factor: Double) = Shadow(
        color = color,
        offset = offset * factor,
        blurRadius = blurRadius * factor
    )

    open fun toPaint() = Paint().also {
        it.color = color
        it.maskFilter = MaskFilter(style = BlurStyle.NORMAL, sigma = blurSigma)
    }
}