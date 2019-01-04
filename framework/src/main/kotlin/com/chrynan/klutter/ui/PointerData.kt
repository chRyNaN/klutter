package com.chrynan.klutter.ui

data class PointerData(
    val timestamp: Long, // TODO update this to a Duration type equivalent
    val change: PointerChange = PointerChange.CANCEL,
    val kind: PointerDeviceKind = PointerDeviceKind.TOUCH,
    val device: Int = 0,
    val physicalX: Double = 0.0,
    val physicalY: Double = 0.0,
    val buttons: Int = 0,
    val obscured: Boolean = false,
    val pressure: Double = 0.0,
    val pressureMin: Double = 0.0,
    val pressureMax: Double = 0.0,
    val distance: Double = 0.0,
    val distanceMax: Double = 0.0,
    val size: Double = 0.0,
    val radiusMajor: Double = 0.0,
    val radiusMinor: Double = 0.0,
    val radiusMin: Double = 0.0,
    val radiusMax: Double = 0.0,
    val orientation: Double = 0.0,
    val tilt: Double = 0.0,
    val platformData: Int = 0
)