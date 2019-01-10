package com.chrynan.klutter.services

import com.chrynan.klutter.ui.TextPosition

abstract class TextSelectionDelegate {

    abstract var textEditingValue: TextEditingValue

    abstract fun hideToolbar()

    abstract fun bringIntoView(position: TextPosition)
}