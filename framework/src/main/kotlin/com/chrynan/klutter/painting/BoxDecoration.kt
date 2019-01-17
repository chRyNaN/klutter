package com.chrynan.klutter.painting

import com.chrynan.klutter.rendering.EdgeInsetsGeometry
import com.chrynan.klutter.ui.BlendMode
import com.chrynan.klutter.ui.Color
import com.chrynan.klutter.ui.VoidCallback

class BoxDecoration(
    val color: Color,
    val image: DecorationImage,
    val border: BoxBorder,
    val borderRadius: BorderRadiusGeometry,
    val boxShadow: List<BoxShadow> = emptyList(),
    val gradient: Gradient,
    val backgroundBlendMode: BlendMode,
    val shape: BoxShape
) : Decoration {

    override val padding: EdgeInsetsGeometry
        get() = border.dimensions

    override val isComplex: Boolean
        get() = boxShadow.isNotEmpty()

    override fun createBoxPainter(onChanged: VoidCallback) =
        BoxDecorationPainter(this, onChanged)
}