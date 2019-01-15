package com.chrynan.klutter.gestures

interface HitTestTarget {

    fun handleEvent(event: PointerEvent, entry: HitTestEntry)
}