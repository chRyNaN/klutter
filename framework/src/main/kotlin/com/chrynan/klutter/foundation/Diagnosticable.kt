package com.chrynan.klutter.foundation

abstract class Diagnosticable {

    fun toDiagnosticsNode(
        name: String? = null,
        style: DiagnosticsTreeStyle = DiagnosticsTreeStyle.SINGLE_LINE
    ): DiagnosticsNode =
        DiagnosticableNode(
            name = name,
            value = this,
            style = style
        )

    fun debugFillProperties(properties: DiagnosticPropertiesBuilder) = Unit
}