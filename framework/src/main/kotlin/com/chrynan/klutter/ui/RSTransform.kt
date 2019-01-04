package com.chrynan.klutter.ui

import kotlin.math.cos
import kotlin.math.sin

data class RSTransform(
    val scos: Double,
    val ssin: Double,
    val tx: Double,
    val ty: Double
) {

    companion object {

        fun fromComponents(
            rotation: Double,
            scale: Double,
            anchorX: Double,
            anchorY: Double,
            translateX: Double,
            translateY: Double
        ): RSTransform {
            val scos = cos(rotation) * scale
            val ssin = sin(rotation) * scale
            val tx = translateX + -scos * anchorX + ssin * anchorY
            val ty = translateY + -ssin * anchorX - scos * anchorY

            return RSTransform(scos = scos, ssin = ssin, tx = tx, ty = ty)
        }
    }
}