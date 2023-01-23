package ca.on.hojat.snakegame.snake

import com.badlogic.gdx.Gdx
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
    var direction: MovementDirection = MovementDirection.RIGHT
) {

    /**
     * check where's the head of the snake.
     */
    private fun checkForOutOfBounds() {
        if (snakeX >= Gdx.graphics.width) {
            snakeX = 0f
        }
    }

    /**
     * the director has told this actor to move.
     */
    fun move() {
        snakeX += SNAKE_MOVEMENT
        // after moving, if it's out of bounds,
        // comes back to the screen
        checkForOutOfBounds()
    }

    companion object {
        // speed of snake's movement
        const val SNAKE_MOVEMENT = 32
    }
}