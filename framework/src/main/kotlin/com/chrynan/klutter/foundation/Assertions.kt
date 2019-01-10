package com.chrynan.klutter.foundation

typealias FlutterExceptionHandler = (details: FlutterErrorDetails) -> Unit

// TODO typealias InformationCollector = (information: StringBuffer) -> Unit

data class FlutterErrorDetails(
    val exception: Throwable,
    val library: String = "Flutter framework",
    val silent: Boolean = false,
    val context: String
    // TODO val stack: StackTrace,
    // TODO val stackFilter: IterableFilter<String>,
    // TODO val informationCollector: InformationCollector
)

data class FlutterError(override val message: String) : AssertionError()