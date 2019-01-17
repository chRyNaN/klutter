package com.chrynan.klutter.painting

import com.chrynan.klutter.rendering.EdgeInsets
import com.chrynan.klutter.rendering.EdgeInsetsGeometry
import com.chrynan.klutter.ui.*

class StadiumToRoundedRectangleBorder(
    val side: BorderSide = BorderSide.NONE,
    val borderRadius: BorderRadius = BorderRadius.ZERO,
    val rectness: Double = 0.0
) : ShapeBorder {

    override val dimensions: EdgeInsetsGeometry
        get() = EdgeInsets.all(side.width)

    override fun scale(t: Double) =
        StadiumToRoundedRectangleBorder(
            side = side.scale(t),
            borderRadius = borderRadius * t,
            rectness = t
        )

    override fun getOuterPath(rect: Rect, textDirection: TextDirection) =
        Path().apply {
            addRRect(adjustBorderRadius(rect).toRRect(rect))
        }

    override fun getInnerPath(rect: Rect, textDirection: TextDirection) =
        Path().apply {
            addRRect(adjustBorderRadius(rect).toRRect(rect).deflate(side.width))
        }

    override fun paint(canvas: Canvas, rect: Rect, textDirection: TextDirection) {
        if (side.style == BorderStyle.SOLID) {
            if (side.width == 0.0) {
                canvas.drawRRect(adjustBorderRadius(rect).toRRect(rect), side.toPaint())
            } else {
                val outer = adjustBorderRadius(rect).toRRect(rect)
                val inner = outer.deflate(side.width)
                val paint = Paint().apply {
                    color = side.color
                }

                canvas.drawDRRect(outer, inner, paint)
            }
        }
    }

    private fun adjustBorderRadius(rect: Rect) = borderRadius
}