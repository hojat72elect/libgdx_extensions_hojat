package ca.on.hojat.snakegame.flappybird.gameobjects

import ca.on.hojat.snakegame.base.BaseGameObject
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.Rectangle

class Bird : BaseGameObject(rectangle = Rectangle()) {

    private val collisionCircle = Circle(xPosition, yPosition, COLLISION_RADIUS)
    private var ySpeed = 0f

    fun drawDebug(shapeRenderer: ShapeRenderer) {
        shapeRenderer.circle(collisionCircle.x, collisionCircle.y, collisionCircle.radius)
    }

    fun move(x: Float, y: Float) {
        xPosition = x
        yPosition = y
        updateCollisionCircle()
    }

    /**
     * The position of the collision shape will be updated to the position of the bird itself.
     */
    private fun updateCollisionCircle() {
        collisionCircle.x = xPosition
        collisionCircle.y = yPosition
    }

    fun update() {
        ySpeed -= DIVE_ACCELERATION
        move(xPosition, yPosition + ySpeed)
    }

    fun flyUp() {
        ySpeed = FLY_ACCELERATION
        move(xPosition, yPosition + ySpeed)
    }

    companion object {
        const val COLLISION_RADIUS = 24f
        const val DIVE_ACCELERATION = 0.30f
        const val FLY_ACCELERATION = 5f
    }
}