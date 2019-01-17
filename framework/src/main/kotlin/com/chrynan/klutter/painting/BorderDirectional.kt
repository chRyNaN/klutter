package com.chrynan.klutter.painting

import com.chrynan.klutter.rendering.EdgeInsetsDirectional
import com.chrynan.klutter.rendering.EdgeInsetsGeometry
import com.chrynan.klutter.ui.Canvas
import com.chrynan.klutter.ui.Rect
import com.chrynan.klutter.ui.TextDirection

class BorderDirectional(
    override val top: BorderSide = BorderSide.NONE,
    val start: BorderSide = BorderSide.NONE,
    val end: BorderSide = BorderSide.NONE,
    override val bottom: BorderSide = BorderSide.NONE
) : BoxBorder {

    override val dimensions: EdgeInsetsGeometry
        get() = EdgeInsetsDirectional(start = start.width, end = end.width, top = top.width, bottom = bottom.width)

    override val isUniform: Boolean
        get() {
            if ((start.color != top.color) or
                (end.color != top.color) or
                (bottom.color != top.color)
            ) return false

            if ((start.width != top.width) or
                (end.width != top.width) or
                (bottom.width != top.width)
            ) return false

            if ((start.style != top.style) or
                (end.style != top.style) or
                (bottom.style != top.style)
            ) return false

            return true
        }

    override fun add(other: ShapeBorder, reversed: Boolean): BoxBorder? {
        if (other is BorderDirectional) {
            return if ((top.canMerge(other.top)) and
                (start.canMerge(other.start)) and
                (end.canMerge(other.end)) and
                (bottom.canMerge(other.bottom))
            ) {
                merge(other)
            } else {
                null
            }
        }

        if (other is Border) {
            if (top.canMerge(other.top) or bottom.canMerge(other.bottom)) return null
            if ((start != BorderSide.NONE) or (end != BorderSide.NONE)) {
                if ((other.left != BorderSide.NONE) or (other.right != BorderSide.NONE)) return null
                return BorderDirectional(
                    top = top.merge(other.top),
                    start = start,
                    end = end,
                    bottom = bottom.merge(other.bottom)
                )
            }

            return Border(
                top = top.merge(other.top),
                right = other.right,
                bottom = bottom.merge(other.bottom),
                left = other.left
            )
        }

        return null
    }

    override fun paint(
        canvas: Canvas,
        rect: Rect,
        textDirection: TextDirection,
        boxShape: BoxShape,
        borderRadius: BorderRadius
    ) {
        if (isUniform) {
            if (top.style == BorderStyle.SOLID) {
                if (boxShape == BoxShape.CIRCLE) {
                    // TODO
                } else if (boxShape == BoxShape.RECTANGLE) {
                    // TODO
                }
            }
        }
    }

    override fun scale(t: Double) =
        BorderDirectional(
            top = top.scale(t),
            start = start.scale(t),
            end = end.scale(t),
            bottom = bottom.scale(t)
        )

    override fun paint(canvas: Canvas, rect: Rect, textDirection: TextDirection) =
        paint(canvas, rect, textDirection, BoxShape.RECTANGLE, BorderRadius.ZERO)

    fun merge(other: BorderDirectional) =
        BorderDirectional(
            top = top.merge(other.top),
            start = start.merge(other.start),
            end = end.merge(other.end),
            bottom = bottom.merge(other.bottom)
        )
}