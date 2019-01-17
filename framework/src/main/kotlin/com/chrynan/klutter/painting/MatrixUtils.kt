package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.Offset
import com.chrynan.klutter.ui.Rect
import com.chrynan.klutter.ui.math.Matrix4
import com.chrynan.klutter.ui.math.Vector3
import kotlin.math.max
import kotlin.math.min

fun Matrix4.getAsTranslation(): Offset? {

    if ((storage[0] == 1.0) and
        (storage[1] == 0.0) and
        (storage[2] == 0.0) and
        (storage[3] == 0.0) and
        (storage[4] == 0.0) and
        (storage[5] == 1.0) and
        (storage[6] == 0.0) and
        (storage[7] == 0.0) and
        (storage[8] == 0.0) and
        (storage[9] == 0.0) and
        (storage[10] == 1.0) and
        (storage[11] == 0.0) and
        (storage[14] == 0.0) and
        (storage[15] == 1.0)
    ) return Offset(dx = storage[12], dy = storage[13])

    return null
}

fun Matrix4.getAsScale(): Double? {
    if ((storage[1] == 0.0) and
        (storage[2] == 0.0) and
        (storage[3] == 0.0) and
        (storage[4] == 0.0) and
        (storage[6] == 0.0) and
        (storage[7] == 0.0) and
        (storage[8] == 0.0) and
        (storage[9] == 0.0) and
        (storage[10] == 1.0) and
        (storage[11] == 0.0) and
        (storage[12] == 0.0) and
        (storage[13] == 0.0) and
        (storage[14] == 0.0) and
        (storage[15] == 1.0) and
        (storage[0] == storage[5])
    ) return storage[0]

    return null
}

fun Matrix4.isIdentity() =
    (storage[0] == 1.0) and
            (storage[1] == 0.0) and
            (storage[2] == 0.0) and
            (storage[3] == 0.0) and
            (storage[4] == 0.0) and
            (storage[5] == 1.0) and
            (storage[6] == 0.0) and
            (storage[7] == 0.0) and
            (storage[8] == 0.0) and
            (storage[9] == 0.0) and
            (storage[10] == 1.0) and
            (storage[11] == 0.0) and
            (storage[12] == 0.0) and
            (storage[13] == 0.0) and
            (storage[14] == 0.0) and
            (storage[15] == 1.0)

fun Matrix4.transformPoint(point: Offset): Offset {
    val position3 = Vector3(initialX = point.dx.toFloat(), initialY = point.dy.toFloat(), initialZ = 0.0f)
    val transformed3 = perspectiveTransform(position3)
    return Offset(dx = transformed3.x.toDouble(), dy = transformed3.y.toDouble())
}

fun Matrix4.transformRect(rect: Rect): Rect {
    val point1 = transformPoint(rect.topLeft)
    val point2 = transformPoint(rect.topRight)
    val point3 = transformPoint(rect.bottomLeft)
    val point4 = transformPoint(rect.bottomRight)
    return Rect(
        left = min4(point1.dx, point2.dx, point3.dx, point4.dx),
        top = min4(point1.dy, point2.dy, point3.dy, point4.dy),
        right = max4(point1.dx, point2.dx, point3.dx, point4.dx),
        bottom = max4(point1.dy, point2.dy, point3.dy, point4.dy)
    )
}

private fun min4(a: Double, b: Double, c: Double, d: Double) = min(a, min(b, min(c, d)))

private fun max4(a: Double, b: Double, c: Double, d: Double) = max(a, max(b, max(c, d)))