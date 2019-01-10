package com.chrynan.klutter.services

data class TextEditingValue(
    val text: String,
    val selection: TextSelection,
    val composing: TextRange
)