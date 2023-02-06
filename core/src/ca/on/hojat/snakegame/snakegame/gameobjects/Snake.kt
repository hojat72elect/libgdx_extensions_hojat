//package ca.on.hojat.snakegame.snakegame.gameobjects
//
//import ca.on.hojat.snakegame.base.MovementDirection
//import ca.on.hojat.snakegame.base.BaseGameObject
//import com.badlogic.gdx.Gdx
//import com.badlogic.gdx.Input
//import com.badlogic.gdx.graphics.Texture
//import com.badlogic.gdx.math.Rectangle
//
///**
// *  head: the head of the snake is a [BaseGameObject] of its own because
// * it's separate from body in the form of the info that it contains.
// *
// *
// */
//class Snake : BaseGameObject(
//    rectangle = Rectangle(),
//    movementDirection = MovementDirection.RIGHT,
//    textureAddress = *arrayOf("snakehead.png", "snakebody.png")
//) {
//
//    // the texture that will be used for snake body parts
//    private lateinit var bodyTexture: Texture
//
//    /**
//     * check where's the head of the snake.
//     */
//    private fun checkForOutOfBounds() {
//        if (xPosition >= Gdx.graphics.width) {
//            xPosition = 0f
//        }
//        if (xPosition < 0) {
//            xPosition = Gdx.graphics.width - SNAKE_MOVEMENT
//        }
//        if (yPosition >= Gdx.graphics.height) {
//            yPosition = 0f
//        }
//        if (yPosition < 0) {
//            yPosition = Gdx.graphics.height - SNAKE_MOVEMENT
//        }
//    }
//
//    /**
//     * the director has told this actor to move.
//     */
//    fun move() {
//        when (movementDirection) {
//            MovementDirection.RIGHT -> {
//                xPosition += SNAKE_MOVEMENT
//            }
//
//            MovementDirection.LEFT -> {
//                xPosition -= SNAKE_MOVEMENT
//            }
//
//            MovementDirection.UP -> {
//                yPosition += SNAKE_MOVEMENT
//            }
//
//            MovementDirection.DOWN -> {
//                yPosition -= SNAKE_MOVEMENT
//            }
//        }
//        // after moving, if it's out of bounds,
//        // comes back to the screen
//        checkForOutOfBounds()
//    }
//
//    /**
//     * the snake related user inputs are queried by itself (just for now).
//     *
//     * Here we're querying the keys. But I'm pretty sure registering listeners for our desired keys will be
//     * a lot better for the sake of performance.
//     */
//    fun queryInput() {
//        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) movementDirection = MovementDirection.LEFT
//        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) movementDirection = MovementDirection.RIGHT
//        if (Gdx.input.isKeyPressed(Input.Keys.UP)) movementDirection = MovementDirection.UP
//        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) movementDirection = MovementDirection.DOWN
//    }
//
//    override fun loadTexture() {
//        super.loadTexture()
//        bodyTexture = textureGraphic[1]
//    }
//
//    companion object {
//        // speed of snake's movement
//        const val SNAKE_MOVEMENT = 32f
//    }
//}