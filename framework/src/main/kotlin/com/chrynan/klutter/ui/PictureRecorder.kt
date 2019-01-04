package com.chrynan.klutter.ui

expect class PictureRecorder {

    val isRecording: Boolean

    fun endRecording(): Picture
}