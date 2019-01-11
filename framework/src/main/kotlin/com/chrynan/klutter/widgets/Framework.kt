package com.chrynan.klutter.widgets

import com.chrynan.klutter.foundation.Key

abstract class Widget { // TODO should extend DiagnosticableTree

    abstract val key: Key

    // TODO abstract fun createElement(): Element
}

abstract class StatelessWidget : Widget() {

    // TODO abstract fun build(context: BuildContext): Widget
}

abstract class StatefulWidget : Widget() {

    // TODO abstract fun createState(): State
}

enum class StateLifecycle {

    CREATED,
    INITIALIZED,
    READY,
    DEFUNCT
}

// TODO typealias StateSetter = (fn: VoidCallback) -> Unit

abstract class State<T : StatefulWidget> { // TODO should extend Diagnosticable

    abstract val widget: T

    // TODO abstract val element: StatefulElement
    // TODO val context: BuildContext = element
    // TODO val mounted: Boolean = element != null

    abstract fun didUpdateWidget(oldWidget: T)

    fun reassemble() {}

    fun initState() {}

    fun setState(fn: () -> Unit) { // TODO should be VoidCallback Parameter
        // TODO mess
    }

    fun deactivate() {}

    fun dispose() {}

    // TODO fun build(context: BuildContext): Widget

    fun didChangeDependencies() {}

    // TODO fun debugFillProperties(properties: DiagnosticPropertiesBuilder){}
}

abstract class ProxyWidget : Widget() {

    abstract val child: Widget
}

enum class ElementLifecycle {

    INITIAL,
    ACTIVE,
    INACTIVE,
    DEFUNCT
}