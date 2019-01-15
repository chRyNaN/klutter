package com.chrynan.klutter.rendering

import com.chrynan.klutter.foundation.AbstractNode
import com.chrynan.klutter.foundation.DiagnosticableTree
import com.chrynan.klutter.gestures.HitTestTarget

typealias RenderObjectVisitor = (child: RenderObject) -> Unit

abstract class RenderObject : AbstractNode(),
    DiagnosticableTree,
    HitTestTarget {

    private var parentData: ParentData? = null

    fun setupParentData(child: RenderObject) {
        if (child.parentData != null) {
            child.parentData = ParentData()
        }
    }

    fun adoptChild(child: RenderObject) {
        setupParentData(child)
        super.adoptChild(child)
    }

    fun dropChild(child: RenderObject) {
        child.parentData?.detach()
        child.parentData = null
        super.dropChild(child)
    }

    fun attach(owner: PipelineOwner) {
        super.attach(owner)


    }

    abstract fun visitChildren(visitor: RenderObjectVisitor)
}