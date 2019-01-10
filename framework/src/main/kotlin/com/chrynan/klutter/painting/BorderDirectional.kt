package com.chrynan.klutter.painting

import com.chrynan.klutter.rendering.EdgeInsets
import com.chrynan.klutter.ui.Canvas
import com.chrynan.klutter.ui.Rect
import com.chrynan.klutter.ui.TextDirection

class BorderDirectional(
    override val top: BorderSide = BorderSide.NONE,
    val start: BorderSide = BorderSide.NONE,
    val end: BorderSide = BorderSide.NONE,
    override val bottom: BorderSide = BorderSide.NONE
) : BoxBorder {

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