package com.chrynan.klutter.painting

import com.chrynan.klutter.rendering.EdgeInsets
import com.chrynan.klutter.ui.Canvas
import com.chrynan.klutter.ui.Color
import com.chrynan.klutter.ui.Rect
import com.chrynan.klutter.ui.TextDirection

class Border(
    override val top: BorderSide,
    val right: BorderSide,
    override val bottom: BorderSide,
    val left: BorderSide
) : BoxBorder {

    companion object {

        fun all(color: Color = Color(0xff), width: Double = 1.0, style: BorderStyle = BorderStyle.SOLID) =
            BorderSide(color = color, width = width, style = style).let {
                Border(
                    left = it,
                    top = it,
                    right = it,
                    bottom = it
                )
            }
    }

    override val dimensions: EdgeInsets
        get() = EdgeInsets(left = left.width, top = top.width, right = right.width, bottom = bottom.width)

    override val isUniform: Boolean
        get() {
            if ((right.color != top.color) or
                (bottom.color != top.color) or
                (left.color != top.color)
            ) return false

            if ((right.width != top.width) or
                (bottom.width != top.width) or
                (left.width != top.width)
            ) return false

            if ((right.style != top.style) or
                (bottom.style != top.style) or
                (left.style != top.style)
            ) return false

            return true
        }

    override fun add(other: ShapeBorder, reversed: Boolean): BoxBorder? {
        if (other !is Border) return null
        if ((top.canMerge(other.top)) and
            (right.canMerge(other.right)) and
            (bottom.canMerge(other.bottom)) and
            (left.canMerge(other.left))
        ) return this.merge(other)

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
                } else {
                    // TODO
                }
            }
        }
    }

    override fun scale(t: Double) =
        Border(
            top = top.scale(t),
            right = right.scale(t),
            bottom = bottom.scale(t),
            left = left.scale(t)
        )

    override fun paint(canvas: Canvas, rect: Rect, textDirection: TextDirection) =
        paint(
            canvas = canvas,
            rect = rect,
            textDirection = textDirection,
            boxShape = BoxShape.RECTANGLE,
            borderRadius = BorderRadius.ZERO
        )

    fun merge(other: Border) =
        Border(
            top = top.merge(other.top),
            right = right.merge(other.right),
            bottom = bottom.merge(other.bottom),
            left = left.merge(other.left)
        )
}