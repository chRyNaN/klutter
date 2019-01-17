package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.Canvas
import com.chrynan.klutter.ui.Offset
import com.chrynan.klutter.ui.Paint
import com.chrynan.klutter.ui.Path
import kotlin.math.atan2

fun paintZigZag(canvas: Canvas, paint: Paint, start: Offset, end: Offset, zigs: Int, width: Double) {
    canvas.save()
    canvas.translate(start.dx, start.dy)

    val diff = end - start

    canvas.rotate(atan2(diff.dy, diff.dx))

    val length = end.distance
    val spacing = length / (zigs * 2.0)
    val path = Path().apply { moveTo(0.0, 0.0) }

    for (i in 0 until zigs) {
        val x = (i * 2.0 + 1.0) * spacing
        val y = width * ((i % 2.0) * 2.0 - 1.0)

        path.lineTo(x, y)
    }

    path.lineTo(length, 0.0)

    canvas.drawPath(path, paint)
    canvas.restore()
}