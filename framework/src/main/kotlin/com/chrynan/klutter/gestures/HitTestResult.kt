package com.chrynan.klutter.gestures

class HitTestResult {

    val path: Iterable<HitTestEntry>
        get() = mutablePath

    private val mutablePath = mutableListOf<HitTestEntry>()

    fun add(entry: HitTestEntry) {
        mutablePath.add(entry)
    }

    override fun toString() =
        "HitTestResult(${if (mutablePath.isEmpty()) "<empty path>" else mutablePath.joinToString(", ")})"
}