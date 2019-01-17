package com.chrynan.klutter.rendering

import com.chrynan.klutter.ui.Size

interface FlowPaintingContext {

    val size: Size

    val childCOunt: Int

    fun getChildSize(i: Int): Size

    // TODO need Matrix4 fun paintChild(i: Int, transform: Matrix4? = null, opacity: Double = 1.0)
}