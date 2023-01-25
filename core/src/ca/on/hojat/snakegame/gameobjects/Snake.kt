package ca.on.hojat.snakegame.gameobjects

import ca.on.hojat.snakegame.base.BaseGameObject
import ca.on.hojat.snakegame.base.MovementDirection
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input

/**
 * @param head: the head of the snake is a [BaseGameObject] of its own because
 * it's separate from body in the form of the info that it contains.
 *
 *
 */
class Snake(
    var head: BaseGameObject,
    var body: Array<BaseGameObject> = emptyArray(),
    private var direction: MovementDirection = MovementDirection.RIGHT
) {

    /**
     * check where's the head of the snake.
     */
    private fun checkForOutOfBounds() {
        if (head.xPosition >= Gdx.graphics.width) {
            head.xPosition = 0
        }
        if (head.xPosition < 0) {
            head.xPosition = Gdx.graphics.width - SNAKE_MOVEMENT
        }
        if (head.yPosition >= Gdx.graphics.height) {
            head.yPosition = 0
        }
        if (head.yPosition < 0) {
            head.yPosition = Gdx.graphics.height - SNAKE_MOVEMENT
        }
    }

    /**
     * the director has told this actor to move.
     */
    fun move() {
        when (direction) {
            MovementDirection.RIGHT -> {
                head.xPosition += SNAKE_MOVEMENT
            }

            MovementDirection.LEFT -> {
                head.xPosition -= SNAKE_MOVEMENT
            }

            MovementDirection.UP -> {
                head.yPosition += SNAKE_MOVEMENT
            }

            MovementDirection.DOWN -> {
                head.yPosition -= SNAKE_MOVEMENT
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

    private fun moveSnakeBody() {
        if (body.size > 0) {

        }
    }

    companion object {
        // speed of snake's movement
        const val SNAKE_MOVEMENT = 32
    }
}