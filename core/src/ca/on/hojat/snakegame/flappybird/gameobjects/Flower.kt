package ca.on.hojat.snakegame.flappybird.gameobjects

import ca.on.hojat.snakegame.base.BaseGameObject
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Circle
import com.badlogic.gdx.math.Rectangle

class Flower : BaseGameObject(rectangle = Rectangle()) {

    private val collisionRectangle =
        Rectangle(xPosition, yPosition, COLLISION_RECTANGLE_WIDTH, COLLISION_RECTANGLE_HEIGHT)

    private val collisionCircle =
        Circle(xPosition + collisionRectangle.width / 2, yPosition + collisionRectangle.height, COLLISION_CIRCLE_RADIUS)

    fun move(x: Float) {
        xPosition = x
        updateCollisionCircle()
        updateCollisionRectangle()
    }

    private fun updateCollisionRectangle() {
        collisionRectangle.x = xPosition
    }

    private fun updateCollisionCircle() {
        collisionCircle.x = xPosition + collisionRectangle.width / 2
        collisionCircle.y = yPosition + collisionRectangle.height
    }

    fun drawDebug(shapeRenderer: ShapeRenderer) {
        shapeRenderer.circle(
            collisionCircle.x,
            collisionCircle.y,
            collisionCircle.radius
        )
        shapeRenderer.rect(
            collisionRectangle.x,
            collisionRectangle.y,
            collisionRectangle.width,
            collisionRectangle.height
        )
    }

    fun update(delta: Float) {
        move(xPosition - (MAX_SPEED_PER_SECOND * delta))
    }

    companion object {
        const val COLLISION_RECTANGLE_WIDTH = 13f
        const val COLLISION_RECTANGLE_HEIGHT = 447f
        const val COLLISION_CIRCLE_RADIUS = 33f
        const val MAX_SPEED_PER_SECOND = 100f
        const val WIDTH = COLLISION_CIRCLE_RADIUS * 2
    }
}