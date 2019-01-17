@file:Suppress("unused")

package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.Color
import com.chrynan.klutter.ui.Paint
import com.chrynan.klutter.ui.PaintingStyle
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

    fun toPaint() =
        when (style) {
            BorderStyle.SOLID -> Paint().also {
                it.color = color
                it.strokeWidth = width
                it.style = PaintingStyle.STROKE
            }
            BorderStyle.NONE -> Paint().also {
                it.color = Color(0x00)
                it.strokeWidth = 0.0
                it.style = PaintingStyle.STROKE
            }
        }

    fun canMerge(other: BorderSide): Boolean {
        if (((style == BorderStyle.NONE) and (width == 0.0)) or
            ((other.style == BorderStyle.NONE) and (other.width == 0.0))
        ) return true

        return (style == other.style) and (color == other.color)
    }

    fun merge(other: BorderSide): BorderSide {
        val isNone = (style == BorderStyle.NONE) and (width == 0.0)
        val otherIsNone = (other.style == BorderStyle.NONE) and (other.width == 0.0)

        if (isNone and otherIsNone) return NONE
        if (isNone) return other
        if (otherIsNone) return this

        return BorderSide(
            color = this.color,
            width = this.width + other.width,
            style = this.style
        )
    }
}