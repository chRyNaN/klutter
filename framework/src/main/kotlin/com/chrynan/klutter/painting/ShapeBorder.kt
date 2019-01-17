package com.chrynan.klutter.painting

import com.chrynan.klutter.rendering.EdgeInsetsGeometry
import com.chrynan.klutter.ui.Canvas
import com.chrynan.klutter.ui.Path
import com.chrynan.klutter.ui.Rect
import com.chrynan.klutter.ui.TextDirection

interface ShapeBorder {

    val dimensions: EdgeInsetsGeometry

    fun scale(t: Double): ShapeBorder

    fun getOuterPath(rect: Rect, textDirection: TextDirection = TextDirection.LTR): Path

    fun getInnerPath(rect: Rect, textDirection: TextDirection = TextDirection.LTR): Path

    fun paint(canvas: Canvas, rect: Rect, textDirection: TextDirection = TextDirection.LTR)

    fun add(other: ShapeBorder, reversed: Boolean = false): ShapeBorder? = null
}