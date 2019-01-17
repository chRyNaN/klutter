package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.Offset
import com.chrynan.klutter.ui.Rect
import com.chrynan.klutter.ui.Size

data class FractionalOffset(
    val dx: Double,
    val dy: Double
) : Alignment(
    x = dx * 2.0 - 1.0,
    y = dy * 2.0 - 1.0
) {

    companion object {

        val TOP_LEFT = FractionalOffset(dx = 0.0, dy = 0.0)

        val TOP_CENTER = FractionalOffset(dx = 0.5, dy = 0.0)

        val TOP_RIGHT = FractionalOffset(dx = 1.0, dy = 0.0)

        val CENTER_LEFT = FractionalOffset(dx = 0.0, dy = 0.5)

        val CENTER = FractionalOffset(dx = 0.5, dy = 0.5)

        val CENTER_RIGHT = FractionalOffset(dx = 1.0, dy = 0.5)

        val BOTTOM_LEFT = FractionalOffset(dx = 0.0, dy = 1.0)

        val BOTTOM_CENTER = FractionalOffset(dx = 0.5, dy = 1.0)

        val BOTTOM_RIGHT = FractionalOffset(dx = 1.0, dy = 1.0)

        fun fromOffsetAndSize(offset: Offset, size: Size) =
            FractionalOffset(
                dx = offset.dx / size.width,
                dy = offset.dy / size.height
            )

        fun fromOffsetAndRect(offset: Offset, rect: Rect) =
            fromOffsetAndSize(
                offset = offset - rect.topLeft,
                size = rect.size
            )
    }

    // TODO
}