package com.chrynan.klutter.foundation

class DiagnosticableNode<T : Diagnosticable>(
    name: String? = null,
    override val value: T,
    style: DiagnosticsTreeStyle
) : DiagnosticsNode(name = name, style = style) {

    private var cachedBuilder: DiagnosticPropertiesBuilder? = null

    private val builder: DiagnosticPropertiesBuilder
        get() {
            if (cachedBuilder == null) {
                cachedBuilder = DiagnosticPropertiesBuilder()
                value.debugFillProperties(cachedBuilder!!)
            }

            return cachedBuilder!!
        }

    override val emptyBodyDescription
        get() = builder.emptyBodyDescription

    override val properties
        get() = builder.properties

    override val children
        get() = emptyList<DiagnosticsNode>()
}