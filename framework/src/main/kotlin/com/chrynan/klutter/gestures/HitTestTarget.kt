package com.chrynan.klutter.gestures

abstract class HitTestTarget {

    abstract fun handleEvent(event: PointerEvent, entry: HitTestEntry)
}