package com.chrynan.klutter.painting

import com.chrynan.klutter.rendering.EdgeInsets
import com.chrynan.klutter.ui.*
import kotlin.math.max
import kotlin.math.min

class BeveledRectangleBorder(
    val side: BorderSide = BorderSide.NONE,
    val borderRadius: BorderRadius = BorderRadius.ZERO
) : ShapeBorder {

    override val dimensions: EdgeInsets
        get() = EdgeInsets.all(side.width)

    override fun scale(t: Double) =
        BeveledRectangleBorder(
            side = side.scale(t),
            borderRadius = borderRadius * t
        )

    override fun getOuterPath(rect: Rect, textDirection: TextDirection) =
        getPath(borderRadius.resolve(textDirection).toRRect(rect))

    override fun getInnerPath(rect: Rect, textDirection: TextDirection) =
        getPath(borderRadius.resolve(textDirection).toRRect(rect).deflate(side.width))

    override fun paint(canvas: Canvas, rect: Rect, textDirection: TextDirection) {
        if (rect.isEmpty) return

        if (side.style == BorderStyle.SOLID) {
            val path = getOuterPath(rect = rect, textDirection = textDirection).apply {
                addPath(getInnerPath(rect = rect, textDirection = textDirection), Offset.ZERO)
            }
            canvas.drawPath(path, side.toPaint())
        }
    }

    private fun getPath(rrect: RRect): Path {
        val centerLeft = Offset(rrect.left, rrect.center.dy);
        val centerRight = Offset(rrect.right, rrect.center.dy);
        val centerTop = Offset(rrect.center.dx, rrect.top);
        val centerBottom = Offset(rrect.center.dx, rrect.bottom);

        val tlRadiusX = max(0.0, rrect.topLeftRadiusX)
        val tlRadiusY = max(0.0, rrect.topLeftRadiusY)
        val trRadiusX = max(0.0, rrect.topRightRadiusX)
        val trRadiusY = max(0.0, rrect.topRightRadiusY)
        val blRadiusX = max(0.0, rrect.bottomLeftRadiusX)
        val blRadiusY = max(0.0, rrect.bottomLeftRadiusY)
        val brRadiusX = max(0.0, rrect.bottomRightRadiusX)
        val brRadiusY = max(0.0, rrect.bottomRightRadiusY)

        val vertices = listOf(
            Offset(rrect.left, min(centerLeft.dy, rrect.top + tlRadiusY)),
            Offset(min(centerTop.dx, rrect.left + tlRadiusX), rrect.top),
            Offset(max(centerTop.dx, rrect.right - trRadiusX), rrect.top),
            Offset(rrect.right, min(centerRight.dy, rrect.top + trRadiusY)),
            Offset(rrect.right, max(centerRight.dy, rrect.bottom - brRadiusY)),
            Offset(max(centerBottom.dx, rrect.right - brRadiusX), rrect.bottom),
            Offset(min(centerBottom.dx, rrect.left + blRadiusX), rrect.bottom),
            Offset(rrect.left, max(centerLeft.dy, rrect.bottom - blRadiusY))
        )

        return Path().apply {
            addPolygon(vertices, true)
        }
    }
}