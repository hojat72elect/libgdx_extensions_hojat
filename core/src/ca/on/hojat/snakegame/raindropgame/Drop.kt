package ca.on.hojat.snakegame.raindropgame

import com.badlogic.gdx.Game
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class Drop : Game() {

    private lateinit var batch: SpriteBatch
    private lateinit var font: BitmapFont

    override fun create() {
        batch = SpriteBatch()
        font = BitmapFont() // Default Arial font of LibGDX
        screen = MainMenuScreen(this)
    }

    override fun render() {
        super.render() // important
    }

    override fun dispose() {
        batch.dispose()
        font.dispose()
    }
}