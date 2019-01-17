package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.Canvas
import com.chrynan.klutter.ui.Path
import com.chrynan.klutter.ui.Rect
import com.chrynan.klutter.ui.VoidCallback

class DecorationImagePainter(
    private val details: DecorationImage,
    private val onChanged: VoidCallback
) {

    fun paint(canvas: Canvas, rect: Rect, clipPath: Path, configuration: ImageConfiguration) {

    }

    fun dispose() {

    }
}