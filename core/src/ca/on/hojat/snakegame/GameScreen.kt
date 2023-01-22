package ca.on.hojat.snakegame

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class GameScreen : ScreenAdapter() {

    private lateinit var batch: SpriteBatch

    // everything about Snake
    private lateinit var snakeHead: Texture

    // co-ordinations of the snake (its head)
    private var snakeX = 0f
    private var snakeY = 0f


    private var timer = MOVE_TIME


    override fun resize(width: Int, height: Int) {
        batch = SpriteBatch()
        snakeHead = Texture(Gdx.files.internal("snakehead.png"))
    }

    override fun render(delta: Float) {

        /**
         * Here we update the time. With the help of the logic that
         * we define in here, we have a good understanding of the
         * steps of time that pass in our game's world.
         *
         * We update the time at the beginning of the render() callback;
         * because it'll be used for the stuff we do in this callback.
         */
        timer -= delta
        if (timer <= 0) {
            timer = MOVE_TIME
            // all the stuff we wanna do at each step of the timer
            snakeX += SNAKE_MOVEMENT
        }

        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.begin()
        batch.draw(snakeHead, snakeX, snakeY)
        batch.end()
    }

    companion object {
        // each step of our timer
        private const val MOVE_TIME = 1f

        // speed of snake's movement
        private const val SNAKE_MOVEMENT = 32
    }
}