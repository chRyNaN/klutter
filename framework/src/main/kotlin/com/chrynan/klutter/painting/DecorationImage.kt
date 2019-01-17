package com.chrynan.klutter.painting

import com.chrynan.klutter.rendering.ImageRepeat
import com.chrynan.klutter.ui.ColorFilter
import com.chrynan.klutter.ui.Rect
import com.chrynan.klutter.ui.VoidCallback

data class DecorationImage(
    val image: ImageProvider,
    val colorFilter: ColorFilter,
    val fit: BoxFit,
    val alignment: AlignmentGeometry = Alignment.CENTER,
    val centerSlice: Rect,
    val imageRepeat: ImageRepeat = ImageRepeat.NO_REPEAT,
    val matchTextDirection: Boolean = false
) {

    fun createPainter(onChanged: VoidCallback) = DecorationImagePainter(this, onChanged)
}