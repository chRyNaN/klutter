package com.chrynan.klutter.ui

expect class Canvas(cullRect: Rect) { // TODO add PictureRecorder parameter when the class is created

    fun clipPath(path: Path, doAntiAlias: Boolean = true)

    fun clipRect(rect: Rect, clipOp: ClipOp = ClipOp.INTERSECT, doAntiAlias: Boolean = true)

    fun clipRRect(rRect: RRect, doAntiAlias: Boolean = true)

    fun drawArc(rect: Rect, startAngle: Double, sweepAngle: Double, useCenter: Boolean, paint: Paint)

    fun drawAtlas(
        atlas: Image,
        transforms: List<RSTransform>,
        rects: List<Rect>,
        colors: List<Color>,
        blendMode: BlendMode,
        cullRect: Rect,
        paint: Paint
    )

    fun drawCircle(c: Offset, radius: Double, paint: Paint)

    fun drawColor(color: Color, blendMode: BlendMode)

    fun drawDRRect(outer: RRect, inner: RRect, paint: Paint)

    fun drawImage(image: Image, p: Offset, paint: Paint)

    fun drawImageNine(image: Image, src: Rect, dst: Rect, paint: Paint)

    fun drawImageRect(image: Image, src: Rect, dst: Rect, paint: Paint)

    fun drawLine(p1: Offset, p2: Offset, paint: Paint)

    fun drawOval(rect: Rect, paint: Paint)

    fun drawPaint(paint: Paint)

    fun drawParagraph(paragraph: Paragraph, offset: Offset)

    fun drawPath(path: Path, paint: Paint)

    fun drawPicture(picture: Picture)

    fun drawPoints(pointMode: PointMode, points: List<Offset>, paint: Paint)

    fun drawRawAtlas(
        atlas: Image,
        rstTransforms: List<Double>,
        rects: List<Double>,
        colors: List<Int>,
        blendMode: BlendMode,
        cullRect: Rect,
        paint: Paint
    )

    fun drawRawPoints(pointMode: PointMode, points: List<Double>, paint: Paint)

    fun drawRect(rect: Rect, paint: Paint)

    fun drawRRect(rRect: RRect, paint: Paint)

    fun drawShadow(path: Path, color: Color, elevation: Double, transparentOccluder: Boolean)

    fun drawVertices(vertices: Vertices, blendMode: BlendMode, paint: Paint)

    fun getSaveCount(): Int

    fun restore()

    fun rotate(radians: Double)

    fun save()

    fun saveLayer(bounds: Rect, paint: Paint)

    fun scale(sx: Double, sy: Double)

    fun skew(sx: Double, sy: Double)

    fun transform(matrix4: List<Double>)

    fun translate(dx: Double, dy: Double)
}