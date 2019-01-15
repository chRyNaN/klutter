package com.chrynan.klutter.foundation

class DiagnosticableTreeNode(
    name: String? = null,
    value: DiagnosticableTree,
    style: DiagnosticsTreeStyle = DiagnosticsTreeStyle.SINGLE_LINE
) : DiagnosticableNode<DiagnosticableTree>(name = name, value = value, style = style)