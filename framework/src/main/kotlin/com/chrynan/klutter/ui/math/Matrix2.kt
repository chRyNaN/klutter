package com.chrynan.klutter.ui.math

class Matrix2(
    initialRowOneColumnOne: Float = 0.0f,
    initialRowOneColumnTwo: Float = 0.0f,
    initialRowTwoColumnOne: Float = 0.0f,
    initialRowTwoColumnTwo: Float = 0.0f
) : Matrix<Float> {

    companion object {

        private const val INDEX_ROW_ONE_COLUMN_ONE = 0
        private const val INDEX_ROW_ONE_COLUMN_TWO = 1
        private const val INDEX_ROW_TWO_COLUMN_ONE = 2
        private const val INDEX_ROW_TWO_COLUMN_TWO = 3
    }

    override val storage: Float32List
        get() = internalStorage

    override val dimension = 2

    val row0: Vector2
        get() = getRow(0)

    val row1: Vector2
        get() = getRow(1)

    val column0: Vector2
        get() = getColumn(0)

    val column1: Vector2
        get() = getColumn(1)

    private val internalStorage =
        mutableListOf(initialRowOneColumnOne, initialRowOneColumnTwo, initialRowTwoColumnOne, initialRowTwoColumnTwo)

    var rowOneColumnOne: Float
        get() = internalStorage[INDEX_ROW_ONE_COLUMN_ONE]
        set(value) {
            internalStorage[INDEX_ROW_ONE_COLUMN_ONE] = value
        }

    var rowOneColumnTwo: Float
        get() = internalStorage[INDEX_ROW_ONE_COLUMN_TWO]
        set(value) {
            internalStorage[INDEX_ROW_ONE_COLUMN_TWO]
        }

    var rowTwoColumnOne: Float
        get() = internalStorage[INDEX_ROW_TWO_COLUMN_ONE]
        set(value) {
            internalStorage[INDEX_ROW_ONE_COLUMN_TWO] = value
        }

    var rowTwoColumnTwo: Float
        get() = internalStorage[INDEX_ROW_TWO_COLUMN_TWO]
        set(value) {
            internalStorage[INDEX_ROW_TWO_COLUMN_TWO] = value
        }

    fun index(row: Int, column: Int) = (row * dimension) + column

    fun entry(row: Int, column: Int) = internalStorage[index(row = row, column = column)]

    fun setEntry(row: Int, column: Int, value: Float) {
        internalStorage[index(row = row, column = column)] = value
    }

    fun setColumns(column0: Vector2, column1: Vector2) {
        internalStorage[INDEX_ROW_ONE_COLUMN_ONE] = column0.x
        internalStorage[INDEX_ROW_ONE_COLUMN_TWO] = column1.x
        internalStorage[INDEX_ROW_TWO_COLUMN_ONE] = column0.y
        internalStorage[INDEX_ROW_TWO_COLUMN_TWO] = column1.y
    }

    fun setRows(row0: Vector2, row1: Vector2) {
        internalStorage[INDEX_ROW_ONE_COLUMN_ONE] = row0.x
        internalStorage[INDEX_ROW_ONE_COLUMN_TWO] = row0.y
        internalStorage[INDEX_ROW_TWO_COLUMN_ONE] = row1.x
        internalStorage[INDEX_ROW_TWO_COLUMN_TWO] = row1.y
    }

    fun getRow(row: Int) =
        Vector2(
            initialX = internalStorage[index(row, 0)],
            initialY = internalStorage[index(row, 1)]
        )

    fun getColumn(column: Int) =
        Vector2(
            initialX = internalStorage[index(0, column)],
            initialY = internalStorage[index(1, column)]
        )

    fun copy(
        rowOneColumnOne: Float = this.rowOneColumnOne, rowOneColumnTwo: Float = this.rowOneColumnTwo,
        rowTwoColumnOne: Float = this.rowTwoColumnOne, rowTwoColumnTwo: Float = this.rowTwoColumnTwo
    ) =
        Matrix2(
            initialRowOneColumnOne = rowOneColumnOne,
            initialRowOneColumnTwo = rowOneColumnTwo,
            initialRowTwoColumnOne = rowTwoColumnOne,
            initialRowTwoColumnTwo = rowTwoColumnTwo
        )

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || this::class != other::class) return false

        other as Matrix2

        if (internalStorage != other.internalStorage) return false

        return true
    }

    override fun hashCode() = internalStorage.hashCode()

    override fun toString() = "[0] ${getRow(0)}\n [1] ${getRow(1)}\n"
}