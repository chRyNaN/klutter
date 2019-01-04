package com.chrynan.klutter.ui

expect class Paragraph {

    val width: Double
    val height: Double
    val minIntrinsicWidth: Double
    val maxIntrinsicWidth: Double
    val alphabeticBaseline: Double
    val ideographicBaseline: Double
    val didExceedMaxLines: Boolean

    fun layout(constraints: ParagraphConstraints)

    fun getBoxesForRange(
        start: Int,
        end: Int,
        boxHeightStyle: BoxHeightStyle = BoxHeightStyle.TIGHT,
        boxWidthStyle: BoxWidthStyle = BoxWidthStyle.TIGHT
    ): List<TextBox>

    fun getPositionForOffset(offset: Offset): TextPosition

    fun getWordBoundary(offset: Offset): List<Int>
}