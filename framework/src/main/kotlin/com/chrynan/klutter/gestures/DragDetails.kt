package com.chrynan.klutter.gestures

import com.chrynan.klutter.ui.Offset

typealias GestureDragDownCallback = (details: DragDetails.DragDownDetails) -> Unit

typealias GestureDragStartCallback = (details: DragDetails.DragStartDetails) -> Unit

typealias GestureDragUpdateCallback = (details: DragDetails.DragUpdateDetails) -> Unit

sealed class DragDetails {

    data class DragDownDetails(val globalPosition: Offset) : DragDetails()

    data class DragStartDetails(
        val sourceTimeStamp: Long,
        val globalPosition: Offset
    ) : DragDetails()

    data class DragUpdateDetails(
        val sourceTimeStamp: Long,
        val delta: Offset = Offset.ZERO,
        val primaryDelta: Offset,
        val globalPosition: Offset
    ) : DragDetails()

    data class DragEndDetails(
        // TODO val velocity: Velocity,
        val primaryVelocity: Double
    ) : DragDetails()
}