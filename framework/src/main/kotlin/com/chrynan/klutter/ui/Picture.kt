package com.chrynan.klutter.ui

expect class Picture {

    val approximateBytesUsed: Int

    fun toImage(width: Int, height: Int): Image

    fun dispose()
}