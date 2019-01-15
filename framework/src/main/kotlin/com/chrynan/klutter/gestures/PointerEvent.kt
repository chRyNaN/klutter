package com.chrynan.klutter.gestures

import com.chrynan.klutter.ui.Offset
import com.chrynan.klutter.ui.PointerDeviceKind

data class PointerEvent(
    val timeStamp: Long = 0L,
    val point: Int = 0,
    val kind: PointerDeviceKind = PointerDeviceKind.TOUCH,
    val device: Int = 0,
    val position: Offset = Offset.ZERO,
    val delta: Offset = Offset.ZERO,
    val buttons: Int = 0,
    val down: Boolean = false,
    val obscured: Boolean = false,
    val pressure: Double = 1.0,
    val pressureMin: Double = 1.0,
    val pressureMax: Double = 1.0,
    val distance: Double = 0.0,
    val distanceMax: Double = 0.0,
    val size: Double = 0.0,
    val radiusMajor: Double = 0.0,
    val radiusMinor: Double = 0.0,
    val radiusMin: Double = 0.0,
    val radiusMax: Double = 0.0,
    val orientation: Double = 0.0,
    val tilt: Double = 0.0,
    val platformData: Int = 0,
    val synthesized: Boolean = false
)