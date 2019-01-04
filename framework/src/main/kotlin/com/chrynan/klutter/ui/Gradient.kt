package com.chrynan.klutter.ui

expect class Gradient : Shader {

    companion object {

        fun linear(
            from: Offset,
            to: Offset,
            colors: List<Color>,
            colorStops: List<Double>,
            tileMode: TileMode = TileMode.CLAMP
        ): Gradient

        fun radial(
            center: Offset,
            radius: Double,
            colors: List<Color>,
            colorStops: List<Double>,
            tileMode: TileMode = TileMode.CLAMP,
            matrix4: List<Double>,
            focal: Offset,
            focalRadius: Double = 0.0
        ): Gradient

        fun sweep(
            center: Offset,
            colors: List<Color>,
            colorStops: List<Double>,
            tileMode: TileMode = TileMode.CLAMP,
            startAngle: Double = 0.0,
            endAngle: Double = 0.0,
            matrix4: List<Double>
        ): Gradient
    }
}