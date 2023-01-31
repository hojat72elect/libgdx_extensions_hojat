package ca.on.hojat.snakegame.gameobjects

import ca.on.hojat.snakegame.base.MovementDirection
import ca.on.hojat.snakegame.base.BaseGameObject
import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Texture

/**
 *  head: the head of the snake is a [BaseGameObject] of its own because
 * it's separate from body in the form of the info that it contains.
 *
 *
 */
class Snake(
    private var direction: MovementDirection = MovementDirection.RIGHT
) : BaseGameObject(textureAddress = *arrayOf("snakehead.png", "snakebody.png")) {

    // the texture that will be used for snake body parts
    private lateinit var bodyTexture: Texture

    // all the body parts of the snake (we will add to it)
    val bodyParts = ArrayList<BaseGameObject>()

    /**
     * check where's the head of the snake.
     */
    private fun checkForOutOfBounds() {
        if (xPosition >= Gdx.graphics.width) {
            xPosition = 0
        }
        if (xPosition < 0) {
            xPosition = Gdx.graphics.width - SNAKE_MOVEMENT
        }
        if (yPosition >= Gdx.graphics.height) {
            yPosition = 0
        }
        if (yPosition < 0) {
            yPosition = Gdx.graphics.height - SNAKE_MOVEMENT
        }
    }

    /**
     * the director has told this actor to move.
     */
    fun move() {
        when (direction) {
            MovementDirection.RIGHT -> {
                xPosition += SNAKE_MOVEMENT
            }

            MovementDirection.LEFT -> {
                xPosition -= SNAKE_MOVEMENT
            }

            MovementDirection.UP -> {
                yPosition += SNAKE_MOVEMENT
            }

            MovementDirection.DOWN -> {
                yPosition -= SNAKE_MOVEMENT
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

    override fun loadTexture() {
        super.loadTexture()
        bodyTexture = textureGraphic[1]
    }

    fun addBodyPart() {
        val newBodyPart = BaseGameObject(bodyTexture)
        newBodyPart.xPosition = xPosition
        newBodyPart.yPosition = yPosition

        bodyParts.add(newBodyPart)
    }

    companion object {
        // speed of snake's movement
        const val SNAKE_MOVEMENT = 32
    }
}