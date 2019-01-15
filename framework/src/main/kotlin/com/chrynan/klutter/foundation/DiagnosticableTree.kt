package com.chrynan.klutter.foundation

interface DiagnosticableTree : Diagnosticable {

    override fun toDiagnosticsNode(name: String?, style: DiagnosticsTreeStyle) =
        DiagnosticableTreeNode(
            name = name,
            value = this,
            style = style
        )
}