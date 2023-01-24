package ca.on.hojat.snakegame

import ca.on.hojat.snakegame.gameobjects.Apple
import ca.on.hojat.snakegame.gameobjects.Snake
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils

class GameScreen : ScreenAdapter() {

    private lateinit var batch: SpriteBatch
    private var timer = MOVE_TIME
    private lateinit var snake: Snake
    private lateinit var apple: Apple

    override fun resize(width: Int, height: Int) {
        batch = SpriteBatch()
        snake = Snake(Texture(Gdx.files.internal("snakehead.png")))
        apple = Apple(Texture(Gdx.files.internal("apple.png")))
    }

    override fun render(delta: Float) {

        // read user's input
        snake.queryInput()
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
            snake.move()
        }

        checkAndPlaceApple()
        clearScreen()
        draw()

    }

    private fun clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

    private fun draw() {
        // begin drawing
        batch.begin()
        // draw the snake
        batch.draw(
            snake.snakeHead,
            snake.snakeX.toFloat(),
            snake.snakeY.toFloat()
        )
        // draw the apple
        if (apple.isAppleAvailable) {
            batch.draw(
                apple.apple,
                apple.appleX.toFloat(),
                apple.appleY.toFloat()
            )
        }
        // stop drawing
        batch.end()
    }

    private fun checkAndPlaceApple() {
        if (!apple.isAppleAvailable) {
            while (apple.appleX == snake.snakeX && apple.appleY == snake.snakeY) {
                with(apple) {
                    appleX = MathUtils.random(Gdx.graphics.width / Snake.SNAKE_MOVEMENT - 1) * Snake.SNAKE_MOVEMENT
                    appleY = MathUtils.random(Gdx.graphics.height / Snake.SNAKE_MOVEMENT - 1) * Snake.SNAKE_MOVEMENT
                    isAppleAvailable = true
                }
            }
        }
    }

    companion object {
        // each step of our timer
        private const val MOVE_TIME = 1f
    }
}