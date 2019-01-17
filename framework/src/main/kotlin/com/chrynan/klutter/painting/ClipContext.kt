package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.*

interface ClipContext {

    val canvas: Canvas

    fun clipPathAndPaint(path: Path, clipBehavior: Clip, bounds: Rect, painter: () -> Unit) =
        clipAndPaint(
            canvasClipCall = { canvas.clipPath(path, it) },
            clipBehavior = clipBehavior,
            bounds = bounds,
            painter = painter
        )

    fun clipRRectAndPaint(rRect: RRect, clipBehavior: Clip, bounds: Rect, painter: () -> Unit) =
        clipAndPaint(
            canvasClipCall = { canvas.clipRRect(rRect, it) },
            clipBehavior = clipBehavior,
            bounds = bounds,
            painter = painter
        )

    fun clipRectAndPaint(rect: Rect, clipBehavior: Clip, bounds: Rect, painter: () -> Unit) =
        clipAndPaint(
            canvasClipCall = { canvas.clipRect(rect, ClipOp.INTERSECT, it) },
            clipBehavior = clipBehavior,
            bounds = bounds,
            painter = painter
        )

    private fun clipAndPaint(
        canvasClipCall: (doAntiAlias: Boolean) -> Unit,
        clipBehavior: Clip,
        bounds: Rect,
        painter: () -> Unit
    ) {
        canvas.save()

        when (clipBehavior) {
            Clip.HARD_EDGE -> canvasClipCall(false)
            Clip.ANTI_ALIAS -> canvasClipCall(true)
            Clip.ANTI_ALIAS_WITH_SAVE_LAYER -> {
                canvasClipCall(true)
                canvas.saveLayer(bounds, Paint())
            }
            Clip.NONE -> {
            }
        }

        painter()

        if (clipBehavior == Clip.ANTI_ALIAS_WITH_SAVE_LAYER) {
            canvas.restore()
        }

        canvas.restore()
    }
}