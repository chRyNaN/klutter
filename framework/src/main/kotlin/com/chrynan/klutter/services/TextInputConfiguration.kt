package com.chrynan.klutter.services

import com.chrynan.klutter.ui.TextAffinity

data class TextInputConfiguration(
    val inputType: TextInputType = TextInputType.TEXT,
    val obscureText: Boolean = false,
    val autocorrect: Boolean = true,
    val actionLabel: String,
    val inputAction: TextInputAction,
    val textCapitalization: TextCapitalization = TextCapitalization.NONE
    // TODO val keyboardAppearance: Brightness = Brightness.LIGHT
) {

    fun toTextAffinity(affinity: String): TextAffinity? =
        when (affinity) {
            "TextAffinity.downstream" -> TextAffinity.DOWN_STREAM
            "TextAffinity.upstream" -> TextAffinity.UP_STREAM
            else -> null
        }
}