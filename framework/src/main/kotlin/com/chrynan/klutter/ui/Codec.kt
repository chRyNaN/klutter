package com.chrynan.klutter.ui

expect class Codec {

    val frameCount: Int

    val repetitionCount: Int

    fun getNextFrame(): FrameInfo // TODO this should probably be an asynchronous function returning a Deferred object

    fun dispose()
}