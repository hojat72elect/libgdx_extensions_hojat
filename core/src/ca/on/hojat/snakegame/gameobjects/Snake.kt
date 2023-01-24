package ca.on.hojat.snakegame.gameobjects

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture

/**
 * @param headTexture: The texture that shows the head of the snake.
 * @param headX
 * @param headY : These 2 are the coordinates of the snake (its head)
 *
 */
class Snake(
    var headTexture: Texture,
    var headX: Int = 0,
    var headY: Int = 0,
    private var direction: MovementDirection = MovementDirection.RIGHT
) {

    /**
     * check where's the head of the snake.
     */
    private fun checkForOutOfBounds() {
        if (headX >= Gdx.graphics.width) {
            headX = 0
        }
        if (headX < 0) {
            headX = Gdx.graphics.width - SNAKE_MOVEMENT
        }
        if (headY >= Gdx.graphics.height) {
            headY = 0
        }
        if (headY < 0) {
            headY = Gdx.graphics.height - SNAKE_MOVEMENT
        }
    }

    /**
     * the director has told this actor to move.
     */
    fun move() {
        when (direction) {
            MovementDirection.RIGHT -> {
                headX += SNAKE_MOVEMENT
            }

            MovementDirection.LEFT -> {
                headX -= SNAKE_MOVEMENT
            }

            MovementDirection.UP -> {
                headY += SNAKE_MOVEMENT
            }

            MovementDirection.DOWN -> {
                headY -= SNAKE_MOVEMENT
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