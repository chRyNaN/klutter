package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.Offset
import com.chrynan.klutter.ui.Path
import com.chrynan.klutter.ui.Radius
import com.chrynan.klutter.ui.Rect
import kotlin.math.sqrt

class CircularNotchedRectangle : NotchedShape {

    override fun getOuterPath(host: Rect, guest: Rect): Path {
        if (!host.overlaps(guest)) return Path().apply { addRect(host) }

        val notchedRadius = guest.width / 2.0

        val s1 = 15.0
        val s2 = 1.0

        val r = notchedRadius
        val a = -1.0 * r - s2
        val b = host.top - guest.center.dy

        val n2 = sqrt(b * b * r * r * (a * a + b * b - r * r))
        val p2xA = ((a * r * r) - n2) / (a * a + b * b)
        val p2xB = ((a * r * r) + n2) / (a * a + b * b)
        val p2yA = sqrt(r * r - p2xA * p2xA)
        val p2yB = sqrt(r * r - p2xB * p2xB)
        val cmp = if (b < 0) -1.0 else 1.0

        val o0 = Offset(dx = a - s1, dy = b)
        val o1 = Offset(dx = a, dy = b)
        val o2 = if (cmp * p2yA > cmp * p2yB) Offset(dx = p2xA, dy = p2yA) else Offset(dx = p2xB, dy = p2yB)

        var p = listOf(
            o0,
            o1,
            o2,
            Offset(dx = -1.0 * o2.dx, dy = o2.dy),
            Offset(dx = -1.0 * o1.dx, dy = o1.dy),
            Offset(dx = -1.0 * o0.dx, dy = o0.dy)
        )

        p = p.map {
            it + guest.center
        }

        return Path().apply {
            moveTo(host.left, host.top)
            lineTo(p[0].dx, p[0].dy)
            quadraticBezierTo(p[1].dx, p[1].dy, p[2].dx, p[2].dy)
            arcToPoint(p[3], Radius.circular(notchedRadius), 0.0, false, false)
            quadraticBezierTo(p[4].dx, p[4].dy, p[5].dx, p[5].dy)
            lineTo(host.right, host.top)
            lineTo(host.right, host.bottom)
            lineTo(host.left, host.bottom)
            close()
        }
    }
}