package com.chrynan.klutter.widgets

import com.chrynan.klutter.ui.Size

interface BuildContext {

    val widget: Widget

    val size: Size

    val owner: BuildOwner

    // TODO abstract fun findRenderObject(): RenderObject

    // TODO fun inheritFromELement(ancestor: InheritedElement, aspect: Any? = null): InheritedWidget

    // TODO fun inheritFromWidgetOfExactType(targetType: Type, aspect: Any? = null): InheritedWidget

    // TODO ancestorInheritedElementForWidgetOfExactType(targetType: Type): InheritedElement

    fun <T> ancestorWidgetOfexactType(): Widget

    // TODO abstract fun ancestorStateOfType(matcher: TypeMatcher): State

    // TODO abstract fun rootAncestorStateOfType(matcher: TypeMatcher): State

    // TODO abstract fun ancestorRenderObjectOfType(matcher: TypeMatcher): RenderObject

    // TODO abstract fun visitAncestorElements(visitor: Boolean, element: Element)

    // TODO abstract fun visitChildElements(visitor: ElementVisitor)
}