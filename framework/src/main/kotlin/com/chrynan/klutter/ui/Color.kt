@file:Suppress("unused")

package com.chrynan.klutter.ui

open class Color(val value: Int) {

    companion object {

        fun fromARGB(alpha: Int, red: Int, green: Int, blue: Int) =
            Color(
                value = alpha and 0xff shl 24 or
                        (red and 0xff shl 16) or
                        (green and 0xff shl 8) or
                        (blue and 0xff shl 0) and -0x1
            )

        fun fromRGBO(red: Int, green: Int, blue: Int, opacity: Double) =
            Color(
                value = ((((opacity * 0xff / 1).toInt() and 0xff) shl 24) or
                        ((red and 0xff) shl 16) or
                        ((green and 0xff) shl 8) or
                        ((blue and 0xff) shl 0)) and -0x1
            )
    }

    val alpha: Int
        get() = value shr 24 and 255

    val opacity: Double
        get() = alpha.toDouble() / 0xFF

    val red: Int
        get() = value shr 16 and 255

    val green: Int
        get() = value shr 8 and 255

    val blue: Int
        get() = value and 255

    fun withAlpha(a: Int) =
        fromARGB(alpha = a, red = red, green = green, blue = blue)

    fun withOpacity(opacity: Double) = withAlpha((255.0 * opacity).toInt())

    fun withRed(r: Int) =
        fromARGB(alpha = alpha, red = r, green = green, blue = blue)

    fun withGreen(g: Int) =
        fromARGB(alpha = alpha, red = red, green = g, blue = blue)

    fun withBlue(b: Int) =
        fromARGB(alpha = alpha, red = red, green = green, blue = b)
}