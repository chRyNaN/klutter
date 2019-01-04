package com.chrynan.klutter.ui

expect class Paint {

    val blendMode: BlendMode

    val color: Color

    val colorFilter: ColorFilter

    val filterQuality: FilterQuality

    val invertColors: Boolean

    val isAntiAlias: Boolean

    val maskFilter: MaskFilter

    // TODO val shader: Shader

    val strokeCap: StrokeCap

    val strokeJoin: StrokeJoin

    val strokeMiterLimit: Double

    val strokeWidth: Double

    val style: PaintingStyle
}