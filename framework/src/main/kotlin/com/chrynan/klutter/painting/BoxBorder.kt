package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.Canvas
import com.chrynan.klutter.ui.Path
import com.chrynan.klutter.ui.Rect
import com.chrynan.klutter.ui.TextDirection

interface BoxBorder : ShapeBorder {

    val top: BorderSide

    val bottom: BorderSide

    val isUniform: Boolean

    override fun add(other: ShapeBorder, reversed: Boolean): BoxBorder?

    override fun getInnerPath(rect: Rect, textDirection: TextDirection) = Path().apply {
        addRect(dimensions.resolve(textDirection).deflateRect(rect))
    }

    override fun getOuterPath(rect: Rect, textDirection: TextDirection) = Path().apply {
        addRect(rect)
    }

    fun paint(
        canvas: Canvas,
        rect: Rect,
        textDirection: TextDirection = TextDirection.LTR,
        boxShape: BoxShape = BoxShape.RECTANGLE,
        borderRadius: BorderRadius
    )
}