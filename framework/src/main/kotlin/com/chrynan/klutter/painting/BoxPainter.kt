package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.Canvas
import com.chrynan.klutter.ui.Offset
import com.chrynan.klutter.ui.VoidCallback

interface BoxPainter {

    val onChanged: VoidCallback

    fun paint(canvas: Canvas, offset: Offset, configuration: ImageConfiguration)

    fun dispose() {}
}