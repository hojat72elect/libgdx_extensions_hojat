package ca.on.hojat.snakegame.flappybird.gameobjects

import ca.on.hojat.snakegame.base.BaseGameObject
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Circle

class Bird : BaseGameObject() {

    private val collisionCircle = Circle(xPosition, yPosition, COLLISION_RADIUS)

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

    companion object {
        const val COLLISION_RADIUS = 24f
    }
}