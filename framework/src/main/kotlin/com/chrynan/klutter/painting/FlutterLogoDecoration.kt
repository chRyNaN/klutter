package com.chrynan.klutter.painting

import com.chrynan.klutter.rendering.EdgeInsets
import com.chrynan.klutter.ui.Color
import com.chrynan.klutter.ui.VoidCallback

class FlutterLogoDecoration(
    val lightColor: Color = Color(0xff42a5),
    val darkColor: Color = Color(0xff0d47),
    val textColor: Color = Color(0xff6161),
    val style: FlutterLogoStyle = FlutterLogoStyle.MARK_ONLY,
    val margin: EdgeInsets = EdgeInsets.ZERO
) : Decoration {

    override val isComplex: Boolean
        get() = !inTransition

    val inTransition: Boolean
        get() = (opacity != 1.0) or ((position != -1.0) and (position != 0.0) and (position != 1.0))

    private val position = when (style) {
        FlutterLogoStyle.MARK_ONLY -> 0.0
        FlutterLogoStyle.HORIZONTAL -> 1.0
        else -> -1.0
    }
    private val opacity = 1.0

    override fun createBoxPainter(onChanged: VoidCallback): BoxPainter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}