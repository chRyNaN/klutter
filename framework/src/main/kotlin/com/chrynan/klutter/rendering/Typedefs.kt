package com.chrynan.klutter.rendering

import com.chrynan.klutter.ui.Rect

typealias CaretChangedHandler = (rect: Rect) -> Unit

typealias ImageErrorListener = (exception: Exception) -> Unit