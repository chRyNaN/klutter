package com.chrynan.klutter.ui

data class TextBox(
    val left: Double,
    val top: Double,
    val right: Double,
    val bottom: Double,
    val direction: TextDirection
) {

    val start: Double
        get() = if (direction == TextDirection.LTR) left else right

    val end: Double
        get() = if (direction == TextDirection.LTR) right else left

    fun toRect() = Rect(left = left, top = top, right = right, bottom = bottom)
}