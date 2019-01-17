package com.chrynan.klutter.painting

import com.chrynan.klutter.foundation.Diagnosticable
import com.chrynan.klutter.rendering.EdgeInsets
import com.chrynan.klutter.rendering.EdgeInsetsGeometry
import com.chrynan.klutter.ui.Offset
import com.chrynan.klutter.ui.Size
import com.chrynan.klutter.ui.TextDirection
import com.chrynan.klutter.ui.VoidCallback

interface Decoration : Diagnosticable {

    val padding: EdgeInsetsGeometry
        get() = EdgeInsets.ZERO

    val isComplex: Boolean
        get() = false

    fun hitTest(size: Size, offset: Offset, textDirection: TextDirection = TextDirection.LTR): Boolean = false

    fun createBoxPainter(onChanged: VoidCallback = {}): BoxPainter
}