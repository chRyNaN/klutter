package com.chrynan.klutter.foundation

abstract class DiagnosticsNode(
    val name: String? = null,
    val showSeparator: Boolean = true,
    val showName: Boolean = true,
    val style: DiagnosticsTreeStyle = DiagnosticsTreeStyle.SINGLE_LINE
) {

    abstract val value: Any

    abstract val emptyBodyDescription: String?

    abstract val properties: List<DiagnosticsNode>

    abstract val children: List<DiagnosticsNode>

    val separator: String
        get() = if (showSeparator) ":" else ""
}