package ca.on.hojat.snakegame.screens

import ca.on.hojat.snakegame.gameobjects.Apple
import ca.on.hojat.snakegame.gameobjects.BodyPart
import ca.on.hojat.snakegame.gameobjects.Snake
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.ScreenAdapter
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.GL20
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.Batch
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.math.MathUtils
import com.badlogic.gdx.utils.Array

class GameScreen : ScreenAdapter() {

    private lateinit var spriteBatch: SpriteBatch
    private var timer = MOVE_TIME
    private lateinit var snake: Snake
    private lateinit var snakeBody: BodyPart
    private lateinit var apple: Apple
    private val bodyParts = Array<BodyPart>()

    override fun resize(width: Int, height: Int) {
        spriteBatch = SpriteBatch()
        snake = Snake(Texture(Gdx.files.internal("snakehead.png")))
        snakeBody = BodyPart(Texture(Gdx.files.internal("snakebody.png")))
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

        checkAppleCollision()
        checkAndPlaceApple()
        clearScreen()
        drawSnakeHeadAndApple()

    }

    private fun clearScreen() {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a)
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT)
    }

    private fun drawSnakeHeadAndApple() {
        // begin drawing
        spriteBatch.begin()
        // draw the snake
        spriteBatch.draw(
            snake.headTexture,
            snake.xPosition.toFloat(),
            snake.yPosition.toFloat()
        )
        // draw the apple
        if (apple.isAvailable) {
            spriteBatch.draw(
                apple.texture,
                apple.xPosition.toFloat(),
                apple.yPosition.toFloat()
            )
        }
        // stop drawing
        spriteBatch.end()
    }

    private fun checkAndPlaceApple() {
        if (!apple.isAvailable) {
            while (apple.xPosition == snake.xPosition && apple.yPosition == snake.yPosition) {
                with(apple) {
                    xPosition = MathUtils.random(Gdx.graphics.width / Snake.SNAKE_MOVEMENT - 1) * Snake.SNAKE_MOVEMENT
                    yPosition = MathUtils.random(Gdx.graphics.height / Snake.SNAKE_MOVEMENT - 1) * Snake.SNAKE_MOVEMENT
                    isAvailable = true
                }
            }
        }
    }

    /**
     * Checks if there has been a collision between snake's head and the apple.
     */
    private fun checkAppleCollision() {
        if (apple.isAvailable && apple.xPosition == snake.xPosition && apple.yPosition == snake.yPosition) {
            snakeBody.updatePosition(snake.xPosition, snake.yPosition)
            bodyParts.insert(0, snakeBody)
            apple.isAvailable = false
        }
    }

    private fun drawBodyPart(batch: Batch, bodyPart: BodyPart, snake: Snake) {
        if (!(bodyPart.xPosition == snake.xPosition && bodyPart.yPosition == snake.yPosition)) {
            batch.draw(bodyPart.texture, bodyPart.xPosition.toFloat(), bodyPart.yPosition.toFloat())
        }
    }

    companion object {
        // each step of our timer
        private const val MOVE_TIME = 1f
    }
}