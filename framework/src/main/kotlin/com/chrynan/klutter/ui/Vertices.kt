package com.chrynan.klutter.ui

expect class Vertices {

    companion object {

        fun raw(
            mode: VertexMode,
            positions: List<Double>,
            textureCoordinates: List<Double>,
            colors: List<Int>,
            indices: List<Int>
        )
    }

    val mode: VertexMode
    val positions: List<Offset>
    val textureCoordinates: List<Offset>
    val colors: List<Color>
    val indices: List<Int>
}