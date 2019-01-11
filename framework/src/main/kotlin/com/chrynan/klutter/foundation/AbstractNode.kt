package com.chrynan.klutter.foundation

abstract class AbstractNode {

    var depth = 0

    var parent: AbstractNode? = null
        private set

    var owner: Any? = null
        private set

    val attached: Boolean
        get() = owner != null

    fun redepthChild(child: AbstractNode) {
        if (child.depth <= depth) {
            child.depth = depth + 1
            child.redepthChildren()
        }
    }

    fun attach(owner: Any) {
        this.owner = owner
    }

    fun detach() {
        owner = null
    }

    fun adoptChild(child: AbstractNode) {
        child.parent = this
        owner?.let(child::attach)
        redepthChild(child)
    }

    fun dropChild(child: AbstractNode) {
        child.parent = null
        if (attached) child.detach()
    }

    open fun redepthChildren() {}
}