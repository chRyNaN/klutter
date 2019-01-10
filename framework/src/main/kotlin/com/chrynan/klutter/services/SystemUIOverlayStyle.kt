package com.chrynan.klutter.services

import com.chrynan.klutter.ui.Color

data class SystemUIOverlayStyle(
    val systemNavigationBarColor: Color,
    val systemNavigationBarDividerColor: Color? = null,
    val systemNavigationBarIconBrightness: Brightness,
    val statusBarColor: Color? = null,
    val statusBarBrightness: Brightness,
    val statusBarIconBrightness: Brightness
) {

    companion object {

        val LIGHT = SystemUIOverlayStyle(
            systemNavigationBarColor = Color(0xff),
            systemNavigationBarDividerColor = null,
            statusBarColor = null,
            systemNavigationBarIconBrightness = Brightness.LIGHT,
            statusBarIconBrightness = Brightness.LIGHT,
            statusBarBrightness = Brightness.DARK
        )

        val DARK = SystemUIOverlayStyle(
            systemNavigationBarColor = Color(0xff),
            systemNavigationBarDividerColor = null,
            statusBarColor = null,
            systemNavigationBarIconBrightness = Brightness.LIGHT,
            statusBarIconBrightness = Brightness.DARK,
            statusBarBrightness = Brightness.LIGHT
        )
    }
}