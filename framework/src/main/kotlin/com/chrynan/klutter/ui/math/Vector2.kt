package com.chrynan.klutter.ui.math

class Vector2(
    initialX: Float = 0.0f,
    initialY: Float = 0.0f
) : Vector<Float> {

    companion object {

        private const val INDEX_X = 0
        private const val INDEX_Y = 1
    }

    override val storage: Float32List
        get() = internalStorage

    private val internalStorage = mutableListOf(initialX, initialY)

    var x: Float
        get() = internalStorage[INDEX_X]
        set(value) {
            internalStorage[INDEX_X] = value
        }

    var y: Float
        get() = internalStorage[INDEX_Y]
        set(value) {
            internalStorage[INDEX_Y] = value
        }

    fun copy(x: Float = this.x, y: Float = this.y) = Vector2(initialX = x, initialY = y)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Vector2

        if (internalStorage != other.internalStorage) return false

        return true
    }

    override fun hashCode() = internalStorage.hashCode()

    override fun toString() = "[$x,$y]"
}