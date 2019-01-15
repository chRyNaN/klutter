package com.chrynan.klutter.gestures

abstract class HitTestDispatcher {

    abstract fun dispatchevent(event: PointerEvent, result: HitTestResult)
}