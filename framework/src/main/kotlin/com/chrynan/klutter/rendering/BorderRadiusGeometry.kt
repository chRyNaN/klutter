package com.chrynan.klutter.rendering

import com.chrynan.klutter.ui.Radius
import com.chrynan.klutter.ui.TextDirection

abstract class BorderRadiusGeometry {

    abstract val topLeft: Radius
    abstract val topRight: Radius
    abstract val bottomLeft: Radius
    abstract val bottomRight: Radius
    abstract val topStart: Radius
    abstract val topEnd: Radius
    abstract val bottomStart: Radius
    abstract val bottomEnd: Radius

    abstract fun resolve(direction: TextDirection): BorderRadius
}