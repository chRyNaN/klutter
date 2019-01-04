package com.chrynan.klutter.ui

expect class Path {

    companion object {

        fun from(source: Path): Path

        fun combine(operation: PathOperation, path1: Path, path2: Path): Path
    }

    val fillType: PathFillType

    fun addArc(oval: Rect, startAngle: Double, sweepAngle: Double)

    fun addOval(rect: Rect)

    fun addPath(path: Path, offset: Offset, maxtrix4: List<Double> = emptyList())

    fun addPolygon(points: List<Offset>, close: Boolean)

    fun addRect(rect: Rect)

    fun addRRect(rRect: RRect)

    fun arcTo(rect: Rect, startAngle: Double, sweepAngle: Double, forceMoveTo: Boolean)

    fun arcToPoint(
        arcEnd: Offset,
        radius: Radius = Radius.ZERO,
        rotation: Double = 0.0,
        largeArc: Boolean = false,
        clockwise: Boolean = true
    )

    fun close()

    fun computeMetrics(forceClosed: Boolean = false)

    fun conicTo(x1: Double, y1: Double, x2: Double, y2: Double, w: Double)

    fun contains(point: Offset)

    fun cubicTo(x1: Double, y1: Double, x2: Double, y2: Double, x3: Double, y3: Double)

    fun extendWithPath(path: Path, offset: Offset, maxtrix4: List<Double> = emptyList())

    fun getBounds(): Rect

    fun lineTo(x: Double, y: Double)

    fun moveTo(x: Double, y: Double)

    fun quadraticBezierTo(x1: Double, y1: Double, x2: Double, y2: Double)

    fun relativeArcToPoint(
        arcEndDelta: Offset,
        radius: Radius = Radius.ZERO,
        rotation: Double = 0.0,
        largeArc: Boolean = false,
        clockwise: Boolean = true
    )

    fun relativeConicTo(x1: Double, y1: Double, x2: Double, y2: Double, w: Double)

    fun relativeCubicTo(x1: Double, y1: Double, x2: Double, y2: Double, x3: Double, y3: Double)

    fun relativeLineTo(dx: Double, dy: Double)

    fun relativeMoveTo(dx: Double, dy: Double)

    fun relativeQuadraticeBezierTo(x1: Double, y1: Double, x2: Double, y2: Double)

    fun reset()

    fun shift(offset: Offset): Path

    fun transform(matrix4: List<Double>): Path

    internal fun clone(): Path
}