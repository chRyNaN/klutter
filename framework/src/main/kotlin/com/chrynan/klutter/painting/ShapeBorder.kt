package com.chrynan.klutter.painting

import com.chrynan.klutter.rendering.EdgeInsets

abstract class ShapeBorder {

    abstract val dimensions: EdgeInsets

    abstract fun scale(t: Double): ShapeBorder

    // TODO
}