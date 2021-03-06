package com.chrynan.klutter.painting

import com.chrynan.klutter.rendering.EdgeInsets
import com.chrynan.klutter.ui.*

class RoundedRectangleBorder(
    val side: BorderSide,
    val borderRadius: BorderRadius
) : ShapeBorder {

    override val dimensions: EdgeInsets
        get() = EdgeInsets.all(side.width)

    override fun scale(t: Double) =
        RoundedRectangleBorder(
            side = side.scale(t),
            borderRadius = borderRadius * t
        )

    override fun getOuterPath(rect: Rect, textDirection: TextDirection) =
        Path().apply {
            addRRect(borderRadius.resolve(textDirection).toRRect(rect).deflate(side.width))
        }

    override fun getInnerPath(rect: Rect, textDirection: TextDirection) =
        Path().apply {
            addRRect(borderRadius.resolve(textDirection).toRRect(rect))
        }

    override fun paint(canvas: Canvas, rect: Rect, textDirection: TextDirection) {
        if (side.style == BorderStyle.SOLID) {
            if (side.width == 0.0) {
                canvas.drawRRect(borderRadius.resolve(textDirection).toRRect(rect), side.toPaint())
            } else {
                val outer = borderRadius.resolve(textDirection).toRRect(rect)
                val inner = outer.deflate(side.width)
                val paint = Paint().apply {
                    color = side.color
                }
                canvas.drawDRRect(outer, inner, paint)
            }
        }
    }
}