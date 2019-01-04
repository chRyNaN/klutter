package com.chrynan.klutter.ui

open class OffsetBase(
    protected open val dx: Double = 0.0,
    protected open val dy: Double = 0.0
) {

    val isFinite: Boolean
        get() = dx.isFinite() and dy.isFinite()

    val isInfinite: Boolean
        get() = dx.isInfinite() or dy.isInfinite()
}