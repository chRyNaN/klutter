package com.chrynan.klutter.rendering

import com.chrynan.klutter.ui.Offset
import com.chrynan.klutter.ui.Rect

data class OverflowRegionData(
    val rect: Rect,
    val label: String = "",
    val labelOffset: Offset = Offset.ZERO,
    val rotation: Double = 0.0,
    val side: OverflowSide
)