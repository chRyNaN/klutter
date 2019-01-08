package com.chrynan.klutter.rendering

import com.chrynan.klutter.animation.Curve

abstract class ViewportOffset { // TODO should extend ChangeNotifier Class

    abstract val pixels: Double

    abstract val userScrollDirection: ScrollDirection

    abstract val allowImplicitScrolling: Boolean

    abstract fun applyViewportDimension(viewportDimension: Double): Boolean

    abstract fun applyContentDimensions(minScrollExtent: Double, maxScrollExtent: Double): Boolean

    abstract fun correctBy(correction: Double)

    abstract fun jumpTo(pixels: Double)

    abstract fun animateTo(to: Double, duration: Long, curve: Curve) // TODO this should probably be asynchronous

    abstract fun moveTo(
        to: Double,
        duration: Long,
        curve: Curve,
        clamp: Boolean
    ) // TODO this should probably be asynchronous

    internal fun debugFillDescription(description: MutableList<String>) {
        description.add("offset: $pixels")
    }
}

class FixedViewportOffset(override var pixels: Double) : ViewportOffset() {

    companion object {

        val ZERO = FixedViewportOffset(pixels = 0.0)
    }

    override val userScrollDirection = ScrollDirection.IDLE

    override val allowImplicitScrolling = false

    override fun applyViewportDimension(viewportDimension: Double) = true

    override fun applyContentDimensions(minScrollExtent: Double, maxScrollExtent: Double) = true

    override fun correctBy(correction: Double) {
        pixels += correction
    }

    override fun jumpTo(pixels: Double) = Unit

    override fun animateTo(to: Double, duration: Long, curve: Curve) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun moveTo(to: Double, duration: Long, curve: Curve, clamp: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}