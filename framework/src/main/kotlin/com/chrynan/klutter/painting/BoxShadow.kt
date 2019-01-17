package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.Color
import com.chrynan.klutter.ui.Offset
import com.chrynan.klutter.ui.Shadow

class BoxShadow(
    color: Color = Color(0x00),
    offset: Offset = Offset.ZERO,
    blurRadius: Double = 0.0,
    val spreadRadius: Double = 0.0
) : Shadow(
    color = color,
    offset = offset,
    blurRadius = blurRadius
) {

    override fun scale(factor: Double): BoxShadow = BoxShadow(
        color = color,
        offset = offset * factor,
        blurRadius = blurRadius * factor,
        spreadRadius = spreadRadius * factor
    )
}