package com.chrynan.klutter.services

data class TextRange(
    val start: Int,
    val end: Int
) {

    companion object {

        val EMPTY = TextRange(start = -1, end = -1)
    }

    val isValid: Boolean
        get() = (start >= 0) and (end >= 0)

    val isCollapsed: Boolean
        get() = start == end

    val isNormalized: Boolean
        get() = end >= start

    fun textBefore(text: String) = text.substring(0, start)

    fun textAfter(text: String) = text.substring(end)

    fun textInside(text: String) = text.substring(start, end)
}