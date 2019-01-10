package com.chrynan.klutter.foundation

typealias ValueChanged<T> = (value: T) -> Unit

typealias ValueSetter<T> = (value: T) -> Unit

typealias ValueGetter<T> = () -> T

typealias IterableFilter<T> = (input: Iterable<T>) -> Iterable<T>