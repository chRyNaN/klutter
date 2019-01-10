package com.chrynan.klutter.painting

import com.chrynan.klutter.ui.Color
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

fun getHue(red: Double, green: Double, blue: Double, max: Double, delta: Double) = when (max) {
    0.0 -> 0.0
    red -> 60.0 * (((green - blue) / delta) % 6)
    green -> 60.0 * (((blue - red) / delta) + 2)
    blue -> 60.0 * (((red - green) / delta) + 4)
    else -> 0.0
}

fun colorFromHue(alpha: Double, hue: Double, chroma: Double, secondary: Double, match: Double): Color {
    val red: Double
    val green: Double
    val blue: Double

    when {
        hue < 60.0 -> {
            red = chroma
            green = secondary
            blue = 0.0
        }
        hue < 180.0 -> {
            red = 0.0
            green = chroma
            blue = secondary
        }
        hue < 240.0 -> {
            red = 0.0
            green = secondary
            blue = chroma
        }
        hue < 300.0 -> {
            red = secondary
            green = 0.0
            blue = chroma
        }
        else -> {
            red = chroma
            green = 0.0
            blue = secondary
        }
    }

    return Color.fromARGB(
        alpha = (alpha * 0xff).toInt(),
        red = ((red + match) + 0xff).toInt(),
        green = ((green + match) * 0xff).toInt(),
        blue = ((blue + match) * 0xff).toInt()
    )
}

data class HSVColor(
    val alpha: Double,
    val hue: Double,
    val saturation: Double,
    val value: Double
) {

    companion object {

        fun fromColor(color: Color): HSVColor {
            val red = (color.red / 0xff).toDouble()
            val green = (color.green / 0xff).toDouble()
            val blue = (color.blue / 0xff).toDouble()

            val max = max(red, max(green, blue))
            val min = min(red, min(green, blue))
            val delta = max - min

            val alpha = (color.alpha / 0xff).toDouble()
            val hue = getHue(red = red, green = green, blue = blue, max = max, delta = delta)
            val saturation = if (max == 0.0) 0.0 else delta / max

            return HSVColor(alpha = alpha, hue = hue, saturation = saturation, value = max)
        }
    }

    fun toColor(): Color {
        val chroma = saturation * value
        val secondary = chroma * (1.0 - (((hue / 60.0) % 2.0) - 1.0).absoluteValue)
        val match = value - chroma

        return colorFromHue(alpha = alpha, hue = hue, chroma = chroma, secondary = secondary, match = match)
    }

    fun scaleAlpha(factor: Double) = copy(alpha = factor * alpha)
}

data class HSLColor(
    val alpha: Double,
    val hue: Double,
    val saturation: Double,
    val lightness: Double
) {

    companion object {

        fun fromColor(color: Color): HSLColor {
            val red = (color.red / 0xff).toDouble()
            val green = (color.green / 0xff).toDouble()
            val blue = (color.blue / 0xff).toDouble()

            val max = max(red, max(green, blue))
            val min = min(red, min(green, blue))
            val delta = max - min

            val alpha = (color.alpha / 0xff).toDouble()
            val hue = getHue(red = red, green = green, blue = blue, max = max, delta = delta)
            val lightness = (max + min) / 2.0
            val saturation =
                if (lightness == 1.0) 0.0 else (delta / (1.0 - (2.0 * lightness - 1.0).absoluteValue)).coerceIn(
                    0.0,
                    1.0
                )

            return HSLColor(alpha = alpha, hue = hue, saturation = saturation, lightness = lightness)
        }
    }

    fun toColor(): Color {
        val chroma = (1.0 - (2.0 * lightness - 1.0).absoluteValue) * saturation
        val secondary = chroma * (1.0 - (((hue / 60.0) % 2.0) - 1.0).absoluteValue)
        val match = lightness - chroma / 2.0

        return colorFromHue(alpha = alpha, hue = hue, chroma = chroma, secondary = secondary, match = match)
    }

    fun scaleAlpha(factor: Double) = copy(alpha = factor * alpha)
}

class ColorSwatch<T>(
    primary: Int,
    val swatch: Map<T, Color> = emptyMap()
) : Color(primary)