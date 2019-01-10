package com.chrynan.klutter.foundation

abstract class Key {

    companion object {

        fun with(value: String) = ValueKey(value)
    }
}

abstract class LocalKey : Key()

data class ValueKey<T>(val value: T) : LocalKey()