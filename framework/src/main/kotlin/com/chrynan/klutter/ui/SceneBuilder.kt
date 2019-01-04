package com.chrynan.klutter.ui

expect class SceneBuilder {

    fun pushTransform(matrix4: List<Double>): EngineLayer

    fun pushOffset(dx: Double, dy: Double): EngineLayer

    fun pushClipRect(rect: Rect, clipBehavior: Clip = Clip.ANTI_ALIAS): EngineLayer

    fun pushClipRRect(rRect: RRect, clipBehavior: Clip = Clip.ANTI_ALIAS): EngineLayer

    fun pushClipPath(path: Path, clipBehavior: Clip = Clip.ANTI_ALIAS): EngineLayer

    fun pushOpacity(alpha: Int, offset: Offset = Offset.ZERO): EngineLayer

    fun pushColorFilter(color: Color, blendMode: BlendMode): EngineLayer

    fun pushBackdropFilter(filter: ImageFilter): EngineLayer

    fun pushShaderMask(shader: Shader, maskRect: Rect, blendMode: BlendMode): EngineLayer

    fun pushPhysicalShape(
        path: Path,
        elevation: Double,
        color: Color,
        shadowColor: Color,
        clipBehavior: Clip
    ): EngineLayer

    fun pop()

    fun addRetained(retainedLayer: EngineLayer): EngineLayer

    fun addPerformanceOverlay(enabledOptions: Int, bounds: Rect)

    fun addPicture(offset: Offset, picture: Picture, isComplexHint: Boolean = false, willChangeHint: Boolean = false)

    fun addTexture(
        textureId: Int,
        offset: Offset = Offset.ZERO,
        width: Double = 0.0,
        height: Double = 0.0,
        freeze: Boolean = false
    )

    fun addPlatformView(viewId: Int, offset: Offset = Offset.ZERO, width: Double = 0.0, height: Double = 0.0)

    fun addChildScene(
        offset: Offset = Offset.ZERO,
        width: Double = 0.0,
        height: Double = 0.0,
        sceneHost: SceneHost,
        hitTestable: Boolean = true
    )

    fun setRasterizerTracingThreshold(frameInterval: Int)

    fun setCheckerboardRasterCacheImages(checkerboard: Boolean)

    fun setCheckerboardOffscreenLayers(checkerboard: Boolean)

    fun build(): Scene
}