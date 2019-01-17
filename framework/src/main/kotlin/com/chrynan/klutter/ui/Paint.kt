package com.chrynan.klutter.ui

expect class Paint() {

    var blendMode: BlendMode

    var color: Color

    var colorFilter: ColorFilter

    var filterQuality: FilterQuality

    var invertColors: Boolean

    var isAntiAlias: Boolean

    var maskFilter: MaskFilter

    // TODO val shader: Shader

    var strokeCap: StrokeCap

    var strokeJoin: StrokeJoin

    var strokeMiterLimit: Double

    var strokeWidth: Double

    var style: PaintingStyle
}