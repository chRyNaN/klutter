package com.chrynan.klutter.services

import com.chrynan.klutter.ui.Offset

data class RawFloatingCursorPoint(
    val offset: Offset,
    val state: FloatingCursorDragState
)