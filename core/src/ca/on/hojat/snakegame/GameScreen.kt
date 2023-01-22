package ca.on.hojat.snakegame

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class GameScreen : ScreenAdapter() {

    private lateinit var batch: SpriteBatch


    override fun resize(width: Int, height: Int) {
        batch = SpriteBatch()
    }

    override fun render(delta: Float) {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.begin()
        // our rendering code will go here
        batch.end()
    }
}