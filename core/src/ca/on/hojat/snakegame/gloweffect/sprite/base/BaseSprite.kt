package ca.on.hojat.snakegame.gloweffect.sprite.base

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.Viewport

abstract class BaseSprite(
    @JvmField
    val viewport: Viewport,
    @JvmField
    val spriteBatch: SpriteBatch
) {


    abstract fun render(delta: Float)

    abstract fun dispose()

}