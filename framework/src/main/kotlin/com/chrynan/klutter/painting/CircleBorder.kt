package com.chrynan.klutter.painting

import com.chrynan.klutter.rendering.EdgeInsets
import com.chrynan.klutter.ui.Canvas
import com.chrynan.klutter.ui.Path
import com.chrynan.klutter.ui.Rect
import com.chrynan.klutter.ui.TextDirection
import kotlin.math.max

class CircleBorder(val side: BorderSide = BorderSide.NONE) : ShapeBorder {

    override val dimensions: EdgeInsets
        get() = EdgeInsets.all(side.width)

    override fun scale(t: Double) = CircleBorder(side = side.scale(t))

    override fun getOuterPath(rect: Rect, textDirection: TextDirection) =
        Path().also {
            it.addOval(
                Rect.fromCircle(
                    center = rect.center,
                    radius = rect.shortestSide / 2.0
                )
            )
        }

    override fun getInnerPath(rect: Rect, textDirection: TextDirection) =
        Path().also {
            it.addOval(
                Rect.fromCircle(
                    center = rect.center,
                    radius = max(0.0, rect.shortestSide / 2.0 - side.width)
                )
            )
        }

    override fun paint(canvas: Canvas, rect: Rect, textDirection: TextDirection) {
        if (side.style == BorderStyle.SOLID) {
            canvas.drawCircle(rect.center, (rect.shortestSide - side.width) / 2.0, side.toPaint())
        }
    }
}