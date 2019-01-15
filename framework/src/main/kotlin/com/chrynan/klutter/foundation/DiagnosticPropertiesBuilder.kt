package com.chrynan.klutter.foundation

class DiagnosticPropertiesBuilder {

    val properties: List<DiagnosticsNode>
        get() = mutableProperties

    private val mutableProperties = mutableListOf<DiagnosticsNode>()

    var defaultDiagnosticsTreeStyle: DiagnosticsTreeStyle = DiagnosticsTreeStyle.SPARSE

    var emptyBodyDescription: String? = null

    fun add(property: DiagnosticsNode) {
        mutableProperties.add(property)
    }
}