package com.chrynan.klutter.widgets

abstract class Element : BuildContext {

    abstract val depth: Int

    abstract val dirty: Boolean

    abstract val owner: BuildOwner

    // TODO abstract val renderObject: RenderObject

    // TODO
}