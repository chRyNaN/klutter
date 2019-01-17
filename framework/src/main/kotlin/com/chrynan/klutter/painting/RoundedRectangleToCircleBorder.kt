package com.chrynan.klutter.painting

import com.chrynan.klutter.rendering.EdgeInsets
import com.chrynan.klutter.rendering.EdgeInsetsGeometry
import com.chrynan.klutter.ui.*

class RoundedRectangleToCircleBorder(
    val side: BorderSide = BorderSide.NONE,
    val borderRadius: BorderRadius = BorderRadius.ZERO,
    val circleness: Double
) : ShapeBorder {

    override val dimensions: EdgeInsetsGeometry
        get() = EdgeInsets.all(side.width)

    override fun scale(t: Double) =
        RoundedRectangleToCircleBorder(
            side = side.scale(t),
            borderRadius = borderRadius * t,
            circleness = t
        )

    override fun getOuterPath(rect: Rect, textDirection: TextDirection) =
        Path().apply {
            addRRect(adjustBorderRadius(rect, textDirection).toRRect(adjustRect(rect)))
        }

    override fun getInnerPath(rect: Rect, textDirection: TextDirection) =
        Path().apply {
            addRRect(adjustBorderRadius(rect, textDirection).toRRect(adjustRect(rect)).deflate(side.width))
        }

    override fun paint(canvas: Canvas, rect: Rect, textDirection: TextDirection) {
        if (side.style == BorderStyle.SOLID) {
            if (side.width == 0.0) {
                canvas.drawRRect(adjustBorderRadius(rect, textDirection).toRRect(adjustRect(rect)), side.toPaint())
            } else {
                val outer = adjustBorderRadius(rect, textDirection).toRRect(adjustRect(rect))
                val inner = outer.deflate(side.width)
                val paint = Paint().also { it.color = side.color }

                canvas.drawDRRect(outer, inner, paint)
            }
        }
    }

    private fun adjustRect(rect: Rect): Rect {
        if ((circleness == 0.0) or (rect.width == rect.height)) return rect

        if (rect.width < rect.height) {
            val delta = circleness * (rect.height - rect.width) / 2.0

            return Rect(
                left = rect.left,
                top = rect.top + delta,
                right = rect.right,
                bottom = rect.bottom - delta
            )
        } else {
            val delta = circleness * (rect.width - rect.height) / 2.0

            return Rect(
                left = rect.left + delta,
                top = rect.top,
                right = rect.right - delta,
                bottom = rect.bottom
            )
        }
    }

    private fun adjustBorderRadius(rect: Rect, textDirection: TextDirection): BorderRadius {
        val resolvedRadius = borderRadius.resolve(textDirection)

        if (circleness == 0.0) return resolvedRadius

        return resolvedRadius * 2.0 // TODO update this it's wrong
    }
}