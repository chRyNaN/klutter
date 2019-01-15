package com.chrynan.klutter.widgets

import com.chrynan.klutter.ui.VoidCallback

abstract class State<T : StatefulWidget> { // TODO should extend Diagnosticable

    abstract val widget: T

    // TODO abstract val element: StatefulElement
    // TODO val context: BuildContext = element
    // TODO val mounted: Boolean = element != null

    abstract fun didUpdateWidget(oldWidget: T)

    fun reassemble() {}

    fun initState() {}

    fun setState(fn: VoidCallback) { // TODO should be VoidCallback Parameter
        // TODO mess
    }

    fun deactivate() {}

    fun dispose() {}

    // TODO fun build(context: BuildContext): Widget

    fun didChangeDependencies() {}

    // TODO fun debugFillProperties(properties: DiagnosticPropertiesBuilder){}
}