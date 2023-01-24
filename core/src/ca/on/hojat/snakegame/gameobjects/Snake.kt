package ca.on.hojat.snakegame.gameobjects

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
    var snakeX: Int = 0,
    var snakeY: Int = 0,
    private var direction: MovementDirection = MovementDirection.RIGHT
) {

    /**
     * check where's the head of the snake.
     */
    private fun checkForOutOfBounds() {
        if (snakeX >= Gdx.graphics.width) {
            snakeX = 0
        }
        if (snakeX < 0) {
            snakeX = Gdx.graphics.width - SNAKE_MOVEMENT
        }
        if (snakeY >= Gdx.graphics.height) {
            snakeY = 0
        }
        if (snakeY < 0) {
            snakeY = Gdx.graphics.height - SNAKE_MOVEMENT
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