package com.chrynan.klutter.painting

import com.chrynan.klutter.foundation.TargetPlatform
import com.chrynan.klutter.services.AssetBundle
import com.chrynan.klutter.ui.Locale
import com.chrynan.klutter.ui.Size
import com.chrynan.klutter.ui.TextDirection

data class ImageConfiguration(
    val bundle: AssetBundle,
    val devicePixelRatio: Double,
    val locale: Locale,
    val textDirection: TextDirection,
    val size: Size,
    val targetPlatform: TargetPlatform
)