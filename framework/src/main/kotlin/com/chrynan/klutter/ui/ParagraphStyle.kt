package com.chrynan.klutter.ui

data class ParagraphStyle(
    val textStyle: TextStyle,
    val textDirection: TextDirection,
    val fontWeight: FontWeight,
    val fontStyle: FontStyle,
    val maxLines: Int,
    val fontFamily: String,
    val fontSize: Double,
    val lineHeight: Double,
    val ellipses: String
    // TODO add Locale class and property here
)