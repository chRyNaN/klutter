package com.chrynan.klutter.ui

typealias VoidCallback = () -> Unit

typealias FrameCallback = (duration: Long) -> Unit

typealias PointerDataPacketCallback = (packet: PointerDataPacket) -> Unit

typealias Float64List = List<Double>

// TODO typealias SemanticsActionCallback = (id: Int, action: SemanticsAction, args: ByteData) -> Unit

// TODO typealias PlatformMessageResponseCallback = (data: ByteData) -> Unit

// TODO typealias PlatformMessageCallback = (name: String, data, ByteData, callback: PlatformMessageResponseCallback) -> Unit