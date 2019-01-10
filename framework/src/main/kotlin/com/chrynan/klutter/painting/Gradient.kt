package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.*
import kotlin.math.PI

class ColorsAndStops(
    val list: List<Color>,
    val stops: List<Double>
)

interface Gradient { // TODO is this the same as the expected class in UI?

    val colors: List<Color>

    val stops: List<Double>

    fun createShader(rect: Rect, textDirection: TextDirection = TextDirection.LTR): Shader

    fun scale(factor: Double): Gradient
}

class LinearGradient(
    val begin: AlignmentGeometry,
    val end: AlignmentGeometry,
    val tileMode: TileMode = TileMode.CLAMP,
    override val colors: List<Color>,
    override val stops: List<Double>
) : Gradient {

    override fun createShader(rect: Rect, textDirection: TextDirection): Shader {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun scale(factor: Double): Gradient {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class RadialGradient(
    val center: AlignmentGeometry,
    val radius: Double = 0.5,
    override val colors: List<Color>,
    override val stops: List<Double>,
    val tileMode: TileMode = TileMode.CLAMP,
    val focal: AlignmentGeometry,
    val focalRadius: Double = 0.0
) : Gradient {

    override fun createShader(rect: Rect, textDirection: TextDirection): Shader {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun scale(factor: Double): Gradient {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class SweepGradient(
    val center: AlignmentGeometry,
    val startAngle: Double = 0.0,
    val endAngle: Double = PI * 2,
    val tileMode: TileMode = TileMode.CLAMP,
    override val colors: List<Color>,
    override val stops: List<Double>
) : Gradient {

    override fun createShader(rect: Rect, textDirection: TextDirection): Shader {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun scale(factor: Double): Gradient {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}