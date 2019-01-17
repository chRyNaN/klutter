package com.chrynan.klutter.painting

import com.chrynan.klutter.rendering.EdgeInsets
import com.chrynan.klutter.rendering.EdgeInsetsGeometry
import com.chrynan.klutter.ui.Canvas
import com.chrynan.klutter.ui.Path
import com.chrynan.klutter.ui.Rect
import com.chrynan.klutter.ui.TextDirection

class CompoundBorder(private val borders: List<ShapeBorder>) : ShapeBorder {

    override val dimensions = borders.fold(EdgeInsets.ZERO) { previous: EdgeInsetsGeometry, border: ShapeBorder ->
        previous + border.dimensions
    }

    override fun add(other: ShapeBorder, reversed: Boolean): ShapeBorder {
        if (other !is CompoundBorder) {
            val ours = if (reversed) borders.last() else borders.first()
            val merged = ours.add(other = other, reversed = reversed) ?: other.add(other = ours, reversed = !reversed)

            if (merged != null) {
                val result = mutableListOf<ShapeBorder>().apply {
                    addAll(borders)
                }
                result[if (reversed) result.size - 1 else 0] = merged

                return CompoundBorder(borders = result)
            }
        }

        val mergedBorders = mutableListOf<ShapeBorder>()

        if (reversed) mergedBorders.addAll(borders)
        if (other is CompoundBorder) {
            mergedBorders.addAll(other.borders)
        } else {
            mergedBorders.add(other)
        }
        if (!reversed) mergedBorders.addAll(borders)

        return CompoundBorder(borders = mergedBorders)
    }

    override fun scale(t: Double) =
        CompoundBorder(borders = borders.map { it.scale(t) })

    override fun getOuterPath(rect: Rect, textDirection: TextDirection) =
        borders.first().getOuterPath(rect, textDirection)

    override fun getInnerPath(rect: Rect, textDirection: TextDirection): Path {
        var newRect = rect

        borders.forEach {
            newRect = it.dimensions.resolve(textDirection).deflateRect(newRect)
        }

        return borders.last().getInnerPath(newRect, textDirection)
    }

    override fun paint(canvas: Canvas, rect: Rect, textDirection: TextDirection) {
        var newRect = rect

        borders.forEach {
            it.paint(canvas, newRect, textDirection)
            newRect = it.dimensions.resolve(textDirection).deflateRect(newRect)
        }
    }
}