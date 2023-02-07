package ca.on.hojat.snakegame.base

import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.Viewport

/**
 * Just a simple wrapper around [SpriteBatch] and [Viewport].
 */
abstract class BaseSprite(
    val viewport: Viewport,
    val spriteBatch: SpriteBatch
) {
    abstract fun render(delta: Float)
    abstract fun dispose()
}