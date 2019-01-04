package com.chrynan.klutter.ui

data class TextDecoration(val mask: Int) {

    companion object {

        val NONE = TextDecoration(0x0)
        val UNDERLINE = TextDecoration(0x1)
        val OVERLINE = TextDecoration(0x2)
        val LINE_THROUGH = TextDecoration(0x4)

        fun combine(decorations: List<TextDecoration>): TextDecoration {
            var mask = 0
            for (decoration in decorations) {
                mask = mask or decoration.mask
            }

            return TextDecoration(mask)
        }
    }

    operator fun contains(other: TextDecoration) = (mask or other.mask) == mask
}