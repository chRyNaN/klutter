package com.chrynan.klutter.services

import com.chrynan.klutter.ui.TextAffinity
import com.chrynan.klutter.ui.TextPosition

class TextSelection(
    val baseOffset: Int,
    val extentOffset: Int,
    val affinity: TextAffinity = TextAffinity.DOWN_STREAM,
    val isDirectional: Boolean = false
) {

    companion object {

        fun collapsed(offset: Int, affinity: TextAffinity) =
            TextSelection(baseOffset = offset, extentOffset = offset, isDirectional = false)

        fun fromPosition(position: TextPosition) = TextSelection(
            baseOffset = position.offset,
            extentOffset = position.offset,
            affinity = position.textAffinity,
            isDirectional = false
        )
    }

    val base: TextPosition
        get() = TextPosition(offset = extentOffset, textAffinity = affinity)
}