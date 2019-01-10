package com.chrynan.klutter.services

abstract class RawKeyEventData

class RawKeyEventDataAndroid(
    val flags: Int = 0,
    val codePoint: Int = 0,
    val keyCode: Int = 0,
    val scanCode: Int = 0,
    val metaState: Int = 0
) : RawKeyEventData()

class RawKeyEventDataFuchsia(
    val hidUsage: Int = 0,
    val codePoint: Int = 0,
    val modifiers: Int = 0
): RawKeyEventData()

sealed class RawKeyEvent(val data: RawKeyEventData){

    class Down(data: RawKeyEventData): RawKeyEvent(data)

    class Up(data: RawKeyEventData): RawKeyEvent(data)
}