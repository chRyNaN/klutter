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

    override val isUniform: Boolean
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun add(other: ShapeBorder, reversed: Boolean): BoxBorder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun paint(
        canvas: Canvas,
        textDirection: TextDirection,
        rect: Rect,
        boxShape: BoxShape,
        borderRadius: BorderRadius
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override val dimensions: EdgeInsets
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun scale(t: Double): ShapeBorder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun paint(canvas: Canvas, textDirection: TextDirection) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}