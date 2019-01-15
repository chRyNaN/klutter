package com.chrynan.klutter.gestures

import com.chrynan.klutter.ui.Offset

interface HitTestable {

    fun hitTest(result: HitTestResult, position: Offset)
}