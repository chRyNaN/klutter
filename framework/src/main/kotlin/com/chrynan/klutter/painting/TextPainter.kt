package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.Locale
import com.chrynan.klutter.ui.Paragraph
import com.chrynan.klutter.ui.TextAlign
import com.chrynan.klutter.ui.TextDirection

data class TextPainter(
    val text: TextSpan,
    val textAlign: TextAlign = TextAlign.START,
    val textDirection: TextDirection,
    val textScaleFactor: Double = 1.0,
    val maxLines: Int,
    val ellipsis: String,
    val locale: Locale
) {

    private var paragraph: Paragraph? = null
    private var needsLayout: Boolean = true

    // TODO
}