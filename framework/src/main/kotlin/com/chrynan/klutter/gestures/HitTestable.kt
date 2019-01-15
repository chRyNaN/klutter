package com.chrynan.klutter.gestures

import com.chrynan.klutter.ui.Offset

abstract class HitTestable {

    abstract fun hitTest(result: HitTestResult, position: Offset)
}