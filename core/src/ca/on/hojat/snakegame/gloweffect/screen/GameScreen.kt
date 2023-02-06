package ca.on.hojat.snakegame.gloweffect.screen

import ca.on.hojat.snakegame.gloweffect.screen.base.BaseScreen
import ca.on.hojat.snakegame.gloweffect.sprite.RingSprite
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class GameScreen : BaseScreen() {

    private val ringSprites = mutableListOf<RingSprite>()
    private val spriteBatch = SpriteBatch()

    init {
        val ringSpriteRed = RingSprite(viewPort, spriteBatch).apply {
            randomSpeed()
        }
        val ringSpriteGreen = RingSprite(viewPort, spriteBatch).apply {
            setColor(Color.GREEN)
            setDirection(RingSprite.Direction.TOP_RIGHT)
            randomSpeed()
        }
        val ringSpriteBlue = RingSprite(viewPort, spriteBatch).apply {
            setColor(Color.BLUE)
            setDirection(RingSprite.Direction.BOTTOM_RIGHT)
            randomSpeed()
        }
        val ringSpriteYellow = RingSprite(viewPort, spriteBatch).apply {
            setColor(Color.YELLOW)
            setDirection(RingSprite.Direction.BOTTOM_LEFT)
            randomSpeed()
        }

        ringSprites.addAll(arrayOf(ringSpriteRed, ringSpriteGreen, ringSpriteBlue, ringSpriteYellow))
    }

    override fun show() {}

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(0f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        for (ring in ringSprites) {
            ring.render(delta)
        }
    }

    override fun resize(width: Int, height: Int) {}

    override fun pause() {

    }

    override fun resume() {

    }

    override fun hide() {

    }

    override fun dispose() {

        spriteBatch.dispose()
        for (ring in ringSprites) {
            ring.dispose()
        }
    }
}