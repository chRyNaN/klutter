package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.Path
import com.chrynan.klutter.ui.Rect

interface NotchedShape {

    fun getOuterPath(host: Rect, guest: Rect): Path
}