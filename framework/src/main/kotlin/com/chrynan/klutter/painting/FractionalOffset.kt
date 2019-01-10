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

        // TODO
    }

    // TODO
}