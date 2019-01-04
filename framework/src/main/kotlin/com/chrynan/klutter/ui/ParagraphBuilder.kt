package com.chrynan.klutter.ui

expect class ParagraphBuilder {

    val style: ParagraphStyle

    fun pushStyle(style: TextStyle)

    fun pop()

    fun addText(text: String)

    fun build(): Paragraph
}