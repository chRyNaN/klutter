package com.chrynan.klutter.painting

import com.chrynan.klutter.rendering.EdgeInsets
import com.chrynan.klutter.ui.Canvas
import com.chrynan.klutter.ui.Path
import com.chrynan.klutter.ui.Rect
import com.chrynan.klutter.ui.TextDirection

class RoundedRectangleBorder(
    side: BorderSide,
    borderRadius: BorderRadius
): ShapeBorder {

    override val dimensions: EdgeInsets
        get() = TODO("not implemented") //To change initializer of created properties use File | Settings | File Templates.

    override fun add(other: ShapeBorder, reversed: Boolean): ShapeBorder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun scale(t: Double): ShapeBorder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getOuterPath(rect: Rect, textDirection: TextDirection): Path {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getInnerPath(rect: Rect, textDirection: TextDirection): Path {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun paint(canvas: Canvas, textDirection: TextDirection) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}