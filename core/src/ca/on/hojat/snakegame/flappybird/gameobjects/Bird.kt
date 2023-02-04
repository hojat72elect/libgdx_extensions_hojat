package ca.on.hojat.snakegame.flappybird.gameobjects

import ca.on.hojat.snakegame.base.BaseGameObject
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.math.Circle

class Bird : BaseGameObject() {

    val collisionCircle = Circle(xPosition, yPosition, COLLISION_RADIUS)

    fun drawDebug(shapeRenderer: ShapeRenderer) {
        shapeRenderer.circle(collisionCircle.x, collisionCircle.y, collisionCircle.radius)
    }

    companion object {
        const val COLLISION_RADIUS = 24f
    }
}