package com.chrynan.klutter.services

enum class TextInputType(
    val index: Int = 2,
    val value: String,
    val signed: Boolean = false,
    val decimal: Boolean = false
) {

    TEXT(index = 0, value = "text"),
    MULTI_LINE(index = 1, value = "multiline"),
    NUMBER(index = 2, value = "number"),
    PHONE(index = 3, value = "phone"),
    DATE_TIME(index = 4, value = "datetime"),
    EMAIL_ADDRESS(index = 5, value = "emailAddress"),
    URL(index = 6, value = "url")
}