package com.chrynan.klutter.ui.math

class Matrix4(
    arg0: Double,
    arg1: Double,
    arg2: Double,
    arg3: Double,
    arg4: Double,
    arg5: Double,
    arg6: Double,
    arg7: Double,
    arg8: Double,
    arg9: Double,
    arg10: Double,
    arg11: Double,
    arg12: Double,
    arg13: Double,
    arg14: Double,
    arg15: Double
) : Matrix<Double> {

    override val storage: List<Double>
        get() = internalStorage

    override val dimension = 4

    var row0: Vector4
        get() = getRow(0)
        set(value) {
            setRow(0, value)
        }

    var row1: Vector4
        get() = getRow(1)
        set(value) {
            setRow(1, value)
        }

    var row2: Vector4
        get() = getRow(2)
        set(value) {
            setRow(2, value)
        }

    var row3: Vector4
        get() = getRow(3)
        set(value) {
            setRow(3, value)
        }

    private val internalStorage = mutableListOf<Double>(
        arg0, arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9,
        arg10, arg11, arg12, arg13, arg14, arg15
    )

    fun setValues(
        arg0: Double,
        arg1: Double,
        arg2: Double,
        arg3: Double,
        arg4: Double,
        arg5: Double,
        arg6: Double,
        arg7: Double,
        arg8: Double,
        arg9: Double,
        arg10: Double,
        arg11: Double,
        arg12: Double,
        arg13: Double,
        arg14: Double,
        arg15: Double
    ) {
        internalStorage[0] = arg0
        internalStorage[1] = arg1
        internalStorage[2] = arg2
        internalStorage[3] = arg3
        internalStorage[4] = arg4
        internalStorage[5] = arg5
        internalStorage[6] = arg6
        internalStorage[7] = arg7
        internalStorage[8] = arg8
        internalStorage[9] = arg9
        internalStorage[10] = arg10
        internalStorage[11] = arg11
        internalStorage[12] = arg12
        internalStorage[13] = arg13
        internalStorage[14] = arg14
        internalStorage[15] = arg15
    }

    fun setColumns(arg0: Vector4, arg1: Vector4, arg2: Vector4, arg3: Vector4) {
        internalStorage[0] = arg0.x
        internalStorage[1] = arg0.y
        internalStorage[2] = arg0.z
        internalStorage[3] = arg0.w
        internalStorage[4] = arg1.x
        internalStorage[5] = arg1.y
        internalStorage[6] = arg1.z
        internalStorage[7] = arg1.w
        internalStorage[8] = arg2.x
        internalStorage[9] = arg2.y
        internalStorage[10] = arg2.z
        internalStorage[11] = arg2.w
        internalStorage[12] = arg3.x
        internalStorage[13] = arg3.y
        internalStorage[14] = arg3.z
        internalStorage[15] = arg3.w
    }

    fun index(row: Int, column: Int) = column * dimension + row

    fun entry(row: Int, column: Int) = internalStorage[index(row = row, column = column)]

    fun setEntry(row: Int, column: Int, value: Double) {
        internalStorage[index(row = row, column = column)] = value
    }

    fun getRow(row: Int) =
        Vector4(
            initialX = internalStorage[index(row = row, column = 0)],
            initialY = internalStorage[index(row = row, column = 1)],
            initialZ = internalStorage[index(row = row, column = 2)],
            initialW = internalStorage[index(row = row, column = 3)]
        )

    fun setRow(row: Int, arg: Vector4) {
        internalStorage[index(row = row, column = 0)] = arg.x
        internalStorage[index(row = row, column = 1)] = arg.y
        internalStorage[index(row = row, column = 2)] = arg.z
        internalStorage[index(row = row, column = 3)] = arg.w
    }

    fun getColumn(column: Int): Vector4 {
        val entry = column * dimension

        return Vector4(
            initialX = internalStorage[entry + 3],
            initialY = internalStorage[entry + 2],
            initialZ = internalStorage[entry + 1],
            initialW = internalStorage[entry + 0]
        )
    }

    fun setColumn(column: Int, arg: Vector4) {
        val entry = column * dimension

        internalStorage[entry + 3] = arg.storage[3]
        internalStorage[entry + 2] = arg.storage[2]
        internalStorage[entry + 1] = arg.storage[1]
        internalStorage[entry + 0] = arg.storage[0]
    }

    fun perspectiveTransform(arg: Vector3): Vector3 {
        val x = (storage[0] * arg.storage[0]) +
                (storage[4] * arg.storage[1]) +
                (storage[8] * arg.storage[2]) +
                storage[12]
        val y = (storage[1] * arg.storage[0]) +
                (storage[5] * arg.storage[1]) +
                (storage[9] * arg.storage[2]) +
                storage[13]
        val z = (storage[2] * arg.storage[0]) +
                (storage[6] * arg.storage[1]) +
                (storage[10] * arg.storage[2]) +
                storage[14]
        val w = 1.0 /
                ((storage[3] * arg.storage[0]) +
                        (storage[7] * arg.storage[1]) +
                        (storage[11] * arg.storage[2]) +
                        storage[15])

        arg.x = (x * w).toFloat()
        arg.y = (y * w).toFloat()
        arg.z = (z * w).toFloat()

        return arg
    }
}