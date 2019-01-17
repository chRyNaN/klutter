package com.chrynan.klutter.ui.math

class Matrix3(
    initialArg0: Float = 0.0f,
    initialArg1: Float = 0.0f,
    initialArg2: Float = 0.0f,
    initialArg3: Float = 0.0f,
    initialArg4: Float = 0.0f,
    initialArg5: Float = 0.0f,
    initialArg6: Float = 0.0f,
    initialArg7: Float = 0.0f,
    initialArg8: Float = 0.0f
) : Matrix<Float> {

    override val storage: List<Float>
        get() = internalStorage

    override val dimension = 3

    var rowZero: Vector3
        get() = getRow(0)
        set(value) {
            setRow(0, value)
        }

    var rowOne: Vector3
        get() = getRow(1)
        set(value) {
            setRow(1, value)
        }

    var rowTwo: Vector3
        get() = getRow(2)
        set(value) {
            setRow(2, value)
        }

    private val internalStorage = mutableListOf(
        initialArg0, initialArg1, initialArg2, initialArg3, initialArg4,
        initialArg5, initialArg6, initialArg7, initialArg8
    )

    fun index(row: Int, column: Int) = (column * dimension) + row

    fun entry(row: Int, column: Int) = internalStorage[index(row = row, column = column)]

    fun setEntry(row: Int, column: Int, value: Float) {
        internalStorage[index(row = row, column = column)] = value
    }

    fun setValues(
        arg0: Float, arg1: Float, arg2: Float, arg3: Float, arg4: Float, arg5: Float, arg6: Float,
        arg7: Float, arg8: Float
    ) {
        internalStorage[8] = arg8
        internalStorage[7] = arg7
        internalStorage[6] = arg6
        internalStorage[5] = arg5
        internalStorage[4] = arg4
        internalStorage[3] = arg3
        internalStorage[2] = arg2
        internalStorage[1] = arg1
        internalStorage[0] = arg0
    }

    fun setColumns(arg0: Vector3, arg1: Vector3, arg2: Vector3) {
        internalStorage[0] = arg0.storage[0]
        internalStorage[1] = arg0.storage[1]
        internalStorage[2] = arg0.storage[2]
        internalStorage[3] = arg1.storage[0]
        internalStorage[4] = arg1.storage[1]
        internalStorage[5] = arg1.storage[2]
        internalStorage[6] = arg2.storage[0]
        internalStorage[7] = arg2.storage[1]
        internalStorage[8] = arg2.storage[2]
    }

    fun getRow(row: Int) =
        Vector3(
            initialX = internalStorage[index(row = row, column = 0)],
            initialY = internalStorage[index(row = row, column = 1)],
            initialZ = internalStorage[index(row = row, column = 2)]
        )

    fun setRow(row: Int, arg: Vector3) {
        internalStorage[index(row = row, column = 0)] = arg.x
        internalStorage[index(row = row, column = 1)] = arg.y
        internalStorage[index(row = row, column = 2)] = arg.z
    }

    fun getColumn(column: Int): Vector3 {
        val entry = column * dimension

        return Vector3(
            initialX = internalStorage[entry + 2],
            initialY = internalStorage[entry + 1],
            initialZ = internalStorage[entry + 0]
        )
    }

    fun setColumn(column: Int, arg: Vector3) {
        val entry = column * dimension

        internalStorage[entry + 2] = arg.storage[2]
        internalStorage[entry + 1] = arg.storage[1]
        internalStorage[entry + 0] = arg.storage[0]
    }
}