package com.chrynan.klutter.rendering

abstract class ShapeBorder {

    abstract val dimensions: EdgeInsets

    abstract fun scale(t: Double): ShapeBorder

    // TODO
}