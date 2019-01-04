package com.chrynan.klutter.ui

data class TextStyle(
    val color: Color,
    val decoration: TextDecoration,
    val decorationColor: Color,
    val decorationStyle: TextDecorationStyle,
    val fontWeight: FontWeight,
    val fontStyle: FontStyle,
    val textBaseline: TextBaseline,
    val fontFamily: String,
    val fontFamilyFallback: List<String> = emptyList(),
    val fontSize: Double,
    val letterSpacing: Double,
    val wordSpacing: Double,
    val height: Double,
    val locale: Locale,
    // TODO add Paint class for background val background: Paint,
    // TODO add Paint class for foreground val foreground: Paint
    val shadows: List<Shadow> = emptyList()
) {

    // TODO add encoded function and value
}