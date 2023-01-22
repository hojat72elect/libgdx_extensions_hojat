package ca.on.hojat.snakegame

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class GameScreen : ScreenAdapter() {

    private lateinit var batch: SpriteBatch
    private lateinit var image: Texture


    override fun resize(width: Int, height: Int) {
        batch = SpriteBatch()
        image = Texture("badlogic.jpg")
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(1f, 0f, 0f, 1f)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
        batch.begin()
        batch.draw(image, 0f, 0f)
        batch.end()
    }
}