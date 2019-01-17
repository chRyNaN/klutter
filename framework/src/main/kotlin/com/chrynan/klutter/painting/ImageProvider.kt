package com.chrynan.klutter.painting

interface ImageProvider {

    fun resolve(configuration: ImageConfiguration): ImageStream

    // TODO fun evict(cache: ImageCache, configuration: ImageConfiguration): Deffered<Boolean>

    fun <T> obtainKey(configuration: ImageConfiguration): T

    fun <T> load(key: T): ImageStreamCompleter
}