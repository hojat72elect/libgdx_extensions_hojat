package ca.on.hojat.snakegame.raindropgame

import com.badlogic.gdx.Screen
import com.badlogic.gdx.graphics.OrthographicCamera

class MainMenuScreen(val game: Drop) : Screen {

    private val camera = OrthographicCamera()

    init {
        camera.setToOrtho(false, 800f, 480f)
    }

    override fun show() {
        TODO("Not yet implemented")
    }

    override fun render(delta: Float) {
        TODO("Not yet implemented")
    }

    override fun resize(width: Int, height: Int) {
        TODO("Not yet implemented")
    }

    override fun pause() {
        TODO("Not yet implemented")
    }

    override fun resume() {
        TODO("Not yet implemented")
    }

    override fun hide() {
        TODO("Not yet implemented")
    }

    override fun dispose() {
        TODO("Not yet implemented")
    }

}
