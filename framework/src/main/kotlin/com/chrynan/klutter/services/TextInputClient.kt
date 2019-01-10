package com.chrynan.klutter.services

abstract class TextInputClient {

    abstract fun updateEditingValue(value: TextEditingValue)

    abstract fun performAction(action: TextInputAction)

    abstract fun updateFloatingCursor(point: RawFloatingCursorPoint)
}