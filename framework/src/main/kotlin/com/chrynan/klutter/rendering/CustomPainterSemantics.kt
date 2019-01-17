package com.chrynan.klutter.rendering

import com.chrynan.klutter.foundation.Key
import com.chrynan.klutter.ui.Rect

data class CustomPainterSemantics(
    val key: Key,
    val rect: Rect,
    val transform: List<Double> // TODO this should be a Matrix4 object
    // TODO val tags: Set<SemanticsTag>,
    // TODO val properties: SemanticsProperties
)