package com.chrynan.klutter.rendering

import com.chrynan.klutter.foundation.Listenable
import com.chrynan.klutter.ui.Canvas
import com.chrynan.klutter.ui.Offset
import com.chrynan.klutter.ui.Size
import com.chrynan.klutter.ui.VoidCallback

interface CustomPainter : Listenable {

    val repaint: Listenable?
        get() = null

    // TODO abstract val semanticsBuilder: SemanticsBuilderCallback

    override fun addListener(listener: VoidCallback) {
        repaint?.addListener(listener)
    }

    override fun removeListener(listener: VoidCallback) {
        repaint?.removeListener(listener)
    }

    fun paint(canvas: Canvas, size: Size)

    fun shouldRepaint(oldDelegate: CustomPainter): Boolean

    fun shouldRebuildSemantics(oldDelegate: CustomPainter) = shouldRepaint(oldDelegate)

    fun hitTest(position: Offset): Boolean? = null
}