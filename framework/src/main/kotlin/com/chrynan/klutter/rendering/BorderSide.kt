@file:Suppress("unused")

package com.chrynan.klutter.rendering

import com.chrynan.klutter.ui.Color
import kotlin.math.max

data class BorderSide(
    val color: Color = Color(0xFF),
    val width: Double = 1.0,
    val style: BorderStyle = BorderStyle.SOLID
) {

    companion object {

        val NONE = BorderSide(width = 0.0, style = BorderStyle.NONE)
    }

    fun scale(scale: Double) =
        BorderSide(
            color = color,
            width = max(0.0, width * scale),
            style = if (scale <= 0.0) BorderStyle.NONE else style
        )

    // TODO add toPaint() function
}