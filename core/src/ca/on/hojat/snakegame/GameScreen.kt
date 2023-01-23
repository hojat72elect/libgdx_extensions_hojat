package ca.on.hojat.snakegame

import ca.on.hojat.snakegame.snake.Snake
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch

class GameScreen : ScreenAdapter() {

    private lateinit var batch: SpriteBatch
    private var timer = MOVE_TIME
    private lateinit var snake: Snake

    override fun resize(width: Int, height: Int) {
        batch = SpriteBatch()
        snake = Snake(Texture(Gdx.files.internal("snakehead.png")))
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
            snake.queryInput()
            snake.move()
        }

        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)

        batch.begin()
        batch.draw(snake.snakeHead, snake.snakeX, snake.snakeY)
        batch.end()
    }


    companion object {
        // each step of our timer
        private const val MOVE_TIME = 1f
    }
}