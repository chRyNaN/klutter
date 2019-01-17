package com.chrynan.klutter.rendering

import com.chrynan.klutter.ui.Offset
import com.chrynan.klutter.ui.TextDirection

data class TextSelectionPoint(
    val point: Offset,
    val direction: TextDirection
)