package com.chrynan.klutter.ui

data class FontWeight(val weight: Int) {

    companion object {

        val W_100 = FontWeight(100)
        val W_200 = FontWeight(200)
        val W_300 = FontWeight(300)
        val W_400 = FontWeight(400)
        val W_500 = FontWeight(500)
        val W_600 = FontWeight(600)
        val W_700 = FontWeight(700)
        val W_800 = FontWeight(800)
        val W_900 = FontWeight(900)
        val NORMAL = W_400
        val BOLD = W_700
        val VALUES = listOf(W_100, W_200, W_300, W_400, W_500, W_600, W_700, W_800, W_900)

        fun fromIndex(index: Int): FontWeight? = VALUES.getOrNull(index)
    }

    val index: Int
        get() = VALUES.indexOfFirst { it.weight == weight }
}