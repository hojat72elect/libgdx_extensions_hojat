package ca.on.hojat.snakegame.gloweffect.screen

import ca.on.hojat.snakegame.base.MovementDirection
import ca.on.hojat.snakegame.gloweffect.screen.base.BaseScreen
import ca.on.hojat.snakegame.gloweffect.sprite.RingSpriteKotlin
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class GameScreen : BaseScreen() {

    private val ringSprites = mutableListOf<RingSpriteKotlin>()
    private val spriteBatch = SpriteBatch()

    init {
        val ringSpriteRed = RingSpriteKotlin(viewPort, spriteBatch).apply {
            randomSpeed()
        }
        val ringSpriteGreen = RingSpriteKotlin(viewPort, spriteBatch).apply {
            color = Color.GREEN
            direction = MovementDirection.TopRight
            randomSpeed()
        }
        val ringSpriteBlue = RingSpriteKotlin(viewPort, spriteBatch).apply {
            color = Color.BLUE
            direction = MovementDirection.BottomRight
            randomSpeed()
        }
        val ringSpriteYellow = RingSpriteKotlin(viewPort, spriteBatch).apply {
            color = Color.YELLOW
            direction = MovementDirection.BottomLeft
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