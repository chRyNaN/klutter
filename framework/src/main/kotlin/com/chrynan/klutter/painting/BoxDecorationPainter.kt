package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.Canvas
import com.chrynan.klutter.ui.Offset
import com.chrynan.klutter.ui.VoidCallback

class BoxDecorationPainter(
    private val decoration: BoxDecoration,
    override val onChanged: VoidCallback
) : BoxPainter {

    override fun paint(canvas: Canvas, offset: Offset, configuration: ImageConfiguration) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}