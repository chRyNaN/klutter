package com.chrynan.klutter.foundation

import com.chrynan.klutter.ui.VoidCallback

interface Listenable {

    fun addListener(listener: VoidCallback)

    fun removeListener(listener: VoidCallback)
}

interface ValueListenable<T> : Listenable {

    abstract val value: T
}

open class ChangeNotifier : Listenable {

    private val listeners = mutableListOf<() -> Unit>()

    val hasListeners: Boolean
        get() = listeners.isNotEmpty()

    override fun addListener(listener: () -> Unit) {
        listeners.add(listener)
    }

    override fun removeListener(listener: () -> Unit) {
        listeners.remove(listener)
    }

    fun dispose() {
        listeners.clear()
    }
}

class ValueNotifier<T>(override val value: T) : ChangeNotifier(),
    ValueListenable<T>