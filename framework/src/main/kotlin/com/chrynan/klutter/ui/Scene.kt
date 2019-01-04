package com.chrynan.klutter.ui

expect class Scene {

    fun toImage(width: Int, height: Int): Image // TODO this should be updated to be asynchronous and return a Deferred

    fun dispose()
}