package com.chrynan.klutter.animation

abstract class Animatable<T> {

    abstract fun transform(t: Double): T

    // fun evaluate(animation: Animation<Double>) = transform(animation.value)

    // fun animate(parent: Animation<Double>): Animation<T>

    // fun chain(parent: Animatable<Double>): Animatable<T>
}