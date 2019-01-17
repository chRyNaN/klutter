package com.chrynan.klutter.ui.math

class Vector3(
    initialX: Float = 0.0f,
    initialY: Float = 0.0f,
    initialZ: Float = 0.0f
) : Vector<Float> {

    companion object {

        private const val INDEX_X = 0
        private const val INDEX_Y = 1
        private const val INDEX_Z = 2
    }

    override val storage: Float32List
        get() = internalStorage

    private val internalStorage = mutableListOf(initialX, initialY, initialZ)

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

    var z: Float
        get() = internalStorage[INDEX_Z]
        set(value) {
            internalStorage[INDEX_Z] = value
        }

    fun copy(x: Float = this.x, y: Float = this.y, z: Float = this.z) =
        Vector3(initialX = x, initialY = y, initialZ = z)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Vector3

        if (internalStorage != other.internalStorage) return false

        return true
    }

    override fun hashCode() = internalStorage.hashCode()

    override fun toString() = "[$x,$y, $z]"
}