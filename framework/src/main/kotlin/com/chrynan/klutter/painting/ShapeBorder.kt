package com.chrynan.klutter.painting

import com.chrynan.klutter.rendering.EdgeInsets
import com.chrynan.klutter.ui.Canvas
import com.chrynan.klutter.ui.Path
import com.chrynan.klutter.ui.Rect
import com.chrynan.klutter.ui.TextDirection

interface ShapeBorder {

    val dimensions: EdgeInsets

    fun add(other: ShapeBorder, reversed: Boolean = false): ShapeBorder

    fun scale(t: Double): ShapeBorder

    fun getOuterPath(rect: Rect, textDirection: TextDirection = TextDirection.LTR): Path

    fun getInnerPath(rect: Rect, textDirection: TextDirection = TextDirection.LTR): Path

    fun paint(canvas: Canvas, textDirection: TextDirection = TextDirection.LTR)
}