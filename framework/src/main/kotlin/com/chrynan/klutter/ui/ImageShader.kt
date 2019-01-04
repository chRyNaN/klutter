package com.chrynan.klutter.ui

expect class ImageShader {

    val image: Image
    val tmx: TileMode
    val tmy: TileMode
    val matrix4: List<Double>
}