package com.chrynan.klutter.ui.math

class Vector4(
    initialX: Double = 0.0,
    initialY: Double = 0.0,
    initialZ: Double = 0.0,
    initialW: Double = 0.0
) : Vector<Double> {

    companion object {

        private const val INDEX_X = 0
        private const val INDEX_Y = 1
        private const val INDEX_Z = 2
        private const val INDEX_W = 3
    }

    override val storage: Float64List
        get() = internalStorage

    private val internalStorage = mutableListOf(initialX, initialY, initialZ, initialW)

    var x: Double
        get() = internalStorage[INDEX_X]
        set(value) {
            internalStorage[INDEX_X] = value
        }

    var y: Double
        get() = internalStorage[INDEX_Y]
        set(value) {
            internalStorage[INDEX_Y] = value
        }

    var z: Double
        get() = internalStorage[INDEX_Z]
        set(value) {
            internalStorage[INDEX_Z] = value
        }

    var w: Double
        get() = internalStorage[INDEX_W]
        set(value) {
            internalStorage[INDEX_W] = value
        }

    fun copy(x: Double = this.x, y: Double = this.y, z: Double = this.z, w: Double = this.w) =
        Vector4(initialX = x, initialY = y, initialZ = z, initialW = w)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Vector4

        if (internalStorage != other.internalStorage) return false

        return true
    }

    override fun hashCode() = internalStorage.hashCode()

    override fun toString() = "[$x,$y, $z, $w]"
}