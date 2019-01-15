package com.chrynan.klutter.rendering

import com.chrynan.klutter.ui.VoidCallback

class PipelineOwner(
    val onNeedVisualUpdate: VoidCallback? = null,
    val onSemanticsOwnerCreated: VoidCallback,
    val onSemanticsOwnerDisposed: VoidCallback
) {

    fun requestVisualUpdate() {
        onNeedVisualUpdate?.invoke()
    }
}