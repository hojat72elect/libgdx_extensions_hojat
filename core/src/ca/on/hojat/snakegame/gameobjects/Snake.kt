package ca.on.hojat.snakegame.gameobjects

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture

/**
 * @param headTexture: The texture that shows the head of the snake.
 * @param x
 * @param y : These 2 are the coordinates of the snake (its head)
 *
 */
class Snake(
    var headTexture: Texture,
    var x: Int = 0,
    var y: Int = 0,
    private var direction: MovementDirection = MovementDirection.RIGHT
) {

    /**
     * check where's the head of the snake.
     */
    private fun checkForOutOfBounds() {
        if (x >= Gdx.graphics.width) {
            x = 0
        }
        if (x < 0) {
            x = Gdx.graphics.width - SNAKE_MOVEMENT
        }
        if (y >= Gdx.graphics.height) {
            y = 0
        }
        if (y < 0) {
            y = Gdx.graphics.height - SNAKE_MOVEMENT
        }
    }

    /**
     * the director has told this actor to move.
     */
    fun move() {
        when (direction) {
            MovementDirection.RIGHT -> {
                x += SNAKE_MOVEMENT
            }

            MovementDirection.LEFT -> {
                x -= SNAKE_MOVEMENT
            }

            MovementDirection.UP -> {
                y += SNAKE_MOVEMENT
            }

            MovementDirection.DOWN -> {
                y -= SNAKE_MOVEMENT
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