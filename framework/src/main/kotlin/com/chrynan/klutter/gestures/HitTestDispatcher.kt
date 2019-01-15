package com.chrynan.klutter.gestures

interface HitTestDispatcher {

    fun dispatchevent(event: PointerEvent, result: HitTestResult)
}