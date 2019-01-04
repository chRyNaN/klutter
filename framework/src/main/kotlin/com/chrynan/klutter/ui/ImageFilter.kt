package com.chrynan.klutter.ui

expect class ImageFilter {

    companion object {

        fun blur(sigmaX: Double, sigmaY: Double): ImageFilter

        fun matrix(matrix4: List<Double>, filterQuality: FilterQuality = FilterQuality.LOW)
    }

    internal fun initBlur(sigmaX: Double, sigmaY: Double)

    internal fun initMatrix(matrix4: List<Double>, filterQuality: Int)
}