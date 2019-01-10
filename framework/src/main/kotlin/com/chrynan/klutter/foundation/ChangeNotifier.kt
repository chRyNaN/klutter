package com.chrynan.klutter.foundation

interface Listenable {

    abstract fun addListener(listener: () -> Unit)

    abstract fun removeListener(listener: () -> Unit)
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