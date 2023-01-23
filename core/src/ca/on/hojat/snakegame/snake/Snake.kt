package ca.on.hojat.snakegame.snake

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture

/**
 * @param snakeHead: The texture that shows the head of the snake.
 * @param snakeX
 * @param snakeY : These 2 are the coordinates of the snake (its head)
 *
 */
class Snake(
    var snakeHead: Texture,
    var snakeX: Float = 0f,
    var snakeY: Float = 0f,
    private var direction: MovementDirection = MovementDirection.RIGHT
) {

    /**
     * check where's the head of the snake.
     */
    private fun checkForOutOfBounds() {
        if (snakeX >= Gdx.graphics.width) {
            snakeX = 0f
        }
        if (snakeX < 0) {
            snakeX = Gdx.graphics.width.toFloat() - SNAKE_MOVEMENT
        }
        if (snakeY >= Gdx.graphics.height) {
            snakeY = 0f
        }
        if (snakeY < 0) {
            snakeY = Gdx.graphics.height.toFloat() - SNAKE_MOVEMENT
        }
    }

    /**
     * the director has told this actor to move.
     */
    fun move() {
        when (direction) {
            MovementDirection.RIGHT -> {
                snakeX += SNAKE_MOVEMENT
            }

            MovementDirection.LEFT -> {
                snakeX -= SNAKE_MOVEMENT
            }

            MovementDirection.UP -> {
                snakeY += SNAKE_MOVEMENT
            }

            MovementDirection.DOWN -> {
                snakeY -= SNAKE_MOVEMENT
            }
        }
        // after moving, if it's out of bounds,
        // comes back to the screen
        checkForOutOfBounds()
    }


    /**
     * the snake related user inputs are queried by itself (just for now).
     *
     * Here we're querying the keys. But I'm pretty sure registering listeners for our desired keys will be
     * a lot better for the sake of performance.
     */
    fun queryInput() {
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) direction = MovementDirection.LEFT
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) direction = MovementDirection.RIGHT
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) direction = MovementDirection.UP
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) direction = MovementDirection.DOWN
    }

    companion object {
        // speed of snake's movement
        const val SNAKE_MOVEMENT = 32
    }
}