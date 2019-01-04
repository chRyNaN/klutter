package com.chrynan.klutter.ui

expect class PathMetric private constructor(path: Path, forceClosed: Boolean) {

    val length: Double

    val isClosed: Boolean

    fun getTangentForOffset(distance: Double): Tangent?

    fun extractPath(start: Double, end: Double, startWithMoveTo: Boolean = true): Path

    internal fun getPosTan(distance: Double): List<Double>

    internal fun moveNext(): Boolean
}

class PathMetricIterator : Iterator<PathMetric?> {

    val current: PathMetric?
        get() = if (firstTime) null else pathMetric

    private var firstTime = true
    private var hasNext = true
    private var pathMetric: PathMetric? = null

    override fun hasNext() = hasNext

    override fun next(): PathMetric? {// TODO verify this works correctly
        val pm = pathMetric

        if (firstTime) {
            firstTime = false
        }

        hasNext = pathMetric?.moveNext() == true

        return pm
    }
}