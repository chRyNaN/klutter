package com.chrynan.klutter.painting

import com.chrynan.klutter.rendering.EdgeInsets
import com.chrynan.klutter.rendering.EdgeInsetsGeometry
import com.chrynan.klutter.ui.*

class StadiumBorder(
    val side: BorderSide = BorderSide.NONE
) : ShapeBorder {

    override val dimensions: EdgeInsetsGeometry
        get() = EdgeInsets.all(side.width)

    override fun scale(t: Double) = StadiumBorder(side = side.scale(t))

    override fun getOuterPath(rect: Rect, textDirection: TextDirection): Path {
        val radius = Radius.circular(rect.shortestSide / 2.0)

        return Path().apply {
            addRRect(RRect.fromRectAndRadius(rect = rect, radius = radius))
        }
    }

    override fun getInnerPath(rect: Rect, textDirection: TextDirection): Path {
        val radius = Radius.circular(rect.shortestSide / 2.0)

        return Path().apply {
            addRRect(RRect.fromRectAndRadius(rect = rect, radius = radius).deflate(side.width))
        }
    }

    override fun paint(canvas: Canvas, rect: Rect, textDirection: TextDirection) {
        if (side.style == BorderStyle.SOLID) {
            val radius = Radius.circular(rect.shortestSide / 2.0)

            canvas.drawRRect(
                RRect.fromRectAndRadius(rect = rect, radius = radius).deflate(side.width / 2.0),
                side.toPaint()
            )
        }
    }
}