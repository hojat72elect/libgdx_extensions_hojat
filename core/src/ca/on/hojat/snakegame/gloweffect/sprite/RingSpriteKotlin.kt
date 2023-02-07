package ca.on.hojat.snakegame.gloweffect.sprite

import ca.on.hojat.snakegame.gloweffect.sprite.base.BaseSprite
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.Interpolation
import com.badlogic.gdx.math.Vector2
import com.badlogic.gdx.utils.viewport.Viewport
import java.util.*

class RingSpriteKotlin(viewport: Viewport, spriteBatch: SpriteBatch) : BaseSprite(viewport, spriteBatch) {

    private var ringTexture = Texture(TEXTURE_RING)
    private var glowTexture = Texture(TEXTURE_GLOW)
    private var position = Vector2(
        viewport.worldWidth / 2 - glowTexture.width / 2,
        viewport.worldHeight / 2 - glowTexture.height / 2
    )
    private var velocity = Vector2(0f, 0f)

    private var alpha = 0.0f
    private var elapsedTime = 0.0f
    private var glowProgress = 0.0f
    private var isGlowing = false
    var direction = Direction.TOP_LEFT
    var color: Color = Color.RED
    private var speedX = 150f
    private var speedY = 150f


    override fun render(delta: Float) {

        interpolateAlpha(delta)


        // Draw extended glow texture with color filter
        spriteBatch.begin()
        spriteBatch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE)
        spriteBatch.setColor(color.r, color.g, color.b, alpha)
        spriteBatch.draw(glowTexture, position.x, position.y)
        spriteBatch.end()

        // Draw default glow texture with color filter
        spriteBatch.begin()
        spriteBatch.setBlendFunction(GL20.GL_SRC_ALPHA, GL20.GL_ONE)
        spriteBatch.setColor(color.r, color.g, color.b, GLOW_DEFAULT)
        spriteBatch.draw(glowTexture, position.x, position.y)
        spriteBatch.end()

        // draw white ring
        spriteBatch.begin()
        spriteBatch.color = Color.WHITE
        spriteBatch.draw(ringTexture, position.x, position.y)
        spriteBatch.end()


        move(delta)

    }

    private fun move(delta: Float) {
        when (direction) {
            Direction.TOP_LEFT -> velocity.add(-speedX, speedY)
            Direction.TOP_RIGHT -> velocity.add(speedX, speedY)
            Direction.BOTTOM_LEFT -> velocity.add(-speedX, -speedY)
            Direction.BOTTOM_RIGHT -> velocity.add(speedX, -speedY)
        }

        if (position.x < -RING_MARGIN) {
            showGlowEffect()
            if (direction == Direction.TOP_LEFT) {
                direction = Direction.TOP_RIGHT
            }
            if (direction == Direction.BOTTOM_LEFT) {
                direction = Direction.BOTTOM_RIGHT
            }
        }

        if (position.x >= viewport.worldWidth - ringTexture.width + RING_MARGIN) {
            showGlowEffect()
            if (direction == Direction.BOTTOM_RIGHT) {
                direction = Direction.BOTTOM_LEFT
            }
            if (direction == Direction.TOP_RIGHT) {
                direction = Direction.TOP_LEFT
            }
        }

        if (position.y >= viewport.worldHeight - ringTexture.height + RING_MARGIN) {
            showGlowEffect()
            if (direction == Direction.TOP_RIGHT) {
                direction = Direction.BOTTOM_RIGHT
            }
            if (direction == Direction.TOP_LEFT) {
                direction = Direction.BOTTOM_LEFT
            }
        }

        if (position.y <= -RING_MARGIN) {
            showGlowEffect()
            if (direction == Direction.BOTTOM_LEFT) {
                direction = Direction.TOP_LEFT
            }
            if (direction == Direction.BOTTOM_RIGHT) {
                direction = Direction.TOP_RIGHT
            }
        }

        velocity.scl(delta)
        position.add(velocity.x, velocity.y)
    }

    private fun showGlowEffect() {
        isGlowing = true
        elapsedTime = 0f
    }

    fun randomSpeed() {
        speedX = generateRandomSpeed()
        speedY = generateRandomSpeed()

    }

    private fun generateRandomSpeed() = (Random().nextInt((MAX_SPEED - MIN_SPEED) + 1) + MIN_SPEED).toFloat()

    override fun dispose() {
        ringTexture.dispose()
        glowTexture.dispose()
    }

    companion object {
        const val TEXTURE_RING = "ring.png"
        const val TEXTURE_GLOW = "ring_glow.png"
        const val GLOW_LIFE_TIME = 0.15f
        const val GLOW_DEFAULT = 0.75f
        const val GLOW_SINE_PERIOD = 2.0f
        const val RING_MARGIN = 24
        const val MIN_SPEED = 150
        const val MAX_SPEED = 250
    }

    enum class Direction {
        TOP_LEFT, TOP_RIGHT, BOTTOM_LEFT, BOTTOM_RIGHT
    }

    private fun interpolateAlpha(delta: Float) {
        if (isGlowing) {
            glowProgress = GLOW_SINE_PERIOD.coerceAtMost(elapsedTime / GLOW_LIFE_TIME)

            if (glowProgress != GLOW_SINE_PERIOD) {
                elapsedTime += delta
                alpha = Interpolation.sine.apply(glowProgress)
            } else {
                isGlowing = false
            }
        }

    }
}