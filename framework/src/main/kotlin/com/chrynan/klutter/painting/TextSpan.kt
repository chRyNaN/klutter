package com.chrynan.klutter.painting

import com.chrynan.klutter.foundation.DiagnosticableTree
import com.chrynan.klutter.ui.TextStyle

class TextSpan(
    val style: TextStyle,
    val text: String,
    val children: List<TextSpan> = emptyList()
    // TODO val recognizer: GestureRecognizer
) : DiagnosticableTree {

    // TODO
}