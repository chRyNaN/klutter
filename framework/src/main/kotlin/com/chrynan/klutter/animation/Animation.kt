package com.chrynan.klutter.animation

abstract class Animation<T> {

    abstract val status: AnimationStatus

    val isDismissed: Boolean
        get() = status == AnimationStatus.DISMISSED

    val isCompleted: Boolean
        get() = status == AnimationStatus.COMPLETED

    abstract fun addStatusListener(listener: AnimationStatusListener)

    abstract fun removeStatusListener(listener: AnimationStatusListener)

    abstract fun <U> drive(child: Animatable<U>): Animation<U>
}